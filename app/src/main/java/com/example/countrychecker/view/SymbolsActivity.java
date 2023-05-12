package com.example.countrychecker.view;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.countrychecker.R;
import com.example.countrychecker.adapters.RequestAdapter;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class SymbolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symbols);
        ImageView flag = findViewById(R.id.flag);
        ImageView coat = findViewById(R.id.coat);
        String country;
        country = getIntent().getStringExtra("Country");
        new Thread(() -> {
            String urlc, urlf;
            //ss
            urlf = RequestAdapter.Photo(country, "image_flag");
            urlc = RequestAdapter.Photo(country, "image_coat");
            flag.post(() -> GlideToVectorYou.init().with(this).load(Uri.parse(urlf), flag));
            coat.post(() -> GlideToVectorYou.init().with(this).load(Uri.parse(urlc), coat));
        }).start();
    }
}