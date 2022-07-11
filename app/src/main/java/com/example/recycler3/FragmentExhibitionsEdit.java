package com.example.recycler3;

import android.app.Activity;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentExhibitionsEditBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FragmentExhibitionsEdit extends Fragment implements View.OnClickListener {
    private FragmentExhibitionsEditBinding b;
    private SampleCallback callback;
    CreateMetod createMetod = new CreateMetod();

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentExhibitionsEditBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentExhibitionsEdit");

        initClicker(); // слушатели
        avto();

        return v;
    }

    private void avto() {
        createMetod.dataAvtomat(b.day, b.mount, b.age, b.editText12);
    }

    private void initClicker() {
        b.layoutSetTextExhibition.setOnClickListener(this);
        b.btnSave.setOnClickListener(this);
    }


    // группа слушателей
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutSetTextExhibition:
                intentCalender();
                break;
            case R.id.btnSave:
                testData(b.day, b.mount, b.age);
                break;
        }
    }

    private void testData(EditText day, EditText mount, EditText age) {
        SimpleDateFormat datD = new SimpleDateFormat("dd");
        String currentDateandD = datD.format(new Date());
        String data1 = ("" + currentDateandD);
        int currentDay = Integer.parseInt(data1);

        SimpleDateFormat datM = new SimpleDateFormat("MM");
        String currentDateandM = datM.format(new Date());
        String data2 = ("" + currentDateandM);
        int currentMount = Integer.parseInt(data2);

        SimpleDateFormat datY = new SimpleDateFormat("yyyy");
        String currentDateandY = datY.format(new Date());
        String data3 = ("" + currentDateandY);
        int currentAge = Integer.parseInt(data3);

        if (b.editText11.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите название выставки", Toast.LENGTH_SHORT).show();
            b.editText11.requestFocus();
            setSoftKeyboard();
        } else if (day.getText().toString().equals("") || mount.getText().toString().equals("") || age.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите дату", Toast.LENGTH_SHORT).show();
            day.setText("");
            mount.setText("");
            age.setText("");
            day.requestFocus();
            setSoftKeyboard();
        } else if (!day.getText().toString().equals("") && !mount.getText().toString().equals("") && !age.getText().toString().equals("")) {
            int dayInt = Integer.parseInt(day.getText().toString());
            int mountInt = Integer.parseInt(mount.getText().toString());
            int ageInt = Integer.parseInt(age.getText().toString());
            if (dayInt >= 31) {
                day.setText("");
                day.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает количество дней в месяце", Toast.LENGTH_SHORT).show();
            } else if (mountInt >= 13) {
                mount.setText("");
                mount.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает количество месяцев в году", Toast.LENGTH_SHORT).show();
            } else if (dayInt <= currentDay && mountInt > currentMount && ageInt == currentAge) {
                age.setText("");
                age.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий месяц", Toast.LENGTH_SHORT).show();
            } else if (dayInt > currentDay && mountInt == currentMount && ageInt == currentAge) {
                day.setText("");
                day.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий день", Toast.LENGTH_SHORT).show();
            } else if (ageInt > currentAge+2) {
                age.setText("");
                age.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий год", Toast.LENGTH_SHORT).show();
            } else {
                save();
            }
        } else {
            save();
        }
    }

    private void save() {
        for (int i = 1; i < 11; i++) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefExhibitionDay"+i, Context.MODE_PRIVATE);
        if (sharedPreferences.getString("exhibitionDay" + i, "").equals("")) {

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefExhibitionDay"+i, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor1 = sharedPreferences1.edit();
            editor1.putString("exhibitionDay"+i, b.day.getText().toString());
            editor1.apply();

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefExhibitionMount"+i, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor12 = sharedPreferences12.edit();
            editor12.putString("exhibitionMount"+i, b.mount.getText().toString());
            editor12.apply();

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefExhibitionAge"+i, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor13 = sharedPreferences13.edit();
            editor13.putString("exhibitionAge"+i, b.age.getText().toString());
            editor13.apply();

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefExhibitionBrend"+i, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor14 = sharedPreferences14.edit();
            editor14.putString("exhibitionBrend"+i, b.editText11.getText().toString());
            editor14.apply();

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefExhibitionFio"+i, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor15 = sharedPreferences15.edit();
            editor15.putString("exhibitionFio"+i, b.editText12.getText().toString());
            editor15.apply();

            SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefExhibitionNote"+i, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor16 = sharedPreferences16.edit();
            editor16.putString("exhibitionNote"+i, b.poleNote2.getText().toString());
            editor16.apply();

            SharedPreferences sharedPreferences17 = getActivity().getSharedPreferences("prefExhibitionStatus"+i, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor17 = sharedPreferences17.edit();
            editor17.putString("exhibitionStatus"+i, b.spinner.getSelectedItem().toString());
            editor17.apply();
            callback.onCreatFragment("exhibitionBack");
            break;
        }
        }
    }

    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
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