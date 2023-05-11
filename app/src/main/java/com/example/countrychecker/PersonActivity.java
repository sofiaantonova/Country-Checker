package com.example.countrychecker;


import static com.example.countrychecker.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

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
        new Thread(() -> {
            String pres, biog;
            try {
                pres = Adapter.Pres("United States");
                biog = Adapter.Bio(pres);
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
                url = new URL(Adapter.Photo(pres, "image"));
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