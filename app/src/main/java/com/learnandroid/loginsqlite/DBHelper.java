package com.learnandroid.loginsqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login2.db";
    public static final String userstbl = "users";
    public static final String booktbl = "booklist";
    public DBHelper(Context context) {
        super(context, "Login2.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
       // MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        //MyDB.execSQL("create Table booklist(book TEXT primary key, author TEXT)");
        String table1 = "CREATE TABLE "+userstbl+"(username TEXT primary key, password TEXT)";
        String table2 = "CREATE TABLE "+booktbl+"(book TEXT primary key, author TEXT)";
        MyDB.execSQL(table1);
        MyDB.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
       // MyDB.execSQL("drop Table if exists users");
        //MyDB.execSQL("drop Table if exists booklist");
        MyDB.execSQL("DROP TABLE IF EXISTS "+userstbl);
        MyDB.execSQL("DROP TABLE IF EXISTS "+booktbl);
        onCreate(MyDB);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert(userstbl, null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean insertBook(String book, String author){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues bookValues= new ContentValues();
        bookValues.put("book", book);
        bookValues.put("author", author);
        long result = MyDB.insert(booktbl, null, bookValues);
        if(result==-1) return false;
        else
            return true;
    }
    // Select All Data
    public String[] SelectAllData() {
        // TODO Auto-generated method stub

        try {
            String arrData[] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  book FROM " + booktbl;
            Cursor cursor = db.rawQuery(strSQL, null);

            if(cursor != null)
            {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getCount()];
                    /***
                     *  [x] = Name
                     */
                    int i= 0;
                    do {
                        arrData[i] = cursor.getString(0);
                        i++;
                    } while (cursor.moveToNext());

                }
            }
            cursor.close();

            return arrData;

        } catch (Exception e) {
            return null;
        }

    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }




}