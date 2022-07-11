package com.example.recycler3;

public interface SampleCallback {
    // это передает ключ и индекс
    void onButtonClicked(String key, int position);
    void onButtonClicked2(String key, int women, int man);
    // это у нас возвращает фрагмент,
    void onCreatFragment(String key);
    void onMedShow(String key, String data1, String drug, String data2, int i);
}
