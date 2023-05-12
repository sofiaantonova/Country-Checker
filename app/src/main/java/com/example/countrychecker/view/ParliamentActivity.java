package com.example.countrychecker.view;

import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.countrychecker.R;
import com.example.countrychecker.adapters.RequestAdapter;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class ParliamentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlament);
        String country;
        country = getIntent().getStringExtra("Country");
        ImageView struc = findViewById(R.id.parliamentPic);
        TextView text = findViewById(R.id.parliamentText);
        new Thread(() -> {
            String par = RequestAdapter.Parliament(country);
            String url = RequestAdapter.Photo(par, "structure1");
            String bio = RequestAdapter.Bio(par);
            text.post(() -> {
                text.setText(bio);
                text.setMovementMethod(new ScrollingMovementMethod());
            });
            struc.post(() -> GlideToVectorYou.init().with(this).load(Uri.parse(url), struc));
        }).start();
    }
}