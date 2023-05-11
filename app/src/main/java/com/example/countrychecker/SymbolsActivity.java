package com.example.countrychecker;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class SymbolsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symbols);
        ImageView flag = findViewById(R.id.flag);
        ImageView coat = findViewById(R.id.coat);
        new Thread(() -> {
            String urlc, urlf;
            //ss
            urlf = Adapter.Photo("United States", "image_flag");
            urlc = Adapter.Photo("United States", "image_coat");
            flag.post(() -> GlideToVectorYou.init().with(this).load(Uri.parse(urlf), flag));
            coat.post(() -> GlideToVectorYou.init().with(this).load(Uri.parse(urlc), coat));
        }).start();
    }
}