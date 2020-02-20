package com.cmutinda.expenditure;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

public class ListItemActivity extends AppCompatActivity {

    private Button addbutton;
    private SQLiteDatabase db;
    private ItemDbHelper itemDbHelper;
    private ExependitureAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        addbutton = findViewById(R.id.addBtn);

        ItemDbHelper dbHelper = new ItemDbHelper(this);
        db = dbHelper.getReadableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExependitureAdapter(this, getItem());
        recyclerView.setAdapter(adapter);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ListItemActivity.this, AddItemActivity.class));
            }

        });
    }

    private Cursor getItem() {
        Cursor cursor = db.query(ItemContract.ItemEntry.TABLE_NAME, null, null, null, null, null, null);

//

        return cursor;

    }

}
