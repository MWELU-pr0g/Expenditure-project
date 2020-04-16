package com.cmutinda.expenditure;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface SpendDao {
    @Insert
    void insert(Spend spend);
    @Update
    void update(Spend spend);
    @Delete
    void delete(Spend spend);
    @Query("DELETE FROM spend_table")
    void deleteAll();
    @Query("SELECT* FROM spend_table")
    LiveData<List<Spend>>getAll();
}
