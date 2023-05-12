package com.example.countrychecker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.countrychecker.R;
import com.example.countrychecker.view.ParliamentActivity;
import com.example.countrychecker.view.PersonActivity;
import com.example.countrychecker.view.SymbolsActivity;

public class InfoActivity extends AppCompatActivity {
    private String country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        country = getIntent().getStringExtra("Country");
    }

    public void leaderStart(View view) {
        Intent leadActivity = new Intent(this, PersonActivity.class);
        leadActivity.putExtra("Country", country);
        leadActivity.putExtra("Leader", "leader_name1");
        startActivity(leadActivity);
    }

    public void primeStart(View view) {
        Intent leadActivity = new Intent(this, PersonActivity.class);
        leadActivity.putExtra("Country", country);
        leadActivity.putExtra("Leader", "leader_name2");
        startActivity(leadActivity);
    }
    public void parliamentStart(View view) {
        Intent parActivity = new Intent(this, ParliamentActivity.class);
        parActivity.putExtra("Country", country);
        startActivity(parActivity);
    }

    public void symbolsStart(View view) {
        Intent symbActivity = new Intent(this, SymbolsActivity.class);
        symbActivity.putExtra("Country", country);
        startActivity(symbActivity);
    }
}