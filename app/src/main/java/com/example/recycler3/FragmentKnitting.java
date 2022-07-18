package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentKnittingBinding;


public class FragmentKnitting extends Fragment implements View.OnClickListener {
    private SampleCallback callback;
    private FragmentKnittingBinding b;
    private int countKnit = 0;
    private int countChild = 0;
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
        b = FragmentKnittingBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentKnitting");
        id();
        hide();
        load();
        clicker();

        return v;
    }

    private void id() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
        String idS = sharedPreferences.getString("activ", "");
        id = Integer.parseInt(idS);
    }

    private void hide() {
        b.layout1.setVisibility(View.GONE);
        b.layout2.setVisibility(View.GONE);
        b.layout3.setVisibility(View.GONE);
        b.layout4.setVisibility(View.GONE);
        b.layout5.setVisibility(View.GONE);
        b.layout6.setVisibility(View.GONE);
        b.layout7.setVisibility(View.GONE);
        b.layout8.setVisibility(View.GONE);
        b.layout9.setVisibility(View.GONE);
        b.layout10.setVisibility(View.GONE);
    }

    private void load() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnitWomen1" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefKnitWomen2" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefKnitWomen3" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefKnitWomen4" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefKnitWomen5" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefKnitWomen6" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefKnitWomen7" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefKnitWomen8" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefKnitWomen9" + id, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefKnitWomen10" + id, Context.MODE_PRIVATE);

        if (!sharedPreferences1.getString("knitWomen1" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout1.setVisibility(View.VISIBLE);
            b.name1.setText(sharedPreferences1.getString("knitWomen1" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay11" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay11" + id, "").equals("")) {
                countKnit = 1;
                b.child1.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay21" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay21" + id, "").equals("")) {
                countKnit = 2;
                b.child1.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay31" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay31" + id, "").equals("")) {
                countKnit = 3;
                b.child1.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay41" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay41" + id, "").equals("")) {
                countKnit = 4;
                b.child1.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay51" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay51" + id, "").equals("")) {
                countKnit = 5;
                b.child1.setText(countKnit + " вязок");
            }

            SharedPreferences sharedPreferences16 = getActivity().getSharedPreferences("prefChildName11" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences16.getString("childName11" + id, "").equals("")) {
                countChild = 1;
                if (countKnit == 1) {
                    b.child1.setText(countKnit + " вязка" + " 1 детеныш");
                } else {
                    b.child1.setText(countKnit + " вязок" + " 1 детеныш");
                }
            }

            SharedPreferences sharedPreferences17 = getActivity().getSharedPreferences("prefChildName21" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences17.getString("childName21" + id, "").equals("")) {
                countChild = 2;
                if (countKnit == 1) {
                    b.child1.setText(countKnit + " вязка" + " 2 детеныша");
                } else {
                    b.child1.setText(countKnit + " вязок" + " 2 детеныша");
                }
            }

            SharedPreferences sharedPreferences18 = getActivity().getSharedPreferences("prefChildName31" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences18.getString("childName31" + id, "").equals("")) {
                countChild = 3;
                if (countKnit == 1) {
                    b.child1.setText(countKnit + " вязка" + " 3 детенышей");
                } else {
                    b.child1.setText(countKnit + " вязок" + " 3 детенышей");
                }
            }

            SharedPreferences sharedPreferences19 = getActivity().getSharedPreferences("prefChildName41" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences19.getString("childName41" + id, "").equals("")) {
                countChild = 4;
                if (countKnit == 1) {
                    b.child1.setText(countKnit + " вязка" + " 4 детенышей");
                } else {
                    b.child1.setText(countKnit + " вязок" + " 4 детенышей");
                }
            }

            SharedPreferences sharedPreferences20 = getActivity().getSharedPreferences("prefChildName51" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences20.getString("childName51" + id, "").equals("")) {
                countChild = 5;
                if (countKnit == 1) {
                    b.child1.setText(countKnit + " вязка" + " 5 детенышей");
                } else {
                    b.child1.setText(countKnit + " вязок" + " 5 детенышей");
                }
            }
        }

        if (!sharedPreferences2.getString("knitWomen2" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout2.setVisibility(View.VISIBLE);
            b.name2.setText(sharedPreferences2.getString("knitWomen2" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay12" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay12" + id, "").equals("")) {
                countKnit = 1;
                b.child2.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay22 + id", Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay22" + id, "").equals("")) {
                countKnit = 2;
                b.child2.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay32" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay32" + id, "").equals("")) {
                countKnit = 3;
                b.child2.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay42" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay42" + id, "").equals("")) {
                countKnit = 4;
                b.child2.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay52" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay52" + id, "").equals("")) {
                countKnit = 5;
                b.child2.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences3.getString("knitWomen3" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout3.setVisibility(View.VISIBLE);
            b.name3.setText(sharedPreferences3.getString("knitWomen3" + id, ""));


            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay13" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay13" + id, "").equals("")) {
                countKnit = 1;
                b.child3.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay23" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay23" + id,  "").equals("")) {
                countKnit = 2;
                b.child3.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay33" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay33" + id, "").equals("")) {
                countKnit = 3;
                b.child3.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay43" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay43" + id, "").equals("")) {
                countKnit = 4;
                b.child3.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay53" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay53" + id, "").equals("")) {
                countKnit = 5;
                b.child3.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences4.getString("knitWomen4" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout4.setVisibility(View.VISIBLE);
            b.name4.setText(sharedPreferences4.getString("knitWomen4" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay14" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay14" + id, "").equals("")) {
                countKnit = 1;
                b.child4.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay24" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay24" + id, "").equals("")) {
                countKnit = 2;
                b.child4.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay34" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay34" + id, "").equals("")) {
                countKnit = 3;
                b.child4.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay44" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay44" + id, "").equals("")) {
                countKnit = 4;
                b.child4.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay54" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay54" + id, "").equals("")) {
                countKnit = 5;
                b.child4.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences5.getString("knitWomen5" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout5.setVisibility(View.VISIBLE);
            b.name5.setText(sharedPreferences5.getString("knitWomen5" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay15" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay15" + id, "").equals("")) {
                countKnit = 1;
                b.child5.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay25" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay25" + id, "").equals("")) {
                countKnit = 2;
                b.child5.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay35" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay35" + id, "").equals("")) {
                countKnit = 3;
                b.child5.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay45" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay45" + id, "").equals("")) {
                countKnit = 4;
                b.child5.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay55" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay55" + id, "").equals("")) {
                countKnit = 5;
                b.child5.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences6.getString("knitWomen6" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout6.setVisibility(View.VISIBLE);
            b.name6.setText(sharedPreferences6.getString("knitWomen6" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay16" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay16" + id, "").equals("")) {
                countKnit = 1;
                b.child6.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay26" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay26" + id, "").equals("")) {
                countKnit = 2;
                b.child6.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay36" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay36" + id, "").equals("")) {
                countKnit = 3;
                b.child6.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay46" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay46" + id, "").equals("")) {
                countKnit = 4;
                b.child6.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay56" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay56" + id, "").equals("")) {
                countKnit = 5;
                b.child6.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences7.getString("knitWomen7" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout7.setVisibility(View.VISIBLE);
            b.name7.setText(sharedPreferences7.getString("knitWomen7" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay17" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay17" + id, "").equals("")) {
                countKnit = 1;
                b.child7.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay27" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay27" + id, "").equals("")) {
                countKnit = 2;
                b.child7.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay37" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay37" + id, "").equals("")) {
                countKnit = 3;
                b.child7.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay47" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay47" + id, "").equals("")) {
                countKnit = 4;
                b.child7.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay57" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay57" + id, "").equals("")) {
                countKnit = 5;
                b.child7.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences8.getString("knitWomen8" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout8.setVisibility(View.VISIBLE);
            b.name8.setText(sharedPreferences8.getString("knitWomen8" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay18" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay18" + id, "").equals("")) {
                countKnit = 1;
                b.child8.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay28" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay28" + id, "").equals("")) {
                countKnit = 2;
                b.child8.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay38" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay38" + id, "").equals("")) {
                countKnit = 3;
                b.child8.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay48" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay48" + id, "").equals("")) {
                countKnit = 4;
                b.child8.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay58" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay58" + id, "").equals("")) {
                countKnit = 5;
                b.child8.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences9.getString("knitWomen9" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout9.setVisibility(View.VISIBLE);
            b.name9.setText(sharedPreferences9.getString("knitWomen9" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay19" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay19" + id, "").equals("")) {
                countKnit = 1;
                b.child9.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay29" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay29" + id, "").equals("")) {
                countKnit = 2;
                b.child9.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay39" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay39" + id, "").equals("")) {
                countKnit = 3;
                b.child9.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay49" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay49" + id, "").equals("")) {
                countKnit = 4;
                b.child9.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay59" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay59" + id , "").equals("")) {
                countKnit = 5;
                b.child9.setText(countKnit + " вязок");
            }
        }

        if (!sharedPreferences10.getString("knitWomen10" + id, "").equals("")) {
            b.textView3.setVisibility(View.GONE);
            b.layout10.setVisibility(View.VISIBLE);
            b.name10.setText(sharedPreferences10.getString("knitWomen10" + id, ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay110" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences11.getString("knitDay110" + id, "").equals("")) {
                countKnit = 1;
                b.child10.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay210" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences12.getString("knitDay210" + id, "").equals("")) {
                countKnit = 2;
                b.child10.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay310" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences13.getString("knitDay310" + id, "").equals("")) {
                countKnit = 3;
                b.child10.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay410" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences14.getString("knitDay410" + id, "").equals("")) {
                countKnit = 4;
                b.child10.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay510" + id, Context.MODE_PRIVATE);
            if (!sharedPreferences15.getString("knitDay510" + id, "").equals("")) {
                countKnit = 5;
                b.child10.setText(countKnit + " вязок");
            }
        }
    }

    private void clicker() {
        b.btnSetPetKnitting.setOnClickListener(this);
        b.imageSetPetKnitting.setOnClickListener(this);
        b.ava1.setOnClickListener(this);
        b.ava2.setOnClickListener(this);
        b.ava4.setOnClickListener(this);
        b.ava5.setOnClickListener(this);
        b.ava6.setOnClickListener(this);
        b.ava7.setOnClickListener(this);
        b.ava8.setOnClickListener(this);
        b.ava9.setOnClickListener(this);
        b.ava10.setOnClickListener(this);
        b.shape1.setOnClickListener(this);
        b.shape2.setOnClickListener(this);
        b.shape3.setOnClickListener(this);
        b.shape4.setOnClickListener(this);
        b.shape5.setOnClickListener(this);
        b.shape6.setOnClickListener(this);
        b.shape7.setOnClickListener(this);
        b.shape8.setOnClickListener(this);
        b.shape9.setOnClickListener(this);
        b.shape10.setOnClickListener(this);
        b.edit1.setOnClickListener(this);
        b.edit2.setOnClickListener(this);
        b.edit3.setOnClickListener(this);
        b.edit4.setOnClickListener(this);
        b.edit5.setOnClickListener(this);
        b.edit6.setOnClickListener(this);
        b.edit7.setOnClickListener(this);
        b.edit8.setOnClickListener(this);
        b.edit9.setOnClickListener(this);
        b.edit10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSetPetKnitting:
                callback.onCreatFragment("KnittingCreate");
                break;
            case R.id.imageSetPetKnitting:
                callback.onCreatFragment("knitting");
                break;
            case R.id.ava1:
                callback.onButtonClicked("knittinglayout", 1);
                break;
            case R.id.ava2:
                callback.onButtonClicked("knittinglayout", 2);
                break;
            case R.id.ava3:
                callback.onButtonClicked("knittinglayout", 3);
                break;
            case R.id.ava4:
                callback.onButtonClicked("knittinglayout", 4);
                break;
            case R.id.ava5:
                callback.onButtonClicked("knittinglayout", 5);
                break;
            case R.id.ava6:
                callback.onButtonClicked("knittinglayout", 6);
                break;
            case R.id.ava7:
                callback.onButtonClicked("knittinglayout", 7);
                break;
            case R.id.ava8:
                callback.onButtonClicked("knittinglayout", 8);
                break;
            case R.id.ava9:
                callback.onButtonClicked("knittinglayout", 9);
                break;
            case R.id.ava10:
                callback.onButtonClicked("knittinglayout", 10);
                break;
            case R.id.shape1:
                callback.onButtonClicked("knittinglayout", 1);
                break;
            case R.id.shape2:
                callback.onButtonClicked("knittinglayout", 2);
                break;
            case R.id.shape3:
                callback.onButtonClicked("knittinglayout", 3);
                break;
            case R.id.shape4:
                callback.onButtonClicked("knittinglayout", 4);
                break;
            case R.id.shape5:
                callback.onButtonClicked("knittinglayout", 5);
                break;
            case R.id.shape6:
                callback.onButtonClicked("knittinglayout", 6);
                break;
            case R.id.shape7:
                callback.onButtonClicked("knittinglayout", 7);
                break;
            case R.id.shape8:
                callback.onButtonClicked("knittinglayout", 8);
                break;
            case R.id.shape9:
                callback.onButtonClicked("knittinglayout", 9);
                break;
            case R.id.shape10:
                callback.onButtonClicked("knittinglayout", 10);
                break;
            case R.id.edit1:
                callback.onButtonClicked3("knittingEdit", 1, "edit");
                break;
            case R.id.edit2:
                callback.onButtonClicked3("knittingEdit", 2, "edit");
                break;
            case R.id.edit3:
                callback.onButtonClicked3("knittingEdit", 3, "edit");
                break;
            case R.id.edit4:
                callback.onButtonClicked3("knittingEdit", 4, "edit");
                break;
            case R.id.edit5:
                callback.onButtonClicked3("knittingEdit", 5, "edit");
                break;
            case R.id.edit6:
                callback.onButtonClicked3("knittingEdit", 6, "edit");
                break;
            case R.id.edit7:
                callback.onButtonClicked3("knittingEdit", 7, "edit");
                break;
            case R.id.edit8:
                callback.onButtonClicked3("knittingEdit", 8, "edit");
                break;
            case R.id.edit9:
                callback.onButtonClicked3("knittingEdit", 9, "edit");
                break;
            case R.id.edit10:
                callback.onButtonClicked3("knittingEdit", 10, "edit");
                break;
        }
    }
}