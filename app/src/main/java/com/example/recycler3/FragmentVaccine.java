package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentVaccineBinding;

import java.util.Locale;
import java.util.Stack;


public class FragmentVaccine extends Fragment implements View.OnClickListener {
    private FragmentVaccineBinding b;
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
        b = FragmentVaccineBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        initCliker();
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
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefVaccineDay1" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefVaccineDay2" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefVaccineDay3" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefVaccineDay4" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefVaccineDay5" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefVaccineDay6" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefVaccineDay7" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefVaccineDay8" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefVaccineDay9" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefVaccineDay10" + id, Context.MODE_PRIVATE);

        if (!sharedPreferences1.getString("vaccineDay1" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefVaccineDay1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefVaccineMount1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefVaccineAge1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefDrugVaccine1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefVaccineExitDay1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefVaccineExitMount1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences17 = getActivity().getSharedPreferences("prefVaccineExitAge1" + id, Context.MODE_PRIVATE);


            String day = sharedPreferences11.getString("vaccineDay1" + id, "");
            String mount = sharedPreferences12.getString("vaccineMount1" + id, "");
            String age = sharedPreferences13.getString("vaccineAge1" + id, "");
            String drug = sharedPreferences14.getString("drugVaccine1" + id, "");
            String dayExit = sharedPreferences15.getString("vaccineExitDay1" + id, "");
            String mountExit = sharedPreferences16.getString("vaccineExitMount1" + id, "");
            String ageExit = sharedPreferences17.getString("vaccineExitAge1" + id, "");


            b.cause1.setText(day + "." + mount + "." + age + " г.");
            b.drug1.setText(drug);
            b.data1.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences2.getString("vaccineDay2" + id, "").equals("")) {
            b.layout2.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences21 = getActivity().getSharedPreferences("prefVaccineDay2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences22 = getActivity().getSharedPreferences("prefVaccineMount2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences23 = getActivity().getSharedPreferences("prefVaccineAge2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences24 = getActivity().getSharedPreferences("prefDrugVaccine2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences25 = getActivity().getSharedPreferences("prefVaccineExitDay2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences26 = getActivity().getSharedPreferences("prefVaccineExitMount2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences27 = getActivity().getSharedPreferences("prefVaccineExitAge2" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences21.getString("vaccineDay2" + id, "");
            String mount = sharedPreferences22.getString("vaccineMount2" + id, "");
            String age = sharedPreferences23.getString("vaccineAge2" + id, "");
            String drug = sharedPreferences24.getString("drugVaccine2" + id, "");
            String dayExit = sharedPreferences25.getString("vaccineExitDay2" + id, "");
            String mountExit = sharedPreferences26.getString("vaccineExitMount2" + id, "");
            String ageExit = sharedPreferences27.getString("vaccineExitAge2" + id, "");


            b.cause2.setText(day + "." + mount + "." + age + " г.");
            b.drug2.setText(drug);
            b.data2.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences3.getString("vaccineDay3" + id, "").equals("")) {
            b.layout3.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences31 = getActivity().getSharedPreferences("prefVaccineDay3" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences32 = getActivity().getSharedPreferences("prefVaccineMount3" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences33 = getActivity().getSharedPreferences("prefVaccineAge3" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences34 = getActivity().getSharedPreferences("prefDrugVaccine3" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences35 = getActivity().getSharedPreferences("prefVaccineExitDay3" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences36 = getActivity().getSharedPreferences("prefVaccineExitMount3" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences37 = getActivity().getSharedPreferences("prefVaccineExitAge3" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences31.getString("vaccineDay3" + id, "");
            String mount = sharedPreferences32.getString("vaccineMount3" + id, "");
            String age = sharedPreferences33.getString("vaccineAge3" + id, "");
            String drug = sharedPreferences34.getString("drugVaccine3" + id, "");
            String dayExit = sharedPreferences35.getString("vaccineExitDay3" + id, "");
            String mountExit = sharedPreferences36.getString("vaccineExitMount3" + id, "");
            String ageExit = sharedPreferences37.getString("vaccineExitAge3" + id, "");


            b.cause3.setText(day + "." + mount + "." + age + " г.");
            b.drug3.setText(drug);
            b.data3.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences4.getString("vaccineDay4" + id, "").equals("")) {
            b.layout4.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences41 = getActivity().getSharedPreferences("prefVaccineDay4" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences42 = getActivity().getSharedPreferences("prefVaccineMount4" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences43 = getActivity().getSharedPreferences("prefVaccineAge4" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences44 = getActivity().getSharedPreferences("prefDrugVaccine4" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences45 = getActivity().getSharedPreferences("prefVaccineExitDay4" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences46 = getActivity().getSharedPreferences("prefVaccineExitMount4" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences47 = getActivity().getSharedPreferences("prefVaccineExitAge4" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences41.getString("vaccineDay4" + id, "");
            String mount = sharedPreferences42.getString("vaccineMount4" + id, "");
            String age = sharedPreferences43.getString("vaccineAge4" + id, "");
            String drug = sharedPreferences44.getString("drugVaccine4" + id, "");
            String dayExit = sharedPreferences45.getString("vaccineExitDay4" + id, "");
            String mountExit = sharedPreferences46.getString("vaccineExitMount4" + id, "");
            String ageExit = sharedPreferences47.getString("vaccineExitAge4" + id, "");


            b.cause4.setText(day + "." + mount + "." + age + " г.");
            b.drug4.setText(drug);
            b.data4.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences5.getString("vaccineDay5" + id, "").equals("")) {
            b.layout5.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences51 = getActivity().getSharedPreferences("prefVaccineDay5" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences52 = getActivity().getSharedPreferences("prefVaccineMount5" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences53 = getActivity().getSharedPreferences("prefVaccineAge5" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences54 = getActivity().getSharedPreferences("prefDrugVaccine5" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences55 = getActivity().getSharedPreferences("prefVaccineExitDay5" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences56 = getActivity().getSharedPreferences("prefVaccineExitMount5" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences57 = getActivity().getSharedPreferences("prefVaccineExitAge5" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences51.getString("vaccineDay5" + id, "");
            String mount = sharedPreferences52.getString("vaccineMount5" + id, "");
            String age = sharedPreferences53.getString("vaccineAge5" + id, "");
            String drug = sharedPreferences54.getString("drugVaccine5" + id, "");
            String dayExit = sharedPreferences55.getString("vaccineExitDay5" + id, "");
            String mountExit = sharedPreferences56.getString("vaccineExitMount5" + id, "");
            String ageExit = sharedPreferences57.getString("vaccineExitAge5" + id, "");

            b.cause5.setText(day + "." + mount + "." + age + " г.");
            b.drug5.setText(drug);
            b.data5.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences6.getString("vaccineDay6" + id, "").equals("")) {
            b.layout6.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences61 = getActivity().getSharedPreferences("prefVaccineDay6" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences62 = getActivity().getSharedPreferences("prefVaccineMount6" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences63 = getActivity().getSharedPreferences("prefVaccineAge6" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences64 = getActivity().getSharedPreferences("prefDrugVaccine6" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences65 = getActivity().getSharedPreferences("prefVaccineExitDay6" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences66 = getActivity().getSharedPreferences("prefVaccineExitMount6" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences67 = getActivity().getSharedPreferences("prefVaccineExitAge6" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences61.getString("vaccineDay6" + id, "");
            String mount = sharedPreferences62.getString("vaccineMount6" + id, "");
            String age = sharedPreferences63.getString("vaccineAge6" + id, "");
            String drug = sharedPreferences64.getString("drugVaccine6" + id, "");
            String dayExit = sharedPreferences65.getString("vaccineExitDay6" + id, "");
            String mountExit = sharedPreferences66.getString("vaccineExitMount6" + id, "");
            String ageExit = sharedPreferences67.getString("vaccineExitAge6" + id, "");

            b.cause6.setText(day + "." + mount + "." + age + " г.");
            b.drug6.setText(drug);
            b.data6.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences7.getString("vaccineDay7" + id, "").equals("")) {
            b.layout7.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences71 = getActivity().getSharedPreferences("prefVaccineDay7" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences72 = getActivity().getSharedPreferences("prefVaccineMount7" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences73 = getActivity().getSharedPreferences("prefVaccineAge7" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences74 = getActivity().getSharedPreferences("prefDrugVaccine7" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences75 = getActivity().getSharedPreferences("prefVaccineExitDay7" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences76 = getActivity().getSharedPreferences("prefVaccineExitMount7" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences77 = getActivity().getSharedPreferences("prefVaccineExitAge7" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences71.getString("vaccineDay7" + id, "");
            String mount = sharedPreferences72.getString("vaccineMount7" + id, "");
            String age = sharedPreferences73.getString("vaccineAge7" + id, "");
            String drug = sharedPreferences74.getString("drugVaccine7" + id, "");
            String dayExit = sharedPreferences75.getString("vaccineExitDay7" + id, "");
            String mountExit = sharedPreferences76.getString("vaccineExitMount7" + id, "");
            String ageExit = sharedPreferences77.getString("vaccineExitAge7" + id, "");

            b.cause7.setText(day + "." + mount + "." + age + " г.");
            b.drug7.setText(drug);
            b.data7.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences8.getString("vaccineDay8" + id, "").equals("")) {
            b.layout8.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences81 = getActivity().getSharedPreferences("prefVaccineDay8" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences82 = getActivity().getSharedPreferences("prefVaccineMount8" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences83 = getActivity().getSharedPreferences("prefVaccineAge8" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences84 = getActivity().getSharedPreferences("prefDrugVaccine8" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences85 = getActivity().getSharedPreferences("prefVaccineExitDay8" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences86 = getActivity().getSharedPreferences("prefVaccineExitMount8" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences87 = getActivity().getSharedPreferences("prefVaccineExitAge8" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences81.getString("vaccineDay8" + id, "");
            String mount = sharedPreferences82.getString("vaccineMount8" + id, "");
            String age = sharedPreferences83.getString("vaccineAge8" + id, "");
            String drug = sharedPreferences84.getString("drugVaccine8" + id, "");
            String dayExit = sharedPreferences85.getString("vaccineExitDay8" + id, "");
            String mountExit = sharedPreferences86.getString("vaccineExitMount8" + id, "");
            String ageExit = sharedPreferences87.getString("vaccineExitAge8" + id, "");

            b.cause8.setText(day + "." + mount + "." + age + " г.");
            b.drug8.setText(drug);
            b.data8.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences9.getString("vaccineDay9" + id, "").equals("")) {
            b.layout9.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences91 = getActivity().getSharedPreferences("prefVaccineDay9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences92 = getActivity().getSharedPreferences("prefVaccineMount9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences93 = getActivity().getSharedPreferences("prefVaccineAge9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences94 = getActivity().getSharedPreferences("prefDrugVaccine9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences95 = getActivity().getSharedPreferences("prefVaccineExitDay9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences96 = getActivity().getSharedPreferences("prefVaccineExitMount9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences97 = getActivity().getSharedPreferences("prefVaccineExitAge9" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences91.getString("vaccineDay9" + id, "");
            String mount = sharedPreferences92.getString("vaccineMount9" + id, "");
            String age = sharedPreferences93.getString("vaccineAge9" + id, "");
            String drug = sharedPreferences94.getString("drugVaccine9" + id, "");
            String dayExit = sharedPreferences95.getString("vaccineExitDay9" + id, "");
            String mountExit = sharedPreferences96.getString("vaccineExitMount9" + id, "");
            String ageExit = sharedPreferences97.getString("vaccineExitAge9" + id, "");

            b.cause9.setText(day + "." + mount + "." + age + " г.");
            b.drug9.setText(drug);
            b.data9.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences9.getString("vaccineDay9" + id , "").equals("")) {
            b.layout9.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences91 = getActivity().getSharedPreferences("prefVaccineDay9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences92 = getActivity().getSharedPreferences("prefVaccineMount9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences93 = getActivity().getSharedPreferences("prefVaccineAge9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences94 = getActivity().getSharedPreferences("prefDrugVaccine9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences95 = getActivity().getSharedPreferences("prefVaccineExitDay9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences96 = getActivity().getSharedPreferences("prefVaccineExitMount9" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences97 = getActivity().getSharedPreferences("prefVaccineExitAge9" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences91.getString("vaccineDay9" + id, "");
            String mount = sharedPreferences92.getString("vaccineMount9" + id, "");
            String age = sharedPreferences93.getString("vaccineAge9" + id, "");
            String drug = sharedPreferences94.getString("drugVaccine9" + id, "");
            String dayExit = sharedPreferences95.getString("vaccineExitDay9" + id, "");
            String mountExit = sharedPreferences96.getString("vaccineExitMount9" + id, "");
            String ageExit = sharedPreferences97.getString("vaccineExitAge9" + id, "");

            b.cause9.setText(day + "." + mount + "." + age + " г.");
            b.drug9.setText(drug);
            b.data9.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

        if (!sharedPreferences10.getString("vaccineDay10" + id, "").equals("")) {
            b.layout10.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences101 = getActivity().getSharedPreferences("prefVaccineDay10" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences102 = getActivity().getSharedPreferences("prefVaccineMount10" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences103 = getActivity().getSharedPreferences("prefVaccineAge10" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences104 = getActivity().getSharedPreferences("prefDrugVaccine10" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences105 = getActivity().getSharedPreferences("prefVaccineExitDay10" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences106 = getActivity().getSharedPreferences("prefVaccineExitMount10" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences107 = getActivity().getSharedPreferences("prefVaccineExitAge10" + id, Context.MODE_PRIVATE);

            String day = sharedPreferences101.getString("vaccineDay10" + id, "");
            String mount = sharedPreferences102.getString("vaccineMount10" + id, "");
            String age = sharedPreferences103.getString("vaccineAge10" + id, "");
            String drug = sharedPreferences104.getString("drugVaccine10" + id, "");
            String dayExit = sharedPreferences105.getString("vaccineExitDay10" + id, "");
            String mountExit = sharedPreferences106.getString("vaccineExitMount10" + id, "");
            String ageExit = sharedPreferences107.getString("vaccineExitAge10" + id, "");

            b.cause10.setText(day + "." + mount + "." + age + " г.");
            b.drug10.setText(drug);
            b.data10.setText(dayExit + "." + mountExit + "." + ageExit + " г.");
        }

    }

    private void initCliker() {
        b.barVaccine.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.barVaccine:
                callback.onCreatFragment("vaccine");
                break;
            case R.id.layout1:
                callback.onButtonClicked("vaccinelayout", 1);
                break;
            case R.id.layout2:
                callback.onButtonClicked("vaccinelayout", 2);
                break;
            case R.id.layout3:
                callback.onButtonClicked("vaccinelayout", 3);
                break;
            case R.id.layout4:
                callback.onButtonClicked("vaccinelayout", 4);
                break;
            case R.id.layout5:
                callback.onButtonClicked("vaccinelayout", 5);
                break;
            case R.id.layout6:
                callback.onButtonClicked("vaccinelayout", 6);
                break;
            case R.id.layout7:
                callback.onButtonClicked("vaccinelayout", 7);
                break;
            case R.id.layout8:
                callback.onButtonClicked("vaccinelayout", 8);
                break;
            case R.id.layout9:
                callback.onButtonClicked("vaccinelayout", 9);
                break;
            case R.id.layout10:
                callback.onButtonClicked("vaccinelayout", 10);
                break;
        }
    }
}