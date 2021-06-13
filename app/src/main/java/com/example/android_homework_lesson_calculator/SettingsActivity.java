package com.example.android_homework_lesson_calculator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;

import static com.example.android_homework_lesson_calculator.Const.AppTheme;
import static com.example.android_homework_lesson_calculator.Const.AppThemeCodeStyle;
import static com.example.android_homework_lesson_calculator.Const.AppThemeLightCodeStyle;
import static com.example.android_homework_lesson_calculator.Const.MyCoolCodeStyle;
import static com.example.android_homework_lesson_calculator.Const.NameSharedPreference;


public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_settings);

        initThemeChooser();

        ImageButton btnReturn = findViewById(R.id.imageButton);
        btnReturn.setOnClickListener(v -> {
            // Метод finish() завершает активити
//            setResult(RESULT_OK);
            setResult(Activity.RESULT_OK);
            finish();
        });

    }


    private int getAppTheme() {
        return codeStyleToStyleId(getCodeStyle(R.style.dark_theme));
    }

    // Инициализация радиокнопок
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radio_btn_dark_theme), MyCoolCodeStyle);
        initRadioButton(findViewById(R.id.radio_btn_orange_theme), AppThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radio_btn_light_theme), AppThemeCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(MyCoolCodeStyle))).setChecked(true);
    }

    // Все инициализации кнопок очень похожи, поэтому создадим метод для
    //переиспользования
    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(v -> {
// сохраним настройки
            setAppTheme(codeStyle);
// пересоздадим активити, чтобы тема применилась
            recreate();
        });
    }

    // Сохранение настроек
    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference,
                MODE_PRIVATE);
// Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeCodeStyle:
                return R.style.orange_theme;
            case AppThemeLightCodeStyle:
                return R.style.light_theme;
            default:
                return R.style.dark_theme;
        }
    }

    // Чтение настроек, параметр «тема»
    private int getCodeStyle(int codeStyle) {
// Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference,
                MODE_PRIVATE);
//Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(AppTheme, codeStyle);
    }
}