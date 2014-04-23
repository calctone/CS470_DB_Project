package com.cs.medscheduler;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.TextView;

@SuppressWarnings("javadoc")
public class ProvidersActivity extends Activity
{
    public static final String TAG = "ProvidersActivity";

    private DBOpenHelper mDBHelper;
    private TextView mProvs;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called.");
        setContentView(R.layout.providerlist);

        mDBHelper = ((MedSchedulerApplication) getApplication()).getDBHelper();

        mProvs = (TextView) findViewById(R.id.txtProviders);

        String[] projection = { BaseColumns._ID, DB.Provider.COLUMN_NAME_NAME,
                DB.Provider.COLUMN_NAME_PHONE };

        String s = new String("");
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor c = db.query(DB.Provider.TABLE_NAME, projection, null, null, null, null, null);

        while (c.moveToNext())
        {
            int provId = c.getInt(0);
            s += c.getString(1) + " ";
            s += " Phone: " + c.getString(2);
            s += " \n";

            String[] projection2 = { BaseColumns._ID, DB.Location.COLUMN_NAME_STREET,
                    DB.Location.COLUMN_NAME_CITY, DB.Location.COLUMN_NAME_STATE,
                    DB.Location.COLUMN_NAME_COUNTRY, DB.Location.COLUMN_NAME_ZIP };
            Cursor c2 = db.query(DB.Location.TABLE_NAME, projection2,
                    DB.Location.COLUMN_NAME_PROVIDERID + " = " + provId, null, null, null, null);
            while (c2.moveToNext())
            {
                s += c2.getString(1) + " ";
                s += c2.getString(2) + " ";
                s += c2.getString(3) + " ";
                s += c2.getString(4) + " ";
                s += c2.getString(5);
                s += " \n";
            }

            String[] projection3 = { BaseColumns._ID, DB.Services.COLUMN_NAME_PROVIDERID,
                    DB.Services.COLUMN_NAME_DESCRIPTION, DB.Services.COLUMN_NAME_COST };
            Cursor c3 = db.query(DB.Services.TABLE_NAME, projection3,
                    DB.Services.COLUMN_NAME_PROVIDERID + " = " + provId, null, null, null, null);
            while (c3.moveToNext())
            {
                s += "Services offered: ";
                s += c3.getString(2) + " ";
                s += " Cost: " + c3.getString(3);
                s += " \n";
            }

            s += " \n \n";
        }

        mProvs.setText(s);

        c.close();
    }
}
