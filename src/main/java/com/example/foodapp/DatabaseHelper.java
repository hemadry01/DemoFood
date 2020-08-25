package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="food.db";
    public static final String TABLE_NAME="food_table";

    public static final String FOOD_ID="id";
    public static final String  FOOD_NAME="name";
    public static final String FOOD_PPRICE="price";

    public static final String CREATE_TABLE="create table "+TABLE_NAME+"("+FOOD_ID+"  INTEGER PRIMARY KEY AUTOINCREMENT,"+FOOD_NAME+" VARCHAR(255), "+FOOD_PPRICE+" VARCHAR(255));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public long  insertData(String product_name,String product_price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FOOD_NAME, product_name);
        contentValues.put(FOOD_PPRICE, product_price);

        long result=db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return result;

    }

    public Cursor showData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME+"",null);
        return cursor;
    }


    public List<String> getAllLabels(){
        List<String> list = new ArrayList<String>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;
    }
}
