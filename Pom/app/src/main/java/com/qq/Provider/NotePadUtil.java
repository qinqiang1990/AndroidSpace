package com.qq.Provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.qq.Log.Tag;

/**
 * Created by qq on 15-5-20.
 */
public class NotePadUtil {


    public static Uri myUri = NotePad.CONTENT_URI;

    private static String TAG = Tag.DBUtil;
    private static final String[] PROJECTION = new String[]{
            NotePad._ID,
            NotePad.NOTE_NAME,
            NotePad.NOTE_AGE,
            NotePad.NOTE_ID
    };

    public static void Add(ContentResolver contentResolver) {

        ContentValues values = new ContentValues();
        values.put(NotePad.NOTE_AGE, "99");
        values.put(NotePad.NOTE_ID, "102");
        values.put(NotePad.NOTE_NAME, "qinqiang");
        contentResolver.insert(myUri, values);

        Log.d(TAG, "NotePad Add");

    }

    public static String Query_String(ContentResolver contentResolver) {
        Cursor cursor = contentResolver.query(myUri, PROJECTION, null, null, null);
        String out = "";
        while (cursor.moveToNext()) {
            out += cursor.getString(cursor.getColumnIndex(NotePad._ID)) + "\n";
            out += cursor.getString(cursor.getColumnIndex(NotePad.NOTE_ID)) + "\n";
            out += cursor.getString(cursor.getColumnIndex(NotePad.NOTE_NAME)) + "\n";
            out += cursor.getString(cursor.getColumnIndex(NotePad.NOTE_AGE)) + "\n";
        }
        cursor.close();
        Log.d(TAG, "NotePad Query");
        return out;
    }

    public static String Query_String(ContentResolver contentResolver, Uri uri) {
        Cursor cursor = contentResolver.query(uri, PROJECTION, null, null, null);
        String out = "";
        while (cursor.moveToNext()) {
            out += cursor.getString(cursor.getColumnIndex(NotePad._ID)) + "\n";
            out += cursor.getString(cursor.getColumnIndex(NotePad.NOTE_ID)) + "\n";
            out += cursor.getString(cursor.getColumnIndex(NotePad.NOTE_NAME)) + "\n";
            out += cursor.getString(cursor.getColumnIndex(NotePad.NOTE_AGE)) + "\n";
        }
        cursor.close();
        Log.d(TAG, "NotePad Query");
        return out;
    }

    public static Cursor Query_Cursor(ContentResolver contentResolver) {
        Cursor cursor = contentResolver.query(myUri, PROJECTION, null, null, null);
        Log.d(TAG, "NotePad Query");
        return cursor;
    }
}
