package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private TextView textView; //создаем переменную для смены вопросов с 1 по 5-й
private Button yesBtn;
private Button noBtn;
private Button showAnswer;


private Questions[] questions = new Questions[]{ //создаем массив
        new Questions(R.string.questions1, true),//вопрос 0. Определяем правильные ответы через запятую
        new Questions(R.string.questions2, false),//вопрос 1.
        new Questions(R.string.questions3, false),//вопрос 2.
        new Questions(R.string.questions4, true),//вопрос 3.
        new Questions(R.string.questions5, true),//вопрос 4.
};

private int questionIndex = 0; //с какого номера вопроса начинаем
    private ArrayList<String> resTest = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) { // у метода onCreate есть хранилище(список) Bundle savedInstanceState
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) { //Если он равен null(пусто) это значит приложение только запустили.
            questionIndex = savedInstanceState.getInt("questionIndex");//запрашиваю questionIndex из savedInstanceState
        }

        textView = findViewById(R.id.textView); //присваем переменную(кнопку) в @Override
        yesBtn = findViewById(R.id.yesBtn);//присваем переменную(кнопку) в @Override
        noBtn = findViewById(R.id.noBtn);
        showAnswer = findViewById(R.id.showAnswer); //присваем переменную(кнопку) в @Override

// кнопка да
        textView.setText(questions[questionIndex].getQuestionResId()); //устанавливаем вопросы подробно 1434_27_11_2020_part2 в 1:09
        yesBtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (questions[questionIndex].isAnswerTrue()) {
                                              Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                                              resTest.add(getString(R.string.correct));
                                          } else {

                                              Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                                              resTest.add(getString(R.string.incorrect));

                                          }
                                          if (questionIndex == questions.length-1) {
                                              System.out.println(resTest);
                                              Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                              intent.putExtra("resTest", resTest);
                                              startActivity(intent);
                                          } else if (questionIndex < questions.length-1) {


                                              questionIndex++;
                                              textView.setText(questions[questionIndex].getQuestionResId());
                                          }
                                      }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if (questions[questionIndex].isAnswerTrue()) {
                                            Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                                            resTest.add(getString(R.string.incorrect));
                                        } else {
                                            Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                                            resTest.add(getString(R.string.correct));
                                        }

                                        if (questionIndex == questions.length-1) {
                                            System.out.println(resTest);
                                            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                            intent.putExtra("resTest", resTest);
                                            startActivity(intent);
                                        } else if (questionIndex < questions.length-1) {


                                            questionIndex++;
                                            textView.setText(questions[questionIndex].getQuestionResId());
                                        }
            }
        });

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }

/*    @Override
    public void onStart() {
        super.onStart();
        Log.d("SYSTEM INFO", "Метод onStart() запущен");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("SYSTEM INFO", "Метод onResume() запущен");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("SYSTEM INFO", "Метод onPause() запущен");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) { // Метод сохранения данных перед уничтожением активности
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO", "Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex", questionIndex); // Добавили элемент по ключу
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("SYSTEM INFO", "Метод onStop() запущен");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SYSTEM INFO", "Метод onDestroy() запущен");
    }*/
}