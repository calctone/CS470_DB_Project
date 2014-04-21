package com.cs.medscheduler;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cs.medscheduler.entity.LoginEntity;
import com.cs.medscheduler.entity.PersonEntity;
import com.example.medscheduler.R;

@SuppressWarnings("javadoc")
public class MainActivity extends Activity
{
    private final String TAG = "MainActivity";
    private DBOpenHelper mDBHelper;

    private EditText userName;
    private EditText password;
    private Button mCancelButton;
    private Button mLoginButton;
    private Button mRegisterButton;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called.");
        setContentView(R.layout.activity_main);

        mDBHelper = new DBOpenHelper(this);
        mCancelButton = (Button) findViewById(R.id.btn_reg_cancel);
        mCancelButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                onBackPressed();
            }
        });

        mLoginButton = (Button) findViewById(R.id.btn_login);
        mLoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                userName = (EditText) findViewById(R.id.edit_user_name);
                password = (EditText) findViewById(R.id.edit_password);
                LoginEntity loginEntity = new LoginEntity();
                loginEntity.setUserName(userName.getText().toString());
                loginEntity.setPassword(password.getText().toString());
                if (getUser(loginEntity))
                {
                    // Intent i = new Intent(MainActivity.this, );
                    // startActivityForResult(i, 0);
                }
            }
        });

        mRegisterButton = (Button) findViewById(R.id.btn_register);
        mRegisterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                userName = (EditText) findViewById(R.id.edit_user_name);
                password = (EditText) findViewById(R.id.edit_password);
                LoginEntity loginEntity = new LoginEntity();
                loginEntity.setUserName(userName.getText().toString());
                loginEntity.setPassword(password.getText().toString());
                registerUser(loginEntity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    protected boolean getUser (LoginEntity loginEntity)
    {
        Log.d(MainActivity.class.getName(), "Checking if user exists: " + loginEntity.getUserName());

        if (loginEntity.getUserName() == null || loginEntity.getUserName().trim().isEmpty()
                || loginEntity.getPassword() == null || loginEntity.getPassword().trim().isEmpty())
        {
            Log.d(MainActivity.class.getName(), "Invalid user name or password provided.");
            Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_LONG)
                    .show();
            return false;
        }

        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        String[] projection = { BaseColumns._ID, DB.Login.COLUMN_NAME_USER_NAME,
                DB.Login.COLUMN_NAME_PASS };
        Cursor c = db.query(DB.Login.TABLE_NAME, projection, DB.Login.COLUMN_NAME_USER_NAME + " = "
                + "\"" + loginEntity.getUserName().trim() + "\"", null, null, null, null);
        c.moveToFirst();

        if (!c.isAfterLast() && c.getInt(0) > 0 && c.getString(1).trim() != "")
        {
            Log.d(MainActivity.class.getName(), "User exists: " + c.getString(1).trim());
            Toast.makeText(getApplicationContext(),
                    "Successfully logged in. Welcome " + loginEntity.getUserName(),
                    Toast.LENGTH_LONG).show();
            return true;
        }

        Log.d(MainActivity.class.getName(),
                "Failed to login with username: " + loginEntity.getUserName());
        Toast.makeText(getApplicationContext(), "Failed to login with username/password.",
                Toast.LENGTH_LONG).show();

        return false;
    }

    protected void registerUser (LoginEntity loginEntity)
    {
        Log.d(MainActivity.class.getName(), "Registering user: " + loginEntity.getUserName());

        if (loginEntity.getUserName() == null || loginEntity.getUserName().trim().isEmpty()
                || loginEntity.getPassword() == null || loginEntity.getPassword().trim().isEmpty())
        {
            Log.d(MainActivity.class.getName(), "Invalid user name or password provided.");
            Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB.Login.COLUMN_NAME_USER_NAME, loginEntity.getUserName());
        values.put(DB.Login.COLUMN_NAME_PASS, loginEntity.getPassword());

        long insertId = db.insert(DB.Login.TABLE_NAME, "null", values);
        if (insertId > 0)
        {
            Log.d(MainActivity.class.getName(), "Successfully inserted login with ID: " + insertId);
            Toast.makeText(getApplicationContext(), "Successfully registered user.",
                    Toast.LENGTH_LONG).show();

        } else
        {
            Log.d(MainActivity.class.getName(),
                    "Failed to insert user with name: " + loginEntity.getUserName());
            Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_LONG)
                    .show();
            userName.setText("");
            password.setText("");
        }
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
        String[] projection = { BaseColumns._ID, DB.Person.COLUMN_NAME_FIRST_NAME,
                DB.Person.COLUMN_NAME_MIDDLE_INIT, DB.Person.COLUMN_NAME_LAST_NAME,
                DB.Person.COLUMN_NAME_SSN };

        Cursor cursor = db.query(DB.Person.TABLE_NAME, projection, BaseColumns._ID + " = "
                + insertId, null, null, null, null);
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
