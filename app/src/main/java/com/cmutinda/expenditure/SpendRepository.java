package com.cmutinda.expenditure;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Update;

import java.util.List;

public class SpendRepository {
    private SpendDao spendDao;
    private LiveData<List<Spend>> allSpending;

    public SpendRepository(Application application){
        SpendDatabase database=SpendDatabase.getInstance(application);
        spendDao=database.spendDao();

        allSpending=spendDao.getAll();

    }
    public void insert(Spend spend){ new InsertSpendAsyncTask(spendDao).execute(spend); }
    public void update(Spend spend){ new UpdateSpendAsyncTask(spendDao).execute(spend); }
    public void delete(Spend spend){ new DeleteSpendAsyncTask(spendDao).execute(spend); }
    public void deleteAll(Spend spend){ new DeleteAllSpendAsyncTask(spendDao).execute();}

    public LiveData<List<Spend>>getAllSpending(){
        return allSpending;
    }
private static class InsertSpendAsyncTask extends AsyncTask<Spend,Void,Void>{
   private SpendDao spendDao;

   private InsertSpendAsyncTask(SpendDao spendDao){
       this.spendDao=spendDao;
   }
    @Override
    protected Void doInBackground(Spend... spends) {
       spendDao.insert(spends[0]);
        return null;
    }
}
    private static class UpdateSpendAsyncTask extends AsyncTask<Spend,Void,Void>{
        private SpendDao spendDao;

        private UpdateSpendAsyncTask(SpendDao spendDao){
            this.spendDao=spendDao;
        }
        @Override
        protected Void doInBackground(Spend... spends) {
            spendDao.update(spends[0]);
            return null;
        }
    }

    private static class DeleteSpendAsyncTask extends AsyncTask<Spend,Void,Void>{
        private SpendDao spendDao;

        private DeleteSpendAsyncTask(SpendDao spendDao){
            this.spendDao=spendDao;
        }
        @Override
        protected Void doInBackground(Spend... spends) {
            spendDao.delete(spends[0]);
            return null;
        }
    }
    private static class DeleteAllSpendAsyncTask extends AsyncTask<Void,Void,Void>{
        private SpendDao spendDao;

        private DeleteAllSpendAsyncTask(SpendDao spendDao){
            this.spendDao=spendDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            spendDao.deleteAll();
            return null;
        }
    }


}
