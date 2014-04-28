package com.cs.medscheduler;

import android.provider.BaseColumns;

@SuppressWarnings("javadoc")
public class DB
{
    private DB()
    {
    }

    private static final String COMMA_SEP = ",";

    public static abstract class Person implements BaseColumns
    {
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_NAME_FIRST_NAME = "first_name";
        public static final String COLUMN_NAME_MIDDLE_INIT = "middle_init";
        public static final String COLUMN_NAME_LAST_NAME = "last_name";
        public static final String COLUMN_NAME_SSN = "ssn";
    }

    public static final String SQL_CREATE_PERSON_TABLE = "CREATE TABLE " + DB.Person.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Person.COLUMN_NAME_FIRST_NAME + " VARCHAR (64) NOT NULL" + COMMA_SEP
            + DB.Person.COLUMN_NAME_MIDDLE_INIT + " CHAR (1) NULL" + COMMA_SEP
            + DB.Person.COLUMN_NAME_LAST_NAME + " VARCHAR (64) NOT NULL" + COMMA_SEP
            + DB.Person.COLUMN_NAME_SSN + " VARCHAR (255) NULL" + " );";

    public static final String SQL_DELETE_PERSON_TABLE = "DROP TABLE IF EXISTS "
            + DB.Person.TABLE_NAME;

    public static abstract class Demographics implements BaseColumns
    {
        public static final String TABLE_NAME = "demographics";
        public static final String COLUMN_NAME_PERSONID = "personid";
        public static final String COLUMN_NAME_DOB = "dob";
        public static final String COLUMN_NAME_STREET = "street";
        public static final String COLUMN_NAME_CITY = "city";
        public static final String COLUMN_NAME_STATE = "state";
        public static final String COLUMN_NAME_COUNTRY = "country";
        public static final String COLUMN_NAME_ZIP = "zip";
        public static final String COLUMN_NAME_PHONE = "phone";
    }

    public static final String SQL_CREATE_DEMOGRAPHICS_TABLE = "CREATE TABLE "
            + DB.Demographics.TABLE_NAME + " (" + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_PERSONID + " INT NOT NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_DOB + " DATE NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_STREET + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_CITY + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_STATE + " VARCHAR (2) NOT NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_COUNTRY + " VARCHAR (64) NOT NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_ZIP + " INT NOT NULL" + COMMA_SEP
            + DB.Demographics.COLUMN_NAME_PHONE + " VARCHAR (255) NULL" + COMMA_SEP
            + " FOREIGN KEY (" + DB.Demographics.COLUMN_NAME_PERSONID + ") REFERENCES "
            + DB.Person.TABLE_NAME + " (" + BaseColumns._ID + "));";

    public static final String SQL_DELETE_DEMOGRAPHICS_TABLE = "DROP TABLE IF EXISTS "
            + DB.Demographics.TABLE_NAME;

    public static abstract class Conditions implements BaseColumns
    {
        public static final String TABLE_NAME = "conditions";
        public static final String COLUMN_NAME_PERSONID = "personid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_CLASSIFICATION = "classification";
        public static final String COLUMN_NAME_ONSET_DATE_TM = "onset_date_tm";
    }

    public static final String SQL_CREATE_CONDITIONS_TABLE = "CREATE TABLE "
            + DB.Conditions.TABLE_NAME + " (" + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Conditions.COLUMN_NAME_PERSONID + " NOT NULL" + COMMA_SEP
            + DB.Conditions.COLUMN_NAME_NAME + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Conditions.COLUMN_NAME_TYPE + " VARCHAR (255) NULL" + COMMA_SEP
            + DB.Conditions.COLUMN_NAME_CLASSIFICATION + " VARCHAR (255) NULL" + COMMA_SEP
            + DB.Conditions.COLUMN_NAME_ONSET_DATE_TM + " DATE NULL" + COMMA_SEP + " FOREIGN KEY ("
            + DB.Conditions.COLUMN_NAME_PERSONID + ") REFERENCES " + DB.Person.TABLE_NAME + " ("
            + BaseColumns._ID + "));";

    public static final String SQL_DELETE_CONDITIONS_TABLE = "DROP TABLE IF EXISTS "
            + DB.Conditions.TABLE_NAME;

    public static abstract class Provider implements BaseColumns
    {
        public static final String TABLE_NAME = "provider";
        public static final String COLUMN_NAME_PERSONID = "personid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_PHONE = "phone";
    }

    public static final String SQL_CREATE_PROVIDER_TABLE = "CREATE TABLE " + DB.Provider.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Provider.COLUMN_NAME_PERSONID + " INT NOT NULL" + COMMA_SEP
            + DB.Provider.COLUMN_NAME_NAME + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Provider.COLUMN_NAME_PHONE + " INT NOT NULL" + COMMA_SEP + " FOREIGN KEY ("
            + DB.Provider.COLUMN_NAME_PERSONID + ") REFERENCES " + DB.Person.TABLE_NAME + " ("
            + BaseColumns._ID + "));";

