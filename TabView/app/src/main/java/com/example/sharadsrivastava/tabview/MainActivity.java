package com.example.sharadsrivastava.tabview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity
{
   TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(R.id.myTab);
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("");

        tabSpec.setIndicator("Orange");
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        ///Second Tab

        tabSpec = tabHost.newTabSpec("");
        tabSpec.setIndicator("Blue");
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        //Third Tab

        tabSpec = tabHost.newTabSpec("");
        tabSpec.setIndicator("Green");
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);

    }
}
