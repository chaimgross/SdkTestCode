package com.sweetch.sdktestmodule;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
@Entity(tableName = "Users")
public class User {

    public User(String fullName, String age) {
        this.fullName = fullName;
        this.age = age;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "FullName")
    private String fullName;

    @ColumnInfo(name = "age")
    private String age;

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

