package com.cs.medscheduler;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Date;

@SuppressWarnings("javadoc")
public class SymptomsActivity extends Activity
{
    public static final String TAG = "SymptomsActivity";

    private DBOpenHelper mDBHelper;
    private CheckBox mHead;
    private CheckBox mBody;
    private CheckBox mNose;
    private CheckBox mEars;
    private CheckBox mThroat;
    private CheckBox mArms;
    private CheckBox mLegs;
    private CheckBox mGenital;

    private Button mSubmitButton;

    AppPreferences appPreferences;
    int personId;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called.");
        setContentView(R.layout.symptoms);

        mDBHelper = ((MedSchedulerApplication) getApplication()).getDBHelper();

        appPreferences = new AppPreferences(SymptomsActivity.this);
        personId = appPreferences.getPrefs().getInt(AppPreferences.ID_KEY, 0);

        mHead = (CheckBox) findViewById(R.id.chk_head);
        mBody = (CheckBox) findViewById(R.id.chk_body);
        mNose = (CheckBox) findViewById(R.id.chk_nose);
        mEars = (CheckBox) findViewById(R.id.chk_ears);
        mThroat = (CheckBox) findViewById(R.id.chk_throat);
        mArms = (CheckBox) findViewById(R.id.chk_arms);
        mLegs = (CheckBox) findViewById(R.id.chk_legs);
        mGenital = (CheckBox) findViewById(R.id.chkGenital);

        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String[] projection = { BaseColumns._ID, DB.Conditions.COLUMN_NAME_PERSONID,
                DB.Conditions.COLUMN_NAME_NAME };
        Cursor c = db.query(DB.Conditions.TABLE_NAME, projection,
                DB.Conditions.COLUMN_NAME_PERSONID + " = " + personId, null, null, null, null);

        while (c.moveToNext())
        {
            String name = c.getString(2);
            if (!name.isEmpty())
            {
                if (name.contains(mHead.getText().toString()))
                {
                    mHead.setChecked(true);
                }
                if (name.contains(mBody.getText().toString()))
                {
                    mBody.setChecked(true);
                }
                if (name.contains(mNose.getText().toString()))
                {
                    mNose.setChecked(true);
                }
                if (name.contains(mEars.getText().toString()))
                {
                    mEars.setChecked(true);
                }
                if (name.contains(mThroat.getText().toString()))
                {
                    mThroat.setChecked(true);
                }
                if (name.contains(mArms.getText().toString()))
                {
                    mArms.setChecked(true);
                }
                if (name.contains(mLegs.getText().toString()))
                {
                    mLegs.setChecked(true);
                }
                if (name.contains(mGenital.getText().toString()))
                {
                    mGenital.setChecked(true);
                }
            }
        }

        mSubmitButton = (Button) findViewById(R.id.btn_submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                if (submitSymptoms())
                {
                    Intent i = new Intent(SymptomsActivity.this, ProvidersActivity.class);
                    startActivityForResult(i, 0);
                }
            }
        });
    }

    protected boolean submitSymptoms ()
    {
        AppPreferences prefs = new AppPreferences(SymptomsActivity.this);
        int prsnId = prefs.getPrefs().getInt(AppPreferences.ID_KEY, 0);

        String symp = new String("");
        if (mHead.isChecked())
        {
            symp += mHead.getText() + " ";
        }
        if (mBody.isChecked())
        {
            symp += mBody.getText() + " ";
        }
        if (mNose.isChecked())
        {
            symp += mNose.getText() + " ";
        }
        if (mEars.isChecked())
        {
            symp += mEars.getText() + " ";
        }
        if (mThroat.isChecked())
        {
            symp += mThroat.getText() + " ";
        }
        if (mArms.isChecked())
        {
            symp += mArms.getText() + " ";
        }
        if (mLegs.isChecked())
        {
            symp += mLegs.getText() + " ";
        }
        if (mGenital.isChecked())
        {
            symp += mGenital.getText() + " ";
        }

        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB.Conditions.COLUMN_NAME_PERSONID, prsnId);
        values.put(DB.Conditions.COLUMN_NAME_NAME, symp);
        values.put(DB.Conditions.COLUMN_NAME_TYPE, "Patient Reported");
        values.put(DB.Conditions.COLUMN_NAME_CLASSIFICATION, "Medical");
        values.put(DB.Conditions.COLUMN_NAME_ONSET_DATE_TM, new Date().toString());

        long id = db.insert(DB.Conditions.TABLE_NAME, "null", values);
        if (id > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Conditions data.");
        }

        Toast.makeText(getApplicationContext(), "Successfully inserted symptoms.",
                Toast.LENGTH_SHORT).show();

        return true;
    }
}
