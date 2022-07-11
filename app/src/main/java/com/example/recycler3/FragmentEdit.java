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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recycler3.databinding.FragmentEditBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FragmentEdit extends Fragment {
    CreateMetod createMetod = new CreateMetod();
    private static final int GALLERY_REQUEST = 1;
    private SampleCallback callback;

    String animalText;
    private FragmentEdit context = this;

    private ArrayList<String> animalArrayList = new ArrayList<String>();
    private ArrayAdapter<String> animalArrayAdapter;

    private String gender = "";

    int id = 0;
    private FragmentEditBinding b;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        b = FragmentEditBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        callback.onCreatFragment("edit");

        jump(); // метод перехода по датам
        editTextHide(); // методы спрятать фокус
        hideParam(); // метод скрыть параметры по умолчанию
        hideInfo(); // метод скрыть информацию по умолчанию
        listener(); // слушатели кнопок спойлеров, скрыть и показать по нажатию
        spAnimal(); // метод спинера, выпадающего списка, выбор вида питомца
        rgGender(); // метод радиокнопки, выбор пола
        setAll(); // метод подгрузки данных

        ava(); // слушатели кнопки добавить аву
        saveM();
        return view;
    }

    // метод подгрузки данных
    private void setAll() {
        // метод проверки данных, если ключ пришел ( id) то загружаем данные, снало проверяем есть ли по ним сохраненки,
        // если есть то загружаем
        if (!this.getArguments().getString("key").equals("")) {
            String i = this.getArguments().getString("key");
            id = Integer.parseInt(i);

            set("prefName", "name", b.edTextNameED);
            set("prefDay", "day", b.edTextDay);
            set("prefMount", "mount", b.edTextMount);
            set("prefAge", "age", b.edTextAge);
            gender("prefGender", "gender", b.radioButtonOne, b.radioButtonTwo);
            set("prefChip", "chip", b.edTextChip);
            animal("prefAnimal", "animal", b.spinnerAnimal);
            kg();
            set("prefBreed", "breed", b.edTextBreed);
            set("prefColor", "color", b.edTextColor);
            set("prefWeight", "weight", b.edTextWeight);
            set("prefHeight", "height", b.edTextHeight);
            set("prefBust", "bust", b.edTextBust);
            set("prefBack", "back", b.edTextBack);
            set("prefGroin", "groin", b.edTextGroin);
            set("prefVolume", "volume", b.edTextVolume);
            set("prefLength", "length", b.edTextLength);
            set("prefWidth", "width", b.edTextWidth);
            set("prefDayCast", "dayCast", b.edTextDayCast);
            set("prefMountCast", "mountCast", b.edTextMountCast);
            set("prefAgeCast", "ageCast", b.edTextAgeCast);
            set("prefDayCicle", "dayCicle", b.edTextDayCicle);
            set("prefMountCicle", "mountCicle", b.edTextMountCicle);
            set("prefAgeCicle", "ageCicle", b.edTextAgeCicle);
            set("prefDayCicleExit", "dayCicleExit", b.edTextDayCicle2);
            set("prefMountCicleExit", "mountCicleExit", b.edTextMountCicle2);
            set("prefAgeCicleExit", "ageCicleExit", b.edTextAgeCicle2);
            set("prefNursery", "nursery", b.edTextNursery);
            set("prefNote", "note", b.edTextNote);
        }
    }

    // Метод заполнения сохраненки стандартных данных
    public void set(String pref, String  key, EditText text ){
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(pref + id, MODE_PRIVATE);
                if(!sharedPreferences.getString(key + id, "").equals("")){
                    text.setText(sharedPreferences.getString(key + id, ""));
                }
    }

    // Метод заполнени спинера по параметру вес
        private void kg() {
           SharedPreferences sharedPreferences = getActivity().getSharedPreferences("prefKg"+id, MODE_PRIVATE);
           if(!sharedPreferences.getString("kg"+id, "").equals("")){
               String testKg = sharedPreferences.getString("kg"+id, "");
               switch (testKg) {
                   case "гр.":
                       b.spinnerKg.setSelection(0);
                       break;
                   case "кг.":
                       b.spinnerKg.setSelection(1);
                       break;
           }
            }
    }

