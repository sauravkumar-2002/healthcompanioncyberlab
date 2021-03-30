package com.example.hj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper {
    private static final String dbname="dbcontact";
    public dbmanager(@Nullable Context context) {
        super(context, dbname,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry="create table tbl_contact (id integer primary key autoincrement, date text,starttime text,endtime text)";
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
String qry="DROP TABLE IF EXISTS tbl_contact";
sqLiteDatabase.execSQL(qry);
onCreate(sqLiteDatabase);
    }
    public String addrecord(String date,String starttime,String endtime){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("date",date);
        cv.put("starttime",starttime);
        cv.put("endtime",endtime);
        float res=db.insert("tbl_contact",null,cv);
        if (res==-1)
        return "failed";
        else
            return "Exercise going on!!";
    }
    public Cursor readalldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select*from tbl_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }
}
