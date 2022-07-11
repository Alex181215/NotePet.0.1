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


public class FragmentKnitting extends Fragment implements View.OnClickListener{
    private SampleCallback callback;
    private FragmentKnittingBinding b;
    private int countKnit = 0;

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

        load();
        clicker();

        return v;
    }

    private void load() {
        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnitWomen1", Context.MODE_PRIVATE);
           if(!sharedPreferences1.getString("knitWomen1", "").equals("")){
               b.textView3.setVisibility(View.GONE);
               b.layout1.setVisibility(View.VISIBLE);
               b.name1.setText(sharedPreferences1.getString("knitWomen1", ""));

               SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay11", Context.MODE_PRIVATE);
               if(!sharedPreferences11.getString("knitDay11", "").equals("")){
                   countKnit = 1;
                   b.child1.setText(countKnit + " вязка");
               }

               SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay21", Context.MODE_PRIVATE);
               if(!sharedPreferences12.getString("knitDay21", "").equals("")){
                   countKnit = 2;
                   b.child1.setText(countKnit + " вязки");
               }

               SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay31", Context.MODE_PRIVATE);
               if(!sharedPreferences13.getString("knitDay31", "").equals("")){
                   countKnit = 3;
                   b.child1.setText(countKnit + " вязки");
               }

               SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay41", Context.MODE_PRIVATE);
               if(!sharedPreferences14.getString("knitDay41", "").equals("")){
                   countKnit = 4;
                   b.child1.setText(countKnit + " вязки");
               }

               SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay51", Context.MODE_PRIVATE);
               if(!sharedPreferences15.getString("knitDay51", "").equals("")){
                   countKnit = 5;
                   b.child1.setText(countKnit + " вязок");
               }

           }

        SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefKnitWomen2", Context.MODE_PRIVATE);
        if(!sharedPreferences2.getString("knitWomen2", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout2.setVisibility(View.VISIBLE);
            b.name2.setText(sharedPreferences2.getString("knitWomen2", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay12", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay12", "").equals("")){
                countKnit = 1;
                b.child2.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay22", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay22", "").equals("")){
                countKnit = 2;
                b.child2.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay32", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay32", "").equals("")){
                countKnit = 3;
                b.child2.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay42", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay42", "").equals("")){
                countKnit = 4;
                b.child2.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay52", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay52", "").equals("")){
                countKnit = 5;
                b.child2.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefKnitWomen3", Context.MODE_PRIVATE);
        if(!sharedPreferences3.getString("knitWomen3", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout3.setVisibility(View.VISIBLE);
            b.name3.setText(sharedPreferences3.getString("knitWomen3", ""));


            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay13", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay13", "").equals("")){
                countKnit = 1;
                b.child3.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay23", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay23", "").equals("")){
                countKnit = 2;
                b.child3.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay33", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay33", "").equals("")){
                countKnit = 3;
                b.child3.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay43", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay43", "").equals("")){
                countKnit = 4;
                b.child3.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay53", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay53", "").equals("")){
                countKnit = 5;
                b.child3.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefKnitWomen4", Context.MODE_PRIVATE);
        if(!sharedPreferences4.getString("knitWomen4", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout4.setVisibility(View.VISIBLE);
            b.name4.setText(sharedPreferences4.getString("knitWomen4", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay14", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay14", "").equals("")){
                countKnit = 1;
                b.child4.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay24", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay24", "").equals("")){
                countKnit = 2;
                b.child4.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay34", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay34", "").equals("")){
                countKnit = 3;
                b.child4.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay44", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay44", "").equals("")){
                countKnit = 4;
                b.child4.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay54", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay54", "").equals("")){
                countKnit = 5;
                b.child4.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefKnitWomen5", Context.MODE_PRIVATE);
        if(!sharedPreferences5.getString("knitWomen5", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout5.setVisibility(View.VISIBLE);
            b.name5.setText(sharedPreferences5.getString("knitWomen5", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay15", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay15", "").equals("")){
                countKnit = 1;
                b.child5.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay25", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay25", "").equals("")){
                countKnit = 2;
                b.child5.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay35", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay35", "").equals("")){
                countKnit = 3;
                b.child5.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay45", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay45", "").equals("")){
                countKnit = 4;
                b.child5.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay55", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay55", "").equals("")){
                countKnit = 5;
                b.child5.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefKnitWomen6", Context.MODE_PRIVATE);
        if(!sharedPreferences6.getString("knitWomen6", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout6.setVisibility(View.VISIBLE);
            b.name6.setText(sharedPreferences6.getString("knitWomen6", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay16", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay16", "").equals("")){
                countKnit = 1;
                b.child6.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay26", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay26", "").equals("")){
                countKnit = 2;
                b.child6.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay36", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay36", "").equals("")){
                countKnit = 3;
                b.child6.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay46", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay46", "").equals("")){
                countKnit = 4;
                b.child6.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay56", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay56", "").equals("")){
                countKnit = 5;
                b.child6.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefKnitWomen7", Context.MODE_PRIVATE);
        if(!sharedPreferences7.getString("knitWomen7", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout7.setVisibility(View.VISIBLE);
            b.name7.setText(sharedPreferences7.getString("knitWomen7", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay17", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay17", "").equals("")){
                countKnit = 1;
                b.child7.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay27", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay27", "").equals("")){
                countKnit = 2;
                b.child7.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay37", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay37", "").equals("")){
                countKnit = 3;
                b.child7.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay47", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay47", "").equals("")){
                countKnit = 4;
                b.child7.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay57", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay57", "").equals("")){
                countKnit = 5;
                b.child7.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences8 = getActivity().getSharedPreferences("prefKnitWomen8", Context.MODE_PRIVATE);
        if(!sharedPreferences8.getString("knitWomen8", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout8.setVisibility(View.VISIBLE);
            b.name8.setText(sharedPreferences8.getString("knitWomen8", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay18", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay18", "").equals("")){
                countKnit = 1;
                b.child8.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay28", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay28", "").equals("")){
                countKnit = 2;
                b.child8.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay38", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay38", "").equals("")){
                countKnit = 3;
                b.child8.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay48", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay48", "").equals("")){
                countKnit = 4;
                b.child8.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay58", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay58", "").equals("")){
                countKnit = 5;
                b.child8.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("prefKnitWomen9", Context.MODE_PRIVATE);
        if(!sharedPreferences9.getString("knitWomen9", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout9.setVisibility(View.VISIBLE);
            b.name9.setText(sharedPreferences9.getString("knitWomen9", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay19", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay19", "").equals("")){
                countKnit = 1;
                b.child9.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay29", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay29", "").equals("")){
                countKnit = 2;
                b.child9.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay39", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay39", "").equals("")){
                countKnit = 3;
                b.child9.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay49", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay49", "").equals("")){
                countKnit = 4;
                b.child9.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay59", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay59", "").equals("")){
                countKnit = 5;
                b.child9.setText(countKnit + " вязок");
            }
        }

        SharedPreferences sharedPreferences10 = getActivity().getSharedPreferences("prefKnitWomen10", Context.MODE_PRIVATE);
        if(!sharedPreferences10.getString("knitWomen10", "").equals("")){
            b.textView3.setVisibility(View.GONE);
            b.layout10.setVisibility(View.VISIBLE);
            b.name10.setText(sharedPreferences10.getString("knitWomen10", ""));

            SharedPreferences sharedPreferences11 = getActivity().getSharedPreferences("prefKnitDay110", Context.MODE_PRIVATE);
            if(!sharedPreferences11.getString("knitDay110", "").equals("")){
                countKnit = 1;
                b.child10.setText(countKnit + " вязка");
            }

            SharedPreferences sharedPreferences12 = getActivity().getSharedPreferences("prefKnitDay210", Context.MODE_PRIVATE);
            if(!sharedPreferences12.getString("knitDay210", "").equals("")){
                countKnit = 2;
                b.child10.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences13 = getActivity().getSharedPreferences("prefKnitDay310", Context.MODE_PRIVATE);
            if(!sharedPreferences13.getString("knitDay310", "").equals("")){
                countKnit = 3;
                b.child10.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences14 = getActivity().getSharedPreferences("prefKnitDay410", Context.MODE_PRIVATE);
            if(!sharedPreferences14.getString("knitDay410", "").equals("")){
                countKnit = 4;
                b.child10.setText(countKnit + " вязки");
            }

            SharedPreferences sharedPreferences15 = getActivity().getSharedPreferences("prefKnitDay510", Context.MODE_PRIVATE);
            if(!sharedPreferences15.getString("knitDay510", "").equals("")){
                countKnit = 5;
                b.child10.setText(countKnit + " вязок");
            }
        }
        }

    private void clicker(){
        b.btnSetPetKnitting.setOnClickListener(this);
        b.imageSetPetKnitting.setOnClickListener(this);
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
            case R.id.btnSetPetKnitting:
                callback.onCreatFragment("KnittingCreate");
                break;
            case R.id.imageSetPetKnitting:
                callback.onCreatFragment("knitting");
                break;
            case R.id.layout1:
                callback.onButtonClicked("knittinglayout", 1);
                break;
            case R.id.layout2:
                callback.onButtonClicked("knittinglayout", 2);
                break;
            case R.id.layout3:
                callback.onButtonClicked("knittinglayout", 3);
                break;
            case R.id.layout4:
                callback.onButtonClicked("knittinglayout", 4);
                break;
            case R.id.layout5:
                callback.onButtonClicked("knittinglayout", 5);
                break;
            case R.id.layout6:
                callback.onButtonClicked("knittinglayout", 6);
                break;
            case R.id.layout7:
                callback.onButtonClicked("knittinglayout", 7);
                break;
            case R.id.layout8:
                callback.onButtonClicked("knittinglayout", 8);
                break;
            case R.id.layout9:
                callback.onButtonClicked("knittinglayout", 9);
                break;
            case R.id.layout10:
                callback.onButtonClicked("knittinglayout", 10);
                break;
        }

    }
}