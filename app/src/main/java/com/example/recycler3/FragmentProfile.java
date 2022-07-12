package com.example.recycler3;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentProfileBinding;

import org.w3c.dom.Text;

public class FragmentProfile extends Fragment {
    private FragmentProfileBinding b;
    private SampleCallback callback;

    AgeCalculator ageCalculator = new AgeCalculator();
    private int id = 1;
    private int position = 0;
    private byte statusParams = 0;
    private byte statusInfo = 0;

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        b = FragmentProfileBinding.inflate(getLayoutInflater());

        View v = b.getRoot();
        callback.onCreatFragment("profile");
        Pref.init(getActivity());

        pass(); // метод получения данных и заполнения
        goneViseble(); // метод отображения
        params(); // проверка есть ли параметры у питомца
        infos();  // проверка есть ли доп параметры у питомца
        header(); // метод проверки отображения заголовков
        click(); // слушатели
//        hideParamBtn();

        return v;
    }

    private void hideParamBtn() {
        b.startParams.setVisibility(VISIBLE);
        b.startInfo.setVisibility(VISIBLE);
        b.startParams2.setVisibility(GONE);
        b.startInfo2.setVisibility(GONE);
    }

    private void click() {

        // кнопка редактирования
        b.bigPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onButtonClicked("edit", position);
            }
        });

        // кнопка история
        b.llHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onButtonClicked("history", position);
            }
        });

        // кнопка история
        b.tvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onButtonClicked("history", position);
            }
        });

        // кнопка история
        b.ivHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onButtonClicked("history", position);
            }
        });

        // кнопка залоговок параметры
        b.params.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                params();
            }
        });

        // кнопка крестик параметры развернуть
        b.startParams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                params();
            }
        });

        // кнопка минус параметры свернуть
        b.startParams2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                params();
            }
        });

        // кнопка заголовок доп инфа
        b.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infos();
            }
        });

        // кнопка крестик доп инфа развернуть
        b.startInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infos();
            }
        });

        // кнопка минус доп инфа свернуть
        b.startInfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infos();
            }
        });
    }

    private void header() {
        if (b.lineWeight.getText().toString().equals("") && b.lineHeight.getText().toString().equals("") && b.lineBust.getText().toString().equals("")
                && b.lineBackLength.getText().toString().equals("") && b.lineNeckToGroin.getText().toString().equals("") && b.lineNeckVolume.getText().toString().equals("")
                && b.linePawLength.getText().toString().equals("") && b.linePawWidth.getText().toString().equals("")) {
            b.params.setVisibility(GONE);
            b.startParams.setVisibility(GONE);
            b.startParams2.setVisibility(GONE);
            b.ivHistory.setVisibility(GONE);
            b.llHistory.setVisibility(GONE);
            b.tvHistory.setVisibility(GONE);
        }
        if (b.dayCastration.getText().toString().equals("")
                && b.mountCastration.getText().toString().equals("")
                && b.ageCastration.getText().toString().equals("")
                && b.dayCicle.getText().toString().equals("")
                && b.mountCicle.getText().toString().equals("")
                && b.ageCicle.getText().toString().equals("")
                && b.dayCicle2.getText().toString().equals("")
                && b.mountCicle2.getText().toString().equals("")
                && b.ageCicle2.getText().toString().equals("")
                && b.lineNursery.getText().toString().equals("")
                && b.poleNote.getText().toString().equals("")) {
            b.info.setVisibility(GONE);
            b.startInfo.setVisibility(GONE);
            b.startInfo2.setVisibility(GONE);
        }
    }

    private void infos() {
        if (statusInfo == 0) {

            b.startInfo.setVisibility(VISIBLE);
            b.startInfo2.setVisibility(GONE);

            b.castration.setVisibility(GONE);
            b.layoutDataCastration.setVisibility(GONE);
            b.layoutCast.setVisibility(GONE);
            b.dayCastration.setVisibility(GONE);
            b.tochDayCastration.setVisibility(GONE);
            b.mountCastration.setVisibility(GONE);
            b.tochMountCastration.setVisibility(GONE);
            b.ageCastration.setVisibility(GONE);
            b.tochAgeCastration.setVisibility(GONE);

            b.cicle.setVisibility(GONE);
            b.layoutDataCicle.setVisibility(GONE);
            b.dayCicle.setVisibility(GONE);
            b.tochDayCicle.setVisibility(GONE);
            b.mountCicle.setVisibility(GONE);
            b.tochMountCicle.setVisibility(GONE);
            b.ageCicle.setVisibility(GONE);
            b.tochAgeCicle.setVisibility(GONE);

            b.layoutDataCicle2.setVisibility(GONE);
            b.dayCicle2.setVisibility(GONE);
            b.tochDayCicle2.setVisibility(GONE);
            b.mountCicle2.setVisibility(GONE);
            b.tochMountCicle2.setVisibility(GONE);
            b.ageCicle2.setVisibility(GONE);
            b.tochAgeCicle2.setVisibility(GONE);

            b.nursery.setVisibility(GONE);
            b.lineNursery.setVisibility(GONE);
            b.note.setVisibility(GONE);
            b.layoutPoleNote.setVisibility(GONE);
            b.poleNote.setVisibility(GONE);
            statusInfo = 1;
        } else if (statusInfo == 1) {

            b.startInfo.setVisibility(GONE);
            b.startInfo2.setVisibility(VISIBLE);

            if (!b.dayCastration.getText().toString().equals("") || !b.mountCastration.getText().toString().equals("") || !b.ageCastration.getText().toString().equals("")) {
                b.castration.setVisibility(VISIBLE);
                b.layoutDataCastration.setVisibility(VISIBLE);
                b.layoutCast.setVisibility(VISIBLE);
                b.dayCastration.setVisibility(VISIBLE);
                b.tochDayCastration.setVisibility(VISIBLE);
                b.mountCastration.setVisibility(VISIBLE);
                b.tochMountCastration.setVisibility(VISIBLE);
                b.ageCastration.setVisibility(VISIBLE);
                b.tochAgeCastration.setVisibility(VISIBLE);
            }

            if (!b.dayCicle.getText().toString().equals("") || !b.mountCicle.getText().toString().equals("") || !b.ageCicle.getText().toString().equals("")) {
                b.castration.setVisibility(VISIBLE);
                b.cicle.setVisibility(VISIBLE);
                b.layoutDataCicle.setVisibility(VISIBLE);
                b.dayCicle.setVisibility(VISIBLE);
                b.tochDayCicle.setVisibility(VISIBLE);
                b.mountCicle.setVisibility(VISIBLE);
                b.tochMountCicle.setVisibility(VISIBLE);
                b.ageCicle.setVisibility(VISIBLE);
                b.tochAgeCicle.setVisibility(VISIBLE);
            }

            if (!b.dayCicle2.getText().toString().equals("") || !b.mountCicle2.getText().toString().equals("") || !b.ageCicle2.getText().toString().equals("")) {
                b.castration.setVisibility(VISIBLE);
                b.layoutDataCicle2.setVisibility(VISIBLE);
                b.dayCicle2.setVisibility(VISIBLE);
                b.tochDayCicle2.setVisibility(VISIBLE);
                b.mountCicle2.setVisibility(VISIBLE);
                b.tochMountCicle2.setVisibility(VISIBLE);
                b.ageCicle2.setVisibility(VISIBLE);
                b.tochAgeCicle2.setVisibility(VISIBLE);
            }

            if (!b.lineNursery.getText().toString().equals("")) {
                b.nursery.setVisibility(VISIBLE);
                b.lineNursery.setVisibility(VISIBLE);
            }

            if (!b.poleNote.getText().toString().equals("")) {
                b.note.setVisibility(VISIBLE);
                b.layoutPoleNote.setVisibility(VISIBLE);
                b.poleNote.setVisibility(VISIBLE);
            }
            statusInfo = 0;
        }
    }

    private void params() {

        if (statusParams == 0) {
            b.startParams.setVisibility(VISIBLE);
            b.startParams2.setVisibility(GONE);

            b.layoutWeightText.setVisibility(GONE);
            b.layoutWeight.setVisibility(GONE);

            b.weight.setVisibility(GONE);
            b.layoutLineWeight.setVisibility(GONE);
            b.lineWeight.setVisibility(GONE);
            b.kg.setVisibility(GONE);

            b.height.setVisibility(GONE);
            b.lineHeight.setVisibility(GONE);
            b.layoutHeight.setVisibility(GONE);
            b.smHeight.setVisibility(GONE);

            b.layoutBustText.setVisibility(GONE);
            b.layoutBust.setVisibility(GONE);

            b.bust.setVisibility(GONE);
            b.layoutLineBust.setVisibility(GONE);
            b.lineBust.setVisibility(GONE);
            b.smBust.setVisibility(GONE);

            b.backLength.setVisibility(GONE);
            b.layoutBackLength.setVisibility(GONE);
            b.lineBackLength.setVisibility(GONE);
            b.smBack.setVisibility(GONE);

            b.layoutNeckToGroinText.setVisibility(GONE);
            b.layoutNeckToGroinText2.setVisibility(GONE);
            b.layoutNeckToGroin.setVisibility(GONE);

            b.neckToGroin.setVisibility(GONE);
            b.neckToGroin2.setVisibility(GONE);
            b.layoutLineNeckToGroin.setVisibility(GONE);
            b.lineNeckToGroin.setVisibility(GONE);
            b.smNeck.setVisibility(GONE);

            b.layoutPawLengthText.setVisibility(GONE);
            b.layoutPawLength.setVisibility(GONE);

            b.pawLength.setVisibility(GONE);
            b.layoutLinePawLength.setVisibility(GONE);
            b.linePawLength.setVisibility(GONE);
            b.smPawLength.setVisibility(GONE);

            b.pawWidth.setVisibility(GONE);
            b.layoutPawWidth.setVisibility(GONE);
            b.linePawWidth.setVisibility(GONE);
            b.smPawWidth.setVisibility(GONE);

            statusParams = 1;
        } else if (statusParams == 1) {
            b.startParams.setVisibility(GONE);
            b.startParams2.setVisibility(VISIBLE);


            if (!b.lineWeight.getText().toString().equals("") || !b.lineHeight.getText().toString().equals("")) {
                b.layoutWeightText.setVisibility(VISIBLE);
                b.layoutWeight.setVisibility(VISIBLE);

                if (!b.lineWeight.getText().toString().equals("")) {
                    b.weight.setVisibility(VISIBLE);
                    b.layoutLineWeight.setVisibility(VISIBLE);
                    b.lineWeight.setVisibility(VISIBLE);
                    b.kg.setVisibility(VISIBLE);
                }
                if (!b.lineHeight.getText().toString().equals("")) {
                    b.height.setVisibility(VISIBLE);
                    b.lineHeight.setVisibility(VISIBLE);
                    b.layoutHeight.setVisibility(VISIBLE);
                    b.smHeight.setVisibility(VISIBLE);
                }
            }

            if (!b.lineBust.getText().toString().equals("") || !b.lineBackLength.getText().toString().equals("")) {
                b.layoutBustText.setVisibility(VISIBLE);
                b.layoutBust.setVisibility(VISIBLE);
                if (!b.lineBust.getText().toString().equals("")) {
                    b.bust.setVisibility(VISIBLE);
                    b.layoutLineBust.setVisibility(VISIBLE);
                    b.lineBust.setVisibility(VISIBLE);
                    b.smBust.setVisibility(VISIBLE);
                }
                if (!b.lineBackLength.getText().toString().equals("")) {
                    b.backLength.setVisibility(VISIBLE);
                    b.layoutBackLength.setVisibility(VISIBLE);
                    b.lineBackLength.setVisibility(VISIBLE);
                    b.smBack.setVisibility(VISIBLE);
                }
            }

            if (!b.lineNeckToGroin.getText().toString().equals("") || !b.lineNeckVolume.getText().toString().equals("")) {

                b.layoutNeckToGroinText2.setVisibility(VISIBLE);
                b.layoutNeckToGroin.setVisibility(VISIBLE);

                if (!b.lineNeckToGroin.getText().toString().equals("")) {
                    b.layoutNeckToGroinText.setVisibility(VISIBLE);
                    b.neckToGroin.setVisibility(VISIBLE);
                    b.neckToGroin2.setVisibility(VISIBLE);
                    b.layoutLineNeckToGroin.setVisibility(VISIBLE);
                    b.lineNeckToGroin.setVisibility(VISIBLE);
                    b.smNeck.setVisibility(VISIBLE);
                }
                if (!b.lineNeckVolume.getText().toString().equals("")) {
                    b.neckVolume.setVisibility(VISIBLE);
                    b.layoutNeckVolume.setVisibility(VISIBLE);
                    b.lineNeckVolume.setVisibility(VISIBLE);
                    b.smVolume.setVisibility(VISIBLE);
                }
            }

            if (!b.linePawLength.getText().toString().equals("") || !b.linePawWidth.getText().toString().equals("")) {
                b.layoutPawLengthText.setVisibility(VISIBLE);
                b.layoutPawLength.setVisibility(VISIBLE);
                if (!b.linePawLength.getText().toString().equals("")) {
                    b.pawLength.setVisibility(VISIBLE);
                    b.layoutLinePawLength.setVisibility(VISIBLE);
                    b.linePawLength.setVisibility(VISIBLE);
                    b.smPawLength.setVisibility(VISIBLE);
                }
                if (!b.linePawWidth.getText().toString().equals("")) {
                    b.pawWidth.setVisibility(VISIBLE);
                    b.layoutPawWidth.setVisibility(VISIBLE);
                    b.linePawWidth.setVisibility(VISIBLE);
                    b.smPawWidth.setVisibility(VISIBLE);
                }
            }

            statusParams = 0;
        }
    }

    private void goneViseble() {
        // метод отображения кнопок
        b.startParams.setVisibility(VISIBLE);
        b.startParams2.setVisibility(GONE);
        b.startInfo.setVisibility(VISIBLE);
        b.startInfo2.setVisibility(GONE);
        // метод отборажения Заголовков и основных данных
        OsnovaVisible(b.genderHeaderPro, b.gender); // отоюражение пола
        OsnovaVisible(b.chip, b.lineChip); // отображение данных по чипу
        OsnovaVisible(b.breed, b.lineBreed); // отображение данных по окрасу
        OsnovaVisible(b.color, b.lineColor); // отображение данных по цвету
    }

    // метод отображения основых данных
    public void OsnovaVisible(TextView header, TextView title) {
        if (title.getText().toString().equals("")) {
            header.setVisibility(View.GONE);
            title.setVisibility(View.GONE);
        }
    }

    // метод заполнение данных из сохранных данных
    private void pass() {
        // заполнение основных параметров
        setAnimalAge();
        set("prefName", "name", b.lineName);

        setCategory();

        set("prefDay", "day", b.day);
        set("prefMount", "mount", b.mount);
        set("prefAge", "age", b.age);

        set("prefKg", "kg", b.kg);


        set("prefGender", "gender", b.gender);
        set("prefChip", "chip", b.lineChip);
        set("prefBreed", "breed", b.lineBreed);
        set("prefColor", "color", b.lineColor);

//        // заполнение параметров
        set("prefWeight", "weight", b.lineWeight);
        set("prefHeight", "height", b.lineHeight);
        set("prefBust", "bust", b.lineBust);
        set("prefBack", "back", b.lineBackLength);
        set("prefGroin", "groin", b.lineNeckToGroin);
        set("prefVolume", "volume", b.lineNeckVolume);
        set("prefLength", "length", b.linePawLength);
        set("prefWidth", "width", b.linePawWidth);

//        // заполнение основной информации
        set("prefDayCast", "dayCast", b.dayCastration);
        set("prefMountCast", "mountCast", b.mountCastration);
        set("prefAgeCast", "ageCast", b.ageCastration);

        set("prefDayCicle", "dayCicle", b.dayCicle);
        set("prefMountCicle", "mountCicle", b.mountCicle);
        set("prefAgeCicle", "ageCicle", b.ageCicle);

        set("prefDayCicleExit", "dayCicleExit", b.dayCicle2);
        set("prefMountCicleExit", "mountCicleExit", b.mountCicle2);
        set("prefAgeCicleExit", "ageCicleExit", b.ageCicle2);

        set("prefNursery", "nursery", b.lineNursery);
        set("prefNote", "note", b.poleNote);
    }

    private void setCategory() {
        String test = this.getArguments().getString("key");
        position = Integer.parseInt(test);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus"+position, Context.MODE_PRIVATE);
        if(!sharedPreferences.getString("myStatus"+position, "").equals("")){
            String category = sharedPreferences.getString("myStatus"+position, "");
            b.category.setText(category);
        }
    }

    // Метод заполнения сохраненки
    public void set(String pref, String key, TextView text) {

        String test = this.getArguments().getString("key");
        position = Integer.parseInt(test);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(pref + position, Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(key + position, "").equals("")) {
            text.setText(sharedPreferences.getString(key + position, ""));
        }
    }

    // метод зваполнения данных по возрасту питомца
    private void setAnimalAge() {
        String test = this.getArguments().getString("key");
        position = Integer.parseInt(test);

        String day, mount, age, animal;

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefDay" + position, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefMount" + position, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefAge" + position, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAnimal" + position, Context.MODE_PRIVATE);

        day = (sharedPreferences.getString("day" + position, ""));
        mount = (sharedPreferences1.getString("mount" + position, ""));
        age = (sharedPreferences2.getString("age" + position, ""));
        animal = (sharedPreferences3.getString("animal" + position, ""));

        if(!day.equals("00")){
            ageCalculator.ageCalculator(day, mount, age, b.animalAge, animal);
        } else {
            b.animalAge.setVisibility(GONE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        goneViseble(); // метод отображения
        params(); // проверка есть ли параметры у питомца
        infos();  // проверка есть ли доп параметры у питомца
        header(); // метод проверки отображения заголовков
        click(); // слушатели
//        hideParamBtn();
    }
}