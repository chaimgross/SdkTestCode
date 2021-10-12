package com.sweetch.sdktestmodule;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDAO {
    @Insert
    void insertUserData(User user);
}
