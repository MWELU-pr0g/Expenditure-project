package com.cmutinda.expenditure;

import android.provider.BaseColumns;

public final class ItemContract {


    ItemContract(){}

    public  static class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME="shopping_list";
        public static final String QUANTITY="quantity";
        public static final String ITEM_NAME="item_name";
        public static final String PRICE ="price";
        public static final String DATE="date";

    }
}
