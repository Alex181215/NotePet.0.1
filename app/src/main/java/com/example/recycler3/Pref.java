package com.example.recycler3;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

public class Pref {
    public static final String STORAGE_NAME = "StorageName";
    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    public final static String ACTIV = "activ";
    public final static String MY_ANIMAL = "myAnimal";
    public final static String STATUS = "status";
    public final static String CATEGORY = "category";
    public final static String ID = "id";
    public final static String DATA = "data";

    public final static String PREF_DATA = "prefData";
    public final static String KEY_DATA = "data";

    public final static String DATA_CATEGORY = "dataCategory";
    public final static String NAME = "name";
    public final static String DAY = "day";
    public final static String MOUNT = "mount";
    public final static String AGE = "age";
    public final static String GENDER = "gender";
    public final static String ANIMAL = "animal";
    public final static String CHIP = "chip";
    public final static String BREED = "breed";
    public final static String COLOR = "color";
    public final static String WEIGHT = "weight";
    public final static String KG = "kg";
    public final static String HEIGHT = "height";
    public final static String BUST = "bust";
    public final static String BACK = "back";
    public final static String GROIN = "groin";
    public final static String VOLUME = "volume";
    public final static String LENGTH = "length";
    public final static String WIDTH = "width";
    public final static String DAY_CAST = "dayCast";
    public final static String MOUNT_CAST = "mountCast";
    public final static String AGE_CAST = "ageCast";
    public final static String DAY_CIC = "dayCic";
    public final static String MOUNT_CIC = "mountCic";
    public final static String AGE_CIC = "ageCic";
    public final static String DAY_CIC_E = "dayCicE";
    public final static String MOUNT_CIC_E = "mountCicE";
    public final static String AGE_CIC_E = "ageCicE";
    public final static String NURSERY = "nursery";
    public final static String NOTE = "note";
    public final static String NOTE_HEA = "noteHea";
    public final static String NOTE_TIT = "noteTit";

    // метод инициализации работы с настройками сохранения, обязательно ставить сразу в креат
    public static void init( Context cntxt ){
        context = cntxt;
    }

    // внутренний метод для работы класса
    private static void init(){
        settings = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
    }

    // метод для записи сохранения
    public static void addEd(String name, EditText value ){
        if( settings == null ){
            init();
        }
        editor.putString( name, String.valueOf(value));
        editor.apply();
    }

    public static void addStr(String name, String value ){
        if( settings == null ){
            init();
        }
        editor.putString( name, value );
        editor.apply();
    }

    // метод для извлечения сохранения
    public static String get( String name ){
        if( settings == null ){
            init();
        }
        return settings.getString( name, null );
    }

    // метод для очистки всех настроек
    public static void clearPref(){
        if( settings == null ){
            init();
        }
        editor.clear();
        editor.apply();
    }

    // метод для очистки поля едит текст
    public static void clearVal(EditText name){
       name.setText("");
    }
}



