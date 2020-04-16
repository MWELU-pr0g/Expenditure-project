package com.cmutinda.expenditure;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "spend_table")
public class Spend {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String item_name;
    private int price;
    private String date;
    private int quantity;

    public Spend(String item_name, int price, String date,int quantity) {
        this.item_name = item_name;
        this.price = price;
        this.date = date;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}