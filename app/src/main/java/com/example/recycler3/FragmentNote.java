package com.example.recycler3;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentNoteBinding;

import java.util.Calendar;

public class FragmentNote extends Fragment implements View.OnClickListener {
    private FragmentNoteBinding b;
    private SampleCallback callback;
    private int id = 0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SampleCallback) {
            callback = (SampleCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SampleCallback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        b = FragmentNoteBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("note");
        callback.onCreatFragment("noteCreate"); // захват фрагмента для смены баров
        id();
        load();
        initClick(); // инициализация слушателей

        return v;
    }

    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    private void load() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefNote"+id, Context.MODE_PRIVATE);
        b.poleNote.setText(sharedPreferences.getString("note"+id, ""));

        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefNoteTitle"+id, Context.MODE_PRIVATE);
        b.poleNote2.setText(sharedPreferences1.getString("title"+id, ""));
    }


    // иницилизация слушателей
    private void initClick() {
        b.getClock.setOnClickListener(this);
        b.imageClock.setOnClickListener(this);
        b.textClock.setOnClickListener(this);

        b.buttonSave.setOnClickListener(this);
        b.getpetmenu.setOnClickListener(this);
        b.getpetmenutext.setOnClickListener(this);
    }

    // слушатели
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getClock:
                intentCalender();
                break;

            case R.id.button_save:
            case R.id.getpetmenu:
            case R.id.getpetmenutext:
                save();
                break;
        }
    }

    private void save() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefNote"+id, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString("note"+id, b.poleNote.getText().toString());
        editor1.apply();

        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefNoteTitle"+id, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        editor2.putString("title"+id, b.poleNote2.getText().toString());
        editor2.apply();
    }

    // метод перехода на календарь
    private void intentCalender() {
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, Calendar.getInstance().getTimeInMillis());
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(builder.build());
        startActivity(intent);
    }
}