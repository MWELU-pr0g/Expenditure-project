package com.cmutinda.expenditure;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private ItemDbHelper itemDbHelper;
    private ExependitureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddItemActivity.class));
            }
        });


        ItemDbHelper dbHelper = new ItemDbHelper(this);
        db = dbHelper.getReadableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExependitureAdapter(this, getItem());
        recyclerView.setAdapter(adapter);

    }


    private Cursor getItem() {
        Cursor cursor = db.query(ItemContract.ItemEntry.TABLE_NAME, null, null, null, null, null, null);

//

        return cursor;

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(getItem());
    }
}
