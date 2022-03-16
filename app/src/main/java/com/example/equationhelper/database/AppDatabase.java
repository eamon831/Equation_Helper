package com.example.equationhelper.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.equationhelper.Converter;

@Database(entities = {User.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}