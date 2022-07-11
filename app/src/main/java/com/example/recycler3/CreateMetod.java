package com.example.recycler3;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class
CreateMetod {
    public boolean isReached = false;

    // Общий метод для переноса фокуса с EditText1 на EditText2 при заполнении кол символов i
    public void nextEdit(EditText editText1, EditText editText2, int i) {
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText1.getText().length() == i && !isReached) {
                    editText1.clearFocus();
                    editText2.requestFocus();
                    isReached = true;
                }
                if (editText1.getText().length() < i && isReached) isReached = false;
            }
        });
    }


    // метод для дат авто переключение
    public void dataAvtomat(EditText day, EditText mount, EditText age, EditText result) {
        nextEdit(day, mount, 2);
        nextEdit(mount, age, 2);
        nextEdit(age, result, 4);
    }

    public void dataAvtomat2(EditText day, EditText mount, EditText age) {
        nextEdit(day, mount, 2);
        nextEdit(mount, age, 2);
    }


    // метод для параметров авто переключение
    public void paramAvtomat(EditText param1, EditText param2, EditText param3, EditText param4, EditText param5, EditText param6, EditText param7, EditText param8) {
        nextEdit(param1, param2, 4);
        nextEdit(param2, param3, 4);
        nextEdit(param3, param4, 4);
        nextEdit(param4, param5, 4);
        nextEdit(param5, param6, 4);
        nextEdit(param6, param7, 4);
        nextEdit(param7, param8, 4);
    }

    public void paramAvtomat2(EditText param1, EditText param2, EditText param3, EditText param4, EditText param5, EditText param6, EditText param7, EditText param8) {
        nextEdit(param1, param2, 6);
        nextEdit(param2, param3, 6);
        nextEdit(param3, param4, 6);
        nextEdit(param4, param5, 6);
        nextEdit(param5, param6, 6);
        nextEdit(param6, param7, 6);
        nextEdit(param7, param8, 6);
    }


    // метод убрать фокус
    void enter(EditText editText, Activity activity, View view) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    editText.clearFocus();
                    hideSoftKeyboard(activity, view);
                    return true;
                }
                return false;
            }
        });
    }

    // метод спрятать клавиатуру, разобраться как работает View почему не ставится
    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    // Для того что бы разобраться с View кидаем весь код вниз с метода где работает

// В креат стояло вот это

//    View.OnFocusChangeListener ofcListenerColor = new MyFocusChangeListenerColor();
//        line_color.setOnFocusChangeListener(ofcListenerColor);

// Ниже стояло вот это как вложенный класс

