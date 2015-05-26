package com.qq.Provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class NotePad implements BaseColumns {


    public final static String AUTHORITY = "org.note.provider";
    public final static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/note");
    //表字段
    public final static String NOTE_ID = "note_id";
    public final static String NOTE_NAME = "note_name";
    public final static String NOTE_AGE = "note_age";

    private String note_id, note_name, note_age;

    public NotePad(String id, String name, String age) {
        note_id = id;
        note_name = name;
        note_age = age;
    }

    public void setNote_id(String note_id) {
        this.note_id = note_id;
    }

    public void setNote_age(String note_age) {
        this.note_age = note_age;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public String getNote_id() {
        return note_id;
    }

    public String getNote_name() {
        return note_name;
    }

    public String getNote_age() {
        return note_age;
    }
}
