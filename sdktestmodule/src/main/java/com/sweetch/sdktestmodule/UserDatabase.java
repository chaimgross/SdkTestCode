package com.sweetch.sdktestmodule;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sweetch.core.db.dao.BaseDao;
import com.sweetch.core.db.entity.BaseEntity;

@Database(entities = {BaseEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static String DATABASE = "DemoAppDatabase";
    private static UserDatabase instance;

    public static UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDatabase.class,
                    DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    //public abstract BaseDao getBaseDao();
   // public abstract UserDAO getUserDao();
}