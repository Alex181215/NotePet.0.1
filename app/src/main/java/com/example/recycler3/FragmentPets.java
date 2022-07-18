package com.example.recycler3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler3.databinding.FragmentPetsBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentPets extends Fragment implements RecyclerViewClickInterface {
    AgeCalculator2 ageCalculator = new AgeCalculator2();
    private FragmentPetsBinding b;
    private SampleCallback callback;

    Metod createMetod = new Metod();

    // Список по статусам питомцев 
    private ArrayList<String> myStatusArrayList = new ArrayList<String>();
    private ArrayAdapter<String> myStatusArrayAdapter;

    // Список по новым категориям питомцевс косторые внес пользователь
    private ArrayList<String> categoryArrayList = new ArrayList<String>();
    private ArrayAdapter<String> categoryArrayAdapter;

    String categoryText, categoryData;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> nameList;
    List<String> ageList;
    List<String> idList;

    View view;

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        b = FragmentPetsBinding.inflate(getLayoutInflater());
        view = b.getRoot();
        callback.onCreatFragment("pets");
//        Pref.init(getActivity());

        clicker(); // метод слушателей
        spCategory(); // метод заполнения спинера

        nameList = new ArrayList<>();
        ageList = new ArrayList<>();
        idList = new ArrayList<>();

        setArrayListMyCategory();

        recyclerView = b.recyclerView;
        recyclerAdapter = new RecyclerAdapter(nameList, ageList, idList, this);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    // слушатели
    private void clicker() {
        b.btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onCreatFragment("createAll");
            }
        });

        b.textGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onCreatFragment("createAll");
            }
        });

        b.imageGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onCreatFragment("createAll");
            }
        });
    }

    private void setArrayListMyCategory() {
        tester("Актуальное");
    }

    // метод тестер пока не потяно за зачем 
    // вставляем тестовое слово например Актуальное
    // если сохраненный статус равен заданому слову то тогда
    private void tester(String text) {
        nameList.clear();
        ageList.clear();
        idList.clear();

        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus" + i, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("myStatus" + i, "").equals(text)) {

                // то тогда применяем правило высчета возвраста
                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefName" + i, Context.MODE_PRIVATE);
                SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("prefDay" + i, Context.MODE_PRIVATE);
                SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("prefMount" + i, Context.MODE_PRIVATE);
                SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("prefAge" + i, Context.MODE_PRIVATE);
                SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("prefAnimal" + i, Context.MODE_PRIVATE);

                String name, day, mount, age, animal;

                name = sharedPreferences1.getString("name" + i, "");
                day = sharedPreferences2.getString("day" + i, "");
                mount = sharedPreferences3.getString("mount" + i, "");
                age = sharedPreferences4.getString("age" + i, "");
                animal = sharedPreferences5.getString("animal" + i, "");

                nameList.add(name);
                if(!day.equals("00")){
                    ageCalculator.ageCalculator(day, mount, age, (ArrayList) ageList, animal);
                } else {
                    ageList.add("");
                }
                idList.add(i + "");
            }
        }
    }

    // метод заполнения данных в спинер
    private void spCategory() {
        categoryArrayList.clear();
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus" + i, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("myStatus" + i, "").equals("Актуальное")) {
                categoryArrayList.add("Актуальное");
                break;
            }
        }
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus" + i, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("myStatus" + i, "").equals("Продажа")) {
                categoryArrayList.add("Продажа");
                break;
            }
        }
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus" + i, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("myStatus" + i, "").equals("Передача")) {
                categoryArrayList.add("Передача");
                break;
            }
        }
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus" + i, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("myStatus" + i, "").equals("Потеря")) {
                categoryArrayList.add("Потеря");
                break;
            }
        }
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus" + i, Context.MODE_PRIVATE);
            if (sharedPreferences.getString("myStatus" + i, "").equals("Смерть")) {
                categoryArrayList.add("Смерть");
                break;
            }
        }

