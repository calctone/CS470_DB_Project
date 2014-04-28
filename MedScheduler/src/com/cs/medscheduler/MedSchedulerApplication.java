package com.cs.medscheduler;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

@SuppressWarnings("javadoc")
public class MedSchedulerApplication extends Application
{
    public static final String DB_HELPER = "com.cs.medscheduler.dbhelper";

    private DBOpenHelper mDBHelper;

    @Override
    public void onCreate ()
    {
        mDBHelper = new DBOpenHelper(this);
        insertDBData();
    }

    /**
     * @return The dBHelper.
     */
    public DBOpenHelper getDBHelper ()
    {
        return mDBHelper;
    }

    public void insertDBData ()
    {
        Log.d(MedSchedulerApplication.class.getName(), "Inserting mock data ");

        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB.Person.COLUMN_NAME_FIRST_NAME, "bob");
        values.put(DB.Person.COLUMN_NAME_MIDDLE_INIT, "P");
        values.put(DB.Person.COLUMN_NAME_LAST_NAME, "Jones");
        values.put(DB.Person.COLUMN_NAME_SSN, 123456789);

        long prsnId1 = db.insert(DB.Person.TABLE_NAME, "null", values);
        if (prsnId1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted person data.");
        }

        values = new ContentValues();
        values.put(DB.Person.COLUMN_NAME_FIRST_NAME, "Arthur");
        values.put(DB.Person.COLUMN_NAME_MIDDLE_INIT, "C");
        values.put(DB.Person.COLUMN_NAME_LAST_NAME, "Scott");
        values.put(DB.Person.COLUMN_NAME_SSN, 123456789);

        long prsnId2 = db.insert(DB.Person.TABLE_NAME, "null", values);
        if (prsnId2 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted person data.");
        }

        values = new ContentValues();
        values.put(DB.Person.COLUMN_NAME_FIRST_NAME, "Prescott");
        values.put(DB.Person.COLUMN_NAME_MIDDLE_INIT, "Z");
        values.put(DB.Person.COLUMN_NAME_LAST_NAME, "Jones");
        values.put(DB.Person.COLUMN_NAME_SSN, 123456789);

        long prsnId3 = db.insert(DB.Person.TABLE_NAME, "null", values);
        if (prsnId3 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted person data.");
        }

        values = new ContentValues();
        values.put(DB.Person.COLUMN_NAME_FIRST_NAME, "John");
        values.put(DB.Person.COLUMN_NAME_MIDDLE_INIT, "C");
        values.put(DB.Person.COLUMN_NAME_LAST_NAME, "Johnson");
        values.put(DB.Person.COLUMN_NAME_SSN, 123456789);

        long prsnId4 = db.insert(DB.Person.TABLE_NAME, "null", values);
        if (prsnId4 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted person data.");
        }

        values = new ContentValues();
        values.put(DB.Demographics.COLUMN_NAME_PERSONID, prsnId1);
        values.put(DB.Demographics.COLUMN_NAME_DOB, "04/04/1944");
        values.put(DB.Demographics.COLUMN_NAME_STREET, "42 Troost");
        values.put(DB.Demographics.COLUMN_NAME_CITY, "KC");
        values.put(DB.Demographics.COLUMN_NAME_STATE, "MO");
        values.put(DB.Demographics.COLUMN_NAME_COUNTRY, "USA");
        values.put(DB.Demographics.COLUMN_NAME_ZIP, 64110);
        values.put(DB.Demographics.COLUMN_NAME_PHONE, 7778888);

