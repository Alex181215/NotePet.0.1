package com.example.recycler3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentPedigreeEditBinding;


public class FragmentPedigreeEdit extends Fragment {
    private FragmentPedigreeEditBinding b;
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
        b = FragmentPedigreeEditBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        callback.onCreatFragment("FragmentPedigreeEdit");


        return v;
    }
}