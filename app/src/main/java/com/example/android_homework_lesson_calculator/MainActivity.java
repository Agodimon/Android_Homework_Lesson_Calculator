package com.example.android_homework_lesson_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    private static final String KEY_VALUE = "key_value";
    private static final String KEY_OPERATOR = "key_operator";
    private static final String KEY_RESULT = "key_result";
    private Button btnNumberOne;
    private Button btnNumberTwo;
    private Button btnNumberThree;
    private Button btnNumberFour;
    private Button btnNumberFive;
    private Button btnNumberSix;
    private Button btnNumberSeven;
    private Button btnNumberEight;
    private Button btnNumberNine;
    private Button btnNumberDot;
    private Button btnNumberZero;
    private TextView txtResult;
    private double valueBuffer;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operator = '1';
        valueBuffer = 0;
        txtResult = findViewById(R.id.txt);
        Button clearNum = findViewById(R.id.clear);

        initButton();

        clearNum.setOnClickListener(view -> {
            valueBuffer = 0;
            txtResult.setText("");
        });
        Button ans = findViewById(R.id.button_equals);
        ans.setOnClickListener(view -> {
            switch (operator) {
                case '+':
                    valueBuffer += Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
                case '-':
                    valueBuffer -= Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
                case '/':
                    valueBuffer /= Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
                case '*':
                    valueBuffer *= Double.parseDouble(txtResult.getText().toString());
                    txtResult.setText(String.valueOf(valueBuffer));
                    break;
            }

            operator = 0;
        });
    }

    private void initButton() {
        btnNumberOne = findViewById(R.id.button1);
        btnNumberOne.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 1;
            txtResult.setText(value);
        });

        btnNumberTwo = findViewById(R.id.button2);
        btnNumberTwo.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 2;
            txtResult.setText(value);
        });

        btnNumberThree = findViewById(R.id.button3);
        btnNumberThree.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 3;
            txtResult.setText(value);
        });

        btnNumberFour = findViewById(R.id.button4);
        btnNumberFour.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 4;
            txtResult.setText(value);
        });

        btnNumberFive = findViewById(R.id.button5);
        btnNumberFive.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 5;
            txtResult.setText(value);
        });

        btnNumberSix = findViewById(R.id.button6);
        btnNumberSix.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 6;
            txtResult.setText(value);
        });

        btnNumberSeven = findViewById(R.id.button7);
        btnNumberSeven.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 7;
            txtResult.setText(value);
        });

        btnNumberEight = findViewById(R.id.button8);
        btnNumberEight.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 8;
            txtResult.setText(value);
        });

        btnNumberNine = findViewById(R.id.button9);
        btnNumberNine.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 9;
            txtResult.setText(value);
        });

        btnNumberDot = findViewById(R.id.button_point);
        btnNumberDot.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + ".";
            txtResult.setText(value);
        });

        btnNumberZero = findViewById(R.id.button0);
        btnNumberZero.setOnClickListener(v -> {
            String value = txtResult.getText().toString() + 0;
            txtResult.setText(value);
        });

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putDouble(KEY_VALUE, valueBuffer);
        instanceState.putString(KEY_RESULT, txtResult.getText().toString());
        instanceState.putChar(KEY_OPERATOR, operator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        double value = instanceState.getDouble(KEY_VALUE);
        String result = instanceState.getString(KEY_RESULT);
        char operator = instanceState.getChar(KEY_OPERATOR);
        setConfig(value, result, operator);
    }

    private void setConfig(double value, String result, char operator) {
        valueBuffer = value;
        if (operator != 0) {
            this.operator = operator;
        }

        txtResult.setText(result);
    }



    public void ops(View view) {
        valueBuffer = Double.parseDouble(txtResult.getText().toString());
        Button button = (Button) view;
        operator = button.getText().charAt(0);
        txtResult.setText("");
    }
}