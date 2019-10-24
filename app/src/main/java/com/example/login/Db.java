package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Db extends SQLiteOpenHelper {
    public static final String DBName = "TestDB";
    public static final int DBVersion = 1;
    public static final String table1 = "table1";
    public static final String gmail1 = "gmail1";
    public static final String password1 = "password1";
    Context c;

    public Db(Context context) {
        super(context, DBName, null, DBVersion);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + table1 + "(" + gmail1 + " String," +
                "                 passsword1);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void added(logindata Logindata, String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(gmail1, Logindata.getAddress());
        cv.put(password1, Logindata.getPassword());
        db.update(table1 ,cv, "password1 = ? AND gmail = ?", new String[]{"3", "500"});
        db.update( table1, cv, "gmail < ? ", new String[]{"1000"});
///////
        long l = db.insert(table1, null, cv);
        if (l == -1) {
            Toast.makeText(c, "Data Not Insert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(c, "Data Inserted", Toast.LENGTH_SHORT).show();

        }
        db.close();
//
    }
}
