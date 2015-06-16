package com.example.charlesburks.thehomestead;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends TabActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;


        intent = new Intent().setClass(this, Tab1.class);

        // Tab 1
        spec = tabHost.newTabSpec("artists").setIndicator("",
                res.getDrawable(R.drawable.home))
                .setContent(intent);
        tabHost.addTab(spec);

        //Tab 2
        intent = new Intent().setClass(this, Tab2.class);
        spec = tabHost.newTabSpec("albums").setIndicator("",
                res.getDrawable(R.drawable.book))
                .setContent(intent);
        tabHost.addTab(spec);

        //Tab 3
        intent = new Intent().setClass(this, Tab3.class);
        spec = tabHost.newTabSpec("songs").setIndicator("",
                res.getDrawable(R.drawable.pics))
                .setContent(intent);
        tabHost.addTab(spec);

        // Tab 4
        intent = new Intent().setClass(this, Tab4.class);
        spec = tabHost.newTabSpec("artists").setIndicator("",
                res.getDrawable(R.drawable.food))
                .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);


    }


}
