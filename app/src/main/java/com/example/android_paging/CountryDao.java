package com.example.android_paging;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     public void insertCountriesList(Country country);

    @Query("SELECT * FROM Country")
    public abstract DataSource.Factory<Integer,Country> getCountries();
}
