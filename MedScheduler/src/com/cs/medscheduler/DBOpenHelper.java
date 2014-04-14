package com.cs.medscheduler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "medical_scheduler.db";
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    private SQLiteDatabase mDatabase;

    public DBOpenHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate (SQLiteDatabase db)
    {
        mDatabase = db;
        Log.d(DBOpenHelper.class.getName(), "Creating person table.");
        mDatabase.execSQL(DB.SQL_CREATE_PERSON_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating demographics table.");
        mDatabase.execSQL(DB.SQL_CREATE_DEMOGRAPHICS_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating conditions table.");
        mDatabase.execSQL(DB.SQL_CREATE_CONDITIONS_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating provider table.");
        mDatabase.execSQL(DB.SQL_CREATE_PROVIDER_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating visit table.");
        mDatabase.execSQL(DB.SQL_CREATE_VISIT_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating services table.");
        mDatabase.execSQL(DB.SQL_CREATE_SERVICES_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating appointments table.");
        mDatabase.execSQL(DB.SQL_CREATE_APPOINTMENTS_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating location table.");
        mDatabase.execSQL(DB.SQL_CREATE_LOCATION_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating notifications table.");
        mDatabase.execSQL(DB.SQL_CREATE_NOTIFICATIONS_TABLE);

        Log.d(DBOpenHelper.class.getName(), "Creating notes table.");
        mDatabase.execSQL(DB.SQL_CREATE_NOTES_TABLE);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(DB.SQL_DELETE_NOTES_TABLE);
        db.execSQL(DB.SQL_DELETE_NOTIFICATIONS_TABLE);
        db.execSQL(DB.SQL_DELETE_LOCATION_TABLE);
        db.execSQL(DB.SQL_DELETE_APPOINTMENTS_TABLE);
        db.execSQL(DB.SQL_DELETE_SERVICES_TABLE);
        db.execSQL(DB.SQL_DELETE_VISIT_TABLE);
        db.execSQL(DB.SQL_DELETE_PROVIDER_TABLE);
        db.execSQL(DB.SQL_DELETE_CONDITIONS_TABLE);
        db.execSQL(DB.SQL_DELETE_DEMOGRAPHICS_TABLE);
        db.execSQL(DB.SQL_DELETE_PERSON_TABLE);
        onCreate(db);
    }

    public void onDowngrade (SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }
}
