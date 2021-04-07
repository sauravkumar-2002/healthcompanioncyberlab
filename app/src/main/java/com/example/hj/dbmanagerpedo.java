package com.example.hj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanagerpedo extends SQLiteOpenHelper {
    private static final String dbnamepedo = "dbcontactpedo1";

    public dbmanagerpedo(@Nullable Context context) {
        super(context, dbnamepedo, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "create table tbl_contact (id integer primary key autoincrement, dateandtime text,textviewstepcount text,textview1stepdetect text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public String addrecord1(String dateandtime, String textviewstepcount, String textview1stepdetect) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("dateandtime", dateandtime);
        cv.put("textviewstepcount", textviewstepcount);
        cv.put("textview1stepdetect", textview1stepdetect);
        float res = db.insert("tbl_contact", null, cv);
        if (res == -1)
            return "failed";
        else
            return "wait!!";
    }

    public Cursor readalldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select*from tbl_contact order by id desc";
        Cursor cursor = db.rawQuery(qry, null);
        return cursor;
    }
}
