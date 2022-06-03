package com.example.razvoj_android_aplikacija_projekt_treci_razred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase.User;
import com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase.UserDataBase;

import java.util.ArrayList;
import java.util.List;

public class LogInActivity extends AppCompatActivity {

    EditText firstInput, secondInput;
    Button login;

    UserDataBase userDataBase;
    ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        firstInput = findViewById(R.id.editTextTextPersonName3);
        secondInput = findViewById(R.id.editTextTextPersonName4);
        login = findViewById(R.id.button4);

        userDataBase = UserDataBase.getDatabase(this);

        userArrayList = new ArrayList<>();

        userDataBase.userDao().getUsers().observe(LogInActivity.this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {


                userArrayList.addAll(users);


            }
        });

        login.setOnClickListener(view -> {

            String firstInputValue = firstInput.getText().toString();
            String secondInputValue = secondInput.getText().toString();

            for (User user : userArrayList) {

                if (user.getUserName().equals(firstInputValue) && user.getPassWord().equals(secondInputValue)) {

                    Intent login = new Intent(LogInActivity.this, MainGameActivity.class);
                    login.putExtra("username", user.getUserName());
                    startActivity(login);

                }

            }

        });

    }
}