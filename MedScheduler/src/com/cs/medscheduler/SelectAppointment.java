package com.cs.medscheduler;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelectAppointment extends Activity
{
    int providerId = -1;
    Button buttonA, buttonB, buttonC;
    EditText txtA, txtB, txtC;
    private DBOpenHelper mDBHelper;
    AppPreferences appPreferences;
    int personId;
    ContentValues values;
    SQLiteDatabase db;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.availability1);
        mDBHelper = ((MedSchedulerApplication) getApplication()).getDBHelper();
        appPreferences = new AppPreferences(SelectAppointment.this);

        personId = appPreferences.getPrefs().getInt(AppPreferences.ID_KEY, 0);

        if (savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras != null)
            {
                providerId = extras.getInt("providerid");
            }
        }

        db = mDBHelper.getWritableDatabase();

        values = new ContentValues();
        values.put("personid", personId);
        values.put("providerid", providerId);
        values.put("locationid", 1);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("providerid"))
            providerId = intent.getIntExtra("providerid", 0);

        buttonA = (Button) findViewById(R.id.button8to9);
        buttonB = (Button) findViewById(R.id.button10to11);
        buttonC = (Button) findViewById(R.id.button12to1);

        txtA = (EditText) findViewById(R.id.editText1);
        txtB = (EditText) findViewById(R.id.editText2);
        txtC = (EditText) findViewById(R.id.editText3);

        String[] projection = { BaseColumns._ID, DB.Appointments.COLUMN_NAME_PROVIDERID,
                DB.Appointments.COLUMN_NAME_PERSONID, DB.Appointments.COLUMN_NAME_APPT_DATE_TM };
        Cursor c = db.query(DB.Appointments.TABLE_NAME, projection,
                DB.Appointments.COLUMN_NAME_PROVIDERID + " = " + providerId, null, null, null, null);

        while (c.moveToNext())
        {
            Log.d(SelectAppointment.class.getName(),
                    "Provider appointment: " + "ProvId: " + c.getInt(1) + " PrsnId: " + c.getInt(2)
                            + " Date: " + c.getString(3));

            int apptProvId = c.getInt(1);
            int apptPersonId = c.getInt(2);
            String apptDtTm = c.getString(3);

            if (apptPersonId == personId)
            {
                if (apptDtTm != null)
                {
                    if (apptDtTm.equals(getResources().getString(R.string.txt_8to9)))
                    {
                        buttonA.setText(R.string.btn_confirmed);
                    } else if (apptDtTm.equals(getResources().getString(R.string.txt_10to11)))
                    {
                        buttonB.setText(R.string.btn_confirmed);
                    } else if (apptDtTm.equals(getResources().getString(R.string.txt_12to1)))
                    {
                        buttonC.setText(R.string.btn_confirmed);
                    }
                }
            } else
            {
                if (apptDtTm != null)
                {
                    if (apptDtTm.equals(getResources().getString(R.string.txt_8to9)))
                    {
                        buttonA.setText(R.string.btn_closed);
                    } else if (apptDtTm.equals(getResources().getString(R.string.txt_10to11)))
                    {
                        buttonB.setText(R.string.btn_closed);
                    } else if (apptDtTm.equals(getResources().getString(R.string.txt_12to1)))
                    {
                        buttonC.setText(R.string.btn_closed);
                    }
                }
            }
        }

        buttonA.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick (View v)
            {
                if (buttonA.getText()
                        .toString()
                        .equals(getResources().getString(R.string.btn_open)))
                {
                    values.put("appt_date_tm", getResources().getString(R.string.txt_8to9));
                    long insert = db.insert(DB.Appointments.TABLE_NAME, null, values);
                    Log.d("insert", "insert=" + insert);
                    Toast.makeText(getApplicationContext(), "Your appointment was confirmed.",
                            Toast.LENGTH_SHORT).show();
                    sendNotification(0);
                    buttonA.setText(R.string.btn_confirmed);
                } else if (buttonA.getText()
                        .toString()
                        .equals(getResources().getString(R.string.btn_confirmed)))
                {
                    if (db.delete(DB.Appointments.TABLE_NAME, DB.Appointments.COLUMN_NAME_PERSONID
                            + " = " + personId + " AND " + DB.Appointments.COLUMN_NAME_APPT_DATE_TM
                            + " = " + "\"" + getResources().getString(R.string.txt_8to9) + "\"",
                            null) > 0)
                    {
                        Toast.makeText(getApplicationContext(), "Your appointment was cancelled!.",
                                Toast.LENGTH_SHORT).show();
                        sendNotification(1);
                        buttonA.setText(R.string.btn_open);
                    }
                }
            }
        });

        buttonB.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick (View v)
            {
                if (buttonB.getText()
                        .toString()
                        .equals(getResources().getString(R.string.btn_open)))
                {
                    values.put("appt_date_tm", getResources().getString(R.string.txt_10to11));
                    long insert = db.insert(DB.Appointments.TABLE_NAME, null, values);
                    Log.d("insert", "insert=" + insert);
                    Toast.makeText(getApplicationContext(), "Your appointment was confirmed.",
                            Toast.LENGTH_SHORT).show();
                    sendNotification(0);
                    buttonB.setText(R.string.btn_confirmed);
                } else if (buttonB.getText()
                        .toString()
                        .equals(getResources().getString(R.string.btn_confirmed)))
                {
                    if (db.delete(DB.Appointments.TABLE_NAME, DB.Appointments.COLUMN_NAME_PERSONID
                            + " = " + personId + " AND " + DB.Appointments.COLUMN_NAME_APPT_DATE_TM
                            + " = " + "\"" + getResources().getString(R.string.txt_10to11) + "\"",
                            null) > 0)
                    {
                        Toast.makeText(getApplicationContext(), "Your appointment was cancelled!.",
                                Toast.LENGTH_SHORT).show();
                        sendNotification(1);
                        buttonB.setText(R.string.btn_open);
                    }
                }
            }
        });

        buttonC.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick (View v)
            {
                if (buttonC.getText()
                        .toString()
                        .equals(getResources().getString(R.string.btn_open)))
                {
                    values.put("appt_date_tm", getResources().getString(R.string.txt_12to1));
                    long insert = db.insert(DB.Appointments.TABLE_NAME, null, values);
                    Log.d("insert", "insert=" + insert);
                    Toast.makeText(getApplicationContext(), "Your appointment was confirmed.",
                            Toast.LENGTH_SHORT).show();
                    sendNotification(0);
                    buttonC.setText(R.string.btn_confirmed);
                } else if (buttonC.getText()
                        .toString()
                        .equals(getResources().getString(R.string.btn_confirmed)))
                {
                    if (db.delete(DB.Appointments.TABLE_NAME, DB.Appointments.COLUMN_NAME_PERSONID
                            + " = " + personId + " AND " + DB.Appointments.COLUMN_NAME_APPT_DATE_TM
                            + " = " + "\"" + getResources().getString(R.string.txt_12to1) + "\"",
                            null) > 0)
                    {
                        Toast.makeText(getApplicationContext(), "Your appointment was cancelled!.",
                                Toast.LENGTH_SHORT).show();
                        sendNotification(1);
                        buttonC.setText(R.string.btn_open);
                    }
                }
            }
        });

        Log.d("providerid", "providerid = " + providerId);
    }

    public void sendNotification (int type)
    {
        NotificationCompat.Builder mBuilder;

        if (type == 0)
        {
            mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher)
            // notification icon
                    .setContentTitle("MedScheduler!")
                    // title for notification
                    .setContentText("Your appointment was confirmed.")
                    // message for notification
                    .setAutoCancel(true); // clear notification after click
        } else if (type == 1)
        {
            mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle("MedScheduler!")
                    .setContentText("Your appointment was cancelled!.")
                    .setAutoCancel(true);
        } else
        {
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
        mBuilder.setContentIntent(pi);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());

    }
}
