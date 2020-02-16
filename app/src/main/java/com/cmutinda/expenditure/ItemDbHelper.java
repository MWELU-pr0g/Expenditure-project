package com.cmutinda.expenditure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class ItemDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="expenditure_info.db";
    public static final int DATABASE_VERSION=1;

    public static final String CREATE_TABLE = "create table "+ItemContract.ItemEntry.TABLE_NAME+
            "("+ItemContract.ItemEntry.QUANTITY+", number"
            +ItemContract.ItemEntry.ITEM_NAME+" text,"
            +ItemContract.ItemEntry.PRICE +" text,"
            +ItemContract.ItemEntry.DATE+" number)";
    public static final String DROP_TABLE=" DROP TABLE IF EXISTS "+ItemContract.ItemEntry.TABLE_NAME;

    public ItemDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d(TAG, "ItemDbHelper:database created... ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "ItemDbHelper:table created... ");

        db.execSQL(CREATE_TABLE);
    }

//    there is a differnce in creating a object of SQliteOpenHelper AND SQLiteDatabase
    public void addItem(SQLiteDatabase db, int quantity, String item_name, int price
            , int date){
        ContentValues values=new ContentValues();
        values.put(ItemContract.ItemEntry.QUANTITY,quantity);
        values.put(ItemContract.ItemEntry.ITEM_NAME,item_name);
        values.put(ItemContract.ItemEntry.DATE,date);
        values.put(ItemContract.ItemEntry.PRICE,price);

       db.insert(ItemContract.ItemEntry.TABLE_NAME,null,values);



    }
    public Cursor getItem(SQLiteDatabase db){
        String [] projection={ItemContract.ItemEntry.ITEM_NAME,ItemContract.ItemEntry.PRICE,ItemContract.ItemEntry.DATE};

        Cursor cursor=db.query(ItemContract.ItemEntry.TABLE_NAME,projection,null,null,null,null,null);

        return cursor;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

}
