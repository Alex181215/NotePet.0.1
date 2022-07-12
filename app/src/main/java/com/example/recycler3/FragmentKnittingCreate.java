package com.example.recycler3;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycler3.databinding.FragmentKnittingCreateBinding;
import com.example.recycler3.databinding.FragmentKnittingEditBinding;

import java.util.ArrayList;
import java.util.List;


public class FragmentKnittingCreate extends Fragment implements View.OnClickListener {
    private FragmentKnittingCreateBinding b;
    private SampleCallback callback;
    private int idWomen = 0;
    private int idMan = 0;

    // список самок
    private ArrayList<String> listWomen = new ArrayList<String>();
    private ArrayAdapter<String> adapterWomen;

    // список самцов
    private ArrayList<String> listMan = new ArrayList<String>();
    private ArrayAdapter<String> adapterMan;

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
        b = FragmentKnittingCreateBinding.inflate(getLayoutInflater());
        View v = b.getRoot();


        hide(); // скрыть доп имена
        spAnimal(); // заполнить спинеры
        initClicker();

        return v;
    }

    // скрыть разделы имена мужской и женский
    private void hide() {
        b.headerTextWomen.setVisibility(View.GONE);
        b.nameWomen.setVisibility(View.GONE);
        b.headerTextMan.setVisibility(View.GONE);
        b.nameMan.setVisibility(View.GONE);
        b.back.setVisibility(View.GONE);
        b.newPet.setVisibility(View.GONE);
    }

    // слушатели кнопок
    private void initClicker() {
        b.newPet.setOnClickListener(this);
        b.news.setOnClickListener(this);
        b.back.setOnClickListener(this);
    }

    private void spAnimal() {
        loadName(); // заполнить спинер данными из сохраненки

        adapterWomen = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, listWomen);
        b.spinnerWomen.setAdapter(adapterWomen);
        b.spinnerWomen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                // слушатель для спинера если нажата кнопка Нет в списке то показывает доп имена женские
                if (selectedItem.equals("Нет в списке")) {
                    b.headerTextWomen.setVisibility(View.VISIBLE);
                    b.nameWomen.setVisibility(View.VISIBLE);
                    b.spinnerWomen.setVisibility(View.GONE);
                    b.lineWomen.setVisibility(View.GONE);
                    b.headerSpinerWomen.setVisibility(View.GONE);
                    b.back.setVisibility(View.VISIBLE);
                    b.spinnerWomen.setSelection(0);
                    b.newPet.setVisibility(View.VISIBLE);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        adapterMan = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, listMan);
        b.spinnerMan.setAdapter(adapterMan);
        b.spinnerMan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                // если выбрано Нет в списке то показать доп поля для имени мужских
                if (selectedItem.equals("Нет в списке")) {
                    b.headerTextMan.setVisibility(View.VISIBLE);
                    b.nameMan.setVisibility(View.VISIBLE);
                    b.headerSpinerMan.setVisibility(View.GONE);
                    b.lineMan.setVisibility(View.GONE);
                    b.spinnerMan.setVisibility(View.GONE);
                    b.back.setVisibility(View.VISIBLE);
                    b.spinnerMan.setSelection(0);
                    b.newPet.setVisibility(View.VISIBLE);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void loadName() {

        // метод загрузки данных из списка, перед тем как заполнить список он сначалот очищается
        listWomen.clear();
        listWomen.add("Выбрать");

        // дополнительно добавить в список кнопку Выбрать
        for (int i = 0; i < 100; i++) {
            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefName" + i, MODE_PRIVATE);
            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefGender" + i, MODE_PRIVATE);
            if (!sharedPreferences1.getString("name" + i, "").equals("") && sharedPreferences2.getString("gender" + i, "").equals("Женский")) {
                listWomen.add(sharedPreferences1.getString("name" + i, ""));
            }
        }
        listWomen.add("Нет в списке");
        // добавить доп поле НЕт в списке

        listMan.clear();
        listMan.add("Выбрать");
        for (int i = 0; i < 100; i++) {
            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefName" + i, MODE_PRIVATE);
            SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefGender" + i, MODE_PRIVATE);
            if (!sharedPreferences1.getString("name" + i, "").equals("") && sharedPreferences2.getString("gender" + i, "").equals("Мужской")) {
                listMan.add(sharedPreferences1.getString("name" + i, ""));
            }
        }
        listMan.add("Нет в списке");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newPet:
                callback.onCreatFragment("create");
                break;
            case R.id.news: // кнопка создать вязку
                test();
                break;
            case R.id.back:
                visi();
                break;
        }
    }

    private void visi() {
        b.headerTextWomen.setVisibility(View.GONE);
        b.nameWomen.setVisibility(View.GONE);
        b.spinnerWomen.setVisibility(View.VISIBLE);
        b.lineWomen.setVisibility(View.VISIBLE);
        b.headerSpinerWomen.setVisibility(View.VISIBLE);

        b.headerTextMan.setVisibility(View.GONE);
        b.nameMan.setVisibility(View.GONE);
        b.headerSpinerMan.setVisibility(View.VISIBLE);
        b.lineMan.setVisibility(View.VISIBLE);
        b.spinnerMan.setVisibility(View.VISIBLE);

        b.back.setVisibility(View.GONE);
        b.newPet.setVisibility(View.GONE);

        b.nameWomen.setText("");
        b.nameMan.setText("");
    }

    // проверка еслли проходиь проверку то запустить сохранение
    // а затем запустить следующий экран
    private void test() {
        // проверка если не стоит в поле имя то всплывает сообщение
        if (b.spinnerWomen.getSelectedItem().toString().equals("Выбрать") && b.nameWomen.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Выберите самку из списка или создайте нового питомца", Toast.LENGTH_SHORT).show();
        } else if (b.spinnerMan.getSelectedItem().toString().equals("Выбрать") && b.nameMan.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Выберите самца из списка или создайте нового питомца", Toast.LENGTH_SHORT).show();
        } else {
            // если проверка проходит то включается сохранение
            save();
            loadTest();
        }
    }

    private void save() {
        String nameWomen = "";
        String nameMan = "";
        // если поле в спинер не Выбрать то сохраняется имя
        if (!b.spinnerWomen.getSelectedItem().toString().equals("Выбрать")) {
            nameWomen = b.spinnerWomen.getSelectedItem().toString();
            saveSpinerWomen(nameWomen);
            // если поле имя не пусто то сохраняется
        } else if (!b.nameWomen.getText().toString().equals("")) {
            nameWomen = b.nameWomen.getText().toString();
            saveNameWomen(nameWomen);

            // этот кусок кода новый, тут пишем что если у нас есть пустое поле для сохранение то сохраняем туда имя
            for (int i = 1; i < 100; i++) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefName" + i, MODE_PRIVATE);
                if (sharedPreferences.getString("name" + i, "").equals("")) {

                    // имя
                    SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefName" + i, MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                    editor1.putString("name"+i, b.nameWomen.getText().toString());
                    editor1.apply();

                    // статус актуальное
                    SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMyStatus" + i, MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    editor2.putString("myStatus" + i, "Актуальное");
                    editor2.apply();

                    // день рождения
                    SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefDay"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                    editor3.putString("day"+i, "00");
                    editor3.apply();

                    // месяц рождения
                    SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefMount"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                    editor4.putString("mount"+i, "00");
                    editor4.apply();

                    // год рождения
                    SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefAge"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                    editor5.putString("age"+i, "00");
                    editor5.apply();

                    // пол
                    SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefGender"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                    editor6.putString("gender"+i, "Женский");
                    editor6.apply();

                    // вид животного
                    SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefAnimal"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor7 = sharedPreferences7.edit();
                    editor7.putString("animal"+i, "Нет вида");
                    editor7.apply();

                    Toast.makeText(getActivity(), "Сохранено", Toast.LENGTH_SHORT).show();
                    break;
                }
            }

        }


        if (!b.spinnerMan.getSelectedItem().toString().equals("Выбрать")) {
            nameMan = b.spinnerMan.getSelectedItem().toString();
            saveSpinerMan(nameMan);
        } else if (!b.nameMan.getText().toString().equals("")) {
            nameMan = b.nameMan.getText().toString();
            saveNameMan(nameMan);


            // этот кусок кода новый, тут пишем что если у нас есть пустое поле для сохранение то сохраняем туда имя
            for (int i = 1; i < 100; i++) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefName" + i, MODE_PRIVATE);
                if (sharedPreferences.getString("name" + i, "").equals("")) {

                    // имя
                    SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefName" + i, MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                    editor1.putString("name"+i, b.nameMan.getText().toString());
                    editor1.apply();

                    // статус актуальное
                    SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefMyStatus" + i, MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    editor2.putString("myStatus" + i, "Актуальное");
                    editor2.apply();

                    // день рождения
                    SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefDay"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                    editor3.putString("day"+i, "00");
                    editor3.apply();

                    // месяц рождения
                    SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefMount"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                    editor4.putString("mount"+i, "00");
                    editor4.apply();

                    // год рождения
                    SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefAge"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                    editor5.putString("age"+i, "00");
                    editor5.apply();

                    // пол
                    SharedPreferences sharedPreferences6 = getActivity().getSharedPreferences("prefGender"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                    editor6.putString("gender"+i, "Мужской");
                    editor6.apply();

                    // вид животного
                    SharedPreferences sharedPreferences7 = getActivity().getSharedPreferences("prefAnimal"+i, MODE_PRIVATE);
                    SharedPreferences.Editor editor7 = sharedPreferences7.edit();
                    editor7.putString("animal"+i, "Нет вида");
                    editor7.apply();

                    Toast.makeText(getActivity(), "Сохранено", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }


    private void saveNameWomen(String name) {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKnittingWomen" + i, MODE_PRIVATE);
            if (sharedPreferences.getString("knittingWomen" + i, "").equals("")) {
                idWomen = i;
                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnittingWomen" + i, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("knittingWomen" + i, name);
                editor.apply();

                break;
            }
        }
    }

    private void saveSpinerWomen(String name) {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKnittingWomen" + i, MODE_PRIVATE);
            if (sharedPreferences.getString("knittingWomen" + i, "").equals("")) {

                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnittingWomen" + i, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("knittingWomen" + i, name);
                editor.apply();
                idWomen = i;

                break;
            }
        }
    }

    private void saveSpinerMan(String name) {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKnittingMan" + i, MODE_PRIVATE);
            if (sharedPreferences.getString("knittingMan" + i, "").equals("")) {

                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnittingMan" + i, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("knittingMan" + i, name);
                editor.apply();
                idMan = i;

                break;
            }
        }
    }

    private void saveNameMan(String name) {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKnittingMan" + i, MODE_PRIVATE);
            if (sharedPreferences.getString("knittingMan" + i, "").equals("")) {
                idMan = i;
                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefKnittingMan" + i, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.putString("knittingMan" + i, name);
                editor.apply();

                break;
            }
        }
    }


    private void loadTest() {
        callback.onButtonClicked2("knittingId", idWomen, idMan);
    }
}


