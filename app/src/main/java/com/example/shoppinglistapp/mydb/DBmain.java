package com.example.shoppinglistapp.mydb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {
    public static final String DBNAME="products";
    public static final String TABLE_NAME="nameProduct";
    public static final int VER=3;

    public DBmain(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+TABLE_NAME+"(id integer primary key, name text)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="drop table if exists "+TABLE_NAME+"";
        db.execSQL(query);
    }
}
