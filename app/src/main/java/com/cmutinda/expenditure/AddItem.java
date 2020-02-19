package com.cmutinda.expenditure;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddItem extends Fragment {
    Button addbutton;
    Button viewbutton;
    EditText e_name, e_price, e_date, e_quantitiy;

    String name, price, date;


    public AddItem() {
        // Required empty public constructor
    }

    public interface OnDbOpListener {
        public void dbOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_add_item, container, false);

        addbutton = view.findViewById(R.id.add_item_btn);
        viewbutton = view.findViewById(R.id.view_item_btn);
        e_name = view.findViewById(R.id.edit1);
        e_price = view.findViewById(R.id.edit2);
        e_date = view.findViewById(R.id.edit3);
        e_quantitiy = view.findViewById(R.id.edit4);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = e_name.getText().toString();
                price = e_price.getText().toString();
                date = e_date.getText().toString();
                String qqty = e_quantitiy.getText().toString();

                BackgroundItem backgroundItem = new BackgroundItem(v.getContext());
                backgroundItem.execute("addItem", name, price, date, qqty);

                ItemDbHelper dbHelper = new ItemDbHelper(getActivity());
                SQLiteDatabase db = dbHelper.getReadableDatabase();

            }

            ;
        });


        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ItemDbHelper helper = new ItemDbHelper(getContext());
                SQLiteDatabase db = helper.getReadableDatabase();
                ListView aListView = view.findViewById(R.id.fragment_list);
                Cursor c = helper.getItem(db);
                ExependitureAdapter adapter = new ExependitureAdapter(getContext(), c, 0);
                aListView.setAdapter(adapter);


            }

        });


        return view;
    }


}


