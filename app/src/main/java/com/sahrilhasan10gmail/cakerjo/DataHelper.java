package com.sahrilhasan10gmail.cakerjo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "kampus.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table kampus(no integer primary key, nama text null, deskripsi text null, foto text null, lat text null, ling text null, fav text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    public List<Kampus> allKampus() {
        List<Kampus> kampus = new ArrayList<>();
        String selectQuery = "SELECT  * FROM kampus";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Kampus kampus1 = new Kampus();
                kampus1.setId(cursor.getString(0));
                kampus1.setName(cursor.getString(1));
                kampus1.setFrom(cursor.getString(2));
                kampus1.setPhoto(cursor.getString(3));
                kampus1.setLat(cursor.getString(4));
                kampus1.setLing(cursor.getString(5));

                kampus.add(kampus1);
            } while (cursor.moveToNext());
        }

        db.close();
        return kampus;
    }
}