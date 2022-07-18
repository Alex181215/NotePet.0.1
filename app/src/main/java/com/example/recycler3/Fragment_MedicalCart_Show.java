package com.example.recycler3;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recycler3.databinding.FragmentMedicalCartShowBinding;

import java.util.Calendar;


public class Fragment_MedicalCart_Show extends Fragment implements View.OnClickListener {
    private FragmentMedicalCartShowBinding b;
    private int id = 0;
    private int countEdit = 0;
    private int countSimp = 0;
    private int countTemp = 1;
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
        b = FragmentMedicalCartShowBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        data(); // автопереход по датам
        id(); // подгрузка айди
        load(); // подругрузка данных из сохраненки по айди
        hide(); // режим просморта, убираем все лишнее
        initClicker(); // инициализируем клики
        testTempCount();
        return (v);
    }

    // подгрузка id
      private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    // метод переход по полям дата
    private void data() {
        createMetod.dataAvtomat(b.day1, b.mount1, b.age1, b.hour1);
    }

    private void show() {
        countEdit = 1;

        // спрятать карандаш
        b.bigPen.setVisibility(View.GONE);

        // показать второе напоминание
        b.linearLayout5.setVisibility(View.VISIBLE);
        b.clock1.setVisibility(View.VISIBLE);
        b.clock2.setVisibility(View.VISIBLE);

        // показать кнопку сохранить
        b.layoutBtnSave.setVisibility(View.VISIBLE);
        b.imageBtnSave.setVisibility(View.VISIBLE);
        b.textBtnSave.setVisibility(View.VISIBLE);

        // метод поставить полям едит текста зеленный цвет
        b.day1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.mount1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.age1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.hour1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.min1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.text1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));

        b.fio.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.adres.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.tel.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.temp1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.temp2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.temp3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.temp4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.temp5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
        b.temp6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));

        // включить поля для редактирвания
        b.day1.setEnabled(true);
        b.mount1.setEnabled(true);
        b.age1.setEnabled(true);
        b.hour1.setEnabled(true);
        b.min1.setEnabled(true);
        b.text1.setEnabled(true);
        b.fio.setEnabled(true);
        b.tel.setEnabled(true);
        b.adres.setEnabled(true);
        b.poleNote1.setEnabled(true);
        b.temp1.setEnabled(true);
        b.temp2.setEnabled(true);
        b.temp3.setEnabled(true);
        b.temp4.setEnabled(true);
        b.temp5.setEnabled(true);
        b.temp6.setEnabled(true);
    }

    private void hide() {
        countEdit = 0;

        // показать карандаш
        b.bigPen.setVisibility(View.VISIBLE);

        // спрятать раздел температуры
        b.layoutTempHeader.setVisibility(View.GONE);
        b.tempHeader.setVisibility(View.GONE);

        b.layoutTemp1.setVisibility(View.GONE);
        b.temp1.setVisibility(View.GONE);
        b.simvol1.setVisibility(View.GONE);

        b.layoutTemp2.setVisibility(View.GONE);
        b.temp2.setVisibility(View.GONE);
        b.simvol2.setVisibility(View.GONE);

        b.layoutTemp3.setVisibility(View.GONE);
        b.temp3.setVisibility(View.GONE);
        b.simvol3.setVisibility(View.GONE);

        b.layoutTemp4.setVisibility(View.GONE);
        b.temp4.setVisibility(View.GONE);
        b.simvol4.setVisibility(View.GONE);

        b.layoutTemp5.setVisibility(View.GONE);
        b.temp5.setVisibility(View.GONE);
        b.simvol5.setVisibility(View.GONE);

        b.layoutTemp6.setVisibility(View.GONE);
        b.temp6.setVisibility(View.GONE);
        b.simvol6.setVisibility(View.GONE);

        // спрятать кнопку добавить температуру
        b.layoutAddTemp.setVisibility(View.GONE);
        b.imageView9.setVisibility(View.GONE);
        b.textView3.setVisibility(View.GONE);

        // спрятать добававить фото
        b.imageView12.setVisibility(View.GONE);
        b.setImage.setVisibility(View.GONE);

        // спрятать добавить видео
        b.imageView13.setVisibility(View.GONE);
        b.textView13.setVisibility(View.GONE);

        // спрятать первое напоминание
        b.layoutSetTextMedCarta.setVisibility(View.GONE);
        b.imageSetTextMedCarta.setVisibility(View.GONE);
        b.textSetTextMedCarta.setVisibility(View.GONE);

        // спрятать второе напоминание
        b.linearLayout5.setVisibility(View.GONE);
        b.clock1.setVisibility(View.GONE);
        b.clock2.setVisibility(View.GONE);

        // спрятать кнопку сохранить
        b.layoutBtnSave.setVisibility(View.GONE);
        b.imageBtnSave.setVisibility(View.GONE);
        b.textBtnSave.setVisibility(View.GONE);

        // спрятать кнопку добавить фото
        b.imageView15.setVisibility(View.GONE);
        b.textView20.setVisibility(View.GONE);

        // спрятать кнопку добавить видео
        b.imageView16.setVisibility(View.GONE);
        b.textView21.setVisibility(View.GONE);

        // отключить поля для редактирвания
        b.day1.setEnabled(false);
        b.mount1.setEnabled(false);
        b.age1.setEnabled(false);
        b.hour1.setEnabled(false);
        b.min1.setEnabled(false);
        b.text1.setEnabled(false);
        b.fio.setEnabled(false);
        b.tel.setEnabled(false);
        b.adres.setEnabled(false);
        b.poleNote1.setEnabled(false);
        b.temp1.setEnabled(false);
        b.temp2.setEnabled(false);
        b.temp3.setEnabled(false);
        b.temp4.setEnabled(false);
        b.temp5.setEnabled(false);
        b.temp6.setEnabled(false);

        // метод поставить полям едит текста прозрачный цвет
        b.day1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.mount1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.age1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.hour1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.min1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.text1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));

        b.fio.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.adres.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.tel.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.temp1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.temp2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.temp3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.temp4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.temp5.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
        b.temp6.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.transparent)));
    }

    private void initClicker() {
        b.linearLayout.setOnClickListener(this); // слушатель спойлера симптомы
        b.linearLayout5.setOnClickListener(this); // слушатель спойлера анализы
        b.bigPen.setOnClickListener(this); // слушатель кнопки карандаш
        b.layoutBtnSave.setOnClickListener(this); // слушатель кнопки сохранить
        b.layoutAddTemp.setOnClickListener(this); // слушатель кнопки добавить температуру
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearLayout: // слушатель спойлера симптомы
                simpt();
                break;
            case R.id.layoutSetTextKnitting: // слушатель спойлера анализы
                break;
            case R.id.linearLayout5: // слушатель кнопки напоминания
                intentCalender();
                break;
            case R.id.bigPen: // слушатель кнопки карандаш
                show();
                if (b.temp1.getVisibility() == View.VISIBLE) {
                    b.layoutAddTemp.setVisibility(View.VISIBLE);
                    b.imageView9.setVisibility(View.VISIBLE);
                    b.textView3.setVisibility(View.VISIBLE);

                    b.imageView12.setVisibility(View.VISIBLE);
                    b.setImage.setVisibility(View.VISIBLE);
                    b.imageView13.setVisibility(View.VISIBLE);
                    b.textView13.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.layout_btn_save: // слушатель кнокпи сохранить
                testData();
//                testTempCount();
            case R.id.layoutAddTemp: // слушатель добавить температуру
                showTemp();
                break;
        }
    }

    private void testTempCount(){
        if (!b.temp1.getText().toString().equals("")) {
            countTemp = 1;
        }
        if (!b.temp2.getText().toString().equals("")) {
            countTemp = 2;
        }
        if (!b.temp3.getText().toString().equals("")) {
            countTemp = 3;
        }
        if (!b.temp4.getText().toString().equals("")) {
            countTemp = 4;
        }
        if(!b.temp5.getText().toString().equals("")){
            countTemp = 5;
        }
        if(!b.temp6.getText().toString().equals("")){
            countTemp = 6;
        }
    }

    private void showTemp() {
        countTemp++;
        if (countTemp == 2) {
            b.layoutTemp2.setVisibility(View.VISIBLE);
            b.temp2.setVisibility(View.VISIBLE);
            b.simvol2.setVisibility(View.VISIBLE);
        } else if (countTemp == 3) {
            b.layoutTemp3.setVisibility(View.VISIBLE);
            b.temp3.setVisibility(View.VISIBLE);
            b.simvol3.setVisibility(View.VISIBLE);
        } else if (countTemp == 4) {
            b.layoutTemp4.setVisibility(View.VISIBLE);
            b.temp4.setVisibility(View.VISIBLE);
            b.simvol4.setVisibility(View.VISIBLE);
        } else if (countTemp == 5) {
            b.layoutTemp5.setVisibility(View.VISIBLE);
            b.temp5.setVisibility(View.VISIBLE);
            b.simvol5.setVisibility(View.VISIBLE);
        } else if (countTemp == 6) {
            b.layoutTemp6.setVisibility(View.VISIBLE);
            b.temp6.setVisibility(View.VISIBLE);
            b.simvol6.setVisibility(View.VISIBLE);
        }
    }

    private void simpt() {
        if (countSimp == 0) {
            countSimp = 1;
            if (countEdit == 0) {
                b.layoutTempHeader.setVisibility(View.VISIBLE);
                b.tempHeader.setVisibility(View.VISIBLE);

                b.layoutTemp1.setVisibility(View.VISIBLE);
                b.temp1.setVisibility(View.VISIBLE);
                b.simvol1.setVisibility(View.VISIBLE);

                if (!b.temp2.getText().toString().equals("")) {
                    b.layoutTemp2.setVisibility(View.VISIBLE);
                    b.temp2.setVisibility(View.VISIBLE);
                    b.simvol2.setVisibility(View.VISIBLE);
                }
                if (!b.temp3.getText().toString().equals("")) {
                    b.layoutTemp3.setVisibility(View.VISIBLE);
                    b.temp3.setVisibility(View.VISIBLE);
                    b.simvol3.setVisibility(View.VISIBLE);
                }
                if (!b.temp4.getText().toString().equals("")) {
                    b.layoutTemp4.setVisibility(View.VISIBLE);
                    b.temp4.setVisibility(View.VISIBLE);
                    b.simvol4.setVisibility(View.VISIBLE);
                }
                if (!b.temp5.getText().toString().equals("")) {
                    b.layoutTemp5.setVisibility(View.VISIBLE);
                    b.temp5.setVisibility(View.VISIBLE);
                    b.simvol5.setVisibility(View.VISIBLE);
                }
                if (!b.temp6.getText().toString().equals("")) {
                    b.layoutTemp6.setVisibility(View.VISIBLE);
                    b.temp6.setVisibility(View.VISIBLE);
                    b.simvol6.setVisibility(View.VISIBLE);
                }
            } else if (countEdit == 1) {
                b.layoutTempHeader.setVisibility(View.VISIBLE);
                b.tempHeader.setVisibility(View.VISIBLE);

                b.layoutAddTemp.setVisibility(View.VISIBLE);
                b.imageView9.setVisibility(View.VISIBLE);
                b.textView3.setVisibility(View.VISIBLE);

                b.imageView12.setVisibility(View.VISIBLE);
                b.setImage.setVisibility(View.VISIBLE);
                b.imageView13.setVisibility(View.VISIBLE);
                b.textView13.setVisibility(View.VISIBLE);

                b.layoutTemp1.setVisibility(View.VISIBLE);
                b.temp1.setVisibility(View.VISIBLE);
                b.simvol1.setVisibility(View.VISIBLE);

                if (!b.temp2.getText().toString().equals("")) {
                    b.layoutTemp2.setVisibility(View.VISIBLE);
                    b.temp2.setVisibility(View.VISIBLE);
                    b.simvol2.setVisibility(View.VISIBLE);
                }
                if (!b.temp3.getText().toString().equals("")) {
                    b.layoutTemp3.setVisibility(View.VISIBLE);
                    b.temp3.setVisibility(View.VISIBLE);
                    b.simvol3.setVisibility(View.VISIBLE);
                }
                if (!b.temp4.getText().toString().equals("")) {
                    b.layoutTemp4.setVisibility(View.VISIBLE);
                    b.temp4.setVisibility(View.VISIBLE);
                    b.simvol4.setVisibility(View.VISIBLE);
                }
                if (!b.temp5.getText().toString().equals("")) {
                    b.layoutTemp5.setVisibility(View.VISIBLE);
                    b.temp5.setVisibility(View.VISIBLE);
                    b.simvol5.setVisibility(View.VISIBLE);
                }
                if (!b.temp6.getText().toString().equals("")) {
                    b.layoutTemp6.setVisibility(View.VISIBLE);
                    b.temp6.setVisibility(View.VISIBLE);
                    b.simvol6.setVisibility(View.VISIBLE);
                }
            }
        } else if (countSimp == 1) {
            countSimp = 0;
            // спрятать заголовок
            b.layoutTempHeader.setVisibility(View.GONE);
            b.tempHeader.setVisibility(View.GONE);

            // спрятать поля температуры
            b.layoutTemp1.setVisibility(View.GONE);
            b.temp1.setVisibility(View.GONE);
            b.simvol1.setVisibility(View.GONE);

            b.layoutTemp2.setVisibility(View.GONE);
            b.temp2.setVisibility(View.GONE);
            b.simvol2.setVisibility(View.GONE);

            b.layoutTemp3.setVisibility(View.GONE);
            b.temp3.setVisibility(View.GONE);
            b.simvol3.setVisibility(View.GONE);

            b.layoutTemp4.setVisibility(View.GONE);
            b.temp4.setVisibility(View.GONE);
            b.simvol4.setVisibility(View.GONE);

            b.layoutTemp5.setVisibility(View.GONE);
            b.temp5.setVisibility(View.GONE);
            b.simvol5.setVisibility(View.GONE);

            b.layoutTemp6.setVisibility(View.GONE);
            b.temp6.setVisibility(View.GONE);
            b.simvol6.setVisibility(View.GONE);

            // спрятать добавить температуру
            b.layoutAddTemp.setVisibility(View.GONE);
            b.imageView9.setVisibility(View.GONE);
            b.textView3.setVisibility(View.GONE);

            // спрятать температуру
            b.layoutTemp1.setVisibility(View.GONE);
            b.temp1.setVisibility(View.GONE);
            b.simvol1.setVisibility(View.GONE);

            // спрятать добавить фото
            b.imageView12.setVisibility(View.GONE);
            b.setImage.setVisibility(View.GONE);

            // спрятать добавить видео
            b.imageView13.setVisibility(View.GONE);
            b.textView13.setVisibility(View.GONE);
        }


    }

    private void testData() {
        save();
    }

    private void save() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefHourMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefMinMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefCauseMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefFioMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTelMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefAdresMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefNoteMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefTemp1MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefTemp2MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefTemp3MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefTemp4MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefTemp5MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefTemp6MedCart" + id, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString("dayMedCart" + id, b.day1.getText().toString());
        editor1.apply();

        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        editor2.putString("mountMedCart" + id, b.mount1.getText().toString());
        editor2.apply();

        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
        editor3.putString("ageMedCart" + id, b.age1.getText().toString());
        editor3.apply();

        SharedPreferences.Editor editor4 = sharedPreferences4.edit();
        editor4.putString("hourMedCart" + id, b.hour1.getText().toString());
        editor4.apply();

        SharedPreferences.Editor editor5 = sharedPreferences5.edit();
        editor5.putString("minMedCart" + id, b.min1.getText().toString());
        editor5.apply();

        SharedPreferences.Editor editor6 = sharedPreferences6.edit();
        editor6.putString("causeMedCart" + id, b.text1.getText().toString());
        editor6.apply();

        SharedPreferences.Editor editor7 = sharedPreferences7.edit();
        editor7.putString("fioMedCart" + id, b.fio.getText().toString());
        editor7.apply();

        SharedPreferences.Editor editor8 = sharedPreferences8.edit();
        editor8.putString("telMedCart" + id, b.tel.getText().toString());
        editor8.apply();

        SharedPreferences.Editor editor9 = sharedPreferences9.edit();
        editor9.putString("adresMedCart" + id, b.adres.getText().toString());
        editor9.apply();

        SharedPreferences.Editor editor10 = sharedPreferences10.edit();
        editor10.putString("noteMedCart" + id, b.poleNote1.getText().toString());
        editor10.apply();

        SharedPreferences.Editor editor11 = sharedPreferences11.edit();
        editor11.putString("temp1MedCart" + id, b.temp1.getText().toString());
        editor11.apply();

        SharedPreferences.Editor editor12 = sharedPreferences12.edit();
        editor12.putString("temp2MedCart" + id, b.temp2.getText().toString());
        editor12.apply();

        SharedPreferences.Editor editor13 = sharedPreferences13.edit();
        editor13.putString("temp3MedCart" + id, b.temp3.getText().toString());
        editor13.apply();

        SharedPreferences.Editor editor14 = sharedPreferences14.edit();
        editor14.putString("temp4MedCart" + id, b.temp4.getText().toString());
        editor14.apply();

        SharedPreferences.Editor editor15 = sharedPreferences15.edit();
        editor15.putString("temp5MedCart" + id, b.temp5.getText().toString());
        editor15.apply();

        SharedPreferences.Editor editor16 = sharedPreferences16.edit();
        editor16.putString("temp6MedCart" + id, b.temp6.getText().toString());
        editor16.apply();

