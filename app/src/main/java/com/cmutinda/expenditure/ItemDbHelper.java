package com.cmutinda.expenditure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import javax.crypto.spec.DESKeySpec;

import static android.content.ContentValues.TAG;

public class ItemDbHelper extends SQLiteOpenHelper{
    private static final String TAG = "ItemDbHelper";

    public static final String DATABASE_NAME="expenditure_info.db";
    public static final int DATABASE_VERSION=1;

    public static final String CREATE_TABLE = "create table "+ItemContract.ItemEntry.TABLE_NAME+
            "(_id INTEGER PRIMARY KEY AUTOINCREMENT ,"
            +ItemContract.ItemEntry.QUANTITY+" integer,"
            +ItemContract.ItemEntry.ITEM_NAME+" text,"
            +ItemContract.ItemEntry.PRICE +" text,"
            +ItemContract.ItemEntry.DATE+" integer)";
    public static final String DROP_TABLE=" DROP TABLE IF EXISTS "+ItemContract.ItemEntry.TABLE_NAME;

    public ItemDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d(TAG, "ItemDbHelper:database created... ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Log.d(TAG, "ItemDbHelper:table created... ");
    }

//    there is a differnce in creating a object of SQliteOpenHelper AND SQLiteDatabase
    public void addItem(SQLiteDatabase db, int quantity, String item_name, int date
            , int price){
        ContentValues values=new ContentValues();
        values.put(ItemContract.ItemEntry.QUANTITY,quantity);
        values.put(ItemContract.ItemEntry.ITEM_NAME,item_name);
        values.put(ItemContract.ItemEntry.DATE,date);
        values.put(ItemContract.ItemEntry.PRICE,price);

       db.insert(ItemContract.ItemEntry.TABLE_NAME,null,values);



    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

}
