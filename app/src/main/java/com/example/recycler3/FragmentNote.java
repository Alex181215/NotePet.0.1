package com.example.recycler3;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
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
        Pref.init(getActivity());
        callback.onCreatFragment("note");


        callback.onCreatFragment("noteCreate"); // захват фрагмента для смены баров
        load(); // подгрузка данных из сохраненки
        initClick(); // инициализация слушателей

        b.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onCreatFragment("note");
            }
        });

        b.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        return v;
    }

    private void load() {
        b.poleNote.setText(Pref.get(Pref.NOTE_HEA));
        b.poleNote2.setText(Pref.get(Pref.NOTE_TIT));
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
            case R.id.imageClock:
            case R.id.getClock:
            case R.id.textClock:
                intentCalender();
                break;

            case R.id.button_save:
            case R.id.getpetmenu:
            case R.id.getpetmenutext:

                Pref.addStr(Pref.NOTE_HEA, b.poleNote.getText().toString());
                Pref.addStr(Pref.NOTE_TIT, b.poleNote2.getText().toString());

                Toast.makeText(getActivity(), "Сохранено", Toast.LENGTH_SHORT).show();
        }
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