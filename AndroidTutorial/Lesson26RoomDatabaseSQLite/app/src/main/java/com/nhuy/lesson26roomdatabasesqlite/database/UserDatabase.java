package com.nhuy.lesson26roomdatabasesqlite.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.nhuy.lesson26roomdatabasesqlite.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "user.db";
    private static UserDatabase instance;

    //Viết hàm khởi tạo cho instance
    public static synchronized UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();
}
