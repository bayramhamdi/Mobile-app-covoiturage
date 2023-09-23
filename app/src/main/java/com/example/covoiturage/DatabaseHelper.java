package com.example.covoiturage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="IDU.db";
    public static final String TABLE_NAME="IDU";


    //COLS



    public static final String COLS_1="TELEPHONE";
    public static final String COLS_2="DATE";
    public static final String COLS_3="DEPART";
    public static final String COLS_4="ARRIVE";
    public static final String COLS_5="NBRE_PASSAGE";

   public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "(TELEPHONE INTEGER PRIMARY KEY , DATE TEXT, DEPART TEXT, ARRIVE TEXT, NBRE_PASSAGE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}



