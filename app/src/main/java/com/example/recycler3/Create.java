package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.recycler3.databinding.ActivityCreateBinding;
import com.example.recycler3.databinding.FragmentMedicalCartShowBinding;
import com.example.recycler3.databinding.FragmentTreatmentShowBinding;


public class Create extends AppCompatActivity implements SampleCallback {
    private ActivityCreateBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityCreateBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);
        setupMenu();

    }

    // метод загрузки экрана, в зависимости от сохранных данных
    private void setupMenu() {
        Bundle argument = getIntent().getExtras();
        if (argument != null) {
            if (argument.getString("key").equals("FragmentPets")) {
                FragmentPets pets = new FragmentPets();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, pets);
                transaction.commit();
                layotBarPets();
                b.txHeader.setText("Мои питомцы");
            } else if (argument.getString("key").equals("FragmentCreate")) {
                FragmentCreate create = new FragmentCreate();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, create);
                transaction.commit();
                layotBarPets();
                b.txHeader.setText("Добавить питомца");
                b.layoutBar.setVisibility(View.GONE);
            }
        }
    }

    // Кнопка Меню
    public void menu(View view) {
        fragMenu();

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View pop = inflater.inflate(R.layout.menu, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(pop, width, height, true);
        popupWindow.showAtLocation(view, Gravity.TOP, 0, 0);

        TextView namePet = pop.findViewById(R.id.namePetMenuAction);
        for (int i = 0; i < 100; i++) {
            SharedPreferences sharedPreferences = getSharedPreferences("prefActiv" + i, MODE_PRIVATE);
            SharedPreferences sharedPreferences2 = getSharedPreferences("prefName" + i, MODE_PRIVATE);
            String name = sharedPreferences.getString("activ" + i, "");
            if (name.equals("Актив")) {
                namePet.setText(sharedPreferences2.getString("name" + i, ""));
                break;
            }
        }


        ImageView imageViewClose1 = pop.findViewById(R.id.imageViewClose1);
        imageViewClose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

        ImageView imageViewClose2 = pop.findViewById(R.id.imageViewClose2);
        imageViewClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

        TextView textViewMed = pop.findViewById(R.id.textBtnMenuOpenMedCartFragment);
        textViewMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentMedicalCart med = new FragmentMedicalCart();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, med).addToBackStack("tag");
                trans.replace(R.id.container, med);
                trans.commit();
                popupWindow.dismiss();
//                textHeader("Медицинская карта");
            }
        });

        ImageView imageViewMed = pop.findViewById(R.id.imageBtnMenuOpenMedCartFragment);
        imageViewMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentMedicalCart med = new FragmentMedicalCart();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, med).addToBackStack("tag");
                trans.replace(R.id.container, med);
                trans.commit();
                popupWindow.dismiss();
//                textHeader("Медицинская карта");
            }
        });


        TextView textViewAch = pop.findViewById(R.id.textBtnMenuOpenAchievemens);
        textViewAch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAchievements ach = new FragmentAchievements();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, ach).addToBackStack("tag");
                trans.replace(R.id.container, ach);
                trans.commit();
                popupWindow.dismiss();
            }
        });

        ImageView imageViewAch = pop.findViewById(R.id.imageBtnMenuOpenAchievemens);
        imageViewAch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAchievements ach = new FragmentAchievements();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, ach).addToBackStack("tag");
                trans.replace(R.id.container, ach);
                trans.commit();
                popupWindow.dismiss();
            }
        });


        TextView textViewKnit = pop.findViewById(R.id.textBtnMenuOpenKnitting);
        textViewKnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentKnitting knit = new FragmentKnitting();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, knit).addToBackStack("tag");
                trans.replace(R.id.container, knit);
                trans.commit();
                popupWindow.dismiss();
                textHeader("Разведение животных");
            }
        });

        ImageView imageViewKnit = pop.findViewById(R.id.imageBtnMenuOpenKnitting);
        imageViewKnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentKnitting knit = new FragmentKnitting();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, knit).addToBackStack("tag");
                trans.replace(R.id.container, knit);
                trans.commit();
                popupWindow.dismiss();
                textHeader("Разведение животных");
            }
        });

        TextView textViewPedigree = pop.findViewById(R.id.textBtnMenuOpenPedigree);
        textViewPedigree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentPedigree pedi = new FragmentPedigree();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, pedi).addToBackStack("tag");
                trans.replace(R.id.container, pedi);
                trans.commit();
                popupWindow.dismiss();
