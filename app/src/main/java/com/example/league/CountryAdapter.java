package com.example.league;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {
    public CountryAdapter(@NonNull Context context, ArrayList<Country> countriesArrayList) {
        super (context, 0, countriesArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return initView(position, convertView, parent);
    }

    @NonNull
    private View initView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.my_row, parent, false
            );
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView texView2 = convertView.findViewById(R.id.textView);
        Country currentItem = getItem(position);

        if (currentItem != null) {
            imageView.setImageResource(currentItem.getImg());
            texView2.setText(currentItem.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
}
