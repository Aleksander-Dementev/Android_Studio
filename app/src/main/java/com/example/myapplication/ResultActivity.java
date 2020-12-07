package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
ArrayList<String> resTest = new ArrayList<>();
TextView textViewResTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewResTest = findViewById(R.id.textViewResTest);
        resTest =getIntent().getStringArrayListExtra("resTest");
        String string = "";
        int i = 1;

        for (String str : resTest) {

            string = string + "\n" + i + "-й вопрос: " + str;
            i++;
        }


        textViewResTest.setText(string);


    }
}