package com.cmutinda.expenditure;

import android.provider.BaseColumns;

public final class ItemContract {


    ItemContract(){}

    public  static class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME="shopping_list";
        public static final String COLUMN_QUANTITY ="quantity";
        public static final String COLUMN_NAME ="item_name";
        public static final String COLUMN_PRICE ="price";
        public static final String COLUMN_DATE ="date";


    }
}
