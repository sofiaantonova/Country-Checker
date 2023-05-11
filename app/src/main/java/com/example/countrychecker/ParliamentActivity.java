package com.example.countrychecker;

import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

public class ParliamentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlament);
        ImageView struc = findViewById(R.id.parliamentPic);
        TextView text = findViewById(R.id.parliamentText);
        new Thread(() -> {
            String par = Adapter.Parliament("United States");
            String url = Adapter.Photo(par, "structure1");
            String bio = Adapter.Bio(par);
            text.post(() -> {
                text.setText(bio);
                text.setMovementMethod(new ScrollingMovementMethod());
            });
            struc.post(() -> GlideToVectorYou.init().with(this).load(Uri.parse(url), struc));
        }).start();
    }
}