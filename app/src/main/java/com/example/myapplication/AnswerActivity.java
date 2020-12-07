package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private boolean isAnswerTrue; //создаем переменную
    private TextView textAnswer; //создаем переменную для кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

// прочитать ответ Intent
isAnswerTrue = getIntent().getBooleanExtra("answer",false);//обращаемся к интенту

//действие на экран Верно / не верно
        textAnswer = findViewById(R.id.textAnswer);
        textAnswer.setText(isAnswerTrue?R.string.correct:R.string.incorrect);
    }
}