package com.cmutinda.expenditure;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenditureList extends Fragment {
    private Button addbutton;
    private SQLiteDatabase db;
    private ItemDbHelper itemDbHelper;
    private ExependitureAdapter adapter;


    public ExpenditureList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expenditure_list, container, false);
        addbutton = view.findViewById(R.id.addBtn);

        ItemDbHelper dbHelper = new ItemDbHelper(getActivity());
        db = dbHelper.getReadableDatabase();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ExependitureAdapter(getContext(), getItem());
        recyclerView.setAdapter(adapter);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItem addItem = new AddItem();
                MainActivity.fragmentManager.beginTransaction().add(R.id.frag_container, new AddItem(), null).addToBackStack(null).commit();


            }

        });


        return view;
    }

    private Cursor getItem() {
        Cursor cursor = db.query(ItemContract.ItemEntry.TABLE_NAME, null, null, null, null, null, null);

//

        return cursor;

    }

}
