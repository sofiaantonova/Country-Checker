package com.example.countrychecker;

import static com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.util.Preconditions;

import static com.example.countrychecker.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.model.StreamEncoder;
import com.pixplicity.sharp.Sharp;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Instant;

import io.github.fastily.jwiki.core.Wiki;


public class LeaderActivity extends AppCompatActivity {
    private RequestBuilder<PictureDrawable> requestBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView leader = findViewById(R.id.LeaderName);
        ImageView ph = findViewById(R.id.leadPhoto);
        new Thread(() -> {
            String pres;
            try {
                pres = Adapter.Pres("United States");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            leader.post(() -> leader.setText(pres));
            URL url;
            try {
                url = new URL(Adapter.Photo("United States"));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            InputStream in;
            try {
                in = url.openStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Sharp.loadInputStream(in).into(ph);
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        //Picasso.get().load(uri).into(ph);
    }
}