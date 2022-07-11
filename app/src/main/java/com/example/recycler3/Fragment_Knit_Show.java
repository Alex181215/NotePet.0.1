package com.example.recycler3;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recycler3.databinding.FragmentKnitShowBinding;

import java.util.Calendar;

public class Fragment_Knit_Show extends Fragment implements View.OnClickListener {
    private FragmentKnitShowBinding b;
    private int id = 0;
    private int showCount = 0;
    private int infoCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentKnitShowBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        loadId(); // получить айди
        show(); // метод показать сохранные данные по айди
        hide(); // метод скрыть данные разделов при загрузке
        initClicker();
        b.layoutEdit.setVisibility(View.VISIBLE);

        return v;
    }

    private void initClicker() {
        b.layoutMinus2.setOnClickListener(this); // кнопка раздела вязка
        b.layout555.setOnClickListener(this); // кнопка добавить вязку
        b.layout666.setOnClickListener(this); // кнопка удалить вязку
        b.layoutMinus.setOnClickListener(this); // кнопка раздела иная информация
        b.layoutAddTemp.setOnClickListener(this); // кнопка добавить температуру
        b.layoutAddTemp2.setOnClickListener(this); // кнопка удалить температуру
        b.imageView12.setOnClickListener(this);// кнопка крестик добавить фото
        b.textView10.setOnClickListener(this); // кнопка текст добавить фото
        b.imageView13.setOnClickListener(this); // кнопка крестик добавит видео
        b.textView48.setOnClickListener(this);  // кнопка текст добавить видео
        b.layoutSetTextKnitting.setOnClickListener(this); // кнопка установить напоминание
        b.linearLayout5.setOnClickListener(this); // кнопка добавить детеныша ( перейти на добавить питомца )
        b.layoutSave.setOnClickListener(this); // кнопка сохранить запись
    }

    private void hide() {

        // раздел Вязка
        // скрыть дата первой вязки
        b.text1.setVisibility(View.GONE);
        b.layoutKn1.setVisibility(View.GONE);
        b.day1.setVisibility(View.GONE);
        b.mount1.setVisibility(View.GONE);
        b.age1.setVisibility(View.GONE);

        // скрыть дата второй вязки
        b.text2.setVisibility(View.GONE);
        b.layoutKn2.setVisibility(View.GONE);
        b.day2.setVisibility(View.GONE);
        b.mount2.setVisibility(View.GONE);
        b.age1.setVisibility(View.GONE);

        // скрыть дата третьей вязки
        b.text3.setVisibility(View.GONE);
        b.layoutKn3.setVisibility(View.GONE);
        b.day3.setVisibility(View.GONE);
        b.mount3.setVisibility(View.GONE);
        b.age3.setVisibility(View.GONE);


        // скрыть дата четвертой вязки
        b.text4.setVisibility(View.GONE);
        b.layoutKn4.setVisibility(View.GONE);
        b.day4.setVisibility(View.GONE);
        b.mount4.setVisibility(View.GONE);
        b.age4.setVisibility(View.GONE);

        // скрыть дата пятой вязки
        b.text5.setVisibility(View.GONE);
        b.layoutKn5.setVisibility(View.GONE);
        b.day5.setVisibility(View.GONE);
        b.mount5.setVisibility(View.GONE);
        b.age5.setVisibility(View.GONE);

        // скрыть кнопку добавить вязку
        b.layout555.setVisibility(View.GONE);

        // скрыть кнопку удалить вязку
        b.layout666.setVisibility(View.GONE);


        // Раздел Иная информация
        // скрыть заголовок результат узи
        b.textView45.setVisibility(View.GONE);

        // скрыть аоле результат узи
        b.editText18.setVisibility(View.GONE);

        // скрыть заголовок показания температуры
        b.textView46.setVisibility(View.GONE);
        // скрыть температуры
        b.layoutTemp1.setVisibility(View.GONE);
        b.layoutTemp2.setVisibility(View.GONE);
        b.layoutTemp3.setVisibility(View.GONE);
        b.layoutTemp4.setVisibility(View.GONE);
        b.layoutTemp5.setVisibility(View.GONE);
        b.layoutTemp6.setVisibility(View.GONE);

        // скрыть кнопку добавить температуру
        b.layoutAddTemp.setVisibility(View.GONE);

        // скрыть кнопку удалить температуру
        b.layoutAddTemp2.setVisibility(View.GONE);

        // скрыть заголовок дата родов
        b.textView44.setVisibility(View.GONE);

        // скрыть дату родов
        b.linearLayout16.setVisibility(View.GONE);

        // скрыть заголовок примечание
        b.textView47.setVisibility(View.GONE);

        // скрыть поле примечания
        b.poleNote3.setVisibility(View.GONE);

        // скрыть шейп примечание
        b.imageView3.setVisibility(View.GONE);

        // скрыть кнопку добавит фото
        b.imageView12.setVisibility(View.GONE);
        b.textView10.setVisibility(View.GONE);

        // скрыть кнопку добавить видео
        b.imageView13.setVisibility(View.GONE);
        b.textView48.setVisibility(View.GONE);

        // скрыть кнопку установить напоминание
        b.layoutSetTextKnitting.setVisibility(View.GONE);

        // скрыть кнопку добавить детеныша
        b.linearLayout5.setVisibility(View.GONE);

        // скрыть кнопку сохранить
        b.layoutSave.setVisibility(View.GONE);
    }

    // загрузить сохранные данные по полученному айди
    private void show() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnittingWomen" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences1.getString("knittingWomen" + id, "").equals("")) {
            b.name.setText(sharedPreferences1.getString("knittingWomen" + id, ""));
        }

        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefKnittingMan" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences2.getString("knittingMan" + id, "").equals("")) {
            b.name2.setText(sharedPreferences2.getString("knittingMan" + id, ""));
        }

        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefKnitDay1" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences3.getString("knitDay1" + id, "").equals("")) {
            b.day1.setText(sharedPreferences3.getString("knitDay1" + id, ""));
        }

        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefKnitMount1" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences4.getString("knitMount1" + id, "").equals("")) {
            b.mount1.setText(sharedPreferences4.getString("knitMount1" + id, ""));
        }

        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefKnitAge1" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences5.getString("knitAge1" + id, "").equals("")) {
            b.age1.setText(sharedPreferences5.getString("knitAge1" + id, ""));
        }

        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefKnitDay2" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences6.getString("knitDay2" + id, "").equals("")) {
            b.day2.setText(sharedPreferences6.getString("knitDay2" + id, ""));
        }

        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefKnitMount2" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences7.getString("knitMount2" + id, "").equals("")) {
            b.mount2.setText(sharedPreferences7.getString("knitMount2" + id, ""));
        }

        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefKnitAge2" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences8.getString("knitAge2" + id, "").equals("")) {
            b.age2.setText(sharedPreferences8.getString("knitAge2" + id, ""));
        }

        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefKnitDay3" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences9.getString("knitDay3" + id, "").equals("")) {
            b.day3.setText(sharedPreferences9.getString("knitDay3" + id, ""));
        }

        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefKnitMount3" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences10.getString("knitMount3" + id, "").equals("")) {
            b.mount3.setText(sharedPreferences10.getString("knitMount3" + id, ""));
        }

        SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitAge3" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences11.getString("knitAge3" + id, "").equals("")) {
            b.age3.setText(sharedPreferences11.getString("knitAge3" + id, ""));
        }

        SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay4" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences12.getString("knitDay4" + id, "").equals("")) {
            b.day4.setText(sharedPreferences12.getString("knitDay4" + id, ""));
        }

        SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitMount4" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences13.getString("knitMount4" + id, "").equals("")) {
            b.mount4.setText(sharedPreferences13.getString("knitMount4" + id, ""));
        }

        SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitAge4" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences14.getString("knitAge4" + id, "").equals("")) {
            b.age4.setText(sharedPreferences14.getString("knitAge4" + id, ""));
        }

        SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay5" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences15.getString("knitDay5" + id, "").equals("")) {
            b.day5.setText(sharedPreferences15.getString("knitDay5" + id, ""));
        }

        SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefKnitMount5" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences16.getString("knitMount5" + id, "").equals("")) {
            b.mount5.setText(sharedPreferences16.getString("knitMount5" + id, ""));
        }

        SharedPreferences sharedPreferences17 = getActivity().getSharedPreferences("prefKnitAge5" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences17.getString("knitAge5" + id, "").equals("")) {
            b.age5.setText(sharedPreferences17.getString("knitAge5" + id, ""));
        }

        SharedPreferences sharedPreferences18 = getActivity().getSharedPreferences("prefYzi" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences18.getString("yzi" + id, "").equals("")) {
            b.editText18.setText(sharedPreferences18.getString("yzi" + id, ""));
        }

        SharedPreferences sharedPreferences19 = getActivity().getSharedPreferences("prefTemp1" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences19.getString("temp1" + id, "").equals("")) {
            b.temp1.setText(sharedPreferences19.getString("temp1" + id, ""));
        }

        SharedPreferences sharedPreferences20 = getActivity().getSharedPreferences("prefTemp2" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences20.getString("temp2" + id, "").equals("")) {
            b.temp2.setText(sharedPreferences20.getString("temp2" + id, ""));
        }

        SharedPreferences sharedPreferences21 = getActivity().getSharedPreferences("prefTemp3" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences21.getString("temp3" + id, "").equals("")) {
            b.temp3.setText(sharedPreferences21.getString("temp3" + id, ""));
        }

        SharedPreferences sharedPreferences22 = getActivity().getSharedPreferences("prefTemp4" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences22.getString("temp4" + id, "").equals("")) {
            b.temp4.setText(sharedPreferences22.getString("temp4" + id, ""));
        }

        SharedPreferences sharedPreferences23 = getActivity().getSharedPreferences("prefTemp5" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences23.getString("temp5" + id, "").equals("")) {
            b.temp5.setText(sharedPreferences23.getString("temp5" + id, ""));
        }

        SharedPreferences sharedPreferences24 = getActivity().getSharedPreferences("prefTemp6" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences24.getString("temp6" + id, "").equals("")) {
            b.temp6.setText(sharedPreferences24.getString("temp6" + id, ""));
        }

        SharedPreferences sharedPreferences25 = getActivity().getSharedPreferences("prefChildDay" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences25.getString("childDay" + id, "").equals("")) {
            b.day6.setText(sharedPreferences25.getString("childDay" + id, ""));
        }

        SharedPreferences sharedPreferences26 = getActivity().getSharedPreferences("prefChildMount" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences26.getString("childMount" + id, "").equals("")) {
            b.mount6.setText(sharedPreferences26.getString("childMount" + id, ""));
        }

        SharedPreferences sharedPreferences27 = getActivity().getSharedPreferences("prefChildAge" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences27.getString("childAge" + id, "").equals("")) {
            b.age6.setText(sharedPreferences27.getString("childAge" + id, ""));
        }

        SharedPreferences sharedPreferences28 = getActivity().getSharedPreferences("prefChildPole" + id, Context.MODE_PRIVATE);
        if (!sharedPreferences28.getString("childPole" + id, "").equals("")) {
            b.poleNote3.setText(sharedPreferences28.getString("childPole" + id, ""));
        }


    }

    // получить айди с прошлого экрана
    private void loadId() {
        if (!this.getArguments().getString("key").equals("")) {
            String i = this.getArguments().getString("key");
            id = Integer.parseInt(i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // кнопка открыть календарь
            case R.id.layoutSetTextKnitting:
                intentCalender();
                break;

            case R.id.layoutMinus2:
                showKnit();
                break;

            case R.id.layoutMinus:
                showInfo();
                break;
        }
    }

    private void showInfo(){
        if(infoCount == 0){
            infoCount = 1;
            if(!b.editText18.getText().toString().equals("")){
                b.editText18.setVisibility(View.VISIBLE);
                b.textView45.setVisibility(View.VISIBLE);
            }

            if(!b.temp1.getText().toString().equals("")){
                b.textView46.setVisibility(View.VISIBLE);
                b.layoutTemp1.setVisibility(View.VISIBLE);
                b.temp1.setVisibility(View.VISIBLE);
                b.simvol1.setVisibility(View.VISIBLE);
            }

            if(!b.temp2.getText().toString().equals("")){
                b.textView46.setVisibility(View.VISIBLE);
                b.layoutTemp2.setVisibility(View.VISIBLE);
                b.temp2.setVisibility(View.VISIBLE);
                b.simvol2.setVisibility(View.VISIBLE);
            }

            if(!b.temp3.getText().toString().equals("")){
                b.textView46.setVisibility(View.VISIBLE);
                b.layoutTemp3.setVisibility(View.VISIBLE);
                b.temp3.setVisibility(View.VISIBLE);
                b.simvol3.setVisibility(View.VISIBLE);
            }

            if(!b.temp4.getText().toString().equals("")){
                b.textView46.setVisibility(View.VISIBLE);
                b.layoutTemp4.setVisibility(View.VISIBLE);
                b.temp4.setVisibility(View.VISIBLE);
                b.simvol4.setVisibility(View.VISIBLE);
            }

            if(!b.temp5.getText().toString().equals("")){
                b.textView46.setVisibility(View.VISIBLE);
                b.layoutTemp5.setVisibility(View.VISIBLE);
                b.temp5.setVisibility(View.VISIBLE);
                b.simvol5.setVisibility(View.VISIBLE);
            }

            if(!b.temp6.getText().toString().equals("")){
                b.textView46.setVisibility(View.VISIBLE);
                b.layoutTemp6.setVisibility(View.VISIBLE);
                b.temp6.setVisibility(View.VISIBLE);
                b.simvol6.setVisibility(View.VISIBLE);
            }

            if(!b.day6.getText().toString().equals("")){
                b.textView44.setVisibility(View.VISIBLE);
                b.linearLayout16.setVisibility(View.VISIBLE);
                b.day6.setVisibility(View.VISIBLE);
                b.mount6.setVisibility(View.VISIBLE);
                b.age6.setVisibility(View.VISIBLE);
            }

            if(!b.poleNote3.getText().toString().equals("")){
                b.textView47.setVisibility(View.VISIBLE);
                b.imageView3.setVisibility(View.VISIBLE);
                b.poleNote3.setVisibility(View.VISIBLE);

            }
        } else if (infoCount == 1){
            hideInfo();
        }
    }

    private void hideInfo(){
        infoCount = 0;
            b.editText18.setVisibility(View.GONE);
            b.textView45.setVisibility(View.GONE);

            b.textView46.setVisibility(View.GONE);
            b.layoutTemp1.setVisibility(View.GONE);
            b.temp1.setVisibility(View.GONE);
            b.simvol1.setVisibility(View.GONE);

            b.textView46.setVisibility(View.GONE);
            b.layoutTemp2.setVisibility(View.GONE);
            b.temp2.setVisibility(View.GONE);
            b.simvol2.setVisibility(View.GONE);

            b.textView46.setVisibility(View.GONE);
            b.layoutTemp3.setVisibility(View.GONE);
            b.temp3.setVisibility(View.GONE);
            b.simvol3.setVisibility(View.GONE);

            b.textView46.setVisibility(View.GONE);
            b.layoutTemp4.setVisibility(View.GONE);
            b.temp4.setVisibility(View.GONE);
            b.simvol4.setVisibility(View.GONE);

            b.textView46.setVisibility(View.GONE);
            b.layoutTemp5.setVisibility(View.GONE);
            b.temp5.setVisibility(View.GONE);
            b.simvol5.setVisibility(View.GONE);

            b.textView46.setVisibility(View.GONE);
            b.layoutTemp6.setVisibility(View.GONE);
            b.temp6.setVisibility(View.GONE);
            b.simvol6.setVisibility(View.GONE);

            b.textView44.setVisibility(View.GONE);
            b.linearLayout16.setVisibility(View.GONE);
            b.day6.setVisibility(View.GONE);
            b.mount6.setVisibility(View.GONE);
            b.age6.setVisibility(View.GONE);

            b.textView47.setVisibility(View.GONE);
            b.imageView3.setVisibility(View.GONE);
            b.poleNote3.setVisibility(View.GONE);
    }

    private void showKnit() {
        if (showCount == 0) {
            showCount = 1;
            if (!b.text1.getText().toString().equals("")) {
                b.text1.setVisibility(View.VISIBLE);
                b.layoutKn1.setVisibility(View.VISIBLE);
                b.day1.setVisibility(View.VISIBLE);
                b.mount1.setVisibility(View.VISIBLE);
                b.age1.setVisibility(View.VISIBLE);
            }

            if (!b.text2.getText().toString().equals("")) {
                b.text2.setVisibility(View.VISIBLE);
                b.layoutKn2.setVisibility(View.VISIBLE);
                b.day2.setVisibility(View.VISIBLE);
                b.mount2.setVisibility(View.VISIBLE);
                b.age2.setVisibility(View.VISIBLE);
            }

            if (!b.text3.getText().toString().equals("")) {
                b.text3.setVisibility(View.VISIBLE);
                b.layoutKn3.setVisibility(View.VISIBLE);
                b.day3.setVisibility(View.VISIBLE);
                b.mount3.setVisibility(View.VISIBLE);
                b.age3.setVisibility(View.VISIBLE);
            }

            if (!b.text4.getText().toString().equals("")) {
                b.text4.setVisibility(View.VISIBLE);
                b.layoutKn4.setVisibility(View.VISIBLE);
                b.day4.setVisibility(View.VISIBLE);
                b.mount4.setVisibility(View.VISIBLE);
                b.age4.setVisibility(View.VISIBLE);
            }

            if (!b.text5.getText().toString().equals("")) {
                b.text5.setVisibility(View.VISIBLE);
                b.layoutKn5.setVisibility(View.VISIBLE);
                b.day5.setVisibility(View.VISIBLE);
                b.mount5.setVisibility(View.VISIBLE);
                b.age5.setVisibility(View.VISIBLE);
            }
        } else if (showCount == 1) {
            hideKnit();
        }
    }

    private void hideKnit() {
        showCount = 0;
        b.text1.setVisibility(View.GONE);
        b.layoutKn1.setVisibility(View.GONE);

        b.text2.setVisibility(View.GONE);
        b.layoutKn2.setVisibility(View.GONE);

        b.text3.setVisibility(View.GONE);
        b.layoutKn3.setVisibility(View.GONE);

        b.text4.setVisibility(View.GONE);
        b.layoutKn4.setVisibility(View.GONE);

        b.text5.setVisibility(View.GONE);
        b.layoutKn5.setVisibility(View.GONE);
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