package com.example.shoppinglistapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBProduct {
    public static final String DBNAME = "mdata.db";
    public static final String TABLENAME = "product";
    public static final int VERSION = 1;

    SQLiteDatabase sqLiteDatabase;
    public DBProduct(@Nullable Context context) {
        OpenHelper mOpenHelper = new OpenHelper(context);
        sqLiteDatabase = mOpenHelper.getWritableDatabase();
    }

    private class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DBNAME, null, VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "create table " + TABLENAME + "(id integer primary key, product text)";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
            onCreate(db);
        }
    }
}
