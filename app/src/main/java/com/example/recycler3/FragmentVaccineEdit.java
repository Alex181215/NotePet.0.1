package com.example.recycler3;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
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

import com.example.recycler3.databinding.FragmentVaccineEditBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FragmentVaccineEdit extends Fragment {
    private FragmentVaccineEditBinding b;
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
        b = FragmentVaccineEditBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentVaccineEdit");
        id();
        cliker();
        data();
        enter(b.param, b.editText5);

        return v;
    }

    // получаем айди активного питомца
    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    // При нажатии на Enter на кливиатуре убираем фокус и прячем клавиатуру
    void enter(EditText editText, EditText editText2) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    editText.clearFocus();
                    editText2.requestFocus();
                    setSoftKeyboard();
                    return true;
                }
                return false;
            }
        });
    }

    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private void data() {
        createMetod.dataAvtomat(b.day, b.editText2, b.age, b.param);
        createMetod.dataAvtomat(b.editText5, b.editText6, b.editText7, b.poleNote2);
        createMetod.nextEdit(b.param, b.editText5, 34);
    }

    private void cliker() {
        b.layoutSetTextVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCalender();
            }
        });

        b.textSetTextVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCalender();
            }
        });

        b.imageSetTextVaccination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCalender();
            }
        });
        b.layoutBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testData(b.day, b.editText2, b.age);
            }
        });
        b.imageBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testData(b.day, b.editText2, b.age);
            }
        });
        b.textBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testData(b.day, b.editText2, b.age);
            }
        });
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
            } else if (ageInt2 > currentAge+2) {
                age2.setText("");
                age2.requestFocus();
                setSoftKeyboard();
                Toast.makeText(getActivity(), "Превышает текущий год", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 1; i < 11; i++) {
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefVaccineDay" + i + id, Context.MODE_PRIVATE);
                    if (sharedPreferences.getString("vaccineDay" + i + id, "").equals("")) {
                        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefVaccineDay" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                        editor1.putString("vaccineDay" + i + id, b.day.getText().toString());
                        editor1.apply();

                        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefVaccineMount" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                        editor2.putString("vaccineMount" + i + id, b.editText2.getText().toString());
                        editor2.apply();

                        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefVaccineAge" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                        editor3.putString("vaccineAge" + i + id, b.age.getText().toString());
                        editor3.apply();


                        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefVaccineExitDay" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                        editor4.putString("vaccineExitDay" + i + id, b.editText5.getText().toString());
                        editor4.apply();

                        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefVaccineExitMount" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                        editor5.putString("vaccineExitMount" + i + id, b.editText6.getText().toString());
                        editor5.apply();

                        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefVaccineExitAge" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                        editor6.putString("vaccineExitAge" + i + id, b.editText7.getText().toString());
                        editor6.apply();

                        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefDrugVaccine" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor7 = sharedPreferences7.edit();
                        editor7.putString("drugVaccine" + i + id, b.param.getText().toString());
                        editor7.apply();

                        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefNoteVaccine" + i + id, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor8 = sharedPreferences8.edit();
                        editor8.putString("noteVaccine" + i + id, b.poleNote2.getText().toString());
                        editor8.apply();

                        // открываем фрагмент мед карта
                        callback.onCreatFragment("medCarta");
                        break;
                    }
                }
            }
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