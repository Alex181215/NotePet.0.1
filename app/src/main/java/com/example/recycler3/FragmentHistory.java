package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentHistoryBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentHistory extends Fragment {
    private FragmentHistoryBinding b;
    private SampleCallback callback;

    AgeCalculator ageCalculator = new AgeCalculator();
    int position = 0;

    String dataExit;

    private ArrayList<String> paramArrayList = new ArrayList<String>();
    private ArrayAdapter<String> paramArrayAdapter;

    private ArrayList<String> periodStartArrayList = new ArrayList<String>();
    private ArrayAdapter<String> periodStartArrayAdapter;

    private ArrayList<String> periodExitArrayList = new ArrayList<String>();
    private ArrayAdapter<String> periodExitArrayAdapter;

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
        b = FragmentHistoryBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("history");
        Pref.init(getActivity());

        set(b.petName);
        setAnimalAge();
        spinnerParam();
        spinnerPeriodStart();
        spinnerPeriodExit();


        return v;
    }

    private void saveData() {
        SimpleDateFormat dat = new SimpleDateFormat("dd.MM.yy");
        String currentDateand = dat.format(new Date());
        periodExitArrayList.add(dataExit = ("" + currentDateand));
    }

    private void spinnerPeriodExit() {
        saveData();
        periodExitArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, periodExitArrayList);
        b.spinneron.setAdapter(periodExitArrayAdapter);
    }

    private void spinnerPeriodStart() {
        loadStartData("prefData"+position, "data"+position);
        periodStartArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, periodStartArrayList);
        b.spinnerfrom.setAdapter(periodStartArrayAdapter);
    }

    private void loadStartData(String pref, String key) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(pref, Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(key, "").equals("")) {
            String name = sharedPreferences.getString(key, "");
            periodStartArrayList.add(name);
        }
    }

    private void spinnerParam() {
        loadParam("prefWeight", "weight", "Вес");
        loadParam("prefHeight", "height", "Высота");
        loadParam("prefBust", "bust", "Обхват груди");
        loadParam("prefBack", "back", "Длина спины");
        loadParam("prefGroin", "groin", "Длина от шеи до паха");
        loadParam("prefVolume", "volume", "Обхват шеи");
        loadParam("prefLength", "length", "Длина лапы");
        loadParam("prefWidth", "width", "Ширина лапы");

        paramArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, paramArrayList);
        b.spinnerParams.setAdapter(paramArrayAdapter);
    }

    private void loadParam(String pref, String key, String text) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(pref+position, Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(key+position, "").equals("")) {
            paramArrayList.add(text);
        }
    }

    private void setAnimalAge() {
        String test = this.getArguments().getString("key");
        position = Integer.parseInt(test);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefDay"+position, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefMount"+position, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefAge"+position, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAnimal"+position, Context.MODE_PRIVATE);

        String day = sharedPreferences.getString("day"+position, "");
        String mount = sharedPreferences1.getString("mount"+position, "");
        String age = sharedPreferences2.getString("age"+position, "");
        String animal = sharedPreferences3.getString("animal"+position, "");
        ageCalculator.ageCalculator(day, mount, age, b.animalAge, animal);
    }

    public void set(TextView text) {
        String test = this.getArguments().getString("key");
        position = Integer.parseInt(test);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefName"+position, Context.MODE_PRIVATE);
        if (!sharedPreferences.getString("name"+position, "").equals("")) {
            String name = sharedPreferences.getString("name"+position, "");
            text.setText(name);
        }
    }

}