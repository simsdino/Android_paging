package com.example.android_paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "Country")
public class Country {
    public Country(){}


    public static DiffUtil.ItemCallback<Country> Diff_Callback
            =new DiffUtil.ItemCallback<Country>() {
        @Override
        public boolean areItemsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return oldItem.id==newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Country oldItem, @NonNull Country newItem) {
            return Objects.equals(oldItem, newItem);
        }
    };
    @PrimaryKey(autoGenerate = true)
     public  int id;

    public static String CountryName;

    public Country(String countryName)
    {
        CountryName=countryName;
    }

    @NonNull
    @Override
    public String toString() {
        return "Country{" +
                "id=" +id+
                ", countryName='"+CountryName+'\''+
                '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj==this)
            return true;
        Country country=(Country) obj;
        return  country.id==this.id
                && country.CountryName==this.CountryName;


    }
}
