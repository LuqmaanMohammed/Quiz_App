package com.example.quizzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button back = findViewById(R.id.button3);

        back.setOnClickListener(v -> {
            Intent iBack = new Intent(About.this, MainActivity.class);
            startActivity(iBack);
        });
    }
}