//        for (int i = 1; i < 100; i++) {
//            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus" + i, Context.MODE_PRIVATE);
//            if(!sharedPreferences.getString("myStatus" + i, "").equals("")){
//                String test = sharedPreferences.getString("myStatus" + i, "");
//                if(!test.equals("Актуальное")&&!test.equals("Продажа")&&!test.equals("Передача")&&!test.equals("Потеря")&&!test.equals("Смерть")){
//                    Toast.makeText(getActivity(), "Проверка на другие категории", Toast.LENGTH_SHORT).show();
//                    categoryArrayList.add(test);
//                }
//            }
//        }


        loadSpCategory();
        categoryArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, categoryArrayList);
        b.spinnerCategory.setAdapter(categoryArrayAdapter);

        // слушатель спинера
        b.spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Актуальное")) {
                    tester("Актуальное");
                    recyclerAdapter.notifyDataSetChanged();
                } else if (selectedItem.equals("Продажа")) {
                    tester("Продажа");
                    recyclerAdapter.notifyDataSetChanged();
                } else if (selectedItem.equals("Передача")) {
                    tester("Передача");
                    recyclerAdapter.notifyDataSetChanged();
                } else if (selectedItem.equals("Потеря")) {
                    tester("Потеря");
                    recyclerAdapter.notifyDataSetChanged();
                } else if (selectedItem.equals("Смерть")) {
                    tester("Смерть");
                    recyclerAdapter.notifyDataSetChanged();
                } else if(!selectedItem.equals("Актуальное")&&!selectedItem.equals("Продажа")&&!selectedItem.equals("Передача")&&!selectedItem.equals("Потеря")&&!selectedItem.equals("Смерть")){
                    Toast.makeText(getActivity(), "Выбрана не стандартная позиция", Toast.LENGTH_SHORT).show();
                    tester("Смерть");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    // Метод проверки и добавление новых питомцев из сохраненки
    private void loadSpCategory() {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyCategory" + i, Context.MODE_PRIVATE);
            if (!sharedPreferences.getString("myCategory" + i, "").equals("")) {
                categoryArrayList.add(sharedPreferences.getString("myCategory" + i, ""));
            }
        }
    }


    @Override
    public void onItemClick(String key, int position) {
        if (key.equals("del")) {
            Toast.makeText(getActivity(), "Удалить", Toast.LENGTH_SHORT).show();
            spinnerDel(position);
        } else {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefActiv", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("activ", ""+position);
            editor.apply();

            callback.onButtonClicked(key, position);
        }

    }

    private void spinnerDel(int position) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.my_animal_category, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        final Spinner spinner = view.findViewById(R.id.spinerMyAnimalCategory);

        myStatusArrayList.clear();

        myStatusArrayList.add("Актуальное");
        myStatusArrayList.add("Продажа");
        myStatusArrayList.add("Передача");
        myStatusArrayList.add("Потеря");
        myStatusArrayList.add("Смерть");
        loadMyCategory();
        myStatusArrayList.add("Другое");

        myStatusArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, myStatusArrayList);
        spinner.setAdapter(myStatusArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Другое")) {
                    spinerCategorytest();
                    recyclerAdapter.notifyDataSetChanged();
                }
            }

            // подтвержения сохранения своего питомца
            private void spinerCategorytest() {
                LayoutInflater li = LayoutInflater.from(getActivity());
                View promptsView = li.inflate(R.layout.spinner_animal_layout, null);
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(getActivity());
                mDialogBuilder.setView(promptsView);
                final EditText userInput = (EditText) promptsView.findViewById(R.id.set_text);
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        categoryText = userInput.getText().toString();
                                        saveMyCategory();
                                        onAdd();
                                        spinner.setSelection(myStatusArrayList.size()-1);
                                    }

                                    private void saveMyCategory() {
                                        for (int i = 1; i < 100; i++) {
                                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyCategory" + i, Context.MODE_PRIVATE);
                                            if (sharedPreferences.getString("myCategory" + i, "").equals("")) {
                                                SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefMyCategory" + i, Context.MODE_PRIVATE);
                                                SharedPreferences.Editor editor = sharedPreferences1.edit();
                                                editor.putString("myCategory" + i, categoryText);
                                                editor.apply();
                                            }
                                            break;
                                        }
                                    }

                                    private void onAdd() {
                                        myStatusArrayList.add(categoryText);
                                        spinner.setAdapter(myStatusArrayAdapter); // наполняем спиннер данными из адаптера
                                    }
                                })
                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final EditText day = view.findViewById(R.id.day_my_animal_category);
        final EditText mount = view.findViewById(R.id.mount_my_animal_category);
        final EditText age = view.findViewById(R.id.age_my_animal_category);

        createMetod.dataAvtomat2(day, mount, age);

        builder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyStatus"+position, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("myStatus"+position, spinner.getSelectedItem().toString());
                                editor.apply();
                                callback.onButtonClicked("test", position);
                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void loadMyCategory() {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyCategory" + i, Context.MODE_PRIVATE);
            if (!sharedPreferences.getString("myCategory" + i, "").equals("")) {
                myStatusArrayList.add(sharedPreferences.getString("myCategory" + i, ""));
            }
        }
    }
}