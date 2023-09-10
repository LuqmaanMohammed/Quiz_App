package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quizPage extends AppCompatActivity {
    TextView tv;
    Button nxtqn,quit;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String qns[]={
            "Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the current object that invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?"
    };
    String ans[]={"main method","this","public","import pkg.*","None of the mentioned"};
    String opt[]={
            "finalize method","main method","static method","private method",
            "import","this","catch","abstract",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage);



        final TextView score=(TextView) findViewById(R.id.textView10);
        TextView textView=(TextView) findViewById(R.id.DispName);
        Intent intent=getIntent();
        String name=intent.getStringExtra("msg");

        if(name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello "+name);

        tv=(TextView)findViewById(R.id.tvque);
        nxtqn=(Button) findViewById(R.id.button4);
        quit=(Button)findViewById(R.id.button5);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton2);
        rb2=(RadioButton)findViewById(R.id.radioButton3);
        rb3=(RadioButton)findViewById(R.id.radioButton4);
        rb4=(RadioButton)findViewById(R.id.radioButton5);
        tv.setText(qns[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        nxtqn.setOnClickListener(v -> {

            if(radio_g.getCheckedRadioButtonId()==-1){
                Toast.makeText(getApplicationContext(),"Please select one choice",Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton vans=(RadioButton) findViewById(radio_g.getCheckedRadioButtonId());

            String ansText=vans.getText().toString();

            if(ansText.equals(ans[flag])){
                correct++;
                Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
            }
            else{
                wrong++;
                Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
            }

            flag++;

            if(score != null)
                score.setText("" + correct);

            if(flag<qns.length){
                tv.setText(qns[flag]);
                rb1.setText(opt[flag*4]);
                rb2.setText(opt[flag*4+1]);
                rb3.setText(opt[flag*4+2]);
                rb4.setText(opt[flag*4+3]);
            }
            else{
                marks=correct;
                Intent intent1=new Intent(getApplicationContext(),FinalActivity.class);
                startActivity(intent1);
            }
            radio_g.clearCheck();
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(), FinalActivity.class);
                startActivity(intent2);
            }
        });

    }
}