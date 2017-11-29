package com.example.seohyun.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DatebaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Asset.db";
    public static final String TABLE_NAME = "asset_table";
    public static final String COL_1 = "DATE";
    public static final String COL_2 = "INCOME";
    public static final String COL_3 = "EXPENSE";
    public static final String COL_4 = "BUDGET";

    public DatebaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_String ="create table " + TABLE_NAME + "(DATE INTEGER PRIMARY KEY AUTOINCREMENT,INCOME TEXT, EXPENSE TEXT, BUDGET )";
        db.execSQL(SQL_String);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_String ="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(SQL_String);
        onCreate(db);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res  = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }

    public boolean insertData(String date, String income, String expense, String budget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,date);
        contentValues.put(COL_2,income);
        contentValues.put(COL_3,expense);
        contentValues.put(COL_4,budget);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(String date,String income, String expense, String result){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,date);
        contentValues.put(COL_2,income);
        contentValues.put(COL_3,expense);
        contentValues.put(COL_4,result);
        db.update(TABLE_NAME, contentValues, "DATE = ?", new String[] {date} );
        return true;
    }

    public Integer deleteData (String date){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"DATE = ?",new String[] {date});
    }
}
