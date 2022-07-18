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

import com.example.recycler3.databinding.FragmentTreatmentShowBinding;
import com.example.recycler3.databinding.FragmentVaccineShowBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Fragment_Vaccine_Show extends Fragment implements View.OnClickListener {
    private FragmentVaccineShowBinding b;
    private int id = 0;
    private SampleCallback callback;
    CreateMetod createMetod = new CreateMetod();
    private int position = 0;

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
        b = FragmentVaccineShowBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        data(); // автопереход по датам
        hide(); // скрыть разделы из редактирования
        initClick(); // инициализация кнопок
        id(); // подгрузка айди
        bundle(); // подгрузка позиции
        load(); // подругрузка данных из сохраненки по айди


        return v;
    }

    private void bundle() {
        if (!this.getArguments().getString("key").equals("")) {
            String i = this.getArguments().getString("key");
            position = Integer.parseInt(i);
        }
    }

    // подгрузка id
    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    private void data() {
        createMetod.dataAvtomat(b.day, b.editText2, b.age, b.param);
        createMetod.dataAvtomat(b.editText5, b.editText6, b.editText7, b.poleNote2);
        createMetod.nextEdit(b.param, b.editText5, 34);
    }

    private void load() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefVaccineDay" + position + id, Context.MODE_PRIVATE);
        if (!sharedPreferences.getString("vaccineDay" + position + id, "").equals("")) {
            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefVaccineDay" + position + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefVaccineMount" + position + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefVaccineAge" + position + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefVaccineExitDay" + position + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefVaccineExitMount" + position + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefVaccineExitAge" + position + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefDrugVaccine" + position + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefNoteVaccine" + position + id, Context.MODE_PRIVATE);

            String day = sharedPreferences1.getString("vaccineDay" + position + id, "");
            String mount = sharedPreferences2.getString("vaccineMount" + position + id, "");
            String age = sharedPreferences3.getString("vaccineAge" + position + id, "");
            String exitDay = sharedPreferences4.getString("vaccineExitDay" + position + id, "");
            String exitMount = sharedPreferences5.getString("vaccineExitMount" + position + id, "");
            String exitAge = sharedPreferences6.getString("vaccineExitAge" + position + id, "");
            String drug = sharedPreferences7.getString("drugVaccine" + position + id, "");
            String note = sharedPreferences8.getString("noteVaccine" + position + id, "");

            b.day.setText(day);
            b.editText2.setText(mount);
            b.age.setText(age);
            b.param.setText(drug);
            b.editText5.setText(exitDay);
            b.editText6.setText(exitMount);
            b.editText7.setText(exitAge);
            b.poleNote2.setText(note);
        }
    }

    private void initClick() {
        b.bigPen.setOnClickListener(this);
        b.layoutSetTextVaccination.setOnClickListener(this);
        b.layoutBtnSave.setOnClickListener(this);
    }

    private void hide() {
        b.layoutSetTextVaccination.setVisibility(View.GONE); // скрыть напоминание
        b.layoutBtnSave.setVisibility(View.GONE); // скрыть кнопку сохранить
        b.bigPen.setVisibility(View.VISIBLE); // показать карандаш

        // убрать линию у полей
        b.day.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.age.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.param.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText7.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.poleNote2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));

        // выключить редактирование у полей
        b.day.setEnabled(false);
        b.editText2.setEnabled(false);
        b.age.setEnabled(false);
        b.param.setEnabled(false);
        b.editText5.setEnabled(false);
        b.editText6.setEnabled(false);
        b.editText7.setEnabled(false);
        b.poleNote2.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bigPen:
                show();
                break;
            case R.id.layoutSetTextVaccination:
                intentCalender();
                break;
            case R.id.layout_btn_save:
                testData(b.day, b.editText2, b.age);
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

        if (day.getText().toString().equals("") || mount.getText().toString().equals("") || age.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите дату", Toast.LENGTH_SHORT).show();
            day.setText("");
            mount.setText("");
            age.setText("");
            day.requestFocus();
            setSoftKeyboard();
        }

        if (!day.getText().toString().equals("") && !mount.getText().toString().equals("") && !age.getText().toString().equals("")) {
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
                mount.setText("");
                mount.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий месяц", Toast.LENGTH_SHORT).show();
            } else if (dayInt > currentDay && mountInt == currentMount && ageInt == currentAge) {
                day.setText("");
                day.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий день", Toast.LENGTH_SHORT).show();
            } else if (ageInt > currentAge) {
                age.setText("");
                age.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий год", Toast.LENGTH_SHORT).show();
            } else {
                if (b.param.getText().toString().equals("")) {
                    b.param.requestFocus();
                    setSoftKeyboard();
                    Toast.makeText(getActivity(), "Введите название препарата", Toast.LENGTH_SHORT).show();
                } else {
                    testData2(b.editText5, b.editText6, b.editText7);
                }
            }
        }
    }

    private void testData2(EditText day2, EditText mount2, EditText age2) {
        if (day2.getText().toString().equals("") || mount2.getText().toString().equals("") || age2.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите период действия препарата", Toast.LENGTH_SHORT).show();
            day2.setText("");
            mount2.setText("");
            age2.setText("");
            day2.requestFocus();
            setSoftKeyboard();
        }
        if (!day2.getText().toString().equals("") && !mount2.getText().toString().equals("") && !age2.getText().toString().equals("")) {
            int dayInt2 = Integer.parseInt(day2.getText().toString());
            int mountInt2 = Integer.parseInt(mount2.getText().toString());
            int ageInt2 = Integer.parseInt(age2.getText().toString());

            SimpleDateFormat datY = new SimpleDateFormat("yyyy");
            String currentDateandY = datY.format(new Date());
            String data3 = ("" + currentDateandY);
            int currentAge = Integer.parseInt(data3);


            if (dayInt2 >= 31) {
                day2.setText("");
                day2.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает количество дней в месяце", Toast.LENGTH_SHORT).show();
            } else if (mountInt2 >= 13) {
                mount2.setText("");
                mount2.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает количество месяцев в году", Toast.LENGTH_SHORT).show();
            } else if (ageInt2 > currentAge + 2) {
                age2.setText("");
                age2.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий год", Toast.LENGTH_SHORT).show();
            } else {
                save();
                callback.onCreatFragment("medCarta");
//                hide();
            }
        }
    }

    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private void save() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefVaccineDay" + position + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefVaccineMount" + position + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefVaccineAge" + position + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefVaccineExitDay" + position + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefVaccineExitMount" + position + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefVaccineExitAge" + position + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefDrugVaccine" + position + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefNoteVaccine" + position + id, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString("vaccineDay" + position + id, b.day.getText().toString());
        editor1.apply();

        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        editor2.putString("vaccineMount"+ position  + id, b.editText2.getText().toString());
        editor2.apply();

        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
        editor3.putString("vaccineAge" + position + id, b.age.getText().toString());
        editor3.apply();

        SharedPreferences.Editor editor4 = sharedPreferences4.edit();
        editor4.putString("vaccineExitDay" + position + id, b.editText5.getText().toString());
        editor4.apply();

        SharedPreferences.Editor editor5 = sharedPreferences5.edit();
        editor5.putString("vaccineExitMount" + position + id, b.editText6.getText().toString());
        editor5.apply();

        SharedPreferences.Editor editor6 = sharedPreferences6.edit();
        editor6.putString("vaccineExitAge" + position + id, b.editText7.getText().toString());
        editor6.apply();

        SharedPreferences.Editor editor7 = sharedPreferences7.edit();
        editor7.putString("drugVaccine" + position + id, b.param.getText().toString());
        editor7.apply();

        SharedPreferences.Editor editor8 = sharedPreferences8.edit();
        editor8.putString("noteVaccine" + position + id, b.poleNote2.getText().toString());
        editor8.apply();
    }

    private void show() {
        b.layoutSetTextVaccination.setVisibility(View.VISIBLE); // показать напоминание
        b.layoutBtnSave.setVisibility(View.VISIBLE); // показать кнопку сохранить
        b.bigPen.setVisibility(View.GONE); // спрятать карандаш

        // показать линию у полей
        b.day.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.age.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.param.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText7.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));

        // включить редактирование у полей
        b.day.setEnabled(true);
        b.editText2.setEnabled(true);
        b.age.setEnabled(true);
        b.param.setEnabled(true);
        b.editText5.setEnabled(true);
        b.editText6.setEnabled(true);
        b.editText7.setEnabled(true);
        b.poleNote2.setEnabled(true);
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