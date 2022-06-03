package com.example.razvoj_android_aplikacija_projekt_treci_razred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.button);
        login = findViewById(R.id.button3);

        register.setOnClickListener(view -> {

            Intent registrationIntent = new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(registrationIntent);

        });

        login.setOnClickListener(view -> {

            Intent loginIntent = new Intent(MainActivity.this, LogInActivity.class);
            startActivity(loginIntent);

        });

    }
}