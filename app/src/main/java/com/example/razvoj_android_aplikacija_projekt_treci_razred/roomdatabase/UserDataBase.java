package com.example.razvoj_android_aplikacija_projekt_treci_razred.roomdatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, exportSchema = false, version = 1)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDataAccessObject userDao();

    private static volatile UserDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized UserDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    UserDataBase.class, "user_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addCallback(userDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback userDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {

                UserDataAccessObject dao = INSTANCE.userDao();

                User userOne = new User("Luka","password123");
                dao.insertNewUser(userOne);
                User userTwo = new User("KorisnikAnon","anon2918");
                dao.insertNewUser(userTwo);

            });
        }
    };

}
