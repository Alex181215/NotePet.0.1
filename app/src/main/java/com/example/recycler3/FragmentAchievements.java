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

public class FragmentAchievements extends Fragment {
    private SampleCallback callback;

    private static final int NUM_PAGES=2;
    ViewPager2 viewPager2;
    FragmentStateAdapter pageAdapter;
    TabLayout tabLayout;
    List<String> tabName;

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
        View v=inflater.inflate(R.layout.fragment_achievements,null);

        tabName=new ArrayList<>();
        tabName.add("Выставки");
        tabName.add("Дрессировка");
        callback.onCreatFragment("FragmentAchievements");



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
        public ScreenSlidePageAdapter(FragmentAchievements fragmentAchievements) {
            super(fragmentAchievements);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new FragmentExhibitions();
                case 1:
                    return new FragmentTraining();
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