package com.example.recycler3;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;
import static android.view.View.GONE;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.recycler3.databinding.FragmentCreateBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentCreate extends Fragment {
    CreateMetod createMetod = new CreateMetod();
    private SampleCallback callback;
    private static final int GALLERY_REQUEST = 1;

    String animalText;
    private FragmentCreate context = this;

    private ArrayList<String> animalArrayList = new ArrayList<String>();
    private ArrayAdapter<String> animalArrayAdapter;

    private String gender = "";
    private FragmentCreateBinding b;

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

        b = FragmentCreateBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        callback.onCreatFragment("сreate");


        jump(); // метод перехода по датам
        editTextHide(); // методы спрятать фокус
        hideParam(); // метод скрыть параметры по умолчанию
        hideInfo(); // метод скрыть информацию по умолчанию
        listener(); // слушатели кнопок спойлеров, скрыть и показать по нажатию
        spAnimal(); // метод спинера, выпадающего списка, выбор вида питомца
        rgGender(); // метод радиокнопки, выбор пола
        ava(); // слушатели кнопки добавить аву
        saveM(); // слушатели для кнопки сохранить
        return view;
    }

    public void save() {
        if (b.edTextName.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите имя Питомца", Toast.LENGTH_SHORT).show();
            b.edTextName.requestFocus();
            setSoftKeyboard();
        } else if (b.edTextDay.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите день рождения", Toast.LENGTH_SHORT).show();
            b.edTextDay.requestFocus();
            setSoftKeyboard();
        } else if (b.edTextMount.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите месяц рождения", Toast.LENGTH_SHORT).show();
            b.edTextMount.requestFocus();
            setSoftKeyboard();
        } else if (b.edTextAge.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите год рождения", Toast.LENGTH_SHORT).show();
            b.edTextAge.requestFocus();
            setSoftKeyboard();
        } else if (b.spinnerAnimal.getSelectedItem().toString().equals("Выбрать")) {
            Toast.makeText(getActivity(), "Выберите вид Питомца", Toast.LENGTH_SHORT).show();
            b.spinnerAnimal.requestFocus();
            b.spinnerAnimal.performClick();
        } else {
            testData(b.edTextDay, b.edTextMount, b.edTextDay);
        }
    }

    private void testData(EditText day, EditText mount, EditText age) {
        SimpleDateFormat datD = new SimpleDateFormat("dd");
        String currentDateandD = datD.format(new Date());
        String data1 = ("" + currentDateandD);
        int currentDay = Integer.parseInt(data1);

        SimpleDateFormat datM = new SimpleDateFormat("MM");
        String currentDateandM = datM.format(new Date());
        String data2 = ("" + currentDateandM);
        int currentMount = Integer.parseInt(data2);

        SimpleDateFormat datY = new SimpleDateFormat("yyyy");
        String currentDateandY = datY.format(new Date());
        String data3 = ("" + currentDateandY);
        int currentAge = Integer.parseInt(data3);

        if (!day.getText().toString().equals("") && !mount.getText().toString().equals("") && !age.getText().toString().equals("")) {
            int dayHappy = Integer.parseInt(day.getText().toString());
            int mountHappy = Integer.parseInt(mount.getText().toString());
            int ageHappy = Integer.parseInt(age.getText().toString());
            if (dayHappy <= 0 || mountHappy <= 0 || ageHappy <= 0) {
                Toast.makeText(getActivity(), "Неверная дата", Toast.LENGTH_SHORT).show();
                day.setText("");
                mount.setText("");
                age.setText("");
                day.requestFocus();
            } else if (dayHappy > 31) {
                Toast.makeText(getActivity(), "Превышает количество дней в месяце", Toast.LENGTH_SHORT).show();
                day.setText("");
                day.requestFocus();
            } else if (dayHappy > currentDay && mountHappy == currentMount && ageHappy == currentAge) {
                Toast.makeText(getActivity(), "Превышает текущий день", Toast.LENGTH_SHORT).show();
                day.setText("");
                day.requestFocus();
            } else if (mountHappy > 12) {
                Toast.makeText(getActivity(), "Превышает количество месяцев в году", Toast.LENGTH_SHORT).show();
                mount.setText("");
                mount.requestFocus();
            } else if (dayHappy >= currentDay && mountHappy > currentMount && ageHappy == currentAge) {
                Toast.makeText(getActivity(), "Превышает текущий месяц", Toast.LENGTH_SHORT).show();
                mount.setText("");
                mount.requestFocus();
            } else if (dayHappy <= currentDay && mountHappy > currentMount && ageHappy == currentAge) {
                Toast.makeText(getActivity(), "Превышает текущий месяц", Toast.LENGTH_SHORT).show();
                mount.setText("");
                mount.requestFocus();
            } else if (ageHappy > currentAge) {
                Toast.makeText(getActivity(), "Превышает текущий год", Toast.LENGTH_SHORT).show();
                age.setText("");
                age.requestFocus();
            } else {
                savePet();
            }
        }
    }

    private void savePet() {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefName" + i, MODE_PRIVATE);
            if (sharedPreferences.getString("name" + i, "").equals("")) {
                saveStatus("prefMyStatus" + i, "myStatus" + i);
                saveActiv("prefActiv" + i, "activ" + i);
                saveData("prefData" + i, "data" + i);
                saveEditText("prefName" + i, "name" + i, b.edTextName);
                saveEditText("prefDay" + i, "day" + i, b.edTextDay);
                saveEditText("prefMount" + i, "mount" + i, b.edTextMount);
                saveEditText("prefAge" + i, "age" + i, b.edTextAge);
                saveGender("prefGender" + i, "gender" + i, gender);
                saveEditText("prefChip" + i, "chip" + i, b.edTextChip);
                saveSpiner("prefAnimal" + i, "animal" + i, b.spinnerAnimal);
                saveEditText("prefBreed" + i, "breed" + i, b.edTextBreed);
                saveEditText("prefColor" + i, "color" + i, b.edTextColor);
                saveEditText("prefWeight" + i, "weight" + i, b.edTextWeight);
                saveSpiner("prefKg" + i, "kg" + i, b.spinnerKg);
                saveEditText("prefHeight" + i, "height" + i, b.edTextHeight);
                saveEditText("prefBust" + i, "bust" + i, b.edTextBust);
                saveEditText("prefBack" + i, "back" + i, b.edTextBack);
                saveEditText("prefGroin" + i, "groin" + i, b.edTextGroin);
                saveEditText("prefVolume" + i, "volume" + i, b.edTextVolume);
                saveEditText("prefLength" + i, "length" + i, b.edTextLength);
                saveEditText("prefWidth" + i, "width" + i, b.edTextWidth);
                saveEditText("prefDayCast" + i, "dayCast" + i, b.edTextDayCast);
                saveEditText("prefMountCast" + i, "mountCast" + i, b.edTextMountCast);
                saveEditText("prefAgeCast" + i, "ageCast" + i, b.edTextAgeCast);
                saveEditText("prefDayCicle" + i, "dayCicle" + i, b.edTextDayCicle);
                saveEditText("prefMountCicle" + i, "mountCicle" + i, b.edTextMountCicle);
                saveEditText("prefAgeCicle" + i, "ageCicle" + i, b.edTextAgeCicle);
                saveEditText("prefDayCicleExit" + i, "dayCicleExit" + i, b.edTextDayCicle2);
                saveEditText("prefMountCicleExit" + i, "mountCicleExit" + i, b.edTextMountCicle2);
                saveEditText("prefAgeCicleExit" + i, "ageCicleExit" + i, b.edTextAgeCicle2);
                saveEditText("prefNursery" + i, "nursery" + i, b.edTextNursery);
                saveEditText("prefNote" + i, "note" + i, b.edTextNote);
                break;
            }
        }
        sendPet();
    }

    // метод для сохранения выбора спинера, выпающего списка ( вида животного )
    private void saveSpiner(String pref, String key, Spinner spinner) {
        if (!spinner.getSelectedItem().toString().equals("Выбрать")) {
            SharedPreferences Shared = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = Shared.edit();
            editor.putString(key, spinner.getSelectedItem().toString());
            editor.apply();
        }
    }

    // метод для сохранения выбора радиокнопки ( пола )
    private void saveGender(String pref, String key, String gender) {
        if (!gender.equals("")) {
            SharedPreferences Shared = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = Shared.edit();
            editor.putString(key, gender);
            editor.apply();
        }
    }

    private void saveData(String pref, String key) {
        String data = "";
        SimpleDateFormat dat = new SimpleDateFormat("dd.MM.yy");
        String currentDateand = dat.format(new Date());
        data = ("" + currentDateand);
        SharedPreferences Shared = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
        SharedPreferences.Editor editor = Shared.edit();
        editor.putString(key, data);
        editor.apply();
    }

    // метод для сохранения остальных данных с форм заполнения пользователем
    private void saveStatus(String pref, String key) {
        SharedPreferences Shared = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
        SharedPreferences.Editor editor = Shared.edit();
        editor.putString(key, "Актуальное");
        editor.apply();
    }

    private void saveActiv(String pref, String key) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, "Актив");
        editor.apply();
    }

    // метод вызова Профиля
    private void sendPet() {
        // когда нажимаем кнопку сохранить, если в сохраненке есть статус дитя в формате ДА
        // то тогда статус меняется на нет
        // и открывается

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefChild", MODE_PRIVATE);
        if(sharedPreferences.getString("child", "").equals("yes")){
//            Toast.makeText(getActivity(), "проверка", Toast.LENGTH_SHORT).show();
            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefChild", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences1.edit();
            editor.putString("prefChild", "No");
            editor.apply();

            callback.onButtonClicked2("Child", 1, 1);
        } else {
            FragmentPets pets = new FragmentPets();
            FragmentTransaction trans = getActivity().getSupportFragmentManager().beginTransaction();
            trans.replace(R.id.container, pets);
            trans.commit();
        }

    }


    // метод для сохранения остальных данных с форм заполнения пользователем
    private void saveEditText(String pref, String key, EditText editText) {
        if (!editText.getText().toString().equals("")) {
            SharedPreferences Shared = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = Shared.edit();
            editor.putString(key, editText.getText().toString());
            editor.apply();
        }

    }

    // метод для захвата и подмены изображения из галереи
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        b.image.setVisibility(GONE);
        b.ava.setVisibility(View.VISIBLE);
        Bitmap bitmap = null;
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    b.ava2.setImageBitmap(bitmap);
                    try {
                        saveToInternalStorage(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    // метод для сохранеия изображения в локальную память
    private String saveToInternalStorage(Bitmap bitmapImage) throws IOException {
        ContextWrapper cw = new ContextWrapper(getActivity().getApplicationContext());
        // путь /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Создаем imageDir
        File mypath = new File(directory, "profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Используем метод сжатия BitMap объекта для записи в OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close();
        }
        return directory.getAbsolutePath();
    }

    private void ava() {
        // кнопка загрузить аватарку
        b.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });

        // кнопка загрузить аватарку
        b.ava2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });

    }

    private void spAnimal() {
        animalArrayList.add("Выбрать");
        animalArrayList.add("Собака");
        animalArrayList.add("Кошка");
        animalArrayList.add("Попугай");
        animalArrayList.add("Крыса");
        animalArrayList.add("Шиншила");
        animalArrayList.add("Хомяк");
        animalArrayList.add("Черепаха");
        loadSpAnimal();
        animalArrayList.add("Другое");
        animalArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_layout, R.id.text_item, animalArrayList);
        b.spinnerAnimal.setAdapter(animalArrayAdapter);
        b.spinnerAnimal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Другое")) {
                    spinerAnimaltest();
                }
            }

            private void spinerAnimaltest() {
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
                                        animalText = userInput.getText().toString();
                                        saveMyAnimal();
                                        onAdd();
                                        int count = animalArrayList.size();
                                        b.spinnerAnimal.setSelection(count - 1);
                                    }

                                    // метод сохранения новых видов питомцев
                                    public void saveMyAnimal() {
                                        for (int i = 1; i < 100; i++) {

                                            SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefMyAnimal" + i, MODE_PRIVATE);
                                            if (sharedPreferences1.getString("myAnimal" + i, "").equals("")) {
                                                SharedPreferences shared = getActivity().getSharedPreferences("prefMyAnimal" + i, MODE_PRIVATE);
                                                SharedPreferences.Editor editor = shared.edit();
                                                editor.putString("myAnimal" + i, animalText);
                                                editor.apply();
                                                break;
                                            }

                                        }
                                    }

                                    private void onAdd() {
                                        animalArrayList.add(animalText + "");
                                        b.spinnerAnimal.setAdapter(animalArrayAdapter); // наполняем спиннер данными из адаптера
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
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    // Метод проверки и добавление новых питомцев из сохраненки
    private void loadSpAnimal() {
        for (int i = 1; i < 100; i++) {
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefMyAnimal" + i, MODE_PRIVATE);
            if (!sharedPreferences.getString("myAnimal" + i, "").equals("")) {
                animalArrayList.add(sharedPreferences.getString("myAnimal" + i, ""));
            }
        }
    }

    private void rgGender() {
        // Слушатель выбора радиокнопки
        b.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        Toast.makeText(getActivity().getApplicationContext(), "Ничего не выбрано",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButtonOne:
                        gender = "Мужской";
                        break;
                    case R.id.radioButtonTwo:
                        gender = "Женский";
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void jump() {
        // автоматический переход Дата рождения
        createMetod.dataAvtomat(b.edTextDay, b.edTextMount, b.edTextAge, b.edTextChip);

        // автоматический переход по параметрам
        createMetod.paramAvtomat2(b.edTextWeight, b.edTextHeight, b.edTextBust, b.edTextBack, b.edTextGroin, b.edTextVolume, b.edTextLength, b.edTextWidth);

        // автоматический переход Дата кастрации
        createMetod.dataAvtomat(b.edTextDayCast, b.edTextMountCast, b.edTextAgeCast, b.edTextDayCicle);

        // автоматический переход Дата начало цикла
        createMetod.dataAvtomat(b.edTextDayCicle, b.edTextMountCicle, b.edTextAgeCicle, b.edTextDayCicle2);

        // аатоматический переход Дата конца цикла
        createMetod.dataAvtomat(b.edTextDayCicle2, b.edTextMountCicle2, b.edTextAgeCicle2, b.edTextNursery);
    }

    public void editTextHide() {
        enter(b.edTextChip);
        enter(b.edTextColor);
        enter(b.edTextWidth);
    }

    // При нажатии на Enter на кливиатуре убираем фокус и прячем клавиатуру
    void enter(EditText editText) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    editText.clearFocus();
                    setSoftKeyboard();
                    return true;
                }
                return false;
            }
        });
    }

    private void setSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void listener() {
        b.headerTextParams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnParam();
            }
        });

        b.btnShowParams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnParam();
            }
        });

        b.btnHideParams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnParam();
            }
        });

        b.headerTextInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnInfo();
            }
        });

        b.btnShowInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnInfo();
            }
        });

        b.btnHideInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnInfo();
            }
        });

    }

    // кнопка по нажатию на текст, скрыть или показать Параметры onClick
    public void btnParam() {
        if (b.btnShowParams.getVisibility() == View.VISIBLE) {
            b.btnShowParams.setVisibility(View.GONE);
            b.btnHideParams.setVisibility(View.VISIBLE);
            showParams();
        } else {
            b.btnShowParams.setVisibility(View.VISIBLE);
            b.btnHideParams.setVisibility(View.GONE);
            hideParam();
        }
    }

    // метод скрыть параметры из класса Креат работат по умолчанию при загрузке
    private void hideParam() {
        createMetod.hideParam(b.btnHideParams,
                b.spinnerKg,
                b.textWeight, b.textHeight, b.textBust, b.textBack, b.textGroin, b.textGroin2, b.textVolume, b.textLength, b.textWidth,
                b.edTextWeight, b.edTextHeight, b.edTextBust, b.edTextBack, b.edTextGroin, b.edTextVolume, b.edTextLength, b.edTextWidth,
                b.smHeight, b.smBust, b.smBack, b.smGroin, b.smVolume, b.smLength, b.smWidth,
                b.layoutWeightHeight, b.layoutWeightHeightText, b.layoutBustBack,
                b.layoutBustBackText, b.layoutNeckGroin, b.layoutNeckGroinText, b.layoutLengthWidth, b.layoutLengthWidthText,
                b.layoutWeight, b.layoutHeight, b.layoutBust, b.layoutBack, b.layoutGroin, b.layoutVolume, b.layoutLength, b.layoutWidth);
    }

    // метод показать параметры
    private void showParams() {
        createMetod.showParam(b.btnHideParams,
                b.spinnerKg,
                b.textWeight, b.textHeight, b.textBust, b.textBack, b.textGroin, b.textGroin2, b.textVolume, b.textLength, b.textWidth,
                b.edTextWeight, b.edTextHeight, b.edTextBust, b.edTextBack, b.edTextGroin, b.edTextVolume, b.edTextLength, b.edTextWidth,
                b.smHeight, b.smBust, b.smBack, b.smGroin, b.smVolume, b.smLength, b.smWidth,
                b.layoutDataGender, b.layoutDataGenderText, b.layoutWeightHeight, b.layoutWeightHeightText, b.layoutBustBack,
                b.layoutBustBackText, b.layoutNeckGroin, b.layoutNeckGroinText, b.layoutLengthWidth, b.layoutLengthWidthText,
                b.layoutWeight, b.layoutHeight, b.layoutBust, b.layoutBack, b.layoutGroin, b.layoutVolume, b.layoutLength, b.layoutWidth);
    }

    // кнопка по нажатию на текст, скрыть или показать Иную информацию из onClick
    public void btnInfo() {
        if (b.btnShowInfo.getVisibility() == View.VISIBLE) {
            b.btnShowInfo.setVisibility(View.GONE);
            b.btnHideInfo.setVisibility(View.VISIBLE);
            showInfo();
        } else {
            b.btnShowInfo.setVisibility(View.VISIBLE);
            b.btnHideInfo.setVisibility(View.GONE);
            hideInfo();
        }
    }

    // метод скрыть иную информацию из класса Креат работат по умолчанию при загрузке
    private void hideInfo() {
        createMetod.hideInfo(b.btnHideInfo,
                b.textCast, b.textCicl, b.textNursery, b.textNote,
                b.edTextDayCast, b.edTextMountCast, b.edTextAgeCast,
                b.edTextDayCicle, b.edTextMountCicle, b.edTextAgeCicle,
                b.edTextDayCicle2, b.edTextMountCicle2, b.edTextAgeCicle2,
                b.edTextNursery, b.edTextNote, b.tochDayCast, b.tochMountCast,
                b.tochAgeCast, b.tochDayCicle, b.tochMountCicle,
                b.tochAgeCicle, b.tochDayCicle2, b.tochMountCicle2, b.tochAgeCicle2,
                b.layoutDataCast, b.layoutDataCicle, b.layoutDataCicle2
        );
    }

    // Метод показать иную информацию
    private void showInfo() {
        createMetod.showInfo(b.btnHideInfo,
                b.textCast, b.textCicl, b.textNursery, b.textNote,
                b.edTextDayCast, b.edTextMountCast, b.edTextAgeCast,
                b.edTextDayCicle, b.edTextMountCicle, b.edTextAgeCicle,
                b.edTextDayCicle2, b.edTextMountCicle2, b.edTextAgeCicle2,
                b.edTextNursery, b.edTextNote, b.tochDayCast, b.tochMountCast,
                b.tochAgeCast, b.tochDayCicle, b.tochMountCicle,
                b.tochAgeCicle, b.tochDayCicle2, b.tochMountCicle2, b.tochAgeCicle2,
                b.layoutDataCast, b.layoutDataCicle, b.layoutDataCicle2);
    }

    public void saveM() {
        b.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
        b.getpetmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        b.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

}