package com.cmutinda.expenditure;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import static com.cmutinda.expenditure.ItemContract.ItemEntry.TABLE_NAME;

public class AddItemActivity extends Activity {
    public static final String EXTRA_NAME=
            "com.cmutinda.expenditure.EXTRA_NAME";
    public static final String EXTRA_PRICE=
            "com.cmutinda.expenditure.EXTRA_PRICE";
    public static final String EXTRA_DATE=
            "com.cmutinda.expenditure.EXTRA_DATE";
    public static final String EXTRA_QUANTITY=
            "com.cmutinda.expenditure.EXTRA_QUANTITY";
    private EditText e_name, e_price, e_date, e_quantity;
    private Button addButton;
//     ExpenditureAdapter adapter;
//     View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);





        e_name = findViewById(R.id.edit1);
        e_price = findViewById(R.id.edit2);
        e_date = findViewById(R.id.edit3);
        e_quantity = findViewById(R.id.edit4);
        addButton=findViewById(R.id.add_item_btn);
    }


        public void savedItems (){
           String name = e_name.getText().toString();
           int price = Integer.parseInt(e_price.getText().toString());
           String date = e_date.getText().toString();
           int qqty = Integer.parseInt(e_quantity.getText().toString())         ;

            if(name.trim().isEmpty()){
                Toast.makeText(this, "PLEASE INSERT ITEM NAME AND PRICE!", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent data =new Intent();
            data.putExtra(EXTRA_NAME,name);
            data.putExtra(EXTRA_PRICE,price);
//            data.putExtra(EXTRA_DATE,date);
//            data.putExtra(EXTRA_QUANTITY,qqty);



            setResult(RESULT_OK,data);
            finish();
//            BackgroundItem backgroundItem = new BackgroundItem(AddItemActivity.this);
//            backgroundItem.execute("add_Item", name, price, date,qqty);
//            finish();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.save_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getGroupId()){
            case R.id.save_icon:
            savedItems();
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void viewSpend(View view) {
        startActivity(new Intent(AddItemActivity.this,ExpensesList.class));
    }
}