    public static final String SQL_DELETE_PROVIDER_TABLE = "DROP TABLE IF EXISTS "
            + DB.Provider.TABLE_NAME;

    public static abstract class Visit implements BaseColumns
    {
        public static final String TABLE_NAME = "visit";
        public static final String COLUMN_NAME_PROVIDERID = "provider";
        public static final String COLUMN_NAME_PERSONID = "personid";
        public static final String COLUMN_NAME_REASON_FOR_VISIT = "reason_for_visit";
        public static final String COLUMN_NAME_VISIT_DATE_TM = "visit_date_tm";
    }

    public static final String SQL_CREATE_VISIT_TABLE = "CREATE TABLE " + DB.Visit.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Visit.COLUMN_NAME_PROVIDERID + " INT NOT NULL" + COMMA_SEP
            + DB.Visit.COLUMN_NAME_PERSONID + " INT NOT NULL" + COMMA_SEP
            + DB.Visit.COLUMN_NAME_REASON_FOR_VISIT + " VARCHAR (255) NULL" + COMMA_SEP
            + DB.Visit.COLUMN_NAME_VISIT_DATE_TM + " DATE NOT NULL" + COMMA_SEP + " FOREIGN KEY ("
            + DB.Visit.COLUMN_NAME_PROVIDERID + ") REFERENCES " + DB.Provider.TABLE_NAME + " ("
            + BaseColumns._ID + ")" + COMMA_SEP + " FOREIGN KEY (" + DB.Visit.COLUMN_NAME_PERSONID
            + ") REFERENCES " + DB.Person.TABLE_NAME + " (" + BaseColumns._ID + "));";

    public static final String SQL_DELETE_VISIT_TABLE = "DROP TABLE IF EXISTS "
            + DB.Visit.TABLE_NAME;

    public static abstract class Services implements BaseColumns
    {
        public static final String TABLE_NAME = "services";
        public static final String COLUMN_NAME_PROVIDERID = "providerid";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_COST = "cost";
    }

    public static final String SQL_CREATE_SERVICES_TABLE = "CREATE TABLE " + DB.Services.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Services.COLUMN_NAME_PROVIDERID + " INT NOT NULL" + COMMA_SEP
            + DB.Services.COLUMN_NAME_DESCRIPTION + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Services.COLUMN_NAME_COST + " DOUBLE NULL" + COMMA_SEP + " FOREIGN KEY ("
            + DB.Services.COLUMN_NAME_PROVIDERID + ") REFERENCES " + DB.Provider.TABLE_NAME + " ("
            + BaseColumns._ID + "));";

    public static final String SQL_DELETE_SERVICES_TABLE = "DROP TABLE IF EXISTS "
            + DB.Services.TABLE_NAME;

    public static abstract class Location implements BaseColumns
    {
        public static final String TABLE_NAME = "location";
        public static final String COLUMN_NAME_PROVIDERID = "providerid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_STREET = "street";
        public static final String COLUMN_NAME_CITY = "city";
        public static final String COLUMN_NAME_STATE = "state";
        public static final String COLUMN_NAME_COUNTRY = "country";
        public static final String COLUMN_NAME_ZIP = "zip";
        public static final String COLUMN_NAME_PHONE = "phone";
    }

    public static final String SQL_CREATE_LOCATION_TABLE = "CREATE TABLE " + DB.Location.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Location.COLUMN_NAME_PROVIDERID + " INT NOT NULL" + COMMA_SEP
            + DB.Location.COLUMN_NAME_STREET + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Location.COLUMN_NAME_CITY + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Location.COLUMN_NAME_STATE + " VARCHAR (2) NOT NULL" + COMMA_SEP
            + DB.Location.COLUMN_NAME_COUNTRY + " VARCHAR (64) NOT NULL" + COMMA_SEP
            + DB.Location.COLUMN_NAME_ZIP + " INT NOT NULL" + COMMA_SEP
            + DB.Location.COLUMN_NAME_NAME + " VARCHAR (64) NOT NULL" + COMMA_SEP
            + " FOREIGN KEY (" + DB.Location.COLUMN_NAME_PROVIDERID + ") REFERENCES "
            + DB.Provider.TABLE_NAME + " (" + BaseColumns._ID + "));";

    public static final String SQL_DELETE_LOCATION_TABLE = "DROP TABLE IF EXISTS "
            + DB.Location.TABLE_NAME;

    public static abstract class Appointments implements BaseColumns
    {
        public static final String TABLE_NAME = "appointments";
        public static final String COLUMN_NAME_PERSONID = "personid";
        public static final String COLUMN_NAME_PROVIDERID = "providerid";
        public static final String COLUMN_NAME_LOCATIONID = "locationid";
        public static final String COLUMN_NAME_APPT_DATE_TM = "appt_date_tm";
    }

