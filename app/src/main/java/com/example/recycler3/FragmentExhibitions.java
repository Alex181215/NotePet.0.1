package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentExhibitionsBinding;


public class FragmentExhibitions extends Fragment implements View.OnClickListener {
    private FragmentExhibitionsBinding b;
    private SampleCallback callback;

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
        b = FragmentExhibitionsBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        initCliker(); // иициализация слушателей
        load();

        return v;
    }

    private void load() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefExhibitionDay1", Context.MODE_PRIVATE);
        if (!sharedPreferences1.getString("exhibitionDay1", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefExhibitionDay1", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefExhibitionMount1", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefExhibitionAge1", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefExhibitionBrend1", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefExhibitionFio1", Context.MODE_PRIVATE);
            String fio1 = sharedPreferences15.getString("exhibitionFio1", "");
            b.fio1.setText(fio1);

            String day1 = sharedPreferences11.getString("exhibitionDay1", "");
            String mount1 = sharedPreferences12.getString("exhibitionMount1", "");
            String age1 = sharedPreferences13.getString("exhibitionAge1", "");
            String brend1 = sharedPreferences14.getString("exhibitionBrend1", "");

            b.name1.setText(brend1);
            b.data1.setText(day1 + "." + mount1 + "." + age1+ "г.");

        }

        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefExhibitionDay2", Context.MODE_PRIVATE);
        if (!sharedPreferences2.getString("exhibitionDay2", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout2.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences21 = getActivity().getSharedPreferences("prefExhibitionDay2", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences22 = getActivity().getSharedPreferences("prefExhibitionMount2", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences23 = getActivity().getSharedPreferences("prefExhibitionAge2", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences24 = getActivity().getSharedPreferences("prefExhibitionBrend2", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences25 = getActivity().getSharedPreferences("prefExhibitionFio2", Context.MODE_PRIVATE);
            String fio1 = sharedPreferences25.getString("exhibitionFio2", "");
            b.fio2.setText(fio1);

            String day2 = sharedPreferences21.getString("exhibitionDay2", "");
            String mount2 = sharedPreferences22.getString("exhibitionMount2", "");
            String age2 = sharedPreferences23.getString("exhibitionAge2", "");
            String brend2 = sharedPreferences24.getString("exhibitionBrend2", "");


            b.name2.setText(brend2);
            b.data2.setText(day2 + "." + mount2 + "." + age2 + "г.");
        }

        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefExhibitionDay3", Context.MODE_PRIVATE);
        if (!sharedPreferences3.getString("exhibitionDay3", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout3.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences31 = getActivity().getSharedPreferences("prefExhibitionDay3", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences32 = getActivity().getSharedPreferences("prefExhibitionMount3", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences33 = getActivity().getSharedPreferences("prefExhibitionAge3", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences34 = getActivity().getSharedPreferences("prefExhibitionBrend3", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences35 = getActivity().getSharedPreferences("prefExhibitionFio3", Context.MODE_PRIVATE);
            String fio3 = sharedPreferences35.getString("exhibitionFio3", "");
            b.fio3.setText(fio3);

            String day = sharedPreferences31.getString("exhibitionDay3", "");
            String mount = sharedPreferences32.getString("exhibitionMount3", "");
            String age = sharedPreferences33.getString("exhibitionAge3", "");
            String brend = sharedPreferences34.getString("exhibitionBrend3", "");


            b.name3.setText(brend);
            b.data3.setText(day + "." + mount + "." + age + "г.");
        }

        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefExhibitionDay4", Context.MODE_PRIVATE);
        if (!sharedPreferences4.getString("exhibitionDay4", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout4.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences41 = getActivity().getSharedPreferences("prefExhibitionDay4", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences42 = getActivity().getSharedPreferences("prefExhibitionMount4", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences43 = getActivity().getSharedPreferences("prefExhibitionAge4", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences44 = getActivity().getSharedPreferences("prefExhibitionBrend4", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences45 = getActivity().getSharedPreferences("prefExhibitionFio4", Context.MODE_PRIVATE);
            String fio4 = sharedPreferences45.getString("exhibitionFio4", "");
            b.fio4.setText(fio4);

            String day4 = sharedPreferences41.getString("exhibitionDay4", "");
            String mount4 = sharedPreferences42.getString("exhibitionMount4", "");
            String age4 = sharedPreferences43.getString("exhibitionAge4", "");
            String brend4 = sharedPreferences44.getString("exhibitionBrend4", "");


            b.name4.setText(brend4);
            b.data4.setText(day4 + "." + mount4 + "." + age4 + "г.");
        }

        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefExhibitionDay5", Context.MODE_PRIVATE);
        if (!sharedPreferences5.getString("exhibitionDay5", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout5.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences51 = getActivity().getSharedPreferences("prefExhibitionDay5", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences52 = getActivity().getSharedPreferences("prefExhibitionMount5", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences53 = getActivity().getSharedPreferences("prefExhibitionAge5", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences54 = getActivity().getSharedPreferences("prefExhibitionBrend5", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences55 = getActivity().getSharedPreferences("prefExhibitionFio5", Context.MODE_PRIVATE);
            String fio5 = sharedPreferences55.getString("exhibitionFio5", "");
            b.fio5.setText(fio5);

            String day5 = sharedPreferences51.getString("exhibitionDay5", "");
            String mount5 = sharedPreferences52.getString("exhibitionMount5", "");
            String age5 = sharedPreferences53.getString("exhibitionAge5", "");
            String brend5 = sharedPreferences54.getString("exhibitionBrend5", "");

            b.name5.setText(brend5);
            b.data5.setText(day5 + "." + mount5 + "." + age5 + "г.");
        }

        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefExhibitionDay6", Context.MODE_PRIVATE);
        if (!sharedPreferences6.getString("exhibitionDay6", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout6.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences61 = getActivity().getSharedPreferences("prefExhibitionDay6", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences62 = getActivity().getSharedPreferences("prefExhibitionMount6", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences63 = getActivity().getSharedPreferences("prefExhibitionAge6", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences64 = getActivity().getSharedPreferences("prefExhibitionBrend6", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences65 = getActivity().getSharedPreferences("prefExhibitionFio6", Context.MODE_PRIVATE);
            String fio6 = sharedPreferences65.getString("exhibitionFio6", "");
            b.fio6.setText(fio6);

            String day6 = sharedPreferences61.getString("exhibitionDay6", "");
            String mount6 = sharedPreferences62.getString("exhibitionMount6", "");
            String age6 = sharedPreferences63.getString("exhibitionAge6", "");
            String brend6 = sharedPreferences64.getString("exhibitionBrend6", "");

            b.name6.setText(brend6);
            b.data6.setText(day6 + "." + mount6 + "." + age6 + "г.");
        }

        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefExhibitionDay7", Context.MODE_PRIVATE);
        if (!sharedPreferences7.getString("exhibitionDay7", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout7.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences71 = getActivity().getSharedPreferences("prefExhibitionDay7", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences72 = getActivity().getSharedPreferences("prefExhibitionMount7", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences73 = getActivity().getSharedPreferences("prefExhibitionAge7", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences74 = getActivity().getSharedPreferences("prefExhibitionBrend7", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences75 = getActivity().getSharedPreferences("prefExhibitionFio7", Context.MODE_PRIVATE);
            String fio7 = sharedPreferences75.getString("exhibitionFio7", "");
            b.fio7.setText(fio7);

            String day7 = sharedPreferences71.getString("exhibitionDay7", "");
            String mount7 = sharedPreferences72.getString("exhibitionMount7", "");
            String age7 = sharedPreferences73.getString("exhibitionAge7", "");
            String brend7 = sharedPreferences74.getString("exhibitionBrend7", "");

            b.name7.setText(brend7);
            b.data7.setText(day7 + "." + mount7 + "." + age7 + "г.");
        }

        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefExhibitionDay8", Context.MODE_PRIVATE);
        if (!sharedPreferences8.getString("exhibitionDay8", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout8.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences81 = getActivity().getSharedPreferences("prefExhibitionDay8", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences82 = getActivity().getSharedPreferences("prefExhibitionMount8", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences83 = getActivity().getSharedPreferences("prefExhibitionAge8", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences84 = getActivity().getSharedPreferences("prefExhibitionBrend8", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences85 = getActivity().getSharedPreferences("prefExhibitionFio8", Context.MODE_PRIVATE);
            String fio8 = sharedPreferences85.getString("exhibitionFio8", "");
            b.fio8.setText(fio8);

            String day8 = sharedPreferences81.getString("exhibitionDay8", "");
            String mount8 = sharedPreferences82.getString("exhibitionMount8", "");
            String age8 = sharedPreferences83.getString("exhibitionAge8", "");
            String brend8 = sharedPreferences84.getString("exhibitionBrend8", "");

            b.name8.setText(brend8);
            b.data8.setText(day8 + "." + mount8 + "." + age8 + "г.");
        }

        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefExhibitionDay9", Context.MODE_PRIVATE);
        if (!sharedPreferences9.getString("exhibitionDay9", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout9.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences91 = getActivity().getSharedPreferences("prefExhibitionDay9", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences92 = getActivity().getSharedPreferences("prefExhibitionMount9", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences93 = getActivity().getSharedPreferences("prefExhibitionAge9", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences94 = getActivity().getSharedPreferences("prefExhibitionBrend9", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences95 = getActivity().getSharedPreferences("prefExhibitionFio9", Context.MODE_PRIVATE);
            String fio9 = sharedPreferences95.getString("exhibitionFio9", "");
            b.fio9.setText(fio9);

            String day9 = sharedPreferences91.getString("exhibitionDay9", "");
            String mount9 = sharedPreferences92.getString("exhibitionMount9", "");
            String age9 = sharedPreferences93.getString("exhibitionAge9", "");
            String brend9 = sharedPreferences94.getString("exhibitionBrend9", "");


            b.name9.setText(brend9);
            b.data9.setText(day9 + "." + mount9 + "." + age9 + "г.");
        }

        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefExhibitionDay10", Context.MODE_PRIVATE);
        if (!sharedPreferences10.getString("exhibitionDay10", "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout10.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences101 = getActivity().getSharedPreferences("prefExhibitionDay10", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences102 = getActivity().getSharedPreferences("prefExhibitionMount10", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences103 = getActivity().getSharedPreferences("prefExhibitionAge10", Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences104 = getActivity().getSharedPreferences("prefExhibitionBrend10", Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences105 = getActivity().getSharedPreferences("prefExhibitionFio10", Context.MODE_PRIVATE);
            String fio10 = sharedPreferences105.getString("exhibitionFio10", "");
            b.fio10.setText(fio10);

            String day10 = sharedPreferences101.getString("exhibitionDay10", "");
            String mount10 = sharedPreferences102.getString("exhibitionMount10", "");
            String age10 = sharedPreferences103.getString("exhibitionAge10", "");
            String brend10 = sharedPreferences104.getString("exhibitionBrend10", "");

            b.name10.setText(brend10);
            b.data10.setText(day10 + "." + mount10 + "." + age10 + "г.");
        }
    }

    private void initCliker() {
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
        switch (v.getId()) {
            case R.id.newNote:
                callback.onCreatFragment("exhibitions");
                break;
            case R.id.layout1:
                callback.onButtonClicked("exhibitionslayout", 1);
                break;
            case R.id.layout2:
                callback.onButtonClicked("exhibitionslayout", 2);
                break;
            case R.id.layout3:
                callback.onButtonClicked("exhibitionslayout", 3);
                break;
            case R.id.layout4:
                callback.onButtonClicked("exhibitionslayout", 4);
                break;
            case R.id.layout5:
                callback.onButtonClicked("exhibitionslayout", 5);
                break;
            case R.id.layout6:
                callback.onButtonClicked("exhibitionslayout", 6);
                break;
            case R.id.layout7:
                callback.onButtonClicked("exhibitionslayout", 7);
                break;
            case R.id.layout8:
                callback.onButtonClicked("exhibitionslayout", 8);
                break;
            case R.id.layout9:
                callback.onButtonClicked("exhibitionslayout", 9);
                break;
            case R.id.layout10:
                callback.onButtonClicked("exhibitionslayout", 10);
                break;
        }
    }
}