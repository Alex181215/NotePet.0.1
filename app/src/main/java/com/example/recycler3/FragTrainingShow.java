package com.example.recycler3;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycler3.databinding.FragmentFragTrainingShowBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class FragTrainingShow extends Fragment implements View.OnClickListener{
    private FragmentFragTrainingShowBinding b;
    private SampleCallback callback;
    private int id = 0;
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
        b = FragmentFragTrainingShowBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        data(); // авто переход по датам
        hide();
        id();
        initCliker();
        showSave();

        return v;
    }

    private void data() {
        createMetod.dataAvtomat(b.day, b.mount, b.age, b.editText14);
    }

    private void showSave() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefTrainingDay" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefTrainingMount" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefTrainingAge" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefTrainingName" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefTrainingAdrees" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefTrainingFio" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefTrainingTel" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTrainingNote" + id, Context.MODE_PRIVATE);

        String day = sharedPreferences1.getString("trainingDay" + id, "");
        String mount = sharedPreferences2.getString("trainingMount" + id, "");
        String age = sharedPreferences3.getString("trainingAge" + id, "");
        String name = sharedPreferences4.getString("trainingName" + id, "");
        String adrees = sharedPreferences5.getString("trainingAdrees" + id, "");
        String fio = sharedPreferences6.getString("trainingFio" + id, "");
        String tel = sharedPreferences7.getString("trainingTel" + id, "");
        String note = sharedPreferences8.getString("trainingNote" + id, "");

        b.day.setText(day);
        b.mount.setText(mount);
        b.age.setText(age);

        b.editText13.setText(name);
        b.editText14.setText(adrees);
        b.editText15.setText(fio);
        b.textView236.setText(tel);
        b.poleNote2.setText(note);
    }


    private void initCliker() {
        b.bigPen.setOnClickListener(this);
        b.layoutSetTextTraining.setOnClickListener(this);
        b.layoutSave.setOnClickListener(this);
    }

    private void hide() {

        // спрятать кнопку сохранить и кнопку напоминание и показать кнопку карандаш
        b.layoutSetTextTraining.setVisibility(View.GONE);
        b.layoutSave.setVisibility(View.GONE);
        b.bigPen.setVisibility(View.VISIBLE);

        // спрятать кнопку добавить фото и видео
        b.imageView12.setVisibility(View.GONE);
        b.textView14.setVisibility(View.GONE);
        b.imageView13.setVisibility(View.GONE);
        b.textView13.setVisibility(View.GONE);

        // скрыть линию полей
        b.editText13.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.day.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.mount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.age.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText14.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText15.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.textView236.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.poleNote2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));

        // выключить редактирование у полей
        b.day.setEnabled(false);
        b.mount.setEnabled(false);
        b.age.setEnabled(false);
        b.editText13.setEnabled(false);
        b.editText14.setEnabled(false);
        b.editText15.setEnabled(false);
        b.textView236.setEnabled(false);
        b.poleNote2.setEnabled(false);
    }

    private void show(){
        // показать кнопку сохранить и кнопку напоминание и показать кнопку карандаш
        b.layoutSetTextTraining.setVisibility(View.VISIBLE);
        b.layoutSave.setVisibility(View.VISIBLE);
        b.bigPen.setVisibility(View.GONE);

        // показать кнопку добавить фото и видео
        b.imageView12.setVisibility(View.VISIBLE);
        b.textView14.setVisibility(View.VISIBLE);
        b.imageView13.setVisibility(View.VISIBLE);
        b.textView13.setVisibility(View.VISIBLE);

        // скрыть линию полей
        b.editText13.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.day.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.mount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.age.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText14.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText15.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.textView236.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.poleNote2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));

        // включить редактирование у полей
        b.day.setEnabled(true);
        b.mount.setEnabled(true);
        b.age.setEnabled(true);
        b.editText13.setEnabled(true);
        b.editText14.setEnabled(true);
        b.editText15.setEnabled(true);
        b.textView236.setEnabled(true);
        b.poleNote2.setEnabled(true);

    }

    // подгрузка id
    private void id() {
        if (!this.getArguments().getString("key").equals("")) {
            String i = this.getArguments().getString("key");
            id = Integer.parseInt(i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layoutSetTextTraining:
                intentCalender();
                break;

            case R.id.bigPen:
                show();
                break;

            case R.id.layoutSave:
                testData(b.day, b.mount, b.age);
                break;
        }
    }

    private void testData(EditText day, EditText mount, EditText age){

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
        } else {
            save();
        }

    }

    private void save() {
            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefTrainingDay" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor1 = sharedPreferences1.edit();
            editor1.putString("trainingDay" + id, b.day.getText().toString());
            editor1.apply();

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefTrainingMount" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor2 = sharedPreferences2.edit();
            editor2.putString("trainingMount" + id, b.day.getText().toString());
            editor2.apply();

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefTrainingAge" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor4 = sharedPreferences4.edit();
            editor4.putString("trainingAge" + id, b.age.getText().toString());
            editor4.apply();

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefTrainingName" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor5 = sharedPreferences5.edit();
            editor5.putString("trainingName" + id, b.editText13.getText().toString());
            editor5.apply();

            SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefTrainingAdrees" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor6 = sharedPreferences6.edit();
            editor6.putString("trainingAdrees" + id, b.editText14.getText().toString());
            editor6.apply();

            SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefTrainingFio" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor7 = sharedPreferences7.edit();
            editor7.putString("trainingFio" + id, b.editText15.getText().toString());
            editor7.apply();

            SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTrainingTel" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor8 = sharedPreferences8.edit();
            editor8.putString("trainingTel" + id, b.textView23.getText().toString());
            editor8.apply();

            SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefTrainingNote" + id, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor9 = sharedPreferences9.edit();
            editor9.putString("trainingNote" + id, b.poleNote2.getText().toString());
            editor9.apply();

        callback.onCreatFragment("exhibitionBack");
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

    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
}