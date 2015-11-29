package com.dd.devotional.karthikapuranamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.dd.devotional.karthikapuranamu.com.dd.utils.AdUtil;

public class DisplayChapter extends AppCompatActivity {
    private static WebSettings.TextSize viewTextSize = WebSettings.TextSize.NORMAL;
    WebSettings ws =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_chapter);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String storyNum = intent.getStringExtra(HomePage.CHAPTER_SELECTED);
        WebView wv= (WebView)findViewById(R.id.webView);
       ws = wv.getSettings();
        ws.setTextSize(viewTextSize);
       ws.setPluginState(WebSettings.PluginState.ON);
        ws.setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/" + storyNum + ".htm");
        new AdUtil(this,getApplicationContext().getPackageName());


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_chapter, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.font_largest:
                viewTextSize = WebSettings.TextSize.LARGEST;
                break;
            case R.id.font_larger:
                viewTextSize = WebSettings.TextSize.LARGER;
                break;
            case R.id.font_normal:
                viewTextSize = WebSettings.TextSize.NORMAL;
                break;
            case R.id.font_small:
                viewTextSize = WebSettings.TextSize.SMALLER;

                break;
            case R.id.font_smallest:
                viewTextSize = WebSettings.TextSize.SMALLEST;

                break;
        }
        //noinspection SimplifiableIfStatement
        ws.setTextSize(viewTextSize);
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
