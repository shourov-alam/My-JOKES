package com.shourov.myjokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

//import com.facebook.ads.*;

public class Holder extends AppCompatActivity {

    RecyclerView recyclerView;
    AdView mAdView;

   // private AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
        recyclerView=findViewById(R.id.recyclerView);

       // AudienceNetworkAds.initialize(this);
        mAdView = findViewById(R.id.adView);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        // mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    /*    adView = new AdView(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();  */




        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            String topic = bundle.getString("key");

            if(topic.equals("w")){
                String[] all=getResources().getStringArray(R.array.myJokes);

               pass(all);



            }
            if(topic.equals("w1")){
                String[]  all =getResources().getStringArray(R.array.myJokes1);

                pass(all);

            }

        }



       // String[] all=getResources().getStringArray(R.array.myJokes);






    }

    private void pass(String[] jokes) {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new Adapter(this,jokes));



    }


  /*  @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }  */


}
