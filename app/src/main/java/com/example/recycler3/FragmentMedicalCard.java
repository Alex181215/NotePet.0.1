package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentMedicalCardBinding;

public class FragmentMedicalCard extends Fragment implements View.OnClickListener {
    private FragmentMedicalCardBinding b;
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
        b = FragmentMedicalCardBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        initClicker(); // инициализируем клики
        id();
        show();

        return v;
    }

    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    private void show() {
        SharedPreferences sharedPreferences01 = getActivity().getSharedPreferences("prefCauseMedCart" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences02 = getActivity().getSharedPreferences("prefCauseMedCart2", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences03 = getActivity().getSharedPreferences("prefCauseMedCart3", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences04 = getActivity().getSharedPreferences("prefCauseMedCart4", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences05 = getActivity().getSharedPreferences("prefCauseMedCart5", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences06 = getActivity().getSharedPreferences("prefCauseMedCart6", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences07 = getActivity().getSharedPreferences("prefCauseMedCart7", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences08 = getActivity().getSharedPreferences("prefCauseMedCart8", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences09 = getActivity().getSharedPreferences("prefCauseMedCart9", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences010 = getActivity().getSharedPreferences("prefCauseMedCart10", Context.MODE_PRIVATE);

        if (!sharedPreferences01.getString("causeMedCart" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart" + id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart" + id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart" + id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart" + id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart" + id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart" + id, "");

            b.data1.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart" + id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart" + id, "");
            b.cause1.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart" + id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart" + id, "");
            b.name1.setText("Врач: " + fio);
        }
        if (!sharedPreferences02.getString("causeMedCart2", "").equals("")) {
            b.layout2.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart2", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart2", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart2", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart2", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart2", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart2", "");

            b.data2.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart2", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart2", "");
            b.cause2.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart2", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart2", "");
            b.name2.setText("Врач: " + fio);

        }

        if (!sharedPreferences03.getString("causeMedCart3", "").equals("")) {
            b.layout3.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart3", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart3", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart3", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart3", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart3", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart3", "");

            b.data3.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart3", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart3", "");
            b.cause3.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart3", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart3", "");
            b.name3.setText("Врач: " + fio);

        }

        if (!sharedPreferences04.getString("causeMedCart4", "").equals("")) {
            b.layout4.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart4", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart4", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart4", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart4", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart4", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart4", "");

            b.data4.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart4", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart4", "");
            b.cause4.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart4", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart4", "");
            b.name4.setText("Врач: " + fio);

        }

        if (!sharedPreferences05.getString("causeMedCart5", "").equals("")) {
            b.layout5.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart5", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart5", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart5", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart5", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart5", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart5", "");

            b.data5.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart5", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart5", "");
            b.cause5.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart5", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart5", "");
            b.name5.setText("Врач: " + fio);

        }

        if (!sharedPreferences06.getString("causeMedCart6", "").equals("")) {
            b.layout6.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart6", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart6", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart6", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart6", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart6", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart6", "");

            b.data6.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart6", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart6", "");
            b.cause6.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart6", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart6", "");
            b.name6.setText("Врач: " + fio);

        }

        if (!sharedPreferences07.getString("causeMedCart7", "").equals("")) {
            b.layout7.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart7", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart7", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart7", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart7", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart7", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart7", "");

            b.data7.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart7", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart7", "");
            b.cause7.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart7", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart7", "");
            b.name7.setText("Врач: " + fio);

        }

        if (!sharedPreferences08.getString("causeMedCart8", "").equals("")) {
            b.layout8.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart8", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart8", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart8", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart8", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart8", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart8", "");

            b.data8.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart8", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart8", "");
            b.cause8.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart8", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart8", "");
            b.name8.setText("Врач: " + fio);
        }

        if (!sharedPreferences09.getString("causeMedCart9", "").equals("")) {
            b.layout9.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart9", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart9", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart9", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart9", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart9", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart9", "");

            b.data9.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart9", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart9", "");
            b.cause9.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart9", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart9", "");
            b.name9.setText("Врач: " + fio);

        }

        if (!sharedPreferences010.getString("causeMedCart10", "").equals("")) {
            b.layout10.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart10", Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart10", "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart10", Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart10", "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart10", Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart10", "");

            b.data10.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart10", Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart10", "");
            b.cause10.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart10", Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart10", "");
            b.name10.setText("Врач: " + fio);

        }


    }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar:
                callback.onCreatFragment("medicalCard");
                break;
            case R.id.layout1:
            case R.id.layout2:
            case R.id.layout3:
            case R.id.layout4:
            case R.id.layout5:
            case R.id.layout6:
            case R.id.layout7:
            case R.id.layout8:
            case R.id.layout9:
            case R.id.layout10:
                callback.onCreatFragment("medicalCardlayout2");
                break;
        }
    }
}