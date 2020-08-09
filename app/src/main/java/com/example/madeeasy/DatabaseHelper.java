package com.example.madeeasy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.madeeasy.DatabaseContract.USERS.TABLE_NAME;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RestaurantData.db";
    private static final String CREATE_USER_TABLE = "CREATE TABLE "
            + DatabaseContract.USERS.TABLE_NAME + "("
            + DatabaseContract.USERS.COL_NAME+ " TEXT NOT NULL,"
            + DatabaseContract.USERS.COL_EMAIL+ " TEXT NOT NULL UNIQUE,"
            + DatabaseContract.USERS.COL_PASSWORD + " TEXT NOT NULL)";

    private static final String CREATE_USER1_TABLE = "CREATE TABLE "
            + DatabaseContract.USERS1.TABLE_NAME + "("
            + DatabaseContract.USERS1.COL_NAME+ " TEXT NOT NULL,"
            + DatabaseContract.USERS1.COL_FEEDBACK + " TEXT NOT NULL)";

    private static final String CREATE_USER2_TABLE = "CREATE TABLE "
            + DatabaseContract.USERS2.TABLE_NAME + "("
            + DatabaseContract.USERS2.COL_RNAME+ " TEXT NOT NULL,"
            + DatabaseContract.USERS2.COL_TIME+ " TEXT NOT NULL,"
            + DatabaseContract.USERS2.COL_DISCRIPTION+ " TEXT NOT NULL,"
            + DatabaseContract.USERS2.COL_INGREDIENTS+ " TEXT NOT NULL,"
            + DatabaseContract.USERS2.COL_METHOD + " TEXT NOT NULL)";


    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME ;
    private String DROP_USER1_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME ;
    private String DROP_USER2_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME ;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_USER1_TABLE);
        db.execSQL(CREATE_USER2_TABLE);


        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_USER1_TABLE);
        db.execSQL(DROP_USER2_TABLE);
        onCreate(db);
    }

}