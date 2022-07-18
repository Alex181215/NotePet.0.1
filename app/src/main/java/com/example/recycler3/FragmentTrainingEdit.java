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

import com.example.recycler3.databinding.FragmentTrainingEditBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FragmentTrainingEdit extends Fragment implements View.OnClickListener {
    private FragmentTrainingEditBinding b;
    private SampleCallback callback;
    CreateMetod createMetod = new CreateMetod();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentTrainingEditBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentTrainingEdit");
        id();
        initCliker();
        data();

        return v;
    }

    // получаем айди активного питомца
    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    private void data() {
        createMetod.dataAvtomat(b.day, b.mount, b.age, b.editText14);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageSetTextTraining:
                intentCalender();
                break;
            case R.id.layoutSave:
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

        if (b.editText13.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите название тренировки", Toast.LENGTH_SHORT).show();
            b.editText13.requestFocus();
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
        }
    }

    private void save() {
        for (int i = 1; i < 11; i++) {

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefTrainingDay" + i + id, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("trainingDay" + i + id, "").equals("")) {

                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefTrainingDay" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.putString("trainingDay" + i + id, b.day.getText().toString());
                editor1.apply();

                SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefTrainingMount" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                editor2.putString("trainingMount" + i + id, b.mount.getText().toString());
                editor2.apply();


                SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefTrainingAge" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                editor4.putString("trainingAge" + i + id, b.age.getText().toString());
                editor4.apply();

                SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefTrainingName" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                editor5.putString("trainingName" + i + id, b.editText13.getText().toString());
                editor5.apply();

                SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefTrainingAdrees" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                editor6.putString("trainingAdrees" + i + id, b.editText14.getText().toString());
                editor6.apply();

                SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefTrainingFio" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor7 = sharedPreferences7.edit();
                editor7.putString("trainingFio" + i + id, b.editText15.getText().toString());
                editor7.apply();

                SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTrainingTel" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor8 = sharedPreferences8.edit();
                editor8.putString("trainingTel" + i + id, b.tel.getText().toString());
                editor8.apply();

                SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefTrainingNote" + i + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor9 = sharedPreferences9.edit();
                editor9.putString("trainingNote" + i + id, b.poleNote2.getText().toString());
                editor9.apply();

                callback.onCreatFragment("exhibitionBack");
                break;
            }
        }
    }

    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private void initCliker() {
        b.imageSetTextTraining.setOnClickListener(this);
        b.layoutSave.setOnClickListener(this);
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