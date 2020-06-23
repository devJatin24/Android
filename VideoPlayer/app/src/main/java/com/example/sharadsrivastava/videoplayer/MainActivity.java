package com.example.sharadsrivastava.videoplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
{

    VideoView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = findViewById(R.id.videoView);
        wv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video));
        wv.setMediaController(new MediaController(this));
        wv.start();
    }
}
