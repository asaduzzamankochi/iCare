package com.example.ahad.icare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mobile App Develop on 10-6-15.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iCare";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = null;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE my_profile(id integer primary key autoincrement,name TEXT, birthDay TEXT, gender TEXT, bloodGroup TEXT, height TEXT, weight TEXT, phoneNo TEXT)");
        db.execSQL("CREATE TABLE family_profile(id integer primary key autoincrement,name TEXT, birthDay TEXT, gender TEXT, bloodGroup TEXT, height TEXT, weight TEXT, phoneNo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void insertMyProfile(String name, String birthDay, String gender, String bloodGroup, String height, String weight, String phoneNo) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("birthDay", birthDay);
        values.put("gender", gender);
        values.put("bloodGroup", bloodGroup);
        values.put("height", height);
        values.put("weight", weight);
        values.put("phoneNo", phoneNo);
        try {
            sqLiteDatabase.insert("my_profile", null, values);
            Log.i(TAG, "Success");
        } catch (SQLException e) {
            Log.i(TAG, "Error");
        }


    }


    public void insertFamilyProfile(String name, String birthDay, String gender, String bloodGroup, String height, String weight, String phoneNo) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("birthDay", birthDay);
        values.put("gender", gender);
        values.put("bloodGroup", bloodGroup);
        values.put("height", height);
        values.put("weight", weight);
        values.put("phoneNo", phoneNo);
        try {
            sqLiteDatabase.insert("family_profile", null, values);
            Log.i(TAG, "Success");
        } catch (SQLException e) {
            Log.i(TAG, "Error");
        }


    }

    public void updateMyProfile(String name, String birthDay, String gender, String bloodGroup, String height, String weight, String phoneNo) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("birthDay", birthDay);
        values.put("gender", gender);
        values.put("bloodGroup", bloodGroup);
        values.put("height", height);
        values.put("weight", weight);
        values.put("phoneNo", phoneNo);

        sqLiteDatabase.update("my_profile", values, "id= ?", new String[]{Integer.toString(0)});

    }


    public int checkId(){
        String query = "SELECT * FROM my_profile";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String count = "SELECT count(*) FROM table";
        Cursor mcursor = sqLiteDatabase.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0)
            return 1;
        else
            return 0;

    }


}
