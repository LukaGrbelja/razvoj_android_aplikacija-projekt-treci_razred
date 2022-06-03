package com.example.razvoj_android_aplikacija_projekt_treci_razred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainGameActivity extends AppCompatActivity {

    TextView welcomeText;
    Button start;

    Resources diffs;
    ArrayAdapter<String> list;
    AutoCompleteTextView drop;

    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        welcomeText = findViewById(R.id.textView2);
        start = findViewById(R.id.button5);

        Intent intent = getIntent();
        userName = intent.getStringExtra("username");

        welcomeText.setText(String.format("Dobrodosao %s",userName));

        drop = findViewById(R.id.autoCompleteTextView);
        diffs = getResources();
        list = new ArrayAdapter<>(
                MainGameActivity.this,
                R.layout.difficulty_item,
                diffs.getStringArray(R.array.diff)
        );
        drop.setAdapter(list);

        start.setOnClickListener(view -> {



        });

    }
}