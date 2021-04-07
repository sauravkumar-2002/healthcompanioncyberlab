package com.example.hj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbmanagersleep extends SQLiteOpenHelper {
    private static final String dbnamesleep="dbcontactsleep1";

    public dbmanagersleep(@Nullable Context context) { super(context, dbnamesleep, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qrysleep="create table tbl_contact1 (id integer primary key autoincrement, datesleep text, statussleep text)";
        sqLiteDatabase.execSQL(qrysleep);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String qry="DROP TABLE IF EXISTS tbl_contact1";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }
    public String addrecord(String datesleep,String statussleep){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("datesleep",datesleep);
        cv.put("statussleep",statussleep);

        float res=db.insert("tbl_contact1",null,cv);
        if (res==-1)
            return "failed";
        else
            return "Wait!!";
    }
    public Cursor readalldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="select*from tbl_contact1 order by id desc";
        Cursor cursor=db.rawQuery(qry,null);
        return cursor;
    }
}