//        hide();
        // открываем фрагмент мед карта
        callback.onCreatFragment("medCarta");
    }


    // метод подгрузки данных из сохраненки
    private void load() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefHourMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefMinMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefCauseMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefFioMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTelMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefAdresMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefNoteMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefTemp1MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefTemp2MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefTemp3MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefTemp4MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefTemp5MedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefTemp6MedCart" + id, Context.MODE_PRIVATE);

        String day = sharedPreferences1.getString("dayMedCart" + id, "");
        String mount = sharedPreferences2.getString("mountMedCart" + id, "");
        String age = sharedPreferences3.getString("ageMedCart" + id, "");
        String hour = sharedPreferences4.getString("hourMedCart" + id, "");
        String min = sharedPreferences5.getString("minMedCart" + id, "");
        String cause = sharedPreferences6.getString("causeMedCart" + id, "");
        String fio = sharedPreferences7.getString("fioMedCart" + id, "");
        String tel = sharedPreferences8.getString("telMedCart" + id, "");
        String adres = sharedPreferences9.getString("adresMedCart" + id, "");
        String note = sharedPreferences10.getString("noteMedCart" + id, "");
        String temp1 = sharedPreferences11.getString("temp1MedCart" + id, "");
        String temp2 = sharedPreferences12.getString("temp2MedCart" + id, "");
        String temp3 = sharedPreferences13.getString("temp3MedCart" + id, "");
        String temp4 = sharedPreferences14.getString("temp4MedCart" + id, "");
        String temp5 = sharedPreferences15.getString("temp5MedCart" + id, "");
        String temp6 = sharedPreferences16.getString("temp6MedCart" + id, "");

        b.textView23.setText(day + "." + mount + "." + age + ".г");

        b.day1.setText(day);
        b.mount1.setText(mount);
        b.age1.setText(age);
        b.hour1.setText(hour);
        b.min1.setText(min);
        b.text1.setText(cause);

        b.fio.setText(fio);
        b.tel.setText(tel);
        b.adres.setText(adres);
        b.poleNote1.setText(note);
        b.temp1.setText(temp1);
        b.temp2.setText(temp2);
        b.temp3.setText(temp3);
        b.temp4.setText(temp4);
        b.temp5.setText(temp5);
        b.temp6.setText(temp6);
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