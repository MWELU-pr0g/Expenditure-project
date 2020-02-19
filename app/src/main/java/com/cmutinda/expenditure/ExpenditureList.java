package com.cmutinda.expenditure;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenditureList extends Fragment  {
    ListView listView;
    private Button addbutton;
    SQLiteDatabase db;
    ItemDbHelper itemDbHelper;



    public ExpenditureList() {
        // Required empty public constructor
    }



    public interface OnDbOpListener{
        public void dbOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_expenditure_list, container, false);
        addbutton=view.findViewById(R.id.addBtn);
        listView=view.findViewById(R.id.fragment_list);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItem addItem=new AddItem(getContext());
                MainActivity.fragmentManager.beginTransaction().add(R.id.frag_container, new AddItem(getContext()),null).addToBackStack(null).commit();




            }

        });




        return view;}

    }
