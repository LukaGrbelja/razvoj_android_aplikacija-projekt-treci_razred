package com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDataAccessObject {

    @Query("SELECT user_name FROM user_table")
    LiveData<List<String>> getUserNames();

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getUsers();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNewUser(User user);

    @Query("SELECT * FROM user_table WHERE user_name = :username")
    User foundUser(String username);

}
