package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MyDb extends SQLiteOpenHelper {

    public static final String DBName = "TestDB";
    public static final int DBVersion = 1;
    public static final String table = "table";
    public static final String Name = "Name";
    public static final String address = "address";
    public static final String bg = "BG";
    public static final String city = "city";
    public static final String gmail = "gmail";
    public static final String password = "password";
    public static final String reenter = "reenter";


    Context c;

    public MyDb(Context context) {
        super(context, DBName, null, DBVersion);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + Name + "(" + address + " String,"
                + bg + " String," + city + " String," + gmail + " String, " + password + " String, " + reenter + " String);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void added(logindata Logindata, String id) {
        SQLiteDatabase db = this.getWritableDatabase();


        /*************************Insert**********************/

        ContentValues cv = new ContentValues();
        cv.put(address, Logindata.getAddress());
        cv.put(password, Logindata.getPassword());
        cv.put(reenter, Logindata.getReenter());
        cv.put(Name, Logindata.getName());
        cv.put(gmail, Logindata.getGmail());
        cv.put(bg, Logindata.getBg());
        cv.put(city, Logindata.getCity());


        /*************************Update**********************/
        db.update(table, cv, "bg = ? AND gmail = ?", new String[]{"3", "500"});
        db.update(table, cv, "gmail < ? ", new String[]{"1000"});
////////
////////        /*************************Delete**********************/
//       db.delete(BooksTable , "id = ?" , new String[]{id});

        long l = db.insert(table, null, cv);
        if (l == -1) {
            Toast.makeText(c, "Data Not Insert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(c, "Data Inserted", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }
}



