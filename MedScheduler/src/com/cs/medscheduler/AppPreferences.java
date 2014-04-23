package com.cs.medscheduler;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

@SuppressWarnings("javadoc")
public class AppPreferences
{
    public static final String PREFS_KEY = "com.cs.medscheduler";
    public static final String USER_KEY = "com.cs.medscheduler.user_key";
    public static final String PASS_KEY = "com.cs.medscheduler.pass_key";
    public static final String ID_KEY = "com.cs.medscheduler.id_key";

    private SharedPreferences mPrefs;
    @SuppressWarnings("unused")
    private Context mContext;

    public AppPreferences(Context context)
    {
        mContext = context;
        mPrefs = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
    }

    public String getPrefString (String prefKey)
    {
        if (mPrefs == null)
        {
            Log.d(MainActivity.class.getName(), "Unable to read preferences.");
            return "";
        }

        return mPrefs.getString(prefKey, "");
    }

    public SharedPreferences getPrefs ()
    {
        return mPrefs;
    }
}
