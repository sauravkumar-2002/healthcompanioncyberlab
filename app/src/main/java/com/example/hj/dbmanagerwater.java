package com.example.hj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanagerwater extends SQLiteOpenHelper {
    private static final String dbnamewater="dbcontactwater";
    public dbmanagerwater(@Nullable Context context) {
        super(context, dbnamewater,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qrywater="create table tbl_contact (id integer primary key autoincrement, dateandtimewater text,glass text)";
        sqLiteDatabase.execSQL(qrywater);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String qrywater="DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qrywater);
        onCreate(sqLiteDatabase);
    }
    public String addrecord(String dateandtimewater,String glass){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("dateandtimewater",dateandtimewater);
        cv.put("glass",glass);

        float res=db.insert("tbl_contact",null,cv);
        if (res==-1)
            return "failed";
        else
            return "Wait!!";
    }
    public Cursor readalldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select*from tbl_contact order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }
}

