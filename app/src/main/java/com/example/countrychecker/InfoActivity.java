package com.example.countrychecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void leaderStart(View view) {
        Intent leadActivity = new Intent(this, PersonActivity.class);
        startActivity(leadActivity);
    }

    public void primeStart(View view) {

        Intent leadActivity = new Intent(this, PersonActivity.class);
        startActivity(leadActivity);
    }
    public void parliamentStart(View view) {

        Intent parActivity = new Intent(this, ParliamentActivity.class);
        startActivity(parActivity);
    }

    public void symbolsStart(View view) {
        Intent symbActivity = new Intent(this, SymbolsActivity.class);
        startActivity(symbActivity);
    }
}