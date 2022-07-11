package com.example.recycler3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class FragmentMedicalCart extends Fragment {
    private static final int NUM_PAGES=3;
    ViewPager2 viewPager2;
    FragmentStateAdapter pageAdapter;
    TabLayout tabLayout;
    List<String> tabName;
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
        View v=inflater.inflate(R.layout.fragment_medical_cart,null);
        callback.onCreatFragment("FragmentMedicalCart");

        tabName=new ArrayList<>();
        tabName.add("Обработка");
        tabName.add("Вакцинация");
        tabName.add("Мед. карта");


        viewPager2=v.findViewById(R.id.viewPager);
        pageAdapter = new ScreenSlidePageAdapter(this);
        viewPager2.setAdapter(pageAdapter);
        tabLayout=v.findViewById(R.id.tabLayout);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabName.get(position));

            }
        }).attach();


        return v;


    }

    private class ScreenSlidePageAdapter extends FragmentStateAdapter {
        public ScreenSlidePageAdapter(FragmentMedicalCart fragmentMedicalCart) {
            super(fragmentMedicalCart);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new com.example.recycler3.FragmentTreatment();
                case 1:
                    return new com.example.recycler3.FragmentVaccine();
                case 2:
                    return new com.example.recycler3.FragmentMedicalCard();
                default:
                    return null;

            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}