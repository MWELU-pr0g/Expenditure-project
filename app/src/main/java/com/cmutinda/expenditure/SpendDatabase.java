package com.cmutinda.expenditure;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class SpendDatabase extends RoomDatabase {
    public static SpendDatabase INSTANCE;
    public abstract SpendDao spendDao();
    public static synchronized SpendDatabase getDatabase(final Context context){
        if(INSTANCE==null){
          INSTANCE  = Room.databaseBuilder(context.getApplicationContext(), SpendDatabase.class,"spend_database")
                    .fallbackToDestructiveMigration().addCallback(callback).build();
        }
        return INSTANCE ;
    }
    private static RoomDatabase.Callback callback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private SpendDao spendDao;

        private PopulateDbAsyncTask(SpendDatabase database){
            spendDao=database.spendDao();

        }
        @Override
        protected Void doInBackground(Void... voids) {
//            spendDao.update(new Spend("Mango",12000,"2/2/2020"));

            return null;
        }
    }
}

