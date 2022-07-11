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
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentKnittingEditBinding;

import java.util.Calendar;

public class FragmentKnittingEdit extends Fragment implements View.OnClickListener {
    private FragmentKnittingEditBinding b;
    private SampleCallback callback;
    CreateMetod createMetod = new CreateMetod();
    private int countTemp = 1;
    private int countKn = 1;
    private int counthide2 = 0;
    private int counthide3 = 0;
    private int idWomen = 0;
    private int idMan = 0;
    private int countChild1 = 0;
    private int countChild2 = 0;
    private int countChild3 = 0;
    private int countChild4 = 0;
    private int countChild5 = 0;


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
        b = FragmentKnittingEditBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentKnittingEdit");

        id(); // подгрузка данных самки и самца
        child(); // подгрузка детенышей
        initClicker();
        data();
        hide();
        hide2(); // скрыть раздел Иная информация
        hide3(); // скрыть раздел Вязка
        hide4(); // скрыть раздел детеныши
        hide5(); // скрыть раздел с детенышами

        return v;
    }

    private void child(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefChildName1"+ idWomen, Context.MODE_PRIVATE);
        if(!sharedPreferences.getString("childName1"+ idWomen, "").equals("")){
            b.nameChild1.setText(sharedPreferences.getString("childName1"+ idWomen, ""));
        }
    }

    private void hide5(){
        b.layoutChild1.setVisibility(View.GONE);
        b.layoutChild2.setVisibility(View.GONE);
        b.layoutChild3.setVisibility(View.GONE);
        b.layoutChild4.setVisibility(View.GONE);
        b.layoutChild5.setVisibility(View.GONE);
    }

    private void show5(){
        b.layoutChild1.setVisibility(View.VISIBLE);
        b.layoutChild2.setVisibility(View.VISIBLE);
        b.layoutChild3.setVisibility(View.VISIBLE);
        b.layoutChild4.setVisibility(View.VISIBLE);
        b.layoutChild5.setVisibility(View.VISIBLE);
    }

    private void hide4(){
        b.linearLayout5.setVisibility(View.GONE);
    }


    // подгрузка id
    private void id() {
        if (!this.getArguments().getString("key").equals("")) {
            String i = this.getArguments().getString("key");
            idWomen = Integer.parseInt(i);
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKnittingWomen" + idWomen, Context.MODE_PRIVATE);
            if (!sharedPreferences.getString("knittingWomen" + idWomen, "").equals("")) {
                String nameWomen = sharedPreferences.getString("knittingWomen" + idWomen, "");
                b.name.setText(nameWomen);
            }
        }

        if (!this.getArguments().getString("key2").equals("")) {
            String i = this.getArguments().getString("key2");
            idMan = Integer.parseInt(i);
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKnittingMan" + idMan, Context.MODE_PRIVATE);
            if (!sharedPreferences.getString("knittingMan" + idMan, "").equals("")) {
                String nameWomen = sharedPreferences.getString("knittingMan" + idMan, "");
                b.name2.setText(nameWomen);
            }
        }

    }

    private void hide3() {
        counthide3 = 0;
        countKn = 1;
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

        b.layout555.setVisibility(View.GONE);
        b.layout666.setVisibility(View.GONE);
    }

    private void show3() {
        counthide3 = 1;
        b.text1.setVisibility(View.VISIBLE);
        b.layoutKn1.setVisibility(View.VISIBLE);
        b.layout555.setVisibility(View.VISIBLE);

//        b.text2.setVisibility(View.VISIBLE);
//        b.layoutKn2.setVisibility(View.VISIBLE);
//
//        b.text3.setVisibility(View.VISIBLE);
//        b.layoutKn3.setVisibility(View.VISIBLE);
//
//        b.text4.setVisibility(View.VISIBLE);
//        b.layoutKn4.setVisibility(View.VISIBLE);
//
//        b.text5.setVisibility(View.VISIBLE);
//        b.layoutKn5.setVisibility(View.VISIBLE);
//
//        b.layout555.setVisibility(View.VISIBLE);
//        b.layout666.setVisibility(View.VISIBLE);
    }

    private void hide2() {
        counthide2 = 0;
        countTemp = 1;
        b.textView44.setVisibility(View.GONE);
        b.linearLayout16.setVisibility(View.GONE);
        b.textView45.setVisibility(View.GONE);
        b.editText18.setVisibility(View.GONE);
        b.textView46.setVisibility(View.GONE);
        b.layoutAddTemp.setVisibility(View.GONE);
        b.layoutAddTemp2.setVisibility(View.GONE);
        b.textView47.setVisibility(View.GONE);
        b.imageView3.setVisibility(View.GONE);
        b.poleNote3.setVisibility(View.GONE);
        b.layoutTemp1.setVisibility(View.GONE);
        b.layoutTemp2.setVisibility(View.GONE);
        b.layoutTemp3.setVisibility(View.GONE);
        b.layoutTemp4.setVisibility(View.GONE);
        b.layoutTemp5.setVisibility(View.GONE);
        b.layoutTemp6.setVisibility(View.GONE);
        b.imageView12.setVisibility(View.GONE);
        b.textView10.setVisibility(View.GONE);
        b.imageView13.setVisibility(View.GONE);
        b.textView48.setVisibility(View.GONE);
    }

    private void show2() {
        counthide2 = 1;
        b.textView44.setVisibility(View.VISIBLE);
        b.linearLayout16.setVisibility(View.VISIBLE);
        b.textView45.setVisibility(View.VISIBLE);
        b.editText18.setVisibility(View.VISIBLE);
        b.textView46.setVisibility(View.VISIBLE);
        b.layoutAddTemp.setVisibility(View.VISIBLE);
        b.layoutAddTemp2.setVisibility(View.VISIBLE);
        b.textView47.setVisibility(View.VISIBLE);
        b.imageView3.setVisibility(View.VISIBLE);
        b.poleNote3.setVisibility(View.VISIBLE);
        b.layoutTemp1.setVisibility(View.VISIBLE);
        b.imageView12.setVisibility(View.VISIBLE);
        b.textView10.setVisibility(View.VISIBLE);
        b.imageView13.setVisibility(View.VISIBLE);
        b.textView48.setVisibility(View.VISIBLE);
    }

    private void hide() {
        b.layoutTemp2.setVisibility(View.GONE);
        b.layoutTemp3.setVisibility(View.GONE);
        b.layoutTemp4.setVisibility(View.GONE);
        b.layoutTemp5.setVisibility(View.GONE);
        b.layoutTemp6.setVisibility(View.GONE);
        b.layoutAddTemp2.setVisibility(View.GONE);
        b.text2.setVisibility(View.GONE);
        b.layoutKn2.setVisibility(View.GONE);
        b.text3.setVisibility(View.GONE);
        b.layoutKn3.setVisibility(View.GONE);
        b.text4.setVisibility(View.GONE);
        b.layoutKn4.setVisibility(View.GONE);
        b.text5.setVisibility(View.GONE);
        b.layoutKn5.setVisibility(View.GONE);
        b.layout666.setVisibility(View.GONE);
    }

    private void initClicker() {
        b.layoutSetTextKnitting.setOnClickListener(this);
        b.layoutAddTemp.setOnClickListener(this);
        b.layoutAddTemp2.setOnClickListener(this);
        b.layout555.setOnClickListener(this);
        b.layout666.setOnClickListener(this);
        b.layoutSave.setOnClickListener(this);
        b.layoutMinus.setOnClickListener(this);
        b.layoutMinus2.setOnClickListener(this);
        b.linearLayout5.setOnClickListener(this);
        b.layoutChild.setOnClickListener(this);
    }

    private void data() {
        createMetod.dataAvtomat(b.day1, b.mount1, b.age1, b.day2);
        createMetod.dataAvtomat(b.day2, b.mount2, b.age2, b.day3);
        createMetod.dataAvtomat(b.day3, b.mount3, b.age3, b.day4);
        createMetod.dataAvtomat(b.day4, b.mount4, b.age4, b.editText18);
        createMetod.dataAvtomat(b.day5, b.mount5, b.age5, b.day6);
        createMetod.dataAvtomat(b.day6, b.mount6, b.age6, b.editText18);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutSetTextKnitting:
                intentCalender();
                break;
            case R.id.layoutAddTemp:
                showTemp(); // показываем или прячем температуру
                break;
            case R.id.layoutAddTemp2:
                hideTemp(); // показываем или прячем температуру
                break;
            case R.id.layout555:
                showKnitting();
                break;
            case R.id.layout666:
                hideKnitting();
                break;
            case R.id.layoutSave:
                save();
                break;
            case R.id.layoutMinus:
                if (counthide2 == 0) {
                    show2();
                } else if (counthide2 == 1) {
                    hide2();
                }
                break;

            case R.id.layoutMinus2:
                if (counthide3 == 0) {
                    show3();
                } else if (counthide3 == 1) {
                    hide3();
                }
                break;
            case R.id.linearLayout5:
                // когда нажимаем добавить детеныша он вызывает экран создания
                callback.onCreatFragment("createChild");
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefChild", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("child", "yes");
                editor.apply();
                break;

            case R.id.layoutChild:
                if(b.linearLayout5.getVisibility() == View.GONE){
                    b.linearLayout5.setVisibility(View.VISIBLE);
                } else {
                    b.linearLayout5.setVisibility(View.GONE);
                }

                // показать спрятать данные первого детеныша если они есть
                if(countChild1 == 0){
                    if(!b.nameChild1.getText().toString().equals("")){
                        b.layoutChild1.setVisibility(View.VISIBLE);
                        countChild1 = 1;
                    }
                } else if(countChild1 == 1){
                        b.layoutChild1.setVisibility(View.GONE);
                        countChild1 = 0;
                }

                // показать спрятать данные второго детеныша если они есть
                if(countChild2 == 0){
                    if(!b.nameChild2.getText().toString().equals("")){
                        b.layoutChild2.setVisibility(View.VISIBLE);
                        countChild2 = 1;
                    }
                } else if(countChild2 == 1){
                    b.layoutChild2.setVisibility(View.GONE);
                    countChild2 = 0;
                }

                // показать спрятать данные второго детеныша если они есть
                if(countChild3 == 0){
                    if(!b.nameChild3.getText().toString().equals("")){
                        b.layoutChild3.setVisibility(View.VISIBLE);
                        countChild3 = 1;
                    }
                } else if(countChild3 == 1){
                    b.layoutChild3.setVisibility(View.GONE);
                    countChild3 = 0;
                }

                // показать спрятать данные второго детеныша если они есть
                if(countChild4 == 0){
                    if(!b.nameChild4.getText().toString().equals("")){
                        b.layoutChild4.setVisibility(View.VISIBLE);
                        countChild4 = 1;
                    }
                } else if(countChild4 == 1){
                    b.layoutChild4.setVisibility(View.GONE);
                    countChild4 = 0;
                }

                // показать спрятать данные второго детеныша если они есть
                if(countChild5 == 0){
                    if(!b.nameChild5.getText().toString().equals("")){
                        b.layoutChild5.setVisibility(View.VISIBLE);
                        countChild5 = 1;
                    }
                } else if(countChild5 == 1){
                    b.layoutChild5.setVisibility(View.GONE);
                    countChild5 = 0;
                }


//                if(b.layoutChild1.getVisibility() == View.GONE){
//                    b.layoutChild1.setVisibility(View.VISIBLE);
//                } else {
//                    b.layoutChild1.setVisibility(View.GONE);
//                }
//
//                if(b.layoutChild2.getVisibility() == View.GONE){
//                    b.layoutChild2.setVisibility(View.VISIBLE);
//                } else {
//                    b.layoutChild2.setVisibility(View.GONE);
//                }
//
//                if(b.layoutChild3.getVisibility() == View.GONE){
//                    b.layoutChild3.setVisibility(View.VISIBLE);
//                } else {
//                    b.layoutChild3.setVisibility(View.GONE);
//                }
//
//                if(b.layoutChild4.getVisibility() == View.GONE){
//                    b.layoutChild4.setVisibility(View.VISIBLE);
//                } else {
//                    b.layoutChild4.setVisibility(View.GONE);
//                }
//
//                if(b.layoutChild5.getVisibility() == View.GONE){
//                    b.layoutChild5.setVisibility(View.VISIBLE);
//                } else {
//                    b.layoutChild5.setVisibility(View.GONE);
//                }

                break;
        }
    }

    private void save() {
        if (!b.name.getText().toString().equals("") && !b.name2.getText().toString().equals("")) {
            for (int i = 1; i < 100; i++) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKnitWomen" + i, Context.MODE_PRIVATE);
                if (sharedPreferences.getString("knitWomen" + i, "").equals("")) {

                    SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnitWomen" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                    editor1.putString("knitWomen" + i, b.name.getText().toString());
                    editor1.apply();


                    SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefKnitMan" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    editor2.putString("knitMan" + i, b.name2.getText().toString());
                    editor2.apply();

                    // сохранить данные по датам вязок

                    if (!b.day1.getText().toString().equals("")) {
                        saveDate("prefKnitDay1", "knitDay1", i, b.day1);
                    }
                    if (!b.mount1.getText().toString().equals("")) {
                        saveDate("prefKnitMount1", "knitMount1", i, b.mount1);
                    }
                    if (!b.age1.getText().toString().equals("")) {
                        saveDate("prefKnitAge1", "knitAge1", i, b.age1);
                    }


                    if (!b.day2.getText().toString().equals("")) {
                        saveDate("prefKnitDay2", "knitDay2", i, b.day2);
                    }
                    if (!b.mount2.getText().toString().equals("")) {
                        saveDate("prefKnitMount2", "knitMount2", i, b.mount2);
                    }
                    if (!b.age2.getText().toString().equals("")) {
                        saveDate("prefKnitAge2", "knitAge2", i, b.age2);
                    }


                    if (!b.day3.getText().toString().equals("")) {
                        saveDate("prefKnitDay3", "knitDay3", i, b.day3);
                    }
                    if (!b.mount3.getText().toString().equals("")) {
                        saveDate("prefKnitMount3", "knitMount3", i, b.mount3);
                    }
                    if (!b.age3.getText().toString().equals("")) {
                        saveDate("prefKnitAge3", "knitAge3", i, b.age3);
                    }
                    if (!b.day4.getText().toString().equals("")) {
                        saveDate("prefKnitDay4", "knitDay4", i, b.day4);
                    }
                    if (!b.mount4.getText().toString().equals("")) {
                        saveDate("prefKnitMount4", "knitMount4", i, b.mount4);
                    }
                    if (!b.age4.getText().toString().equals("")) {
                        saveDate("prefKnitAge4", "knitAge4", i, b.age4);
                    }
                    if (!b.day5.getText().toString().equals("")) {
                        saveDate("prefKnitDay5", "knitDay5", i, b.day5);
                    }
                    if(!b.mount5.getText().toString().equals("")){
                        saveDate("prefKnitMount5", "knitMount5", i, b.mount5);
                    }
                    if(!b.age5.getText().toString().equals("")){
                        saveDate("prefKnitAge5", "knitAge5", i, b.age5);
                    }

                    // сохранить показатели узи
                    SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefYzi" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                    editor3.putString("yzi" + i, b.editText18.getText().toString());
                    editor3.apply();

                    // сохранить показания температуры
                    SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefTemp1" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor11 = sharedPreferences11.edit();
                    editor11.putString("temp1" + i, b.temp1.getText().toString());
                    editor11.apply();

                    SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefTemp2" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor12 = sharedPreferences12.edit();
                    editor12.putString("temp2" + i, b.temp2.getText().toString());
                    editor12.apply();

                    SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefTemp3" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor13 = sharedPreferences13.edit();
                    editor13.putString("temp3" + i, b.temp3.getText().toString());
                    editor13.apply();

                    SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefTemp4" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor14 = sharedPreferences14.edit();
                    editor14.putString("temp4" + i, b.temp4.getText().toString());
                    editor14.apply();

                    SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefTemp5" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor15 = sharedPreferences15.edit();
                    editor15.putString("temp5" + i, b.temp5.getText().toString());
                    editor15.apply();

                    SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefTemp6" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor16 = sharedPreferences16.edit();
                    editor16.putString("temp6" + i, b.temp6.getText().toString());
                    editor16.apply();

                    SharedPreferences sharedPreferences17 = getActivity().getSharedPreferences("prefChildDay" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor17 = sharedPreferences17.edit();
                    editor17.putString("childDay" + i, b.day6.getText().toString());
                    editor17.apply();

                    SharedPreferences sharedPreferences18 = getActivity().getSharedPreferences("prefChildMount" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor18 = sharedPreferences18.edit();
                    editor18.putString("childMount" + i, b.mount6.getText().toString());
                    editor18.apply();

                    SharedPreferences sharedPreferences19 = getActivity().getSharedPreferences("prefChildAge" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor19 = sharedPreferences19.edit();
                    editor19.putString("childAge" + i, b.age6.getText().toString());
                    editor19.apply();

                    SharedPreferences sharedPreferences20 = getActivity().getSharedPreferences("prefChildPole" + i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor20 = sharedPreferences20.edit();
                    editor20.putString("childPole" + i, b.poleNote3.getText().toString());
                    editor20.apply();

                    SharedPreferences sharedPreferences21 = getActivity().getSharedPreferences("prefChildName1"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor21 = sharedPreferences21.edit();
                    editor21.putString("childName1" + i, b.nameChild1.getText().toString());
                    editor21.apply();

                    SharedPreferences sharedPreferences22 = getActivity().getSharedPreferences("prefChildName2"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor22 = sharedPreferences22.edit();
                    editor22.putString("childName2" + i, b.nameChild2.getText().toString());
                    editor22.apply();

                    SharedPreferences sharedPreferences23 = getActivity().getSharedPreferences("prefChildName3"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor23 = sharedPreferences23.edit();
                    editor23.putString("childName3" + i, b.nameChild3.getText().toString());
                    editor23.apply();

                    SharedPreferences sharedPreferences24 = getActivity().getSharedPreferences("prefChildName4"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor24 = sharedPreferences24.edit();
                    editor24.putString("childName4" + i, b.nameChild4.getText().toString());
                    editor24.apply();

                    SharedPreferences sharedPreferences25 = getActivity().getSharedPreferences("prefChildName5"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor25 = sharedPreferences25.edit();
                    editor25.putString("childName5" + i, b.nameChild5.getText().toString());
                    editor25.apply();

                    SharedPreferences sharedPreferences26 = getActivity().getSharedPreferences("prefChildGender1"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor26 = sharedPreferences26.edit();
                    editor26.putString("childGender1" + i, b.genderChild1.getText().toString());
                    editor26.apply();

                    SharedPreferences sharedPreferences27 = getActivity().getSharedPreferences("prefChildGender2"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor27 = sharedPreferences27.edit();
                    editor27.putString("childGender2" + i, b.genderChild2.getText().toString());
                    editor27.apply();

                    SharedPreferences sharedPreferences28 = getActivity().getSharedPreferences("prefChildGender3"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor28 = sharedPreferences28.edit();
                    editor28.putString("childGender3" + i, b.genderChild3.getText().toString());
                    editor28.apply();

                    SharedPreferences sharedPreferences29 = getActivity().getSharedPreferences("prefChildGender4"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor29 = sharedPreferences29.edit();
                    editor29.putString("childGender4" + i, b.genderChild4.getText().toString());
                    editor29.apply();

                    SharedPreferences sharedPreferences30 = getActivity().getSharedPreferences("prefChildGender5"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor30 = sharedPreferences30.edit();
                    editor30.putString("childGender5" + i, b.genderChild5.getText().toString());
                    editor30.apply();

                    SharedPreferences sharedPreferences31 = getActivity().getSharedPreferences("prefChildData1"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor31 = sharedPreferences31.edit();
                    editor31.putString("childData1" + i, b.gataChild1.getText().toString());
                    editor31.apply();

                    SharedPreferences sharedPreferences32 = getActivity().getSharedPreferences("prefChildData2"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor32 = sharedPreferences32.edit();
                    editor32.putString("childData2" + i, b.gataChild2.getText().toString());
                    editor32.apply();

                    SharedPreferences sharedPreferences33 = getActivity().getSharedPreferences("prefChildData3"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor33 = sharedPreferences33.edit();
                    editor33.putString("childData3" + i, b.gataChild3.getText().toString());
                    editor33.apply();

                    SharedPreferences sharedPreferences34 = getActivity().getSharedPreferences("prefChildData4"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor34 = sharedPreferences34.edit();
                    editor34.putString("childData4" + i, b.gataChild4.getText().toString());
                    editor34.apply();

                    SharedPreferences sharedPreferences35 = getActivity().getSharedPreferences("prefChildData5"+i, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor35 = sharedPreferences35.edit();
                    editor35.putString("childData5" + i, b.gataChild5.getText().toString());
                    editor35.apply();


                    Toast.makeText(getActivity(), "Сохранено", Toast.LENGTH_SHORT).show();
                    callback.onCreatFragment("FragmentKnittingSave");
                    break;
                }
            }
        }


    }

    // метод для сохранения дат по вязке
    private void saveDate(String pref, String key, int i, EditText text) {
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences(pref + i, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        editor2.putString(key + i, text.getText().toString());
        editor2.apply();
    }


    private void hideKnitting() {
        if (b.layoutKn5.getVisibility() == View.VISIBLE) {
            b.text5.setVisibility(View.GONE);
            b.layoutKn5.setVisibility(View.GONE);
            countKn = 4;
            b.layout555.setVisibility(View.VISIBLE);
        } else if (b.layoutKn4.getVisibility() == View.VISIBLE) {
            b.text4.setVisibility(View.GONE);
            b.layoutKn4.setVisibility(View.GONE);
            countKn = 3;
            b.layout555.setVisibility(View.VISIBLE);
        } else if (b.layoutKn3.getVisibility() == View.VISIBLE) {
            b.text3.setVisibility(View.GONE);
            b.layoutKn3.setVisibility(View.GONE);
            countKn = 2;
            b.layout555.setVisibility(View.VISIBLE);
        } else if (b.layoutKn2.getVisibility() == View.VISIBLE) {
            b.text2.setVisibility(View.GONE);
            b.layoutKn2.setVisibility(View.GONE);
            countKn = 1;
            b.layout555.setVisibility(View.VISIBLE);
            b.layout666.setVisibility(View.GONE);
        }
    }

    private void showKnitting() {
        if (countKn == 1) {
            b.layout666.setVisibility(View.VISIBLE);
            countKn = 2;
            b.text2.setVisibility(View.VISIBLE);
            b.layoutKn2.setVisibility(View.VISIBLE);
        } else if (countKn == 2) {
            countKn = 3;
            b.layout666.setVisibility(View.VISIBLE);
            b.text3.setVisibility(View.VISIBLE);
            b.layoutKn3.setVisibility(View.VISIBLE);
        } else if (countKn == 3) {
            countKn = 4;
            b.layout666.setVisibility(View.VISIBLE);
            b.text4.setVisibility(View.VISIBLE);
            b.layoutKn4.setVisibility(View.VISIBLE);
        } else if (countKn == 4) {
            countKn = 5;
            b.layout555.setVisibility(View.GONE);
            b.layout666.setVisibility(View.VISIBLE);
            b.text5.setVisibility(View.VISIBLE);
            b.layoutKn5.setVisibility(View.VISIBLE);
        }
    }

    private void hideTemp() {
        if (b.layoutTemp6.getVisibility() == View.VISIBLE) {
            b.layoutTemp6.setVisibility(View.GONE);
            countTemp = 5;
            b.layoutAddTemp.setVisibility(View.VISIBLE);
        } else if (b.layoutTemp5.getVisibility() == View.VISIBLE) {
            b.layoutTemp5.setVisibility(View.GONE);
            countTemp = 4;
            b.layoutAddTemp.setVisibility(View.VISIBLE);
        } else if (b.layoutTemp4.getVisibility() == View.VISIBLE) {
            b.layoutTemp4.setVisibility(View.GONE);
            countTemp = 3;
            b.layoutAddTemp.setVisibility(View.VISIBLE);
        } else if (b.layoutTemp3.getVisibility() == View.VISIBLE) {
            b.layoutTemp3.setVisibility(View.GONE);
            countTemp = 2;
            b.layoutAddTemp.setVisibility(View.VISIBLE);
        } else if (b.layoutTemp2.getVisibility() == View.VISIBLE) {
            b.layoutTemp2.setVisibility(View.GONE);
            b.layoutAddTemp2.setVisibility(View.GONE);
            countTemp = 1;
        }
    }

    // метод показа доп температуры
    private void showTemp() {
        countTemp++;
        if (countTemp == 2) {
            b.layoutTemp2.setVisibility(View.VISIBLE);
            b.temp2.setVisibility(View.VISIBLE);
            b.simvol2.setVisibility(View.VISIBLE);
            b.layoutAddTemp2.setVisibility(View.VISIBLE);
        } else if (countTemp == 3) {
            b.layoutTemp3.setVisibility(View.VISIBLE);
            b.temp3.setVisibility(View.VISIBLE);
            b.simvol3.setVisibility(View.VISIBLE);
            b.layoutAddTemp2.setVisibility(View.VISIBLE);
        } else if (countTemp == 4) {
            b.layoutTemp4.setVisibility(View.VISIBLE);
            b.temp4.setVisibility(View.VISIBLE);
            b.simvol4.setVisibility(View.VISIBLE);
            b.layoutAddTemp2.setVisibility(View.VISIBLE);
        } else if (countTemp == 5) {
            b.layoutTemp5.setVisibility(View.VISIBLE);
            b.temp5.setVisibility(View.VISIBLE);
            b.simvol5.setVisibility(View.VISIBLE);
            b.layoutAddTemp2.setVisibility(View.VISIBLE);
        } else if (countTemp == 6) {
            b.layoutTemp6.setVisibility(View.VISIBLE);
            b.temp6.setVisibility(View.VISIBLE);
            b.simvol6.setVisibility(View.VISIBLE);
            b.layoutAddTemp2.setVisibility(View.VISIBLE);
            b.layoutAddTemp.setVisibility(View.GONE);
        }
    }
}