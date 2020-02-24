package com.cmutinda.expenditure;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
;

public class BackgroundItem extends AsyncTask<String, Void, String> {

    Context ctx;

    BackgroundItem(Context ctx) {

        this.ctx = (Context) ctx;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
    }


    @Override
    protected String doInBackground(String[] params) {
        String method = params[0];
        ItemDbHelper dbHelper = new ItemDbHelper(ctx);

        try {
                if (method.equals("addItem "  ) ){
                int price = Integer.parseInt(params[2]);
                String name = params[1];
                int date = Integer.parseInt(params[3]);
                int qqty = Integer.parseInt(params[4]);

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.addItem(db, name, date,qqty, price);

                return "one row is inserted";
            } else if (method.equals("get_item")) {
                    SQLiteDatabase db=dbHelper.getReadableDatabase();



            }

        } catch (NumberFormatException ex) {
        }return null;

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }
}