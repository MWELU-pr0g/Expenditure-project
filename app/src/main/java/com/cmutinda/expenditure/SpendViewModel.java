package com.cmutinda.expenditure;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class SpendViewModel extends AndroidViewModel {
    private SpendRepository repository;
    private LiveData<List<Spend>> allSpend;

    public SpendViewModel(@NonNull Application application) {
        super(application);
        repository = new SpendRepository(application);
        allSpend = repository.getAllSpending();
    }

    public void insert(Spend spend) {
        repository.insert(spend);
    }

    public void update(Spend spend) {
        repository.update(spend);
    }

    public void delete(Spend spend) {
        repository.delete(spend);
    }
    public void deleteAllSpend(Spend spend){
        repository.deleteAll(spend);
    }

    public LiveData<List<Spend>> getAllSpend() {
        return allSpend;
    }
}