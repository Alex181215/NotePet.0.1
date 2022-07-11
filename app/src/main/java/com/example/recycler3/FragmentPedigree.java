package com.example.recycler3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentPedigreeBinding;


public class FragmentPedigree extends Fragment {
    private FragmentPedigreeBinding b;
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
        b = FragmentPedigreeBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentPedigree");

        b.textViewPedigree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onCreatFragment("pedigree");
            }
        });


        return v;

    }
}