package com.example.android_paging;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public  class CountryViewModel extends AndroidViewModel{
    public CountryDao countryDao;
    private CountryDatabase countryDatabase;
    public  LiveData<PagedList<Country>> countrieslist;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        countryDatabase=CountryDatabase.getCountryDatabase(this.getApplication());
        countryDao=countryDatabase.countryDao();
    }
    public  void init(CountryDao countryDao)
    {
        PagedList.Config pagelistConfig=
                (new PagedList.Config.Builder()).setEnablePlaceholders(true)
                .setPrefetchDistance(10)
                .setPageSize(10).build();
        countrieslist=(new LivePagedListBuilder(countryDao.getCountries(),
                pagelistConfig)).build();
    }

}
