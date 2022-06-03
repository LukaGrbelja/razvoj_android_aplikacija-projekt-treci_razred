package com.example.razvoj_android_aplikacija_projekt_treci_razred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase.User;
import com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase.UserDataBase;

import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    EditText firstInput, secondInput;
    Button submit;

    UserDataBase userDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstInput = findViewById(R.id.editTextTextPersonName);
        secondInput = findViewById(R.id.editTextTextPersonName2);
        submit = findViewById(R.id.button2);

        userDataBase = UserDataBase.getDatabase(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userDataBase.userDao().getUserNames().observe(RegistrationActivity.this, new Observer<List<String>>() {
                    @Override
                    public void onChanged(List<String> usernames) {

                        if (usernames.indexOf(firstInput.getText().toString()) != -1) {

                            Toast.makeText(RegistrationActivity.this, "Korisnicko ime zauzeto!", Toast.LENGTH_SHORT).show();
                            firstInput.requestFocus();

                        }
                        else {

                            userDataBase.userDao().insertNewUser(new User(firstInput.getText().toString(), secondInput.getText().toString()));
                            Intent registrationIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                            startActivity(registrationIntent);

                        }

                    }
                });

            }
        });

    }
}