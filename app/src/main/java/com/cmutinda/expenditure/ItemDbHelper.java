package com.cmutinda.expenditure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import static com.cmutinda.expenditure.ItemContract.ItemEntry.COLUMN_DATE;
import static com.cmutinda.expenditure.ItemContract.ItemEntry.COLUMN_NAME;
import static com.cmutinda.expenditure.ItemContract.ItemEntry.COLUMN_PRICE;
import static com.cmutinda.expenditure.ItemContract.ItemEntry.TABLE_NAME;

public class ItemDbHelper extends SQLiteOpenHelper {

    private EditText editName,editPrice,editDate,editQty;
    private static final String TAG = "ItemDbHelper";

    public static final String DATABASE_NAME = "expenditure_info.db";
    public static final int DATABASE_VERSION = 3;

    public static final String CREATE_TABLE = "CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME +
            "("
            +ItemContract.ItemEntry.COLUMN_QUANTITY+ "  INTEGER,"
            +ItemContract.ItemEntry.COLUMN_NAME+ " TEXT,"
            +ItemContract.ItemEntry.COLUMN_PRICE+ " INTEGER,"
            +COLUMN_DATE+ " INTEGER);";
    public static final String DROP_TABLE = " DROP TABLE IF EXISTS " + ItemContract.ItemEntry.TABLE_NAME;

    public ItemDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d(TAG, "ItemDbHelper:database created... ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        db.execSQL(CREATE_TABLE);
        Log.d(TAG, "ItemDbHelper:table created... ");
    }

    //    there is a difference in creating a object of SQLiteOpenHelper AND SQLiteDatabase
    public void addItem(SQLiteDatabase db, int quantity, String item_name, int date
            , int price) {
    ContentValues values = new ContentValues();
        values.put(ItemContract.ItemEntry.COLUMN_QUANTITY,quantity);
        values.put(ItemContract.ItemEntry.COLUMN_NAME, item_name);
        values.put(ItemContract.ItemEntry.COLUMN_DATE, date);
        values.put(ItemContract.ItemEntry.COLUMN_PRICE, price);

        db.insert(ItemContract.ItemEntry.TABLE_NAME,null, values);
        Log.d(TAG, "ItemDbHelper:item inserted successfully... ");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);

        onCreate(db);

    }

    public Cursor getItem(SQLiteDatabase db) {
        db = this.getReadableDatabase();


        String[] projection = {
                COLUMN_NAME, COLUMN_PRICE};
        Cursor cursor = db.query(TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,
                null,                               // The columns for the WHERE clause// ,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null // The sort order
        );
//
        if (cursor != null)
            cursor.moveToNext();

        cursor.getColumnIndex(COLUMN_NAME);
        cursor.getColumnIndex(COLUMN_PRICE);

        return cursor;
    }

    public Cursor getSum(SQLiteDatabase db) {

        Cursor cur = db.rawQuery("SELECT SUM(price) FROM shopping_list ", null);
        if (cur.moveToFirst()) {
            cur.getColumnIndex(COLUMN_PRICE);

        }
        return cur;
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.setVersion(oldVersion);
    }
}