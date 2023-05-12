package com.example.countrychecker.view;


import static com.example.countrychecker.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.countrychecker.R;
import com.example.countrychecker.adapters.RequestAdapter;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        TextView leader = findViewById(R.id.LeaderName);
        ImageView ph = findViewById(R.id.leadPhoto);
        TextView bio = findViewById(leaderBio);
        String country, person;
        country = getIntent().getStringExtra("Country");
        person =  getIntent().getStringExtra("Leader");
        new Thread(() -> {
            String pres, biog;
            try {
                pres = RequestAdapter.Pres(country, person);
                biog = RequestAdapter.Bio(pres);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            leader.post(() -> leader.setText(pres));
            bio.post(() -> {
                bio.setText(biog);
                bio.setMovementMethod(new ScrollingMovementMethod());
            });
            URL url;
            try {
                url = new URL(RequestAdapter.Photo(pres, "image"));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            InputStream in;
            try {
                in = url.openStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ph.post(() -> Picasso.get().load(url.toString()).into(ph));
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}