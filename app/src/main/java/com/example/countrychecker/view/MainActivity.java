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
        //MediaWikiBot wikiBot = new MediaWikiBot("https://en.wikipedia.org/w/");
        //Article article = wikiBot.getArticle("United States");
        //System.out.println(article.getText());
        //setupPermissions()
        Intent recyclerActivity = new Intent(this, RecyclerActivity.class);
        startActivity(recyclerActivity);
    }
}