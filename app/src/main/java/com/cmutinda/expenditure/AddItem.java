package com.cmutinda.expenditure;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private Button addbutton;
   private Button viewbutton;
    private EditText e_name, e_price, e_date, e_quantitiy;

   private String name, price, date;
    private ExependitureAdapter adapter;


    public AddItem() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_add_item, container, false);

        ItemDbHelper dbHelper = new ItemDbHelper(getActivity());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

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



                //MainActivity.fragmentManager.beginTransaction().replace(R.id.recycler_view, new ExpenditureList(),null).addToBackStack(null).commit();

            }

            ;
        });


        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }

        });


        return view;
    }


}