//                textHeader("Родословная");
            }
        });

        ImageView imageViewPedigree = pop.findViewById(R.id.imageBtnMenuOpenPedigree);
        imageViewPedigree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentPedigree pedi = new FragmentPedigree();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, pedi).addToBackStack("tag");
                trans.replace(R.id.container, pedi);
                trans.commit();
                popupWindow.dismiss();
//                textHeader("Родословная");
            }
        });

        TextView textViewTravel = pop.findViewById(R.id.textBtnMenuOpenTravel);
        textViewTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTravel travel = new FragmentTravel();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, travel).addToBackStack("tag");
                trans.replace(R.id.container, travel);
                trans.commit();
                popupWindow.dismiss();
            }
        });

        ImageView imageViewTravel = pop.findViewById(R.id.imageBtnMenuOpenTravel);
        imageViewTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTravel travel = new FragmentTravel();
                FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//                trans.replace(R.id.container, travel).addToBackStack("tag");
                trans.replace(R.id.container, travel);
                trans.commit();
                popupWindow.dismiss();
            }
        });

    }

    // Кнопка Питомцы
    public void pets(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("prefName1", MODE_PRIVATE);
        if(!sharedPreferences.getString("name1", "").equals("")){
            fragPets();
        } else {
            Toast.makeText(Create.this, "Создайте питомца", Toast.LENGTH_SHORT);
        }
    }

    // Кнопка Заметки
    public void note(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("prefName1", MODE_PRIVATE);
        if(!sharedPreferences.getString("name1", "").equals("")){
            fragNote();
        } else {
            Toast.makeText(Create.this, "Создайте питомца", Toast.LENGTH_SHORT);
        }
    }

    // Нажатие Меню
    private void layotBarMenu() {
        b.layoutBar.setBackgroundResource(R.drawable.spl_left);
        imageBarHide(b.imageMenuRed, b.imagePet, b.imageNotes, b.imageMenu, b.imagePetRed, b.imageNotesRed);
    }

    // Нажатие Питомцы
    private void layotBarPets() {
        b.layoutBar.setBackgroundResource(R.drawable.spl_center);
        imageBarHide(b.imageMenu, b.imagePetRed, b.imageNotes, b.imageMenuRed, b.imagePet, b.imageNotesRed);
    }

    // Нажатие заметки
    private void layotBarNote() {
        b.layoutBar.setBackgroundResource(R.drawable.spl_right);
        imageBarHide(b.imageMenu, b.imagePet, b.imageNotesRed, b.imageMenuRed, b.imagePetRed, b.imageNotes);
    }

    private void fragCreate() {
        layotBarPets();
        textHeader("Добавить питомца");

        FragmentCreate create = new FragmentCreate();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//        trans.replace(R.id.container, create).addToBackStack("tag");
        trans.replace(R.id.container, create);
        trans.commit();
    }

    private void fragPets() {
        layotBarPets();
        textHeader("Мои питомцы");

        FragmentPets pets = new FragmentPets();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//        trans.replace(R.id.container, pets).addToBackStack("tag");
        trans.replace(R.id.container, pets);
        trans.commit();
    }

    private void fragMenu() {
        layotBarMenu();
        textHeader("Меню");
    }

    private void fragNote() {
        layotBarNote();
        textHeader("Заметки");

        FragmentNote note = new FragmentNote();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//        trans.replace(R.id.container, note).addToBackStack("tag");
        trans.replace(R.id.container, note);
        trans.commit();
    }

    private void fragEdit() {

        layotBarPets();
        textHeader("Редактирование");

        FragmentEdit edit = new FragmentEdit();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//        trans.replace(R.id.container, edit).addToBackStack("tag");
        trans.replace(R.id.container, edit);
        trans.commit();
    }

    private void fragHistory() {
        layotBarPets();
        textHeader("История");

        FragmentHistory history = new FragmentHistory();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//        trans.replace(R.id.container, history).addToBackStack("tag");
        trans.replace(R.id.container, history);
        trans.commit();
    }

    // Отображение Вернего бара, заголовка
    private void textHeader(String text) {
        b.txHeader.setText(text);
    }

    // Отбображение нижнего Бара
    public void imageBarHide(ImageView visi1, ImageView visi2, ImageView visi3, ImageView gone1, ImageView gone2, ImageView gone3) {
        visi1.setVisibility(View.VISIBLE);
        visi2.setVisibility(View.VISIBLE);
        visi3.setVisibility(View.VISIBLE);
        gone1.setVisibility(View.GONE);
        gone2.setVisibility(View.GONE);
        gone3.setVisibility(View.GONE);
    }

    // Захват кнопки
    @Override
    public void onButtonClicked(String key, int position) {
        testActiv(position);
        if (key.equals("edit")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            FragmentEdit edit = new FragmentEdit();

            edit.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, edit);
            transaction.commit();

            layotBarPets();
            b.txHeader.setText("Редактирование");

        } else if (key.equals("profile")) {

            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            FragmentProfile profile = new FragmentProfile();

            profile.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, profile);
            transaction.commit();

            layotBarPets();
            b.txHeader.setText("Профиль");
        } else if (key.equals("history")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            FragmentHistory history = new FragmentHistory();

            history.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, history);
            transaction.commit();

            layotBarPets();
            b.txHeader.setText("История");
        } else if (key.equals("test")) {
            FragmentPets pets = new FragmentPets();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.container, pets).addToBackStack("tag");
            transaction.replace(R.id.container, pets);
            transaction.commit();
            layotBarPets();
            b.txHeader.setText("Мои питомцы");
        } else if (key.equals("medicalCardlayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            Fragment_MedicalCart_Show fragmentMedicalCartShow = new Fragment_MedicalCart_Show();

            fragmentMedicalCartShow.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.container, fragmentMedicalCartShow).addToBackStack("tag");
            transaction.replace(R.id.container, fragmentMedicalCartShow);
            transaction.commit();
            layotBarMenu();
        } else if (key.equals("treatmentlayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            Fragment_Treatment_Show fragmenttreatmentshow = new Fragment_Treatment_Show();

            fragmenttreatmentshow.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.container, fragmenttreatmentshow).addToBackStack("tag");
            transaction.replace(R.id.container, fragmenttreatmentshow);
            transaction.commit();
            layotBarMenu();
            textHeader("Обработка");
        } else if (key.equals("vaccinelayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            Fragment_Vaccine_Show fragment_vaccine_show = new Fragment_Vaccine_Show();

            fragment_vaccine_show.setArguments(bundle);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.container, fragment_vaccine_show);
//            trans.replace(R.id.container, fragment_vaccine_show).addToBackStack("tag");
            trans.commit();
            layotBarMenu();
            textHeader("Вакцинация");
        } else if (key.equals("exhibitionslayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            Fragment_Exhibitions_Show exhibitions_show = new Fragment_Exhibitions_Show();

            exhibitions_show.setArguments(bundle);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, exhibitions_show).addToBackStack("tag");
            trans.replace(R.id.container, exhibitions_show);
            trans.commit();
            layotBarMenu();
            textHeader("Выставка");
        } else if (key.equals("traininglayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            FragTrainingShow trainingShow = new FragTrainingShow();

            trainingShow.setArguments(bundle);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, trainingShow).addToBackStack("tag");
            trans.replace(R.id.container, trainingShow);
            trans.commit();
            layotBarMenu();
            textHeader("Дрессировка");
        } else if (key.equals("knittingId")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");

            FragmentKnittingEdit knittingEdit = new FragmentKnittingEdit();
            knittingEdit.setArguments(bundle);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, knittingEdit).addToBackStack("tag");
            trans.replace(R.id.container, knittingEdit);
            trans.commit();
            layotBarMenu();
            textHeader("Добавить вязку");
        } else if (key.equals("knittinglayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");
            bundle.putString("edit", "no");

            Fragment_Knit_Show fragmentKnitShow = new Fragment_Knit_Show();
            fragmentKnitShow.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.container, fragmentKnitShow).addToBackStack("tag");
            transaction.replace(R.id.container, fragmentKnitShow);
            transaction.commit();
            layotBarMenu();
            textHeader("Вязка");
        }
    }

    @Override
    public void onButtonClicked2(String key, int women, int man) {
        if (key.equals("knittingId")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", women + "");
            bundle.putString("key2", man + "");

            FragmentKnittingEdit knittingEdit = new FragmentKnittingEdit();
            knittingEdit.setArguments(bundle);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, knittingEdit).addToBackStack("tag");
            trans.replace(R.id.container, knittingEdit);
            trans.commit();
            layotBarMenu();
            textHeader("Добавить вязку");
        } else if(key.equals("Child")){
            Bundle bundle = new Bundle();
            bundle.putString("key", women + "");
            bundle.putString("key2", man + "");

            FragmentKnittingEdit knittingEdit = new FragmentKnittingEdit();
            knittingEdit.setArguments(bundle);

            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, knittingEdit).addToBackStack("tag");
            trans.replace(R.id.container, knittingEdit);
            trans.commit();
            layotBarMenu();
            textHeader("Добавить вязку");
        } else if(key.equals("ChildEdit")){
            Fragment_Knit_Show show = new Fragment_Knit_Show();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, show).addToBackStack("tag");
            trans.replace(R.id.container, show);
            trans.commit();
            layotBarMenu();
            textHeader("Проверка");
        }


    }

    @Override
    public void onButtonClicked3(String key, int position, String edit) {
        if(key.equals("knittingEdit")){
            Bundle bundle = new Bundle();
            bundle.putString("key", position + "");
            bundle.putString("edit", edit);

            Fragment_Knit_Show fragmentKnitShow = new Fragment_Knit_Show();
            fragmentKnitShow.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.container, fragmentKnitShow).addToBackStack("tag");
            transaction.replace(R.id.container, fragmentKnitShow);
            transaction.commit();

            layotBarMenu();
            textHeader("Вязка редактирование");
        }
    }

    @Override
    public void onPetVoid() {
        b.layoutBar.setVisibility(View.VISIBLE);
    }

    private void testActiv(int position) {
        for (int i = 0; i < 100; i++) {
            SharedPreferences sharedPreferences = getSharedPreferences("prefActiv" + i, MODE_PRIVATE);
            SharedPreferences sharedPreferences2 = getSharedPreferences("prefActiv" + position, MODE_PRIVATE);


            if (sharedPreferences.getString("activ" + i, "").equals("Актив")) {
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putString("activ" + i, "");
                editor1.apply();

                SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                editor2.putString("activ" + position, "Актив");
                editor2.apply();
            }
        }
    }

    @Override
    public void onCreatFragment(String key) {
        if (key.equals("pets")) {
            layotBarPets();
            textHeader("Мои питомцы");
        } else if (key.equals("create")) {
            layotBarPets();
            textHeader("Добавить питомца");
            fragCreate();
        } else if (key.equals("note")) {
            layotBarNote();
            textHeader("Заметки");
        } else if (key.equals("menu")) {
            layotBarMenu();
            textHeader("Меню");
        } else if (key.equals("edit")) {
            layotBarPets();
            textHeader("Редактирование");
        } else if (key.equals("history")) {
            layotBarPets();
            textHeader("История");
        } else if (key.equals("profile")) {
            layotBarPets();
            textHeader("Профиль");
        } else if (key.equals("petsAll")) {
            fragPets();
        } else if (key.equals("createAll")) {
            fragCreate();
        } else if (key.equals("treatment")) {
            FragmentTreatmentEdit treatment = new FragmentTreatmentEdit();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, treatment).addToBackStack("tag");
            trans.replace(R.id.container, treatment);
            trans.commit();
            layotBarMenu();
        } else if (key.equals("vaccine")) {
            FragmentVaccineEdit vaccine = new FragmentVaccineEdit();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, vaccine).addToBackStack("tag");
            trans.replace(R.id.container, vaccine);
            trans.commit();
            layotBarMenu();
        } else if (key.equals("FragmentTreatmentEdit")) {
            layotBarMenu();
            textHeader("Обработка");
        } else if (key.equals("FragmentVaccineEdit")) {
            layotBarMenu();
            textHeader("Вакцинация");
        } else if (key.equals("FragmentMedicalCardEdit")) {
            layotBarMenu();
            textHeader("Мед.карта");
        } else if (key.equals("FragmentMedicalCart")) {
            layotBarMenu();
            textHeader("Медицинская карта");
        } else if (key.equals("FragmentAchievements")) {
            layotBarMenu();
            textHeader("Достижения");
        } else if (key.equals("FragmentTrainingEdit")) {
            layotBarMenu();
            textHeader("Дрессировка");
        } else if (key.equals("FragmentExhibitionsEdit")) {
            layotBarMenu();
            textHeader("Выставка");
        } else if (key.equals("FragmentKnitting")) {
            layotBarMenu();
            textHeader("Разведение животных");
        } else if (key.equals("FragmentKnittingEdit")) {
            layotBarMenu();
            textHeader("Добавить вязку");
        } else if (key.equals("medicalCard")) {
            FragmentMedicalCardEdit vaccine = new FragmentMedicalCardEdit();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, vaccine).addToBackStack("tag");
            trans.replace(R.id.container, vaccine);
            trans.commit();
        } else if (key.equals("exhibitions")) {
            FragmentExhibitionsEdit exhibitions = new FragmentExhibitionsEdit();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, exhibitions).addToBackStack("tag");
            trans.replace(R.id.container, exhibitions);
            trans.commit();
        } else if (key.equals("training")) {
            FragmentTrainingEdit training = new FragmentTrainingEdit();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, training).addToBackStack("tag");
            trans.replace(R.id.container, training);
            trans.commit();
        } else if (key.equals("knitting")) {
            FragmentKnittingEdit knittingEdit = new FragmentKnittingEdit();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, knittingEdit).addToBackStack("tag");
            trans.replace(R.id.container, knittingEdit);
            trans.commit();
            textHeader("Добавить вязку");
        } else if (key.equals("pedigree")) {
            FragmentPedigreeEdit knit = new FragmentPedigreeEdit();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, knit).addToBackStack("tag");
            trans.replace(R.id.container, knit);
            trans.commit();
            textHeader("Создание связи");
            layotBarMenu();
        } else if (key.equals("FragmentPedigree")) {
            layotBarMenu();
            textHeader("Родословная");
        } else if (key.equals("FragmentPedigreeEdit")) {
            layotBarMenu();
            textHeader("Создание связи");
        } else if (key.equals("FragmentTravel")) {
            layotBarMenu();
            textHeader("В путешествие");
        } else if (key.equals("backTreatment")) {
            FragmentTreatment fragmentTreatment = new FragmentTreatment();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, fragmentTreatment).addToBackStack("tag");
            trans.replace(R.id.container, fragmentTreatment);
            trans.commit();
            layotBarMenu();
            textHeader("Медицинская карта");
        } else if (key.equals("medCarta")) {
            FragmentMedicalCart med = new FragmentMedicalCart();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, med).addToBackStack("tag");
            trans.replace(R.id.container, med);
            trans.commit();
        } else if (key.equals("exhibitionBack")) {
            FragmentAchievements ach = new FragmentAchievements();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, ach).addToBackStack("tag");
            trans.replace(R.id.container, ach);
            trans.commit();
        } else if (key.equals("KnittingCreate")) {
            FragmentKnittingCreate create = new FragmentKnittingCreate();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, create).addToBackStack("tag");
            trans.replace(R.id.container, create);
            trans.commit();
        } else if (key.equals("FragmentKnittingSave")) {
            FragmentKnitting fragmentKnitting = new FragmentKnitting();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, fragmentKnitting).addToBackStack("tag");
            trans.replace(R.id.container, fragmentKnitting);
            trans.commit();
        } else if(key.equals("Child")){
            Toast.makeText(Create.this, "проверка", Toast.LENGTH_SHORT).show();
            FragmentKnittingCreate create = new FragmentKnittingCreate();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, create).addToBackStack("tag");
            trans.replace(R.id.container, create);
            trans.commit();
        } else if(key.equals("createChild")){
            FragmentCreate create = new FragmentCreate();
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, create).addToBackStack("tag");
            trans.replace(R.id.container, create);
            trans.commit();

            layotBarPets();
            textHeader("Добавить детеныша");
        }
    }


    @Override
    public void onMedShow(String key, String data1, String drug, String data2, int i) {
        if (key.equals("treatmentlayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", data1);
            bundle.putString("key2", drug);
            bundle.putString("key3", data2);
            bundle.putString("key4", i + "");

            Fragment_Treatment_Show fragment_treatment_show = new Fragment_Treatment_Show();
            fragment_treatment_show.setArguments(bundle);
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, fragment_treatment_show).addToBackStack("tag");
            trans.replace(R.id.container, fragment_treatment_show);
            trans.commit();
            layotBarMenu();
            textHeader("Обработка");
        } else if (key.equals("vaccinelayout")) {
            Bundle bundle = new Bundle();
            bundle.putString("key", data1);
            bundle.putString("key2", drug);
            bundle.putString("key3", data2);
            bundle.putString("key4", i + "");

            Fragment_Vaccine_Show fragment_vaccine_show = new Fragment_Vaccine_Show();
            fragment_vaccine_show.setArguments(bundle);
            FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
//            trans.replace(R.id.container, fragment_vaccine_show).addToBackStack("tag");
            trans.replace(R.id.container, fragment_vaccine_show);
            trans.commit();
            layotBarMenu();
            textHeader("Вакцинация");
        }
    }

    // Cпрятать клавиатуру при нажатии на экран
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View v = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);
        Log.d("TagCreate", "Касание экрана");
        if (v instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            Log.d("Activity", "Touch event " + event.getRawX() + "," + event.getRawY() + " " + x + "," + y + " rect " + w.getLeft() + "," + w.getTop() + "," + w.getRight() + "," + w.getBottom() + " coords " + scrcoords[0] + "," + scrcoords[1]);
            if (event.getAction() == MotionEvent.ACTION_UP && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w.getBottom())) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            }
        }
        return ret;
    }
}
