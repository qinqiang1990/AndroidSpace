package com.qq.Provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

import com.qq.Log.Tag;

public class NoteProvider extends ContentProvider {
    private SQLiteDatabase sqDb;
    private DatabaseHelper helper;
    private final String TAG = Tag.DBUtil;
    // 数据库名
    private final static String DATABASE_NAME = "qinq.db";
    // 版本
    private static final int DATABASE_VERSION = 1;
    // 表名
    private static final String TABLE_NAME = "note";
    // 创建表的sql语句
    private final static String CREATE_TABLE = "Create table " + TABLE_NAME
            + "( " + NotePad._ID + " integer primary key autoincrement," + NotePad.NOTE_ID
            + " TEXT," + NotePad.NOTE_NAME + " TEXT," + NotePad.NOTE_AGE
            + " TEXT);";

    // Declaration Datababsehelper
    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
            onCreate(db);
        }

    }

    // UriMatcher add URI
    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private final static int NOTES = 1;
    private final static int NOTE = 2;

    static {
        MATCHER.addURI(NotePad.AUTHORITY, "note", NOTES);
        MATCHER.addURI(NotePad.AUTHORITY, "note/#", NOTE);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // TODO Auto-generated method stub
        sqDb = helper.getWritableDatabase();
        int count = 0;
        switch (MATCHER.match(uri)) {
            case NOTES:
                count = sqDb.delete(TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
        getContext().getContentResolver().notifyChange(NotePad.CONTENT_URI, null);
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO Auto-generated method stub
        switch (MATCHER.match(uri)) {
            case NOTES:
                return "vnd.android.cursor.dir/note";
            case NOTE:
                return "vnd.android.cursor.item/note";
            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO Auto-generated method stub
        sqDb = helper.getWritableDatabase();
        Uri insertUri = null;
        long rowid = 0;
        switch (MATCHER.match(uri)) {
            case NOTES:
                rowid = sqDb.insert(TABLE_NAME, NotePad._ID, values);
                insertUri = ContentUris.withAppendedId(uri, rowid);
                getContext().getContentResolver().notifyChange(insertUri, null);
                Log.i(TAG, "insert:" + values.toString());
                break;
            default:
                throw new IllegalArgumentException("Unkwon Uri:" + uri.toString());
        }
        //通知监听器
        return insertUri;
    }

    @Override
    public boolean onCreate() {
        // TODO Auto-generated method stub
        helper = new DatabaseHelper(getContext());
        boolean result = helper == null ? false : true;
        Log.i(TAG, "create:" + String.valueOf(result));
        return result;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO Auto-generated method stub
        sqDb = helper.getWritableDatabase();

        switch (MATCHER.match(uri)) {
            case NOTES:
                Cursor notes = sqDb.query(TABLE_NAME, projection, selection,
                        selectionArgs, null, null, sortOrder);
                if (notes != null) {
                    //通知监听器
                    notes.setNotificationUri(getContext().getContentResolver(), NotePad.CONTENT_URI);
                }
                return notes;
            case NOTE://条件查询
                long id = ContentUris.parseId(uri);
                String where = NotePad._ID + "=" + id;
                if (selection != null && !"".equals(selection)) {
                    where = where + " and " + selection;
                }
                Cursor note = sqDb.query(TABLE_NAME, projection, where, selectionArgs, null,
                        null, sortOrder);
                if (note != null) {
                    note.setNotificationUri(getContext().getContentResolver(), NotePad.CONTENT_URI);
                }
                return note;
            default:
                throw new IllegalArgumentException("unknow uri" + uri.toString());
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO Auto-generated method stub
        sqDb = helper.getWritableDatabase();
        int count = 0;
        switch (MATCHER.match(uri)) {
            case NOTES:
                count = sqDb.update(TABLE_NAME, values, selection, selectionArgs);
                getContext().getContentResolver().notifyChange(NotePad.CONTENT_URI, null);
                return count;
            default:
                throw new IllegalArgumentException("unknow uri" + uri.toString());
        }

    }

}