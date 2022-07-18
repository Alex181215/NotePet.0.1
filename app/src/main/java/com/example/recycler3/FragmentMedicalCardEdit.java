package com.example.recycler3;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentMedicalCardEditBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FragmentMedicalCardEdit extends Fragment implements View.OnClickListener {
    private FragmentMedicalCardEditBinding b;
    private SampleCallback callback;
    CreateMetod createMetod = new CreateMetod();

    public boolean isReached = false;
    int currentAge = 0, dayInt1 = 0, mountInt1 = 0, ageInt1 = 0, hourInt1 = 0, minInt1 = 0;
    String day1 = "", mount1 = "", age1 = "";
    Boolean diagnosis = false, route = false;
    int countTemp = 1;
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
        b = FragmentMedicalCardEditBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentMedicalCardEdit");
        id();
        hide(); // спрятать ненужный лайяут с напоминаниями
        initCliker(); // слушатели
        data(); // атопереход по датам
        nextEditAll(); // переход с дат на время и затем на текст
        setAge();     // метод сьема системной даты ( года )
        hideDiagnosis(); // метод спрятать раздел диагноз пока его не откроют
        hideRoute(); // метод спрятать раздел направление на анализы
        hideTemp(); // скрыть доп температуры
        return v;
    }

    // получаем айди активного питомца
    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    // инициализация группы кликов
    private void initCliker() {
        b.layoutSetTextMedCarta.setOnClickListener(this);
        b.layoutBtnSave.setOnClickListener(this);
        b.linearLayout.setOnClickListener(this);
        b.layoutSetTextKnitting.setOnClickListener(this);
        b.layoutAddTemp.setOnClickListener(this);
        b.layoutAddTemp2.setOnClickListener(this);
    }

    // метод скрытия доп температуры
    private void hideTemp() {
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
    }

    private void hideTemp2() {
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

    // метод скрыть напоминание
    private void hide() {
        b.linearLayout5.setVisibility(View.GONE);
        b.clock1.setVisibility(View.GONE);
        b.clock2.setVisibility(View.GONE);
    }

    // проверка на заполненость полей
    private void testData() {
        if (b.day1.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите дату приема", Toast.LENGTH_SHORT).show();
            b.day1.requestFocus();
            setSoftKeyboard();
        } else if (b.mount1.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите дату приема", Toast.LENGTH_SHORT).show();
            b.mount1.requestFocus();
            setSoftKeyboard();
        } else if (b.age1.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите дату приема", Toast.LENGTH_SHORT).show();
            b.age1.requestFocus();
            setSoftKeyboard();
        } else {
            day1 = b.day1.getText().toString();
            dayInt1 = Integer.parseInt(day1);

            mount1 = b.mount1.getText().toString();
            mountInt1 = Integer.parseInt(mount1);

            age1 = b.age1.getText().toString();
            ageInt1 = Integer.parseInt(age1);
        }

        // проверка правильного заполнения дат
        if (dayInt1 != 0 && mountInt1 != 0 && ageInt1 != 0) {
            if (dayInt1 > 31) {
                Toast.makeText(getActivity(), "Превышает количество дней", Toast.LENGTH_SHORT).show();
                b.day1.setText("");
                b.day1.requestFocus();
                setSoftKeyboard();
            } else if (mountInt1 > 12) {
                Toast.makeText(getActivity(), "Превышает количество месяцев", Toast.LENGTH_SHORT).show();
                b.mount1.setText("");
                b.mount1.requestFocus();
                setSoftKeyboard();
            } else if (ageInt1 > currentAge + 10) {
                Toast.makeText(getActivity(), "Превышает текущий год", Toast.LENGTH_SHORT).show();
                b.age1.setText("");
                b.age1.requestFocus();
                setSoftKeyboard();
            } else if (b.text1.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Ввведите причину обращения", Toast.LENGTH_SHORT).show();
                b.text1.requestFocus();
                setSoftKeyboard();
            } else {
                // если проверка прошла то сохраняем данные
                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.putString("dayMedCart" + id, b.day1.getText().toString());
                editor1.apply();

                SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                editor2.putString("mountMedCart" + id, b.mount1.getText().toString());
                editor2.apply();

                SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                editor3.putString("ageMedCart" + id, b.age1.getText().toString());
                editor3.apply();

                SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefHourMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                editor4.putString("hourMedCart" + id, b.hour1.getText().toString());
                editor4.apply();

                SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefMinMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                editor5.putString("minMedCart" + id, b.min1.getText().toString());
                editor5.apply();

                SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefCauseMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                editor6.putString("causeMedCart" + id, b.text1.getText().toString());
                editor6.apply();

                SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefFioMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor7 = sharedPreferences7.edit();
                editor7.putString("fioMedCart" + id, b.fio.getText().toString());
                editor7.apply();

                SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTelMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor8 = sharedPreferences8.edit();
                editor8.putString("telMedCart" + id, b.tel.getText().toString());
                editor8.apply();

                SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefAdresMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor9 = sharedPreferences9.edit();
                editor9.putString("adresMedCart" + id, b.adres.getText().toString());
                editor9.apply();

                SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefNoteMedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor10 = sharedPreferences10.edit();
                editor10.putString("noteMedCart" + id, b.poleNote1.getText().toString());
                editor10.apply();

                SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefTemp1MedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor11 = sharedPreferences11.edit();
                editor11.putString("temp1MedCart" + id, b.temp1.getText().toString());
                editor11.apply();

                SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefTemp2MedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor12 = sharedPreferences12.edit();
                editor12.putString("temp2MedCart" + id, b.temp2.getText().toString());
                editor12.apply();

                SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefTemp3MedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor13 = sharedPreferences13.edit();
                editor13.putString("temp3MedCart" + id, b.temp3.getText().toString());
                editor13.apply();

                SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefTemp4MedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor14 = sharedPreferences14.edit();
                editor14.putString("temp4MedCart" + id, b.temp4.getText().toString());
                editor14.apply();

                SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefTemp5MedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor15 = sharedPreferences15.edit();
                editor15.putString("temp5MedCart" + id, b.temp5.getText().toString());
                editor15.apply();

                SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefTemp6MedCart" + id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor16 = sharedPreferences16.edit();
                editor16.putString("temp6MedCart" + id, b.temp6.getText().toString());
                editor16.apply();

                // открываем фрагмент мед карта
                callback.onCreatFragment("medCarta");
            }
        }
    }

    // метод спрятать кнопки добавить фото и видео в разделе Анализы
    private void hideRoute() {
        b.imageView15.setVisibility(View.GONE);
        b.textView20.setVisibility(View.GONE);
        b.imageView16.setVisibility(View.GONE);
        b.textView21.setVisibility(View.GONE);
    }

    // метод показать кнопки добавить фото и видео в разделе Анализы
    private void showRoute() {
        if (route.equals(false)) {
            b.imageView15.setVisibility(View.VISIBLE);
            b.textView20.setVisibility(View.VISIBLE);
            b.imageView16.setVisibility(View.VISIBLE);
            b.textView21.setVisibility(View.VISIBLE);
            route = true;
        } else {
            hideRoute();
            route = false;
        }

    }

    // метод срятать раздел Симптомы
    private void hideDiagnosis() {
        countTemp = 1;
        b.layoutAddTemp.setVisibility(View.GONE);
        b.tempHeader.setVisibility(View.GONE);
        b.temp1.setVisibility(View.GONE);
        b.simvol.setVisibility(View.GONE);
        b.temp2.setVisibility(View.GONE);
        b.simvol2.setVisibility(View.GONE);
        b.temp3.setVisibility(View.GONE);
        b.simvol3.setVisibility(View.GONE);
        b.temp4.setVisibility(View.GONE);
        b.simvol4.setVisibility(View.GONE);
        b.temp5.setVisibility(View.GONE);
        b.simvol5.setVisibility(View.GONE);
        b.temp6.setVisibility(View.GONE);
        b.simvol6.setVisibility(View.GONE);
        b.imageView9.setVisibility(View.GONE);
        b.textView3.setVisibility(View.GONE);
        b.imageView12.setVisibility(View.GONE);
        b.setImage.setVisibility(View.GONE);
        b.imageView13.setVisibility(View.GONE);
        b.textView13.setVisibility(View.GONE);
        b.layoutAddTemp2.setVisibility(View.GONE);
    }

    // метод показать раздел Симптомы
    private void showDiagnosis() {
        if (diagnosis.equals(false)) {
            countTemp = 1;
            b.layoutAddTemp.setVisibility(View.VISIBLE);
            b.tempHeader.setVisibility(View.VISIBLE);
            b.temp1.setVisibility(View.VISIBLE);
            b.simvol.setVisibility(View.VISIBLE);
            b.imageView9.setVisibility(View.VISIBLE);
            b.textView3.setVisibility(View.VISIBLE);
            b.imageView12.setVisibility(View.VISIBLE);
            b.setImage.setVisibility(View.VISIBLE);
            b.imageView13.setVisibility(View.VISIBLE);
            b.textView13.setVisibility(View.VISIBLE);
            diagnosis = true;
        } else if (diagnosis.equals(true)) {
            hideDiagnosis();
            diagnosis = false;
        }

    }

    // метод перехода по полям время
    private void nextEditAll() {
        nextEdit(b.hour1, b.min1, 2);
    }

    // метод переход по полям дата
    private void data() {
        createMetod.dataAvtomat(b.day1, b.mount1, b.age1, b.hour1);
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

    // При нажатии на Enter на кливиатуре убираем фокус и прячем клавиатуру
    void enter(EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    editText.clearFocus();
                    setSoftKeyboard();
                    return true;
                }
                return false;
            }
        });
    }

    // метод спрятать клавиатуру
    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    // Общий метод для переноса фокуса с EditText1 на EditText2 при заполнении кол символов i
    public void nextEdit(EditText editText1, EditText editText2, int i) {
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText1.getText().length() == i && !isReached) {
                    editText1.clearFocus();
                    editText2.requestFocus();
                    isReached = true;
                }
                if (editText1.getText().length() < i && isReached) isReached = false;
            }
        });
    }

    // метод сьема системной даты ( года )
    private void setAge() {
        SimpleDateFormat datY = new SimpleDateFormat("yyyy");
        String currentDateandY = datY.format(new Date());
        String data3 = ("" + currentDateandY);
        currentAge = Integer.parseInt(data3);
    }

    // группа слушателей
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.layoutSetTextMedCarta:
                intentCalender(); // открываем напоминание в гугл календаре
                break;

            case R.id.layout_btn_save:
                testData(); // проверяем введены ли даты
                break;

            case R.id.linearLayout:
                showDiagnosis(); // открываем симптомы или прячкем симптомы
                break;

            case R.id.layoutSetTextKnitting:
                showRoute(); // показываем кнопки добавить или прячкм
                break;

            case R.id.layoutAddTemp:
                showTemp(); // показываем или прячем температуру
                break;
            case R.id.layoutAddTemp2:
                hideTemp2();
                break;
        }
    }
}