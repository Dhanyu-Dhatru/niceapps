package com.dd.devotional.karthikapuranamu.com.dd.utils;

import android.app.Activity;
import android.os.AsyncTask;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by anagha on 11/8/2015.
 */
public class AdUtil {
    Activity activity=null;
    String package_code="";
    public  AdUtil(Activity activityName,String package_code)
    {
        this.activity = activityName;
        this.package_code = package_code;
        new getAndShowAd().execute(package_code);
    }
    private InterstitialAd interstitial;

    public void showAd(String adUnitId)
    {try {
        interstitial = new InterstitialAd(activity);

//        interstitial.setAdListener(this);
        //interstitial.setAdUnitId("ca-app-pub-3677485003590408/9680924970");
        interstitial.setAdUnitId(adUnitId);
        // Create ad request.
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                interstitial.show();
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.

        interstitial.loadAd(adRequest);
        // Log.e("naagint", "ads loaded without any problem");


    } catch(Exception ex){
        // Log.e("naagint","exception in ads",ex);
    }

    }

    public class getAndShowAd extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            try {

                //URL url = new URL("http://example.com/example.txt");
                URL url = new URL("http://apphelper5555.net/prod/getAdId.php?app_code="+AdUtil.this.package_code);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String line = null;

                while ((line = in.readLine()) != null) {
                    //get lines
                    result+=line;
                }
                in.close();


            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
            return result;
        }

        protected void onProgressUpdate() {
            //called when the background task makes any progress
        }

        protected void onPreExecute() {
            //called before doInBackground() is started
        }

        @Override
        protected void onPostExecute(String result) {
           if(result!=null && !result.equals(""))
            AdUtil.this.showAd(result);
        }
    }
}