//// класс избавления от фокуса и скрытия клавиатуры
//private class MyFocusChangeListenerColor implements View.OnFocusChangeListener {
//    public void onFocusChange(View v, boolean hasFocus) {
//        if (v.getId() == R.id.line_color && !hasFocus) {
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//            hideSoftKeyboard.hideSoftKeyboard(GetPet.this, v);
//        }
//    }
//}

    public void clearFocus(EditText editText1, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, EditText editText7, EditText editText8, EditText editText9, EditText editText10, EditText editText11, EditText editText12, EditText editText13, EditText editText14, EditText editText15, EditText editText16, EditText editText17, EditText editText18, EditText editText19, EditText editText20, EditText editText21, EditText editText22, EditText editText23, EditText editText24, EditText editText25, EditText editText26) {
        editText1.clearFocus();
        editText2.clearFocus();
        editText3.clearFocus();
        editText4.clearFocus();
        editText5.clearFocus();
        editText6.clearFocus();
        editText7.clearFocus();
        editText8.clearFocus();
        editText9.clearFocus();
        editText10.clearFocus();
        editText11.clearFocus();
        editText12.clearFocus();
        editText13.clearFocus();
        editText14.clearFocus();
        editText15.clearFocus();
        editText16.clearFocus();
        editText17.clearFocus();
        editText18.clearFocus();
        editText19.clearFocus();
        editText20.clearFocus();
        editText21.clearFocus();
        editText22.clearFocus();
        editText23.clearFocus();
        editText24.clearFocus();
        editText25.clearFocus();
        editText26.clearFocus();
    }

    void hideParam(ImageButton button, Spinner spinner,
                   TextView text1, TextView text2, TextView text3, TextView text4, TextView text5, TextView text6, TextView text7, TextView text8, TextView text9,
                   EditText edit1, EditText edit2, EditText edit3, EditText edit4, EditText edit5, EditText edit6, EditText edit7, EditText edit8,
                   TextView sm1, TextView sm2, TextView sm3, TextView sm4, TextView sm5, TextView sm6, TextView sm7,
                   LinearLayout layout1, LinearLayout layout2, LinearLayout layout3, LinearLayout layout4, LinearLayout layout5, LinearLayout layout6,
                   LinearLayout layout7, LinearLayout layout8, LinearLayout layout9, LinearLayout layout10, LinearLayout layout11, LinearLayout layout12, LinearLayout layout13, LinearLayout layout14,
                   LinearLayout layout15, LinearLayout layout16) {
        button.setVisibility(View.GONE);

        spinner.setVisibility(View.GONE);

        text1.setVisibility(View.GONE);
        text2.setVisibility(View.GONE);
        text3.setVisibility(View.GONE);
        text4.setVisibility(View.GONE);
        text5.setVisibility(View.GONE);
        text6.setVisibility(View.GONE);
        text7.setVisibility(View.GONE);
        text8.setVisibility(View.GONE);
        text9.setVisibility(View.GONE);

        edit1.setVisibility(View.GONE);
        edit2.setVisibility(View.GONE);
        edit3.setVisibility(View.GONE);
        edit4.setVisibility(View.GONE);
        edit5.setVisibility(View.GONE);
        edit6.setVisibility(View.GONE);
        edit7.setVisibility(View.GONE);
        edit8.setVisibility(View.GONE);

        sm1.setVisibility(View.GONE);
        sm2.setVisibility(View.GONE);
        sm3.setVisibility(View.GONE);
        sm4.setVisibility(View.GONE);
        sm5.setVisibility(View.GONE);
        sm6.setVisibility(View.GONE);
        sm7.setVisibility(View.GONE);

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        layout4.setVisibility(View.GONE);
        layout5.setVisibility(View.GONE);
        layout6.setVisibility(View.GONE);
        layout7.setVisibility(View.GONE);
        layout8.setVisibility(View.GONE);

        layout9.setVisibility(View.GONE);
        layout10.setVisibility(View.GONE);
        layout11.setVisibility(View.GONE);
        layout12.setVisibility(View.GONE);
        layout13.setVisibility(View.GONE);
        layout14.setVisibility(View.GONE);
        layout15.setVisibility(View.GONE);
        layout16.setVisibility(View.GONE);
    }

    void showParam(ImageButton button, Spinner spinner,
                   TextView text1, TextView text2, TextView text3, TextView text4, TextView text5, TextView text6, TextView text7, TextView text8, TextView text9,
                   EditText edit1, EditText edit2, EditText edit3, EditText edit4, EditText edit5, EditText edit6, EditText edit7, EditText edit8,
                   TextView sm1, TextView sm2, TextView sm3, TextView sm4, TextView sm5, TextView sm6, TextView sm7,
                   LinearLayout layout1, LinearLayout layout2, LinearLayout layout3, LinearLayout layout4, LinearLayout layout5, LinearLayout layout6, LinearLayout layout7, LinearLayout layout8,
                   LinearLayout layout9, LinearLayout layout10, LinearLayout layout11, LinearLayout layout12, LinearLayout layout13, LinearLayout layout14, LinearLayout layout15, LinearLayout layout16,
                   LinearLayout layout17, LinearLayout layout18) {
        button.setVisibility(View.VISIBLE);

        spinner.setVisibility(View.VISIBLE);

        text1.setVisibility(View.VISIBLE);
        text2.setVisibility(View.VISIBLE);
        text3.setVisibility(View.VISIBLE);
        text4.setVisibility(View.VISIBLE);
        text5.setVisibility(View.VISIBLE);
        text6.setVisibility(View.VISIBLE);
        text7.setVisibility(View.VISIBLE);
        text8.setVisibility(View.VISIBLE);
        text9.setVisibility(View.VISIBLE);

        edit1.setVisibility(View.VISIBLE);
        edit2.setVisibility(View.VISIBLE);
        edit3.setVisibility(View.VISIBLE);
        edit4.setVisibility(View.VISIBLE);
        edit5.setVisibility(View.VISIBLE);
        edit6.setVisibility(View.VISIBLE);
        edit7.setVisibility(View.VISIBLE);
        edit8.setVisibility(View.VISIBLE);

        sm1.setVisibility(View.VISIBLE);
        sm2.setVisibility(View.VISIBLE);
        sm3.setVisibility(View.VISIBLE);
        sm4.setVisibility(View.VISIBLE);
        sm5.setVisibility(View.VISIBLE);
        sm6.setVisibility(View.VISIBLE);
        sm7.setVisibility(View.VISIBLE);

        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.VISIBLE);
        layout3.setVisibility(View.VISIBLE);
        layout4.setVisibility(View.VISIBLE);
        layout5.setVisibility(View.VISIBLE);
        layout6.setVisibility(View.VISIBLE);
        layout7.setVisibility(View.VISIBLE);
        layout8.setVisibility(View.VISIBLE);
        layout9.setVisibility(View.VISIBLE);
        layout10.setVisibility(View.VISIBLE);

        layout11.setVisibility(View.VISIBLE);
        layout12.setVisibility(View.VISIBLE);
        layout13.setVisibility(View.VISIBLE);
        layout14.setVisibility(View.VISIBLE);
        layout15.setVisibility(View.VISIBLE);
        layout16.setVisibility(View.VISIBLE);
        layout17.setVisibility(View.VISIBLE);
        layout18.setVisibility(View.VISIBLE);
    }

    void hideInfo(ImageButton button,
                  TextView text1, TextView text2, TextView text3, TextView text4,
                  EditText edit1, EditText edit2, EditText edit3, EditText edit4,
                  EditText edit5, EditText edit6, EditText edit7, EditText edit8,
                  EditText edit9, EditText edit10, EditText edit11,
                  TextView toch1, TextView toch2, TextView toch3, TextView toch4,
                  TextView toch5, TextView toch6, TextView toch7, TextView toch8, TextView toch9,
                  LinearLayout layout1, LinearLayout layout2, LinearLayout layout3) {
        button.setVisibility(View.GONE);

        text1.setVisibility(View.GONE);
        text2.setVisibility(View.GONE);
        text3.setVisibility(View.GONE);
        text4.setVisibility(View.GONE);

        edit1.setVisibility(View.GONE);
        edit2.setVisibility(View.GONE);
        edit3.setVisibility(View.GONE);
        edit4.setVisibility(View.GONE);
        edit5.setVisibility(View.GONE);
        edit6.setVisibility(View.GONE);
        edit7.setVisibility(View.GONE);
        edit8.setVisibility(View.GONE);
        edit9.setVisibility(View.GONE);
        edit10.setVisibility(View.GONE);
        edit11.setVisibility(View.GONE);

        toch1.setVisibility(View.GONE);
        toch2.setVisibility(View.GONE);
        toch3.setVisibility(View.GONE);
        toch4.setVisibility(View.GONE);
        toch5.setVisibility(View.GONE);
        toch6.setVisibility(View.GONE);
        toch7.setVisibility(View.GONE);
        toch8.setVisibility(View.GONE);
        toch9.setVisibility(View.GONE);

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
    }

    void showInfo(ImageButton button,
                  TextView text1, TextView text2, TextView text3, TextView text4,
                  EditText edit1, EditText edit2, EditText edit3, EditText edit4,
                  EditText edit5, EditText edit6, EditText edit7, EditText edit8,
                  EditText edit9, EditText edit10, EditText edit11,
                  TextView toch1, TextView toch2, TextView toch3, TextView toch4,
                  TextView toch5, TextView toch6, TextView toch7, TextView toch8, TextView toch9,
                  LinearLayout layout1, LinearLayout layout2, LinearLayout layout3) {
        button.setVisibility(View.VISIBLE);

        text1.setVisibility(View.VISIBLE);
        text2.setVisibility(View.VISIBLE);
        text3.setVisibility(View.VISIBLE);
        text4.setVisibility(View.VISIBLE);

        edit1.setVisibility(View.VISIBLE);
        edit2.setVisibility(View.VISIBLE);
        edit3.setVisibility(View.VISIBLE);
        edit4.setVisibility(View.VISIBLE);
        edit5.setVisibility(View.VISIBLE);
        edit6.setVisibility(View.VISIBLE);
        edit7.setVisibility(View.VISIBLE);
        edit8.setVisibility(View.VISIBLE);
        edit9.setVisibility(View.VISIBLE);
        edit10.setVisibility(View.VISIBLE);
        edit11.setVisibility(View.VISIBLE);

        toch1.setVisibility(View.VISIBLE);
        toch2.setVisibility(View.VISIBLE);
        toch3.setVisibility(View.VISIBLE);
        toch4.setVisibility(View.VISIBLE);
        toch5.setVisibility(View.VISIBLE);
        toch6.setVisibility(View.VISIBLE);
        toch7.setVisibility(View.VISIBLE);
        toch8.setVisibility(View.VISIBLE);
        toch9.setVisibility(View.VISIBLE);

        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.VISIBLE);
        layout3.setVisibility(View.VISIBLE);
    }

    // Внизу хороши  метод для показывания клавиутуры , простестировать, переработать, так что бы можно было одной строчкой вызывать из класса

//    private void showKey(EditText editText) {
//        editText.requestFocus();
//        editText.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                keyboard.showSoftInput(editText, 0);
//            }
//        }, 200);
//    }


}