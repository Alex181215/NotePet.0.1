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
        b = FragmentExhibitionsBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        initCliker(); // иициализация слушателей
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
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefExhibitionDay1" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefExhibitionDay2" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefExhibitionDay3" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefExhibitionDay4" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefExhibitionDay5" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefExhibitionDay6" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefExhibitionDay7" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefExhibitionDay8" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefExhibitionDay9" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefExhibitionDay10" + id, Context.MODE_PRIVATE);

        if (!sharedPreferences1.getString("exhibitionDay1" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefExhibitionDay1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefExhibitionMount1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefExhibitionAge1" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefExhibitionBrend1" + id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefExhibitionFio1" + id, Context.MODE_PRIVATE);
            String fio1 = sharedPreferences15.getString("exhibitionFio1" + id, "");
            b.fio1.setText(fio1);

            String day1 = sharedPreferences11.getString("exhibitionDay1" + id, "");
            String mount1 = sharedPreferences12.getString("exhibitionMount1" + id, "");
            String age1 = sharedPreferences13.getString("exhibitionAge1" + id, "");
            String brend1 = sharedPreferences14.getString("exhibitionBrend1" + id, "");

            b.name1.setText(brend1);
            b.data1.setText(day1 + "." + mount1 + "." + age1 + "г.");

        }

        if (!sharedPreferences2.getString("exhibitionDay2" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout2.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences21 = getActivity().getSharedPreferences("prefExhibitionDay2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences22 = getActivity().getSharedPreferences("prefExhibitionMount2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences23 = getActivity().getSharedPreferences("prefExhibitionAge2" + id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences24 = getActivity().getSharedPreferences("prefExhibitionBrend2" + id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences25 = getActivity().getSharedPreferences("prefExhibitionFio2" + id, Context.MODE_PRIVATE);
            String fio1 = sharedPreferences25.getString("exhibitionFio2" + id, "");
            b.fio2.setText(fio1);

            String day2 = sharedPreferences21.getString("exhibitionDay2" + id, "");
            String mount2 = sharedPreferences22.getString("exhibitionMount2" + id, "");
            String age2 = sharedPreferences23.getString("exhibitionAge2" + id, "");
            String brend2 = sharedPreferences24.getString("exhibitionBrend2" + id, "");


            b.name2.setText(brend2);
            b.data2.setText(day2 + "." + mount2 + "." + age2 + "г.");
        }

        if (!sharedPreferences3.getString("exhibitionDay3" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout3.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences31 = getActivity().getSharedPreferences("prefExhibitionDay3" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences32 = getActivity().getSharedPreferences("prefExhibitionMount3" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences33 = getActivity().getSharedPreferences("prefExhibitionAge3" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences34 = getActivity().getSharedPreferences("prefExhibitionBrend3" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences35 = getActivity().getSharedPreferences("prefExhibitionFio3" +id, Context.MODE_PRIVATE);
            String fio3 = sharedPreferences35.getString("exhibitionFio3" +id, "");
            b.fio3.setText(fio3);

            String day = sharedPreferences31.getString("exhibitionDay3" +id, "");
            String mount = sharedPreferences32.getString("exhibitionMount3" +id, "");
            String age = sharedPreferences33.getString("exhibitionAge3" +id, "");
            String brend = sharedPreferences34.getString("exhibitionBrend3" +id, "");


            b.name3.setText(brend);
            b.data3.setText(day + "." + mount + "." + age + "г.");
        }

        if (!sharedPreferences4.getString("exhibitionDay4" +id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout4.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences41 = getActivity().getSharedPreferences("prefExhibitionDay4" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences42 = getActivity().getSharedPreferences("prefExhibitionMount4" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences43 = getActivity().getSharedPreferences("prefExhibitionAge4" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences44 = getActivity().getSharedPreferences("prefExhibitionBrend4" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences45 = getActivity().getSharedPreferences("prefExhibitionFio4" +id, Context.MODE_PRIVATE);
            String fio4 = sharedPreferences45.getString("exhibitionFio4" +id, "");
            b.fio4.setText(fio4);

            String day4 = sharedPreferences41.getString("exhibitionDay4" +id, "");
            String mount4 = sharedPreferences42.getString("exhibitionMount4" +id, "");
            String age4 = sharedPreferences43.getString("exhibitionAge4" +id, "");
            String brend4 = sharedPreferences44.getString("exhibitionBrend4" +id, "");


            b.name4.setText(brend4);
            b.data4.setText(day4 + "." + mount4 + "." + age4 + "г.");
        }

        if (!sharedPreferences5.getString("exhibitionDay5" +id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout5.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences51 = getActivity().getSharedPreferences("prefExhibitionDay5" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences52 = getActivity().getSharedPreferences("prefExhibitionMount5" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences53 = getActivity().getSharedPreferences("prefExhibitionAge5" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences54 = getActivity().getSharedPreferences("prefExhibitionBrend5" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences55 = getActivity().getSharedPreferences("prefExhibitionFio5" +id, Context.MODE_PRIVATE);
            String fio5 = sharedPreferences55.getString("exhibitionFio5" +id, "");
            b.fio5.setText(fio5);

            String day5 = sharedPreferences51.getString("exhibitionDay5" +id, "");
            String mount5 = sharedPreferences52.getString("exhibitionMount5" +id, "");
            String age5 = sharedPreferences53.getString("exhibitionAge5" +id, "");
            String brend5 = sharedPreferences54.getString("exhibitionBrend5" +id, "");

            b.name5.setText(brend5);
            b.data5.setText(day5 + "." + mount5 + "." + age5 + "г.");
        }

        if (!sharedPreferences6.getString("exhibitionDay6" +id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout6.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences61 = getActivity().getSharedPreferences("prefExhibitionDay6" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences62 = getActivity().getSharedPreferences("prefExhibitionMount6" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences63 = getActivity().getSharedPreferences("prefExhibitionAge6" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences64 = getActivity().getSharedPreferences("prefExhibitionBrend6" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences65 = getActivity().getSharedPreferences("prefExhibitionFio6" +id, Context.MODE_PRIVATE);
            String fio6 = sharedPreferences65.getString("exhibitionFio6" +id, "");
            b.fio6.setText(fio6);

            String day6 = sharedPreferences61.getString("exhibitionDay6" +id, "");
            String mount6 = sharedPreferences62.getString("exhibitionMount6" +id, "");
            String age6 = sharedPreferences63.getString("exhibitionAge6" +id, "");
            String brend6 = sharedPreferences64.getString("exhibitionBrend6" +id, "");

            b.name6.setText(brend6);
            b.data6.setText(day6 + "." + mount6 + "." + age6 + "г.");
        }

        if (!sharedPreferences7.getString("exhibitionDay7" +id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout7.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences71 = getActivity().getSharedPreferences("prefExhibitionDay7" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences72 = getActivity().getSharedPreferences("prefExhibitionMount7" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences73 = getActivity().getSharedPreferences("prefExhibitionAge7" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences74 = getActivity().getSharedPreferences("prefExhibitionBrend7" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences75 = getActivity().getSharedPreferences("prefExhibitionFio7" +id, Context.MODE_PRIVATE);
            String fio7 = sharedPreferences75.getString("exhibitionFio7" +id, "");
            b.fio7.setText(fio7);

            String day7 = sharedPreferences71.getString("exhibitionDay7" +id, "");
            String mount7 = sharedPreferences72.getString("exhibitionMount7" +id, "");
            String age7 = sharedPreferences73.getString("exhibitionAge7" +id, "");
            String brend7 = sharedPreferences74.getString("exhibitionBrend7" +id, "");

            b.name7.setText(brend7);
            b.data7.setText(day7 + "." + mount7 + "." + age7 + "г.");
        }

        if (!sharedPreferences8.getString("exhibitionDay8" +id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout8.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences81 = getActivity().getSharedPreferences("prefExhibitionDay8" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences82 = getActivity().getSharedPreferences("prefExhibitionMount8" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences83 = getActivity().getSharedPreferences("prefExhibitionAge8" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences84 = getActivity().getSharedPreferences("prefExhibitionBrend8" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences85 = getActivity().getSharedPreferences("prefExhibitionFio8" +id, Context.MODE_PRIVATE);
            String fio8 = sharedPreferences85.getString("exhibitionFio8" +id, "");
            b.fio8.setText(fio8);

            String day8 = sharedPreferences81.getString("exhibitionDay8" +id, "");
            String mount8 = sharedPreferences82.getString("exhibitionMount8" +id, "");
            String age8 = sharedPreferences83.getString("exhibitionAge8" +id, "");
            String brend8 = sharedPreferences84.getString("exhibitionBrend8" +id, "");

            b.name8.setText(brend8);
            b.data8.setText(day8 + "." + mount8 + "." + age8 + "г.");
        }

        if (!sharedPreferences9.getString("exhibitionDay9" +id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout9.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences91 = getActivity().getSharedPreferences("prefExhibitionDay9" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences92 = getActivity().getSharedPreferences("prefExhibitionMount9" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences93 = getActivity().getSharedPreferences("prefExhibitionAge9" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences94 = getActivity().getSharedPreferences("prefExhibitionBrend9" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences95 = getActivity().getSharedPreferences("prefExhibitionFio9" +id, Context.MODE_PRIVATE);
            String fio9 = sharedPreferences95.getString("exhibitionFio9" +id, "");
            b.fio9.setText(fio9);

            String day9 = sharedPreferences91.getString("exhibitionDay9" +id, "");
            String mount9 = sharedPreferences92.getString("exhibitionMount9" +id, "");
            String age9 = sharedPreferences93.getString("exhibitionAge9" +id, "");
            String brend9 = sharedPreferences94.getString("exhibitionBrend9" +id, "");


            b.name9.setText(brend9);
            b.data9.setText(day9 + "." + mount9 + "." + age9 + "г.");
        }

        if (!sharedPreferences10.getString("exhibitionDay10" +id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout10.setVisibility(View.VISIBLE);
            SharedPreferences sharedPreferences101 = getActivity().getSharedPreferences("prefExhibitionDay10" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences102 = getActivity().getSharedPreferences("prefExhibitionMount10" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences103 = getActivity().getSharedPreferences("prefExhibitionAge10" +id, Context.MODE_PRIVATE);
            SharedPreferences sharedPreferences104 = getActivity().getSharedPreferences("prefExhibitionBrend10" +id, Context.MODE_PRIVATE);

            SharedPreferences sharedPreferences105 = getActivity().getSharedPreferences("prefExhibitionFio10" +id, Context.MODE_PRIVATE);
            String fio10 = sharedPreferences105.getString("exhibitionFio10" +id, "");
            b.fio10.setText(fio10);

            String day10 = sharedPreferences101.getString("exhibitionDay10" +id, "");
            String mount10 = sharedPreferences102.getString("exhibitionMount10" +id, "");
            String age10 = sharedPreferences103.getString("exhibitionAge10" +id, "");
            String brend10 = sharedPreferences104.getString("exhibitionBrend10" +id, "");

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