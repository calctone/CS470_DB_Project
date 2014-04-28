package com.cs.medscheduler;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cs.medscheduler.entity.DemographicsEntity;
import com.cs.medscheduler.entity.LoginEntity;
import com.cs.medscheduler.entity.PersonEntity;

@SuppressWarnings("javadoc")
public class RegisterActivity extends Activity
{
    public static final String TAG = "RegisterActivity";
    private DBOpenHelper mDBHelper;

    private EditText mUserName;
    private EditText mPassword;
    private EditText mFName;
    private EditText mLName;
    private EditText mSSN;
    private EditText mZip;
    private EditText mPhone;
    private EditText mCity;
    // private EditText mRole;
    private EditText mCountry;
    private EditText mState;
    private EditText mStreet;
    private EditText mDOB;

    private Button mCancelButton;
    private Button mRegisterButton;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called.");
        setContentView(R.layout.register);

        mDBHelper = ((MedSchedulerApplication) getApplication()).getDBHelper();

        mUserName = (EditText) findViewById(R.id.edit_user_name_reg);
        mPassword = (EditText) findViewById(R.id.edit_passwordreg);
        mFName = (EditText) findViewById(R.id.edit_first_name);
        mLName = (EditText) findViewById(R.id.edit_last_name);
        mSSN = (EditText) findViewById(R.id.edit_ssn);
        mZip = (EditText) findViewById(R.id.edit_zip);
        mPhone = (EditText) findViewById(R.id.edit_phone);
        mCity = (EditText) findViewById(R.id.edit_city);
        mCountry = (EditText) findViewById(R.id.edit_country);
        mState = (EditText) findViewById(R.id.edit_state);
        mStreet = (EditText) findViewById(R.id.edit_street);
        mDOB = (EditText) findViewById(R.id.edit_dob);
        // mRole = (EditText) findViewById(R.id.);

        mCancelButton = (Button) findViewById(R.id.btn_reg_cancel);
        mCancelButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                onBackPressed();
            }
        });

        mRegisterButton = (Button) findViewById(R.id.btn_reg_register);
        mRegisterButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                if (registerUser())
                {
                    onBackPressed();
                }
            }
        });
    }

    protected boolean registerUser ()
    {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserName(mUserName.getText().toString());
        loginEntity.setPassword(mPassword.getText().toString());

        if (loginEntity.getUserName() == null || loginEntity.getUserName().trim().isEmpty()
                || loginEntity.getPassword() == null || loginEntity.getPassword().trim().isEmpty())
        {
            Log.d(MainActivity.class.getName(), "Invalid user name or password provided.");
            Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_SHORT)
                    .show();
            return false;
        }

        AppPreferences prefs = new AppPreferences(RegisterActivity.this);
        if (!prefs.getPrefString(AppPreferences.USER_KEY).trim().isEmpty()
                && prefs.getPrefString(AppPreferences.USER_KEY).equals(loginEntity.getUserName()))
        {
            Log.d(MainActivity.class.getName(), "User already exists.");
            Toast.makeText(getApplicationContext(),
                    "User already exists! Please try a different username.", Toast.LENGTH_SHORT)
                    .show();
            return false;
        }

        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(mFName.getText().toString());
        personEntity.setLastName(mLName.getText().toString());
        if (mSSN != null && !mSSN.getText().toString().trim().isEmpty())
        {
            personEntity.setSSN(mSSN.getText().toString());
        }

        if (personEntity.getFirstName() == null || personEntity.getFirstName().trim().isEmpty()
                || personEntity.getLastName() == null
                || personEntity.getLastName().trim().isEmpty()
                || personEntity.getSSN().trim().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please enter all the fields.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        DemographicsEntity demogEntity = new DemographicsEntity();
        demogEntity.setDOB(mDOB.getText().toString());
        demogEntity.setPhone(mPhone.getText().toString());
        demogEntity.setStreet(mStreet.getText().toString());
        demogEntity.setState(mState.getText().toString());
        demogEntity.setCity(mCity.getText().toString());
        demogEntity.setCountry(mCountry.getText().toString());
        demogEntity.setZip(Integer.parseInt(mZip.getText().toString()));

        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values = new ContentValues();
        values.put(DB.Person.COLUMN_NAME_FIRST_NAME, personEntity.getFirstName());
        values.put(DB.Person.COLUMN_NAME_LAST_NAME, personEntity.getLastName());
        values.put(DB.Person.COLUMN_NAME_SSN, personEntity.getSSN());

        long personId = db.insert(DB.Person.TABLE_NAME, "null", values);
        if (personId > 0)
        {
            Log.d(MainActivity.class.getName(), "Successfully inserted person with ID: " + personId);
            Toast.makeText(getApplicationContext(), "Successfully inserted person.",
                    Toast.LENGTH_SHORT).show();

        } else
        {
            Log.d(MainActivity.class.getName(),
                    "Failed to insert person with name: " + loginEntity.getUserName());
            Toast.makeText(getApplicationContext(), "Failed to insert person.", Toast.LENGTH_SHORT)
                    .show();

            return false;
        }

        values = new ContentValues();
        values.put(DB.Login.COLUMN_NAME_USER_NAME, loginEntity.getUserName());
        values.put(DB.Login.COLUMN_NAME_PASS, loginEntity.getPassword());
        values.put(DB.Login.COLUMN_NAME_PERSONID, personId);

        long loginId = db.insert(DB.Login.TABLE_NAME, "null", values);
        if (loginId > 0)
        {
            Log.d(MainActivity.class.getName(), "Successfully inserted login with ID: " + loginId);
            Toast.makeText(getApplicationContext(), "Successfully registered user.",
                    Toast.LENGTH_SHORT).show();

        } else
        {
            Log.d(MainActivity.class.getName(),
                    "Failed to insert user with name: " + loginEntity.getUserName());
            Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_SHORT)
                    .show();

            return false;
        }

        values = new ContentValues();
        values.put(DB.Demographics.COLUMN_NAME_PERSONID, personId);
        values.put(DB.Demographics.COLUMN_NAME_DOB, demogEntity.getDOB().toString());
        values.put(DB.Demographics.COLUMN_NAME_PHONE, demogEntity.getPhone());
        values.put(DB.Demographics.COLUMN_NAME_STREET, demogEntity.getStreet());
        values.put(DB.Demographics.COLUMN_NAME_STATE, demogEntity.getState());
        values.put(DB.Demographics.COLUMN_NAME_CITY, demogEntity.getCity());
        values.put(DB.Demographics.COLUMN_NAME_COUNTRY, demogEntity.getCountry());
        values.put(DB.Demographics.COLUMN_NAME_ZIP, demogEntity.getZIP());

        long demogId = db.insert(DB.Demographics.TABLE_NAME, "null", values);
        if (demogId > 0)
        {
            Log.d(MainActivity.class.getName(), "Successfully inserted demographics with ID: "
                    + demogId);
            Toast.makeText(getApplicationContext(), "Successfully inserted demographics.",
                    Toast.LENGTH_SHORT).show();

        } else
        {
            Log.d(MainActivity.class.getName(), "Failed to insert demographics with name: "
                    + loginEntity.getUserName());
            Toast.makeText(getApplicationContext(), "Failed to insert demographics.",
                    Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }
}
