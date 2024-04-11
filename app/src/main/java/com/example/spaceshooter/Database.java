package com.example.spaceshooter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper{

    public static final String databaseName = "account.db";
    public Database(@Nullable Context context) {
        super(context, "account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table allusers(username text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists allusers");
    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = db.insert("allusers", null, contentValues);

        return result != -1;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from allusers Where username = ?",
                new String[]{username});

        return cursor.getCount() > 0;
    }

    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from allusers Where username = ? and password = ?",
                new String[]{username, password});

        return cursor.getCount() > 0;
    }
}
