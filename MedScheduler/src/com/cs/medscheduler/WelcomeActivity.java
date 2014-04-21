package com.cs.medscheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.medscheduler.R;

@SuppressWarnings("javadoc")
public class WelcomeActivity extends Activity
{
    private final String TAG = "WelcomeActivity";
    private Button mContinueButton;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called.");
        setContentView(R.layout.welcome);

        mContinueButton = (Button) findViewById(R.id.btn_continue);
        mContinueButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                Intent i = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivityForResult(i, 0);
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
}
