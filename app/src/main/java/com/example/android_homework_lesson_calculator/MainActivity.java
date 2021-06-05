package com.example.android_homework_lesson_calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    TextView txt;
    double buffer;
    char op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op='1';
        buffer=0;
        txt=findViewById(R.id.txt);
        Button clearNum=findViewById(R.id.clear);
        clearNum.setOnClickListener(view->{
            buffer=0;
            txt.setText("");
        });
        Button ans=findViewById(R.id.button_equals);
        ans.setOnClickListener(view->{
            switch (op){
                case '+':
                    buffer+=Double.parseDouble(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '-':
                    buffer-=Double.parseDouble(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '/':
                    buffer/=Double.parseDouble(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '*':
                    buffer*=Double.parseDouble(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
            }
        });
    }
    @SuppressLint("SetTextI18n")
    public void appendText(View view){
        Button button=(Button) view;
    txt.setText(txt.getText().toString()+button.getText().toString());
    }
    public void ops(View view){
    buffer=Double.parseDouble(txt.getText().toString());
        Button button=(Button) view;
        op= button.getText().charAt(0);
        txt.setText("");
    }
}