    public static final String SQL_CREATE_APPOINTMENTS_TABLE = "CREATE TABLE "
            + DB.Appointments.TABLE_NAME + " (" + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Appointments.COLUMN_NAME_PERSONID + " INT NOT NULL" + COMMA_SEP
            + DB.Appointments.COLUMN_NAME_PROVIDERID + " INT NOT NULL" + COMMA_SEP
            + DB.Appointments.COLUMN_NAME_LOCATIONID + " INT NOT NULL" + COMMA_SEP
            + DB.Appointments.COLUMN_NAME_APPT_DATE_TM + " DATE NOT NULL" + COMMA_SEP
            + " FOREIGN KEY (" + DB.Appointments.COLUMN_NAME_PERSONID + ") REFERENCES "
            + DB.Person.TABLE_NAME + " (" + BaseColumns._ID + ")" + COMMA_SEP + " FOREIGN KEY ("
            + DB.Appointments.COLUMN_NAME_PROVIDERID + ") REFERENCES " + DB.Provider.TABLE_NAME
            + " (" + BaseColumns._ID + ")" + COMMA_SEP + " FOREIGN KEY ("
            + DB.Appointments.COLUMN_NAME_LOCATIONID + ") REFERENCES " + DB.Location.TABLE_NAME
            + " (" + BaseColumns._ID + ")" + ");";

    public static final String SQL_DELETE_APPOINTMENTS_TABLE = "DROP TABLE IF EXISTS "
            + DB.Appointments.TABLE_NAME;

    public static abstract class Notifications implements BaseColumns
    {
        public static final String TABLE_NAME = "notifications";
        public static final String COLUMN_NAME_PROVIDERID = "providerid";
        public static final String COLUMN_NAME_ALERT_TEXT = "alert_text";
        public static final String COLUMN_NOTIF_DATE_TM = "notif_date_tm";
    }

    public static final String SQL_CREATE_NOTIFICATIONS_TABLE = "CREATE TABLE "
            + DB.Notifications.TABLE_NAME + " (" + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Notifications.COLUMN_NAME_PROVIDERID + " INT NOT NULL" + COMMA_SEP
            + DB.Notifications.COLUMN_NAME_ALERT_TEXT + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Notifications.COLUMN_NOTIF_DATE_TM + " DATE NOT NULL" + COMMA_SEP
            + " FOREIGN KEY (" + DB.Notifications.COLUMN_NAME_PROVIDERID + ") REFERENCES "
            + DB.Provider.TABLE_NAME + " (" + BaseColumns._ID + "));";

    public static final String SQL_DELETE_NOTIFICATIONS_TABLE = "DROP TABLE IF EXISTS "
            + DB.Notifications.TABLE_NAME;

    public static abstract class Notes implements BaseColumns
    {
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_NAME_PROVIDERID = "providerid";
        public static final String COLUMN_NAME_NOTE_TEXT = "note_text";
    }

    public static final String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " + DB.Notes.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Notes.COLUMN_NAME_PROVIDERID + " INT NOT NULL" + COMMA_SEP
            + DB.Notes.COLUMN_NAME_NOTE_TEXT + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + " FOREIGN KEY (" + DB.Notes.COLUMN_NAME_PROVIDERID + ") REFERENCES "
            + DB.Provider.TABLE_NAME + " (" + BaseColumns._ID + "));";

    public static final String SQL_DELETE_NOTES_TABLE = "DROP TABLE IF EXISTS "
            + DB.Notes.TABLE_NAME;

    public static abstract class Login implements BaseColumns
    {
        public static final String TABLE_NAME = "login";
        public static final String COLUMN_NAME_USER_NAME = "user_name";
        public static final String COLUMN_NAME_PASS = "pass";
        public static final String COLUMN_NAME_PERSONID = "personid";
    }

    public static final String SQL_CREATE_LOGIN_TABLE = "CREATE TABLE " + DB.Login.TABLE_NAME
            + " (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + COMMA_SEP
            + DB.Login.COLUMN_NAME_USER_NAME + " INT NOT NULL" + COMMA_SEP
            + DB.Login.COLUMN_NAME_PASS + " VARCHAR (255) NOT NULL" + COMMA_SEP
            + DB.Login.COLUMN_NAME_PERSONID + " INT NOT NULL" + COMMA_SEP + " FOREIGN KEY ("
            + DB.Login.COLUMN_NAME_PERSONID + ") REFERENCES " + DB.Person.TABLE_NAME + " ("
            + BaseColumns._ID + "));";

    public static final String SQL_DELETE_LOGIN_TABLE = "DROP TABLE IF EXISTS "
            + DB.Login.TABLE_NAME;
}
