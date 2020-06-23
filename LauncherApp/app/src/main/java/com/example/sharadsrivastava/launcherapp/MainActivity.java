package com.example.sharadsrivastava.launcherapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= findViewById(R.id.button);
        b2= findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Intent intent = new Intent(Intent.ACTION_VIEW, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                //Intent intent = new  Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //Intent intent = new Intent(Settings.ACTION_SETTINGS);
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Intent intent  = getPackageManager().getLaunchIntentForPackage("com.atdmoney.app");
                //Intent intent  = getPackageManager().getLaunchIntentForPackage("indiansq.app.com.indiansq");
                //Intent intent  = getPackageManager().getLaunchIntentForPackage("com.android.vending");

                /*if(intent==null)
                {
                     //intent  = getPackageManager().getLaunchIntentForPackage("com.android.vending");



                }else
                    {
                    intent  = getPackageManager().getLaunchIntentForPackage("indiansq.app.com.indiansq");

                }*/

                //startActivity(intent);

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setPackage("com.android.vending");
                intent.setData(Uri.parse("https://play.google.com"));
                startActivity(intent);


            }
        });
    }
}
