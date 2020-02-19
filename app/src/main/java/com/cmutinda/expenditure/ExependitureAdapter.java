package com.cmutinda.expenditure;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ExependitureAdapter extends CursorAdapter {
    LayoutInflater inflater;
    public ExependitureAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.text1);
        name.setText(cursor.getString(cursor.getColumnIndex("name")));

//        TextView price = (TextView) view.findViewById(R.id.text2);
//        price.setText(cursor.getString(cursor.getColumnIndex("price")));
//
//         TextView date = (TextView) view.findViewById(R.id.text3);
//        date.setText(cursor.getString(cursor.getColumnIndex("date")));


    }
}
