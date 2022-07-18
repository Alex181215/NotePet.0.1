package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentTrainingBinding;


public class FragmentTraining extends Fragment implements View.OnClickListener{
    private FragmentTrainingBinding b;
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
        b = FragmentTrainingBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        initClicker();
        id();
        load();


        return v;
    }

    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    private void load() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefTrainingDay1"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefTrainingDay2"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefTrainingDay3"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefTrainingDay4"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefTrainingDay5"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefTrainingDay6"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefTrainingDay7"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefTrainingDay8"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefTrainingDay9"+id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefTrainingDay10"+id, Context.MODE_PRIVATE);


        if (!sharedPreferences1.getString("trainingDay1"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefTrainingDay1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefTrainingMount1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefTrainingAge1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefTrainingName1"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefTrainingFio1"+id, Context.MODE_PRIVATE);

            String day1 = sharedPreferences11.getString("trainingDay1"+id, "");
            String mount1 = sharedPreferences12.getString("trainingMount1"+id, "");
            String age1 = sharedPreferences13.getString("trainingAge1"+id, "");

            String cause1 = sharedPreferences14.getString("trainingName1"+id, "");
            String fio1 = sharedPreferences15.getString("trainingFio1"+id, "");

            b.fio1.setText(fio1);
            b.cause1.setText(cause1);
            b.data1.setText(day1 + "." + mount1 + "." + age1+ "г.");
        }

        if (!sharedPreferences2.getString("trainingDay2"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout2.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences21 = getActivity().getSharedPreferences("prefTrainingDay2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences22 = getActivity().getSharedPreferences("prefTrainingMount2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences23 = getActivity().getSharedPreferences("prefTrainingAge2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences24 = getActivity().getSharedPreferences("prefTrainingName2"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences25 = getActivity().getSharedPreferences("prefTrainingFio2"+id, Context.MODE_PRIVATE);

            String day2 = sharedPreferences21.getString("trainingDay2"+id, "");
            String mount2 = sharedPreferences22.getString("trainingMount2"+id, "");
            String age2 = sharedPreferences23.getString("trainingAge2"+id, "");

            String cause2 = sharedPreferences24.getString("trainingName2"+id, "");
            String fio2 = sharedPreferences25.getString("trainingFio2"+id, "");

            b.fio2.setText(fio2);
            b.cause2.setText(cause2);
            b.data2.setText(day2 + "." + mount2 + "." + age2+ "г.");
        }
        if (!sharedPreferences3.getString("trainingDay3"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout3.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences31 = getActivity().getSharedPreferences("prefTrainingDay3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences32 = getActivity().getSharedPreferences("prefTrainingMount3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences33 = getActivity().getSharedPreferences("prefTrainingAge3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences34 = getActivity().getSharedPreferences("prefTrainingName3"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences35 = getActivity().getSharedPreferences("prefTrainingFio3"+id, Context.MODE_PRIVATE);

            String day3 = sharedPreferences31.getString("trainingDay3"+id, "");
            String mount3 = sharedPreferences32.getString("trainingMount3"+id, "");
            String age3 = sharedPreferences33.getString("trainingAge3"+id, "");

            String cause3 = sharedPreferences34.getString("trainingName3"+id, "");
            String fio3 = sharedPreferences35.getString("trainingFio3"+id, "");

            b.fio3.setText(fio3);
            b.cause3.setText(cause3);
            b.data3.setText(day3 + "." + mount3 + "." + age3+ "г.");
        }
        if (!sharedPreferences4.getString("trainingDay4"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout4.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences41 = getActivity().getSharedPreferences("prefTrainingDay4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences42 = getActivity().getSharedPreferences("prefTrainingMount4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences43 = getActivity().getSharedPreferences("prefTrainingAge4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences44 = getActivity().getSharedPreferences("prefTrainingName4"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences45 = getActivity().getSharedPreferences("prefTrainingFio4"+id, Context.MODE_PRIVATE);

            String day4 = sharedPreferences41.getString("trainingDay4"+id, "");
            String mount4 = sharedPreferences42.getString("trainingMount4"+id, "");
            String age4 = sharedPreferences43.getString("trainingAge4"+id, "");

            String cause4 = sharedPreferences44.getString("trainingName4"+id, "");
            String fio4 = sharedPreferences45.getString("trainingFio4"+id, "");

            b.fio4.setText(fio4);
            b.cause4.setText(cause4);
            b.data4.setText(day4 + "." + mount4 + "." + age4+ "г.");
        }

        if (!sharedPreferences5.getString("trainingDay5"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout5.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences51 = getActivity().getSharedPreferences("prefTrainingDay5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences52 = getActivity().getSharedPreferences("prefTrainingMount5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences53 = getActivity().getSharedPreferences("prefTrainingAge5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences54 = getActivity().getSharedPreferences("prefTrainingName5"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences55 = getActivity().getSharedPreferences("prefTrainingFio5"+id, Context.MODE_PRIVATE);

            String day5 = sharedPreferences51.getString("trainingDay5"+id, "");
            String mount5 = sharedPreferences52.getString("trainingMount5"+id, "");
            String age5 = sharedPreferences53.getString("trainingAge5"+id, "");

            String cause5 = sharedPreferences54.getString("trainingName5"+id, "");
            String fio5 = sharedPreferences55.getString("trainingFio5"+id, "");

            b.fio5.setText(fio5);
            b.cause5.setText(cause5);
            b.data5.setText(day5 + "." + mount5 + "." + age5+ "г.");
        }

        if (!sharedPreferences6.getString("trainingDay6"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout6.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences61 = getActivity().getSharedPreferences("prefTrainingDay6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences62 = getActivity().getSharedPreferences("prefTrainingMount6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences63 = getActivity().getSharedPreferences("prefTrainingAge6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences64 = getActivity().getSharedPreferences("prefTrainingName6"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences65 = getActivity().getSharedPreferences("prefTrainingFio6"+id, Context.MODE_PRIVATE);

            String day6 = sharedPreferences61.getString("trainingDay6"+id, "");
            String mount6 = sharedPreferences62.getString("trainingMount6"+id, "");
            String age6 = sharedPreferences63.getString("trainingAge6"+id, "");

            String cause6 = sharedPreferences64.getString("trainingName6"+id, "");
            String fio6 = sharedPreferences65.getString("trainingFio6"+id, "");

            b.fio6.setText(fio6);
            b.cause6.setText(cause6);
            b.data6.setText(day6 + "." + mount6 + "." + age6+ "г.");
        }

        if (!sharedPreferences7.getString("trainingDay7"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout7.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences71 = getActivity().getSharedPreferences("prefTrainingDay7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences72 = getActivity().getSharedPreferences("prefTrainingMount7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences73 = getActivity().getSharedPreferences("prefTrainingAge7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences74 = getActivity().getSharedPreferences("prefTrainingName7"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences75 = getActivity().getSharedPreferences("prefTrainingFio7"+id, Context.MODE_PRIVATE);

            String day7 = sharedPreferences71.getString("trainingDay7"+id, "");
            String mount7 = sharedPreferences72.getString("trainingMount7"+id, "");
            String age7 = sharedPreferences73.getString("trainingAge7"+id, "");

            String cause7 = sharedPreferences74.getString("trainingName7"+id, "");
            String fio7 = sharedPreferences75.getString("trainingFio7"+id, "");

            b.fio7.setText(fio7);
            b.cause7.setText(cause7);
            b.data7.setText(day7 + "." + mount7 + "." + age7+ "г.");
        }

        if (!sharedPreferences8.getString("trainingDay8"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout8.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences81 = getActivity().getSharedPreferences("prefTrainingDay8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences82 = getActivity().getSharedPreferences("prefTrainingMount8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences83 = getActivity().getSharedPreferences("prefTrainingAge8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences84 = getActivity().getSharedPreferences("prefTrainingName8"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences85 = getActivity().getSharedPreferences("prefTrainingFio8"+id, Context.MODE_PRIVATE);

            String day8 = sharedPreferences81.getString("trainingDay8"+id, "");
            String mount8 = sharedPreferences82.getString("trainingMount8"+id, "");
            String age8 = sharedPreferences83.getString("trainingAge8"+id, "");

            String cause8 = sharedPreferences84.getString("trainingName8"+id, "");
            String fio8 = sharedPreferences85.getString("trainingFio8"+id, "");

            b.fio8.setText(fio8);
            b.cause8.setText(cause8);
            b.data8.setText(day8 + "." + mount8 + "." + age8+ "г.");
        }

        if (!sharedPreferences9.getString("trainingDay9"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout9.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences91 = getActivity().getSharedPreferences("prefTrainingDay9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences92 = getActivity().getSharedPreferences("prefTrainingMount9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences93 = getActivity().getSharedPreferences("prefTrainingAge9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences94 = getActivity().getSharedPreferences("prefTrainingName9"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences95 = getActivity().getSharedPreferences("prefTrainingFio9"+id, Context.MODE_PRIVATE);

            String day9 = sharedPreferences91.getString("trainingDay9"+id, "");
            String mount9 = sharedPreferences92.getString("trainingMount9"+id, "");
            String age9 = sharedPreferences93.getString("trainingAge9"+id, "");

            String cause9 = sharedPreferences94.getString("trainingName9"+id, "");
            String fio9 = sharedPreferences95.getString("trainingFio9"+id, "");

            b.fio9.setText(fio9);
            b.cause9.setText(cause9);
            b.data9.setText(day9 + "." + mount9 + "." + age9+ "г.");
        }

        if (!sharedPreferences10.getString("trainingDay10"+id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout10.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences101 = getActivity().getSharedPreferences("prefTrainingDay10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences102 = getActivity().getSharedPreferences("prefTrainingMount10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences103 = getActivity().getSharedPreferences("prefTrainingAge10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences104 = getActivity().getSharedPreferences("prefTrainingName10"+id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences105 = getActivity().getSharedPreferences("prefTrainingFio10"+id, Context.MODE_PRIVATE);

            String day10 = sharedPreferences101.getString("trainingDay10"+id, "");
            String mount10 = sharedPreferences102.getString("trainingMount10"+id, "");
            String age10 = sharedPreferences103.getString("trainingAge10"+id, "");

            String cause10 = sharedPreferences104.getString("trainingName10"+id, "");
            String fio10 = sharedPreferences105.getString("trainingFio10"+id, "");

            b.fio10.setText(fio10);
            b.cause10.setText(cause10);
            b.data10.setText(day10 + "." + mount10 + "." + age10+ "г.");
        }

    }

    private void initClicker() {
        b.newNote.setOnClickListener(this);
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
        switch (v.getId()){
            case R.id.newNote:
                callback.onCreatFragment("training");
                break;
            case R.id.layout1:
                callback.onButtonClicked("traininglayout", 1);
                break;
            case R.id.layout2:
                callback.onButtonClicked("traininglayout", 2);
                break;
            case R.id.layout3:
                callback.onButtonClicked("traininglayout", 3);
                break;
            case R.id.layout4:
                callback.onButtonClicked("traininglayout", 4);
                break;
            case R.id.layout5:
                callback.onButtonClicked("traininglayout", 5);
                break;
            case R.id.layout6:
                callback.onButtonClicked("traininglayout", 6);
                break;
            case R.id.layout7:
                callback.onButtonClicked("traininglayout", 7);
                break;
            case R.id.layout8:
                callback.onButtonClicked("traininglayout", 8);
                break;
            case R.id.layout9:
                callback.onButtonClicked("traininglayout", 9);
                break;
            case R.id.layout10:
                callback.onButtonClicked("traininglayout", 10);
                break;
        }
    }
}