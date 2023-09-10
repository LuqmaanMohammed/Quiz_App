package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
Button about,start;
EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        start = findViewById(R.id.button);
        about = findViewById(R.id.button2);
        et = findViewById(R.id.editTextText);

        about.setOnClickListener(v -> {
            Intent iAbout = new Intent(MainActivity.this, About.class);
            startActivity(iAbout);
        });
start.setOnClickListener(v -> {
            Intent iAbout = new Intent(MainActivity.this, quizPage.class);
            String txt = et.getText().toString().trim();
    if(txt.isEmpty())
    {
        Toast.makeText(getApplicationContext(),"Please Enter your Name",Toast.LENGTH_LONG).show();
    }
            else
            {
                iAbout.putExtra("msg",txt);
            startActivity(iAbout);
            }
        });


    }


}