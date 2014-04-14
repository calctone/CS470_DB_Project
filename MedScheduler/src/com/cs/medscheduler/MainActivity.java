package com.cs.medscheduler;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.cs.medscheduler.entity.PersonEntity;
import com.example.medscheduler.R;

public class MainActivity extends Activity
{
    private DBOpenHelper mDBHelper;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDBHelper = new DBOpenHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void insertPerson (PersonEntity personEntity)
    {
        Log.d(MainActivity.class.getName(), "Inserting person: " + personEntity.toString());

        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB.Person.COLUMN_NAME_FIRST_NAME, personEntity.getFirstName());
        values.put(DB.Person.COLUMN_NAME_MIDDLE_INIT, personEntity.getMInit());
        values.put(DB.Person.COLUMN_NAME_LAST_NAME, personEntity.getLastName());
        values.put(DB.Person.COLUMN_NAME_SSN, personEntity.getSSN());

        long insertId = db.insert(DB.Person.TABLE_NAME, "null", values);
        String[] projection = { DB.Person._ID, DB.Person.COLUMN_NAME_FIRST_NAME,
                DB.Person.COLUMN_NAME_MIDDLE_INIT, DB.Person.COLUMN_NAME_LAST_NAME,
                DB.Person.COLUMN_NAME_SSN };

        Cursor cursor = db.query(DB.Person.TABLE_NAME, projection,
                DB.Person._ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();

        PersonEntity entity = cursorToPerson(cursor);
        cursor.close();

        Log.d(MainActivity.class.getName(),
                "Successfully inserted person with ID: " + entity.getId());
    }

    private PersonEntity cursorToPerson (Cursor c)
    {
        PersonEntity entity = new PersonEntity();
        if (c != null && !c.isAfterLast())
        {
            entity.setId(c.getInt(0));
        }

        return entity;
    }
}
