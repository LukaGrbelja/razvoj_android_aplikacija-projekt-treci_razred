package com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "pass_word")
    private String passWord;

    public User(@NonNull String userName, String passWord) {

        this.userName = userName;
        this.passWord = passWord;

    }

    @NonNull
    public String getUserName() {

        return userName;

    }

    public String getPassWord() {

        return passWord;

    }

}
