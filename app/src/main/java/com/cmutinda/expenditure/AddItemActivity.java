package com.cmutinda.expenditure;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.cmutinda.expenditure.ItemContract.ItemEntry.TABLE_NAME;

public class AddItemActivity extends Activity {

    private Button viewbutton;
    private EditText e_name, e_price, e_date, e_quantitiy;
    String name, price, date, qqty;
     ExependitureAdapter adapter;
     View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);





        viewbutton = findViewById(R.id.view_item_btn);
        e_name = findViewById(R.id.edit1);
        e_price = findViewById(R.id.edit2);
        e_date = findViewById(R.id.edit3);
        e_quantitiy = findViewById(R.id.edit4);}


        public void savedItems (View view){
            name = e_name.getText().toString();
            price = e_price.getText().toString();
            date = e_date.getText().toString();
            qqty = e_quantitiy.getText().toString();

            BackgroundItem backgroundItem = new BackgroundItem(AddItemActivity.this);
            backgroundItem.execute(TABLE_NAME, name, price, date,qqty);

            finish();
        }

    }









