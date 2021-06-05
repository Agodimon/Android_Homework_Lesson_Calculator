package com.example.android_homework_lesson_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
    }
    @SuppressLint("SetTextI18n")
    public void appendText(View view){
        Button button=(Button) view;
    txt.setText(txt.getText().toString()+button.getText().toString());
    }
}