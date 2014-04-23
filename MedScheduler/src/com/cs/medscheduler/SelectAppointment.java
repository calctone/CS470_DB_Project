package com.cs.medscheduler;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelectAppointment extends Activity
{
	int providerid = -1;
	Button button8to9, button10to11, button12to1;
	 private DBOpenHelper mDBHelper;
	 AppPreferences appPreferences;
	 int personid;
	 ContentValues values;
	 SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.availability1);
		mDBHelper = ((MedSchedulerApplication)  getApplication()).getDBHelper();
		appPreferences = new AppPreferences(SelectAppointment.this);
		
		personid = appPreferences.getPrefs().getInt(AppPreferences.ID_KEY, 0);
		
		
	      db = mDBHelper.getWritableDatabase();
//	        Cursor c = db.rawQuery("insert into appointments values personid="+personid+",providerid="+providerid + ",locationid = 1"+",appt_date_tm="+button8to9.getTag(), null);
	        
	        values = new ContentValues();
	        values.put("personid", personid);
	        values.put("providerid", providerid);
	        values.put("locationid", 1);
	       
	        
	        
	    
		Intent intent = getIntent();
		if(intent!=null && intent.hasExtra("providerid"))
			providerid = intent.getIntExtra("providerid", 0);
		
		button10to11 = (Button) findViewById(R.id.button10to11);
		button8to9 = (Button) findViewById(R.id.button8to9);
		button12to1 = (Button) findViewById(R.id.button12to1);
		
		button8to9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				 values.put("appt_date_tm", "15/06/14");
				   long insert = db.insert("appointments", null, values);
			       Log.e("insert","insert="+insert);
			       Toast.makeText(getApplicationContext(), "Your appointment has conformed.", Toast.LENGTH_SHORT).show();
			       sendNotification();
			}
		});
		
		button10to11.setOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick(View v) 
			{
				 values.put("appt_date_tm", "14/06/14");
				   long insert = db.insert("appointments", null, values);
			       Log.e("insert","insert="+insert);
			       Toast.makeText(getApplicationContext(), "Your appointment has conformed.", Toast.LENGTH_SHORT).show();
			       sendNotification();
			}
		});
				
		button12to1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				   values.put("appt_date_tm", "13/06/14");
				   long insert = db.insert("appointments", null, values);
			       Log.e("insert","insert="+insert);
			       Toast.makeText(getApplicationContext(), "Your appointment has conformed.", Toast.LENGTH_SHORT).show();
			       sendNotification();
			}
		});
		Log.e("providerid","providerid = "+providerid);

		
	}

	public void sendNotification()
	{
		NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_launcher) // notification icon
        .setContentTitle("MedScheduler!") // title for notification
        .setContentText("Your appointment has conformed.") // message for notification
        .setAutoCancel(true); // clear notification after click
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this,0,intent,Intent.FLAG_ACTIVITY_NEW_TASK);
		mBuilder.setContentIntent(pi);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(0, mBuilder.build());
		
	}
}
