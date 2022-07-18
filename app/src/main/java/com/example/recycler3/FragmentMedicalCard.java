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
        SharedPreferences sharedPreferences01 = getActivity().getSharedPreferences("prefCauseMedCart1" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences02 = getActivity().getSharedPreferences("prefCauseMedCart2" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences03 = getActivity().getSharedPreferences("prefCauseMedCart3" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences04 = getActivity().getSharedPreferences("prefCauseMedCart4" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences05 = getActivity().getSharedPreferences("prefCauseMedCart5" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences06 = getActivity().getSharedPreferences("prefCauseMedCart6" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences07 = getActivity().getSharedPreferences("prefCauseMedCart7" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences08 = getActivity().getSharedPreferences("prefCauseMedCart8" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences09 = getActivity().getSharedPreferences("prefCauseMedCart9" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences010 = getActivity().getSharedPreferences("prefCauseMedCart10" + id, Context.MODE_PRIVATE);

        if (!sharedPreferences01.getString("causeMedCart1" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart1" + id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart1" + id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart1" + id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart1" + id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart1" + id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart1" + id, "");

            b.data1.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart1" + id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart1" + id, "");
            b.cause1.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart1" + id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart1" + id, "");
            b.name1.setText("Врач: " + fio);
        }
        if (!sharedPreferences02.getString("causeMedCart2" + id, "").equals("")) {
            b.layout2.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart2" + id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart2" + id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart2" + id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart2" + id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart2" + id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart2" + id, "");

            b.data2.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart2" + id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart2" + id, "");
            b.cause2.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart2" + id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart2" + id, "");
            b.name2.setText("Врач: " + fio);

        }

        if (!sharedPreferences03.getString("causeMedCart3"+id, "").equals("")) {
            b.layout3.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart3"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart3"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart3"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart3"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart3"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart3"+id, "");

            b.data3.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart3"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart3"+id, "");
            b.cause3.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart3"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart3"+id, "");
            b.name3.setText("Врач: " + fio);

        }

        if (!sharedPreferences04.getString("causeMedCart4"+id, "").equals("")) {
            b.layout4.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart4"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart4"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart4"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart4"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart4"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart4"+id, "");

            b.data4.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart4"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart4"+id, "");
            b.cause4.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart4"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart4"+id, "");
            b.name4.setText("Врач: " + fio);

        }

        if (!sharedPreferences05.getString("causeMedCart5"+id, "").equals("")) {
            b.layout5.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart5"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart5"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart5"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart5"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart5"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart5"+id, "");

            b.data5.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart5"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart5"+id, "");
            b.cause5.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart5"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart5"+id, "");
            b.name5.setText("Врач: " + fio);

        }

        if (!sharedPreferences06.getString("causeMedCart6"+id, "").equals("")) {
            b.layout6.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart6"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart6"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart6"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart6"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart6"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart6"+id, "");

            b.data6.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart6"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart6"+id, "");
            b.cause6.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart6"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart6"+id, "");
            b.name6.setText("Врач: " + fio);

        }

        if (!sharedPreferences07.getString("causeMedCart7"+id, "").equals("")) {
            b.layout7.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart7"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart7"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart7"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart7"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart7"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart7"+id, "");

            b.data7.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart7"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart7"+id, "");
            b.cause7.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart7"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart7"+id, "");
            b.name7.setText("Врач: " + fio);

        }

        if (!sharedPreferences08.getString("causeMedCart8"+id, "").equals("")) {
            b.layout8.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart8"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart8"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart8"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart8"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart8"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart8"+id, "");

            b.data8.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart8"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart8"+id, "");
            b.cause8.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart8"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart8"+id, "");
            b.name8.setText("Врач: " + fio);
        }

        if (!sharedPreferences09.getString("causeMedCart9"+id, "").equals("")) {
            b.layout9.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart9"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart9"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart9"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart9"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart9"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart9"+id, "");

            b.data9.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart9"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart9"+id, "");
            b.cause9.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart9"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart9"+id, "");
            b.name9.setText("Врач: " + fio);

        }

        if (!sharedPreferences010.getString("causeMedCart10"+id, "").equals("")) {
            b.layout10.setVisibility(View.VISIBLE);

            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefDayMedCart10"+id, Context.MODE_PRIVATE);
            String day = sharedPreferences1.getString("dayMedCart10"+id, "");

            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMountMedCart10"+id, Context.MODE_PRIVATE);
            String mount = sharedPreferences2.getString("mountMedCart10"+id, "");

            SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefAgeMedCart10"+id, Context.MODE_PRIVATE);
            String age = sharedPreferences3.getString("ageMedCart10"+id, "");

            b.data10.setText("Прием от: " + day + "." + mount + "." + age + ".г");

            SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefCauseMedCart10"+id, Context.MODE_PRIVATE);
            String cause = sharedPreferences4.getString("causeMedCart10"+id, "");
            b.cause10.setText(cause);

            SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefFioMedCart10"+id, Context.MODE_PRIVATE);
            String fio = sharedPreferences5.getString("fioMedCart10"+id, "");
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
                callback.onButtonClicked("medicalCardlayout2", 1);

                break;
            case R.id.layout2:
                callback.onButtonClicked("medicalCardlayout2", 2);
                break;

            case R.id.layout3:
                callback.onButtonClicked("medicalCardlayout2", 3);
                break;

            case R.id.layout4:
                callback.onButtonClicked("medicalCardlayout2", 4);
                break;

            case R.id.layout5:
                callback.onButtonClicked("medicalCardlayout2", 5);
                break;

            case R.id.layout6:
                callback.onButtonClicked("medicalCardlayout2", 6);
                break;

            case R.id.layout7:
                callback.onButtonClicked("medicalCardlayout2", 7);
                break;

            case R.id.layout8:
                callback.onButtonClicked("medicalCardlayout2", 8);
                break;

            case R.id.layout9:
                callback.onButtonClicked("medicalCardlayout2", 9);
                break;
            case R.id.layout10:
                callback.onButtonClicked("medicalCardlayout2", 10);
                break;
        }
    }
}