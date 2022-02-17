package com.example.league;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerClass;
    private ArrayList<Country> mCountries;
    private CountryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerClass = (Spinner) findViewById(R.id.spinner);
        initList();

        mAdapter = new CountryAdapter( this, mCountries);
        spinnerClass.setAdapter(mAdapter);
        spinnerClass.setSelected(false);
        spinnerClass.setSelection(0,true);

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Country selectedItem = (Country) parent.getItemAtPosition(position);
                String selectedCountry = selectedItem.getName();
                Toast.makeText(MainActivity.this, selectedCountry, Toast.LENGTH_SHORT).show();
                if (!selectedCountry.equals("Select a country")) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("pais", selectedCountry);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initList() {
        mCountries = new ArrayList<>();
        mCountries.add(new Country("Argentina", R.drawable.argentina));
        mCountries.add(new Country("Australia", R.drawable.australia));
        mCountries.add(new Country("Canada", R.drawable.canada));
        mCountries.add(new Country("Congo", R.drawable.congo));
        mCountries.add(new Country("Egypt", R.drawable.egypt));
        mCountries.add(new Country("France", R.drawable.france));
        mCountries.add(new Country("Germany", R.drawable.germany));
        mCountries.add(new Country("Greece", R.drawable.greece));
        mCountries.add(new Country("India", R.drawable.india));
        mCountries.add(new Country("Indonesia", R.drawable.indonesia));
        mCountries.add(new Country("Ireland", R.drawable.ireland));
        mCountries.add(new Country("Italy", R.drawable.italy));
        mCountries.add(new Country("Kenya", R.drawable.kenya));
        mCountries.add(new Country("Mexico", R.drawable.mexico));
        mCountries.add(new Country("New Zeland", R.drawable.newzeland));
        mCountries.add(new Country("Norway", R.drawable.norway));
        mCountries.add(new Country("Poland", R.drawable.poland));
        mCountries.add(new Country("Qatar", R.drawable.qatar));
        mCountries.add(new Country("South Africa", R.drawable.southafrica));
        mCountries.add(new Country("South Korea", R.drawable.southkorea));
        mCountries.add(new Country("Spain", R.drawable.spain));
        mCountries.add(new Country("UK", R.drawable.uk));
        mCountries.add(new Country("USA", R.drawable.usa));
    }

}