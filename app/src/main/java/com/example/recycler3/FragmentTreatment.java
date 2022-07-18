package com.example.recycler3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentTreatmentBinding;
import com.example.recycler3.databinding.FragmentTreatmentEditBinding;


public class FragmentTreatment extends Fragment implements View.OnClickListener {
    private FragmentTreatmentBinding b;
    private SampleCallback callback;
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
        b = FragmentTreatmentBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        initClicker(); // инициализируем клики
        id();
        show(); // проверяем на сохраненки и заполняем данными

        return v;
    }

    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    private void show() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefTreatmentDay1"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefTreatmentDay2"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefTreatmentDay3"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefTreatmentDay4"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefTreatmentDay5"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefTreatmentDay6"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefTreatmentDay7"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTreatmentDay8"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefTreatmentDay9"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefTreatmentDay10"+id, Context.MODE_PRIVATE);

        if (!sharedPreferences1.getString("treatmentDay1"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefTreatmentDay1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefTreatmentMount1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefTreatmentAge1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefTreatmentExitDay1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefTreatmentExitMount1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefTreatmentExitAge1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences17 = getActivity().getSharedPreferences("prefDrugTreatment1"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences11.getString("treatmentDay1"+id, "");
            String mount = sharedPreferences12.getString("treatmentMount1"+id, "");
            String age = sharedPreferences13.getString("treatmentAge1"+id, "");
            String dayExit = sharedPreferences14.getString("treatmentExitDay1"+id, "");
            String mountExit = sharedPreferences15.getString("treatmentExitMount1"+id, "");
            String ageExit = sharedPreferences16.getString("treatmentExitAge1"+id, "");
            String drug = sharedPreferences17.getString("drugTreatment1"+id, "");

            b.cause1.setText(day + "." + mount + "." + age + " г.");
            b.drug1.setText(drug);
            b.data1.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }
        if (!sharedPreferences2.getString("treatmentDay2"+id, "").equals("")) {
            b.layout2.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences21 = getActivity().getSharedPreferences("prefTreatmentDay2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences22 = getActivity().getSharedPreferences("prefTreatmentMount2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences23 = getActivity().getSharedPreferences("prefTreatmentAge2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences24 = getActivity().getSharedPreferences("prefTreatmentExitDay2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences25 = getActivity().getSharedPreferences("prefTreatmentExitMount2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences26 = getActivity().getSharedPreferences("prefTreatmentExitAge2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences27 = getActivity().getSharedPreferences("prefDrugTreatment2"+id, Context.MODE_PRIVATE);


            String day = sharedPreferences21.getString("treatmentDay2"+id, "");
            String mount = sharedPreferences22.getString("treatmentMount2"+id, "");
            String age = sharedPreferences23.getString("treatmentAge2"+id, "");
            String dayExit = sharedPreferences24.getString("treatmentExitDay2"+id, "");
            String mountExit = sharedPreferences25.getString("treatmentExitMount2"+id, "");
            String ageExit = sharedPreferences26.getString("treatmentExitAge2"+id, "");
            String drug = sharedPreferences27.getString("drugTreatment2"+id, "");

            b.cause2.setText(day + "." + mount + "." + age + " г.");
            b.drug2.setText(drug);
            b.data2.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences3.getString("treatmentDay3"+id, "").equals("")) {
            b.layout3.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences31 = getActivity().getSharedPreferences("prefTreatmentDay3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences32 = getActivity().getSharedPreferences("prefTreatmentMount3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences33 = getActivity().getSharedPreferences("prefTreatmentAge3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences34 = getActivity().getSharedPreferences("prefTreatmentExitDay3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences35 = getActivity().getSharedPreferences("prefTreatmentExitMount3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences36 = getActivity().getSharedPreferences("prefTreatmentExitAge3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences37 = getActivity().getSharedPreferences("prefDrugTreatment3"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences31.getString("treatmentDay3"+id, "");
            String mount = sharedPreferences32.getString("treatmentMount3"+id, "");
            String age = sharedPreferences33.getString("treatmentAge3"+id, "");
            String dayExit = sharedPreferences34.getString("treatmentExitDay3"+id, "");
            String mountExit = sharedPreferences35.getString("treatmentExitMount3"+id, "");
            String ageExit = sharedPreferences36.getString("treatmentExitAge3"+id, "");
            String drug = sharedPreferences37.getString("drugTreatment3"+id, "");

            b.cause3.setText(day + "." + mount + "." + age + " г.");
            b.drug3.setText(drug);
            b.data3.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }
        if (!sharedPreferences4.getString("treatmentDay4"+id, "").equals("")) {
            b.layout4.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences41 = getActivity().getSharedPreferences("prefTreatmentDay4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences42 = getActivity().getSharedPreferences("prefTreatmentMount4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences43 = getActivity().getSharedPreferences("prefTreatmentAge4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences44 = getActivity().getSharedPreferences("prefTreatmentExitDay4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences45 = getActivity().getSharedPreferences("prefTreatmentExitMount4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences46 = getActivity().getSharedPreferences("prefTreatmentExitAge4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences47 = getActivity().getSharedPreferences("prefDrugTreatment4"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences41.getString("treatmentDay4"+id, "");
            String mount = sharedPreferences42.getString("treatmentMount4"+id, "");
            String age = sharedPreferences43.getString("treatmentAge4"+id, "");
            String dayExit = sharedPreferences44.getString("treatmentExitDay4"+id, "");
            String mountExit = sharedPreferences45.getString("treatmentExitMount4"+id, "");
            String ageExit = sharedPreferences46.getString("treatmentExitAge4"+id, "");
            String drug = sharedPreferences47.getString("drugTreatment4"+id, "");

            b.cause4.setText(day + "." + mount + "." + age + " г.");
            b.drug4.setText(drug);
            b.data4.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences5.getString("treatmentDay5"+id, "").equals("")) {
            b.layout5.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences51 = getActivity().getSharedPreferences("prefTreatmentDay5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences52 = getActivity().getSharedPreferences("prefTreatmentMount5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences53 = getActivity().getSharedPreferences("prefTreatmentAge5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences54 = getActivity().getSharedPreferences("prefTreatmentExitDay5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences55 = getActivity().getSharedPreferences("prefTreatmentExitMount5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences56 = getActivity().getSharedPreferences("prefTreatmentExitAge5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences57 = getActivity().getSharedPreferences("prefDrugTreatment5"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences51.getString("treatmentDay5"+id, "");
            String mount = sharedPreferences52.getString("treatmentMount5"+id, "");
            String age = sharedPreferences53.getString("treatmentAge5"+id, "");
            String dayExit = sharedPreferences54.getString("treatmentExitDay5"+id, "");
            String mountExit = sharedPreferences55.getString("treatmentExitMount5"+id, "");
            String ageExit = sharedPreferences56.getString("treatmentExitAge5"+id, "");
            String drug = sharedPreferences57.getString("drugTreatment5"+id, "");

            b.cause5.setText(day + "." + mount + "." + age + " г.");
            b.drug5.setText(drug);
            b.data5.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences6.getString("treatmentDay6"+id, "").equals("")) {
            b.layout6.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences61 = getActivity().getSharedPreferences("prefTreatmentDay6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences62 = getActivity().getSharedPreferences("prefTreatmentMount6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences63 = getActivity().getSharedPreferences("prefTreatmentAge6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences64 = getActivity().getSharedPreferences("prefTreatmentExitDay6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences65 = getActivity().getSharedPreferences("prefTreatmentExitMount6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences66 = getActivity().getSharedPreferences("prefTreatmentExitAge6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences67 = getActivity().getSharedPreferences("prefDrugTreatment6"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences61.getString("treatmentDay6"+id, "");
            String mount = sharedPreferences62.getString("treatmentMount6"+id, "");
            String age = sharedPreferences63.getString("treatmentAge6"+id, "");
            String dayExit = sharedPreferences64.getString("treatmentExitDay6"+id, "");
            String mountExit = sharedPreferences65.getString("treatmentExitMount6"+id, "");
            String ageExit = sharedPreferences66.getString("treatmentExitAge6"+id, "");
            String drug = sharedPreferences67.getString("drugTreatment6"+id, "");

            b.cause6.setText(day + "." + mount + "." + age + " г.");
            b.drug6.setText(drug);
            b.data6.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences7.getString("treatmentDay7"+id, "").equals("")) {
            b.layout7.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences71 = getActivity().getSharedPreferences("prefTreatmentDay7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences72 = getActivity().getSharedPreferences("prefTreatmentMount7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences73 = getActivity().getSharedPreferences("prefTreatmentAge7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences74 = getActivity().getSharedPreferences("prefTreatmentExitDay7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences75 = getActivity().getSharedPreferences("prefTreatmentExitMount7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences76 = getActivity().getSharedPreferences("prefTreatmentExitAge7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences77 = getActivity().getSharedPreferences("prefDrugTreatment7"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences71.getString("treatmentDay7"+id, "");
            String mount = sharedPreferences72.getString("treatmentMount7"+id, "");
            String age = sharedPreferences73.getString("treatmentAge7"+id, "");
            String dayExit = sharedPreferences74.getString("treatmentExitDay7"+id, "");
            String mountExit = sharedPreferences75.getString("treatmentExitMount7"+id, "");
            String ageExit = sharedPreferences76.getString("treatmentExitAge7"+id, "");
            String drug = sharedPreferences77.getString("drugTreatment7"+id, "");

            b.cause7.setText(day + "." + mount + "." + age + " г.");
            b.drug7.setText(drug);
            b.data7.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences8.getString("treatmentDay8"+id, "").equals("")) {
            b.layout8.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences81 = getActivity().getSharedPreferences("prefTreatmentDay8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences82 = getActivity().getSharedPreferences("prefTreatmentMount8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences83 = getActivity().getSharedPreferences("prefTreatmentAge8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences84 = getActivity().getSharedPreferences("prefTreatmentExitDay8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences85 = getActivity().getSharedPreferences("prefTreatmentExitMount8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences86 = getActivity().getSharedPreferences("prefTreatmentExitAge8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences87 = getActivity().getSharedPreferences("prefDrugTreatment8"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences81.getString("treatmentDay8"+id, "");
            String mount = sharedPreferences82.getString("treatmentMount8"+id, "");
            String age = sharedPreferences83.getString("treatmentAge8"+id, "");
            String dayExit = sharedPreferences84.getString("treatmentExitDay8"+id, "");
            String mountExit = sharedPreferences85.getString("treatmentExitMount8"+id, "");
            String ageExit = sharedPreferences86.getString("treatmentExitAge8"+id, "");
            String drug = sharedPreferences87.getString("drugTreatment8"+id, "");

            b.cause8.setText(day + "." + mount + "." + age + " г.");
            b.drug8.setText(drug);
            b.data8.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }
        if (!sharedPreferences9.getString("treatmentDay9"+id, "").equals("")) {
            b.layout9.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences91 = getActivity().getSharedPreferences("prefTreatmentDay9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences92 = getActivity().getSharedPreferences("prefTreatmentMount9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences93 = getActivity().getSharedPreferences("prefTreatmentAge9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences94 = getActivity().getSharedPreferences("prefTreatmentExitDay9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences95 = getActivity().getSharedPreferences("prefTreatmentExitMount9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences96 = getActivity().getSharedPreferences("prefTreatmentExitAge9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences97 = getActivity().getSharedPreferences("prefDrugTreatment9"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences91.getString("treatmentDay9"+id, "");
            String mount = sharedPreferences92.getString("treatmentMount9"+id, "");
            String age = sharedPreferences93.getString("treatmentAge9"+id, "");
            String dayExit = sharedPreferences94.getString("treatmentExitDay9"+id, "");
            String mountExit = sharedPreferences95.getString("treatmentExitMount9"+id, "");
            String ageExit = sharedPreferences96.getString("treatmentExitAge9"+id, "");
            String drug = sharedPreferences97.getString("drugTreatment9"+id, "");

            b.cause9.setText(day + "." + mount + "." + age + " г.");
            b.drug9.setText(drug);
            b.data9.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences9.getString("treatmentDay9"+id, "").equals("")) {
            b.layout9.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences91 = getActivity().getSharedPreferences("prefTreatmentDay9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences92 = getActivity().getSharedPreferences("prefTreatmentMount9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences93 = getActivity().getSharedPreferences("prefTreatmentAge9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences94 = getActivity().getSharedPreferences("prefTreatmentExitDay9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences95 = getActivity().getSharedPreferences("prefTreatmentExitMount9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences96 = getActivity().getSharedPreferences("prefTreatmentExitAge9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences97 = getActivity().getSharedPreferences("prefDrugTreatment9"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences91.getString("treatmentDay9"+id, "");
            String mount = sharedPreferences92.getString("treatmentMount9"+id, "");
            String age = sharedPreferences93.getString("treatmentAge9"+id, "");
            String dayExit = sharedPreferences94.getString("treatmentExitDay9"+id, "");
            String mountExit = sharedPreferences95.getString("treatmentExitMount9"+id, "");
            String ageExit = sharedPreferences96.getString("treatmentExitAge9"+id, "");
            String drug = sharedPreferences97.getString("drugTreatment9"+id, "");

            b.cause9.setText(day + "." + mount + "." + age + " г.");
            b.drug9.setText(drug);
            b.data9.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences10.getString("treatmentDay10"+id, "").equals("")) {
            b.layout10.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences101 = getActivity().getSharedPreferences("prefTreatmentDay10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences102 = getActivity().getSharedPreferences("prefTreatmentMount10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences103 = getActivity().getSharedPreferences("prefTreatmentAge10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences104 = getActivity().getSharedPreferences("prefTreatmentExitDay10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences105 = getActivity().getSharedPreferences("prefTreatmentExitMount10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences106 = getActivity().getSharedPreferences("prefTreatmentExitAge10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences107 = getActivity().getSharedPreferences("prefDrugTreatment10"+id, Context.MODE_PRIVATE);

            String day = sharedPreferences101.getString("treatmentDay10"+id, "");
            String mount = sharedPreferences102.getString("treatmentMount10"+id, "");
            String age = sharedPreferences103.getString("treatmentAge10"+id, "");
            String dayExit = sharedPreferences104.getString("treatmentExitDay10"+id, "");
            String mountExit = sharedPreferences105.getString("treatmentExitMount10"+id, "");
            String ageExit = sharedPreferences106.getString("treatmentExitAge10"+id, "");
            String drug = sharedPreferences107.getString("drugTreatment10"+id, "");

            b.cause10.setText(day + "." + mount + "." + age + " г.");
            b.drug10.setText(drug);
            b.data10.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }
    }


    // метод инициализации кликов
    private void initClicker() {
        b.bar.setOnClickListener(this);
        b.layout1.setOnClickListener(this);
        b.layout2.setOnClickListener(this);
        b.layout3.setOnClickListener(this);
        b.layout4.setOnClickListener(this);
        b.layout5.setOnClickListener(this);
        b.layout6.setOnClickListener(this);
        b.layout7.setOnClickListener(this);
        b.layout8.setOnClickListener(this);
        b.layout9.setOnClickListener(this);
        b.layout10.setOnClickListener(this);
    }

    // метод подвязки команды в зависимости от клика
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar:
                callback.onCreatFragment("treatment");
                break;
            case R.id.layout1:
                callback.onButtonClicked("treatmentlayout", 1);
                break;
            case R.id.layout2:
                callback.onButtonClicked("treatmentlayout", 2);
                break;
            case R.id.layout3:
                callback.onButtonClicked("treatmentlayout", 3);
                break;
            case R.id.layout4:
                callback.onButtonClicked("treatmentlayout", 4);
                break;
            case R.id.layout5:
                callback.onButtonClicked("treatmentlayout", 5);
                break;
            case R.id.layout6:
                callback.onButtonClicked("treatmentlayout", 6);
                break;
            case R.id.layout7:
                callback.onButtonClicked("treatmentlayout", 7);
                break;
            case R.id.layout8:
                callback.onButtonClicked("treatmentlayout", 8);
                break;
            case R.id.layout9:
                callback.onButtonClicked("treatmentlayout", 9);
                break;
            case R.id.layout10:
                callback.onButtonClicked("treatmentlayout", 10);
                break;
        }
    }
}