package com.cmutinda.expenditure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends Activity {

    private Button addbutton;
    private Button viewbutton;
    private EditText e_name, e_price, e_date, e_quantitiy;

    private String name, price, date;
    private ExependitureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);


        addbutton = findViewById(R.id.add_item_btn);
        viewbutton = findViewById(R.id.view_item_btn);
        e_name = findViewById(R.id.edit1);
        e_price = findViewById(R.id.edit2);
        e_date = findViewById(R.id.edit3);
        e_quantitiy = findViewById(R.id.edit4);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = e_name.getText().toString();
                price = e_price.getText().toString();
                date = e_date.getText().toString();
                String qqty = e_quantitiy.getText().toString();

                BackgroundItem backgroundItem=new BackgroundItem(AddItemActivity.this);
                backgroundItem.execute("addItem",name,price,date);
                finish();


            }

            ;
        });


        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( AddItemActivity.this,MainActivity.class));



                ItemDbHelper dbHelper = new ItemDbHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();



                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
                adapter = new ExependitureAdapter(this, getItem());
                recyclerView.setAdapter(adapter);


            }

        });
    }
}
