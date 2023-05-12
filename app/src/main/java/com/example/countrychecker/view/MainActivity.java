package com.example.countrychecker.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.countrychecker.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startWorkflow(View view){
        Intent recyclerActivity = new Intent(this, RecyclerActivity.class);
        startActivity(recyclerActivity);
    }
}