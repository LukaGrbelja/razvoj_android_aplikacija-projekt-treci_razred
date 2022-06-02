package com.example.razvoj_android_aplikacija_projekt_treci_razred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase.User;
import com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase.UserDataBase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button submit;
    ListView listView;

    UserDataBase userDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.button);
        listView = findViewById(R.id.listview);

        userDataBase = UserDataBase.getDatabase(this);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        

                    }
                }
        );


        userDataBase.userDao().getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

                ArrayList<String> usernames = new ArrayList<>();
                for (User user : users) {

                    usernames.add("Korisnicko ime: " + user.getUserName() + "\nLozinka: " + user.getPassWord());

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.list_item,usernames);
                listView.setAdapter(adapter);


            }
        });

    }
}