package com.example.android_paging;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {Country.class},version = 1)
public abstract class CountryDatabase extends RoomDatabase {
    private static  final String DB_NAME="Country_Database.db";
    private static  CountryDatabase INSTANCE;

    public static CountryDatabase getCountryDatabase(Context context)
    {
        if (INSTANCE==null)
        {
            INSTANCE= Room.databaseBuilder(context,CountryDatabase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(sRoomDtabaseCallback)
                    .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance()
    {
        INSTANCE=null;
    }
    public abstract CountryDao countryDao();
    private static RoomDatabase.Callback sRoomDtabaseCallback=
            new RoomDatabase.Callback()
            {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();

                }
            };
    private static class  PopulateDbAsync extends AsyncTask<Void,Void,Void>
    {
        private final CountryDao mdao;
        private static String [] colleges={"JKUAT","CUEA","COPERATIVE","KU"};
        PopulateDbAsync(CountryDatabase db){mdao=db.countryDao();}

        @Override
        protected Void doInBackground(final Void... params) {
            {
                for (int i=0;i<=colleges.length-1;i++)
                {
                    Country country=new Country("JKUAT");
                    mdao.insertCountriesList(country);
                }
            }
            return null;
        }
    }



}
