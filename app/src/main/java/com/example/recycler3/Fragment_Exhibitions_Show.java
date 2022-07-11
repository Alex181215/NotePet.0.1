package com.example.recycler3;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycler3.databinding.FragmentExhibitionsBinding;
import com.example.recycler3.databinding.FragmentExhibitionsShowBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fragment_Exhibitions_Show extends Fragment implements View.OnClickListener {
    private FragmentExhibitionsShowBinding b;
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
        b = FragmentExhibitionsShowBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        hide(); // скрыть разделы из редактирования
        initClicker();
        id(); // подгрузка айди
        showSave(); // подругрузка данных из сохраненки по айди
        avto();


        return (v);
    }

    private void avto() {
        createMetod.dataAvtomat(b.day, b.mount, b.age, b.editText12);
    }


    private void showSave() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefExhibitionDay" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefExhibitionMount" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefExhibitionAge" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefExhibitionBrend" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefExhibitionFio" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefExhibitionNote" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefExhibitionStatus" + id, Context.MODE_PRIVATE);

        String day = sharedPreferences1.getString("exhibitionDay" + id, "");
        String mount = sharedPreferences2.getString("exhibitionMount" + id, "");
        String age = sharedPreferences3.getString("exhibitionAge" + id, "");
        String brend = sharedPreferences4.getString("exhibitionBrend" + id, "");
        String fio = sharedPreferences5.getString("exhibitionFio" + id, "");
        String note = sharedPreferences6.getString("exhibitionNote" + id, "");
        String status = sharedPreferences7.getString("exhibitionStatus" + id, "");

        if(status.equals("Гость")){
            b.spinner.setSelection(0);
        } else if(status.equals("Участник")){
            b.spinner.setSelection(1);
        }

        b.day.setText(day);
        b.mount.setText(mount);
        b.age.setText(age);
        b.editText11.setText(brend);
        b.editText12.setText(fio);
        b.poleNote2.setText(note);
        b.textSpiner.setText(status);
    }

    // подгрузка id
    private void id() {
        if (!this.getArguments().getString("key").equals("")) {
            String i = this.getArguments().getString("key");
            id = Integer.parseInt(i);
        }
    }

    private void initClicker() {
        b.bigPen.setOnClickListener(this);
        b.btnSave.setOnClickListener(this);
    }

    private void hide() {
        // спрятать напоминание и кнопку сохранить
        b.layoutSetTextExhibition.setVisibility(View.GONE);
        b.btnSave.setVisibility(View.GONE);
        b.bigPen.setVisibility(View.VISIBLE);
        b.spinner.setVisibility(View.GONE);
        b.textSpiner.setVisibility(View.VISIBLE);

        // убрать линию у полей
        b.day.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.mount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.age.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText11.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.editText12.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.poleNote2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));

        // выключить редактирование у полей
        b.day.setEnabled(false);
        b.mount.setEnabled(false);
        b.age.setEnabled(false);
        b.editText11.setEnabled(false);
        b.editText12.setEnabled(false);
        b.poleNote2.setEnabled(false);

        b.imageView12.setVisibility(View.GONE);
        b.textView567.setVisibility(View.GONE);
        b.imageView13.setVisibility(View.GONE);
        b.textView13.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bigPen:
                show();
                break;
            case R.id.btnSave:
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
        }
    }

    private void save() {

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefExhibitionDay" + id, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("exhibitionDay" + id, "").equals("")) {

                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefExhibitionDay" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.putString("exhibitionDay" + id, b.day.getText().toString());
                editor1.apply();

                SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefExhibitionMount" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                editor2.putString("exhibitionMount" + id, b.mount.getText().toString());
                editor2.apply();

                SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefExhibitionAge" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                editor3.putString("exhibitionAge" + id, b.age.getText().toString());
                editor3.apply();

                SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefExhibitionBrend" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                editor4.putString("exhibitionBrend" + id, b.editText11.getText().toString());
                editor4.apply();

                SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefExhibitionFio" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                editor5.putString("exhibitionFio" + id, b.editText12.getText().toString());
                editor5.apply();

                SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefExhibitionNote" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                editor6.putString("exhibitionNote" + id, b.poleNote2.getText().toString());
                editor6.apply();

                SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefExhibitionStatus" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor7 = sharedPreferences7.edit();
                editor7.putString("exhibitionStatus" + id, b.spinner.getSelectedItem().toString());
                editor7.apply();

                callback.onCreatFragment("exhibitionBack");
        }
    }

    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }


    private void show() {
        // показать напоминание и кнопку сохранить
        b.layoutSetTextExhibition.setVisibility(View.VISIBLE);
        b.btnSave.setVisibility(View.VISIBLE);
        b.bigPen.setVisibility(View.GONE);
        b.spinner.setVisibility(View.VISIBLE);
        b.textSpiner.setVisibility(View.GONE);

        // показать линию у полей
        b.day.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.mount.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.age.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText11.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.editText12.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.poleNote2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));

        // включить редактирование у полей
        b.day.setEnabled(true);
        b.mount.setEnabled(true);
        b.age.setEnabled(true);
        b.editText11.setEnabled(true);
        b.editText12.setEnabled(true);
        b.poleNote2.setEnabled(true);

        b.imageView12.setVisibility(View.VISIBLE);
        b.textView567.setVisibility(View.VISIBLE);
        b.imageView13.setVisibility(View.VISIBLE);
        b.textView13.setVisibility(View.VISIBLE);
    }
}