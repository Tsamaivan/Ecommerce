package com.example.fatuma.jpapp;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Order.class},version = 1, exportSchema = false)
public abstract class JpDatabase extends RoomDatabase {

    public abstract OrderDao orderDao();
}
