package com.dd.devotional.karthikapuranamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    public final  static String CHAPTER_SELECTED ="SHOW_ADHYAY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void showAdhyay(View v) {

        Intent intent = new Intent(this, DisplayChapter.class);
        String storyselected="";
        String btnClickedTag = ((Button)findViewById(v.getId())).getTag().toString();
        storyselected = btnClickedTag.substring(btnClickedTag.indexOf("_")+1);
         intent.putExtra(CHAPTER_SELECTED, storyselected);
        startActivity(intent);
    }
}