// Метод заполнения спинера по виду животного
    private void animal(String pref, String key, Spinner spinner) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(pref + id, Context.MODE_PRIVATE);
                String testAnimal = sharedPreferences.getString(key + id, "");
                switch (testAnimal) {
                    case "Выбрать":
                        spinner.setSelection(0);
                        break;
                    case "Собака":
                        spinner.setSelection(1);
                        break;
                    case "Кошка":
                        spinner.setSelection(2);
                        break;
                    case "Попугай":
                        spinner.setSelection(3);
                        break;
                    case "Крыса":
                        spinner.setSelection(4);
                        break;
                    case "Шиншила":
                        spinner.setSelection(5);
                        break;
                    case "Хомяк":
                        spinner.setSelection(6);
                        break;
                    case "Черепаха":
                        spinner.setSelection(7);
                        break;
                }

                // метод проверки сохраненок по не стандартным видам животного
                SharedPreferences shar = getActivity().getSharedPreferences(pref + id, MODE_PRIVATE);
                String tera = shar.getString(key + id, "");
                if (!tera.equals("Выбрать") && !tera.equals("Собака") && !tera.equals("Кошка") && !tera.equals("Попугай") && !tera.equals("Крыса") && !tera.equals("Шиншила") && !tera.equals("Хомяк") && !tera.equals("Черепаха")) {
                    for (int f = 1; f < 100; f++) {
                        SharedPreferences sharedPreferences1 = getActivity().getSharedPreferences("prefMyAnimal"+f , MODE_PRIVATE);
                        if (sharedPreferences1.getString("myAnimal" + f, "").equals(tera)) {
                            spinner.setSelection(7+f);
                        }
                    }
                }
    }

    // метод по выбору пола из сохраненки
    public void gender(String pref, String key, RadioButton one, RadioButton two) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(pref + id, Context.MODE_PRIVATE);
                if (sharedPreferences.getString(key + id, "").equals("Мужской")) {
                    one.setChecked(true);
                } else if (sharedPreferences.getString(key + id, "").equals("Женский")) {
                    two.setChecked(true);
                }
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

    public void save() {

        if (b.edTextNameED.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Введите имя Питомца", Toast.LENGTH_SHORT).show();
            b.edTextNameED.requestFocus();
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
        saveEditText("prefName" + id, "name" + id, b.edTextNameED);
        saveEditText("prefDay" + id, "day" + id, b.edTextDay);
        saveEditText("prefMount" + id, "mount" + id, b.edTextMount);
        saveEditText("prefAge" + id, "age" + id, b.edTextAge);
        saveGender("prefGender" + id, "gender" + id, gender);
        saveEditText("prefChip" + id, "chip" + id, b.edTextChip);
        saveSpiner("prefAnimal" + id, "animal" + id, b.spinnerAnimal);
        saveEditText("prefBreed" + id, "breed" + id, b.edTextBreed);
        saveEditText("prefColor" + id, "color" + id, b.edTextColor);
        saveEditText("prefWeight" + id, "weight" + id, b.edTextWeight);
        saveSpiner("prefKg" + id, "kg" + id, b.spinnerKg);
        saveEditText("prefHeight" + id, "height" + id, b.edTextHeight);
        saveEditText("prefBust" + id, "bust" + id, b.edTextBust);
        saveEditText("prefBack" + id, "back" + id, b.edTextBack);
        saveEditText("prefGroin" + id, "groin" + id, b.edTextGroin);
        saveEditText("prefVolume" + id, "volume" + id, b.edTextVolume);
        saveEditText("prefLength" + id, "length" + id, b.edTextLength);
        saveEditText("prefWidth" + id, "width" + id, b.edTextWidth);
        saveEditText("prefDayCast" + id, "dayCast" + id, b.edTextDayCast);
        saveEditText("prefMountCast" + id, "mountCast" + id, b.edTextMountCast);
        saveEditText("prefAgeCast" + id, "ageCast" + id, b.edTextAgeCast);
        saveEditText("prefDayCicle" + id, "dayCicle" + id, b.edTextDayCicle);
        saveEditText("prefMountCicle" + id, "mountCicle" + id, b.edTextMountCicle);
        saveEditText("prefAgeCicle" + id, "ageCicle" + id, b.edTextAgeCicle);
        saveEditText("prefDayCicleExit" + id, "dayCicleExit" + id, b.edTextDayCicle2);
        saveEditText("prefMountCicleExit" + id, "mountCicleExit" + id, b.edTextMountCicle2);
        saveEditText("prefAgeCicleExit" + id, "ageCicleExit" + id, b.edTextAgeCicle2);
        saveEditText("prefNursery" + id, "nursery" + id, b.edTextNursery);
        saveEditText("prefNote" + id, "note" + id, b.edTextNote);
        Toast.makeText(getActivity(), "Сохранено", Toast.LENGTH_SHORT).show();
        callback.onCreatFragment("petsAll");
    }

    // метод для сохранения остальных данных с форм заполнения пользователем
    private void saveEditText(String pref, String key, EditText editText) {
        SharedPreferences Shared = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
        SharedPreferences.Editor editor = Shared.edit();
        editor.putString(key, editText.getText().toString());
        editor.apply();
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

    // метод для сохранения выбора спинера, выпающего списка ( вида животного )
    private void saveSpiner(String pref, String key, Spinner spinner) {
        if (!spinner.getSelectedItem().toString().equals("Выбрать")) {
            SharedPreferences Shared = getActivity().getSharedPreferences(pref, MODE_PRIVATE);
            SharedPreferences.Editor editor = Shared.edit();
            editor.putString(key, spinner.getSelectedItem().toString());
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

    private void jump() {  // автоматический переход Дата рождения
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
}