package com.application.littlehabit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySqliteHelper extends SQLiteOpenHelper {

    public MySqliteHelper(Context context) {
        super(context, "LittleHabit.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("tag", "+++++++++++onCreate++++++++++");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
