package com.qq.Preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by qq on 15-5-14.
 */
public class Share {

    private static final String PREFERENCES_NAME = "poeminfo";

    public static String GetValue(Activity activity, String key) {

        SharedPreferences preferences = activity.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        return preferences.getString("key", null);
    }

    public static void SetValue(Activity activity, String key, String values) {

        SharedPreferences preferences = activity.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, values);
        editor.commit();
    }

}
