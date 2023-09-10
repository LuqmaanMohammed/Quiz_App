package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class FinalActivity extends AppCompatActivity {
    Button restart;
    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        restart= findViewById(R.id.button6);
        txt1= findViewById(R.id.textView4);
        txt2= findViewById(R.id.textView5);
        txt3= findViewById(R.id.textView6);


        StringBuffer str1=new StringBuffer();
        str1.append("Correct Answers: ").append(quizPage.correct).append("\n");
        StringBuffer str2=new StringBuffer();
        str2.append("Wrong Answers: ").append(quizPage.wrong).append("\n");
        StringBuffer str3=new StringBuffer();
        str3.append("Final Score: ").append(quizPage.marks).append("\n");

        txt1.setText(str1);
        txt2.setText(str2);
        txt3.setText(str3);
         quizPage.correct=0;
         quizPage.wrong=0;
         quizPage.marks=0;

        restart.setOnClickListener(v -> {
            Intent intent1=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent1);
        });
    }
}