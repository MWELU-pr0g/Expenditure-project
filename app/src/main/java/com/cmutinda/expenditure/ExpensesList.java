package com.cmutinda.expenditure;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static androidx.lifecycle.ViewModelProvider.*;

public class ExpensesList extends AppCompatActivity {
    public static final int ADD_ITEM_REQUEST = 1;
    private SpendViewModel model;


    private ItemDbHelper dbHelper;
    private ExependitureAdapter adapter;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_list);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        model = new ViewModelProvider(this).get(SpendViewModel.class);
        model.getAllSpend().observe(this, new Observer<List<Spend>>() {
            @Override
            public void onChanged(List<Spend> spends) {
                adapter.setSpend(spends);

            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(ExpensesList.this, AddItemActivity.class));
                startActivityForResult(intent, ADD_ITEM_REQUEST);
            }
        });

//        dbHelper = new ItemDbHelper(this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        adapter = new ExependitureAdapter();
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
//        adapter.swapCursor(dbHelper.getItem(db));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_ITEM_REQUEST && resultCode == RESULT_OK) {
            String name=data.getStringExtra(AddItemActivity.EXTRA_NAME);
            int price=data.getIntExtra(AddItemActivity.EXTRA_PRICE,0);
            String date=data.getStringExtra(AddItemActivity.EXTRA_DATE);
            int qqty=data.getIntExtra(AddItemActivity.EXTRA_QUANTITY,0);

            Spend spend =new Spend(name,price,date,qqty);
            model.insert(spend);
            Toast.makeText(this, "Expenses Saved", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Expenses Not Saved", Toast.LENGTH_SHORT).show();
        }
    }


}