        long demId1 = db.insert(DB.Demographics.TABLE_NAME, "null", values);
        if (demId1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(),
                    "Successfully inserted Demographics data.");
        }

        values = new ContentValues();
        values.put(DB.Demographics.COLUMN_NAME_PERSONID, prsnId2);
        values.put(DB.Demographics.COLUMN_NAME_DOB, "06/05/1946");
        values.put(DB.Demographics.COLUMN_NAME_STREET, "66 UMKC");
        values.put(DB.Demographics.COLUMN_NAME_CITY, "KC");
        values.put(DB.Demographics.COLUMN_NAME_STATE, "MO");
        values.put(DB.Demographics.COLUMN_NAME_COUNTRY, "USA");
        values.put(DB.Demographics.COLUMN_NAME_ZIP, 64110);
        values.put(DB.Demographics.COLUMN_NAME_PHONE, 7778888);

        long demId2 = db.insert(DB.Demographics.TABLE_NAME, "null", values);
        if (demId2 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(),
                    "Successfully inserted Demographics data.");
        }

        values = new ContentValues();
        values.put(DB.Conditions.COLUMN_NAME_PERSONID, prsnId1);
        values.put(DB.Conditions.COLUMN_NAME_NAME, "Amnesia");
        values.put(DB.Conditions.COLUMN_NAME_TYPE, "Medical");
        values.put(DB.Conditions.COLUMN_NAME_CLASSIFICATION, "Mental Disorder");
        values.put(DB.Conditions.COLUMN_NAME_ONSET_DATE_TM, "12/12/2012");

        long cond1 = db.insert(DB.Conditions.TABLE_NAME, "null", values);
        if (cond1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Conditions data.");
        }

        values = new ContentValues();
        values.put(DB.Conditions.COLUMN_NAME_PERSONID, prsnId1);
        values.put(DB.Conditions.COLUMN_NAME_NAME, "Cat Allergies");
        values.put(DB.Conditions.COLUMN_NAME_TYPE, "Medical");
        values.put(DB.Conditions.COLUMN_NAME_CLASSIFICATION, "Allergy");
        values.put(DB.Conditions.COLUMN_NAME_ONSET_DATE_TM, "12/11/2000");

        long cond2 = db.insert(DB.Conditions.TABLE_NAME, "null", values);
        if (cond2 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Conditions data.");
        }

        values = new ContentValues();
        values.put(DB.Provider.COLUMN_NAME_PERSONID, prsnId2);
        values.put(DB.Provider.COLUMN_NAME_NAME, "Dr. Jones");
        values.put(DB.Provider.COLUMN_NAME_PHONE, 6665555);

        long prov1 = db.insert(DB.Provider.TABLE_NAME, "null", values);
        if (prov1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Provider data.");
        }

        values = new ContentValues();
        values.put(DB.Provider.COLUMN_NAME_PERSONID, prsnId3);
        values.put(DB.Provider.COLUMN_NAME_NAME, "Dr. Smith");
        values.put(DB.Provider.COLUMN_NAME_PHONE, 6664444);

        long prov2 = db.insert(DB.Provider.TABLE_NAME, "null", values);
        if (prov2 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Provider data.");
        }

        values = new ContentValues();
        values.put(DB.Provider.COLUMN_NAME_PERSONID, prsnId4);
        values.put(DB.Provider.COLUMN_NAME_NAME, "Dr. Monty");
        values.put(DB.Provider.COLUMN_NAME_PHONE, 6663333);

        long prov3 = db.insert(DB.Provider.TABLE_NAME, "null", values);
        if (prov3 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Provider data.");
        }

        values = new ContentValues();
        values.put(DB.Visit.COLUMN_NAME_PROVIDERID, prov1);
        values.put(DB.Visit.COLUMN_NAME_PERSONID, prsnId1);
        values.put(DB.Visit.COLUMN_NAME_REASON_FOR_VISIT, "Cat Allergies");
        values.put(DB.Visit.COLUMN_NAME_VISIT_DATE_TM, "01/01/2014");

        long visit1 = db.insert(DB.Visit.TABLE_NAME, "null", values);
        if (visit1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Visit data.");
        }

        values = new ContentValues();
        values.put(DB.Services.COLUMN_NAME_PROVIDERID, prov1);
        values.put(DB.Services.COLUMN_NAME_DESCRIPTION, "General Checkup");
        values.put(DB.Services.COLUMN_NAME_COST, 500);

        long serv1 = db.insert(DB.Services.TABLE_NAME, "null", values);
        if (serv1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Services data.");
        }

        values = new ContentValues();
        values.put(DB.Services.COLUMN_NAME_PROVIDERID, prov2);
        values.put(DB.Services.COLUMN_NAME_DESCRIPTION, "Allergies");
        values.put(DB.Services.COLUMN_NAME_COST, 200);

        long serv2 = db.insert(DB.Services.TABLE_NAME, "null", values);
        if (serv2 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Services data.");
        }

        values = new ContentValues();
        values.put(DB.Services.COLUMN_NAME_PROVIDERID, prov3);
        values.put(DB.Services.COLUMN_NAME_DESCRIPTION, "Fracture repair");
        values.put(DB.Services.COLUMN_NAME_COST, 5000);

        long serv3 = db.insert(DB.Services.TABLE_NAME, "null", values);
        if (serv3 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Services data.");
        }

        values = new ContentValues();
        values.put(DB.Location.COLUMN_NAME_PROVIDERID, prov1);
        values.put(DB.Location.COLUMN_NAME_STREET, "42 Troost");
        values.put(DB.Location.COLUMN_NAME_CITY, "KC");
        values.put(DB.Location.COLUMN_NAME_STATE, "MO");
        values.put(DB.Location.COLUMN_NAME_COUNTRY, "USA");
        values.put(DB.Location.COLUMN_NAME_ZIP, 64101);
        values.put(DB.Location.COLUMN_NAME_NAME, "Research Med.");

        long loc1 = db.insert(DB.Location.TABLE_NAME, "null", values);
        if (loc1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Location data.");
        }

        values = new ContentValues();
        values.put(DB.Appointments.COLUMN_NAME_PERSONID, prsnId1);
        values.put(DB.Appointments.COLUMN_NAME_PROVIDERID, prov1);
        values.put(DB.Appointments.COLUMN_NAME_LOCATIONID, loc1);
        values.put(DB.Appointments.COLUMN_NAME_APPT_DATE_TM,
                getResources().getString(R.string.txt_8to9));

        long appt1 = db.insert(DB.Appointments.TABLE_NAME, "null", values);
        if (appt1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(),
                    "Successfully inserted Appointments data.");
        }

        values = new ContentValues();
        values.put(DB.Notifications.COLUMN_NAME_PROVIDERID, prov1);
        values.put(DB.Notifications.COLUMN_NAME_ALERT_TEXT, "Appointment Alert!");
        values.put(DB.Notifications.COLUMN_NOTIF_DATE_TM, "06/02/2014");

        long notif1 = db.insert(DB.Notifications.TABLE_NAME, "null", values);
        if (notif1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(),
                    "Successfully inserted Notifications data.");
        }

        values = new ContentValues();
        values.put(DB.Notes.COLUMN_NAME_PROVIDERID, prov1);
        values.put(DB.Notes.COLUMN_NAME_NOTE_TEXT, "Patient is crazy.");

        long note1 = db.insert(DB.Notes.TABLE_NAME, "null", values);
        if (note1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Notes data.");
        }

        values = new ContentValues();
        values.put(DB.Login.COLUMN_NAME_USER_NAME, "bob");
        values.put(DB.Login.COLUMN_NAME_PASS, "test");
        values.put(DB.Login.COLUMN_NAME_PERSONID, prsnId1);

        long login1 = db.insert(DB.Login.TABLE_NAME, "null", values);
        if (login1 > 0)
        {
            Log.d(MedSchedulerApplication.class.getName(), "Successfully inserted Login data.");
        }
    }
}
