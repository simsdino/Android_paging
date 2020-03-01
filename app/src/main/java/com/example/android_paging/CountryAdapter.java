package com.example.android_paging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CountryAdapter extends PagedListAdapter<Country, CountryAdapter.CountryViewHolder> {

    protected CountryAdapter() {
        super(Country.Diff_Callback);
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler,parent,false);

        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country=getItem(position);
         if (country!=null)
             holder.bindTo(country);


    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView id;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            id= itemView.findViewById(R.id.txt_id);
            name=itemView.findViewById(R.id.txt_name);
        }
        public void bindTo(Country country)
        {
            name.setText(Country.CountryName);
            id.setText(Integer.toString(new Country().id));
        }

    }
}
