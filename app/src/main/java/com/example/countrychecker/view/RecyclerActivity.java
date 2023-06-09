package com.example.countrychecker.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.countrychecker.R;
import com.example.countrychecker.adapters.RecyclerAdapter;
import com.example.countrychecker.model.Country;
import com.example.countrychecker.view.InfoActivity;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    ArrayList<Country> countries = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        setCountries();
        RecyclerView recyclerView = findViewById(R.id.rcView);
        RecyclerAdapter.Listener listener = new RecyclerAdapter.Listener() {
            @Override
            public void onClickMove(Country country) {
                temp(country);
            }
        };
        RecyclerAdapter adapter = new RecyclerAdapter(this, countries, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private void setCountries() {
        countries.add(new Country("Russia"));
        countries.add(new Country("United States"));
        countries.add(new Country("United Kingdom"));
        countries.add(new Country("India"));
        countries.add(new Country("China"));
        countries.add(new Country("Germany"));
        countries.add(new Country("France"));
        countries.add(new Country("Spain"));
        countries.add(new Country("Japan"));
        countries.add(new Country("Hungary"));
        countries.add(new Country("Denmark"));
        countries.add(new Country("Poland"));
        countries.add(new Country("Canada"));
        countries.add(new Country("Austria"));
        countries.add(new Country("Australia"));
        countries.add(new Country("Finland"));
        countries.add(new Country("Israel"));
        countries.add(new Country("Republic of Ireland"));
        countries.add(new Country("Mexico"));
        countries.add(new Country("New Zealand"));


    }

    private void temp(Country country) {
        Intent infoActivity = new Intent(this, InfoActivity.class);
        infoActivity.putExtra("Country", country.getName());
        startActivity(infoActivity);
    }
}