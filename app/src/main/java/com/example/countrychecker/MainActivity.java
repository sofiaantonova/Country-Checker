package com.example.countrychecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



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
        Intent infoActivity = new Intent(this, InfoActivity.class);
        startActivity(infoActivity);
    }
}