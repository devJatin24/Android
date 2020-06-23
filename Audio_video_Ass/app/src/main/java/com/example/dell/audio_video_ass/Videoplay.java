package com.example.dell.audio_video_ass;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videoplay extends AppCompatActivity
{
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay);
        vv = findViewById(R.id.videoView);
        Bundle list = getIntent().getExtras();
        if(list!=null)
        {
            String sl = list.getString("sl0");

            if(sl.equalsIgnoreCase("We dont talk anymore"))
            {
                vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.wedonttalkanymore));
                vv.setMediaController(new MediaController(this));
                vv.start();

            }
            else if(sl.equalsIgnoreCase("Attention"))
            {
                vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.attention));
                vv.setMediaController(new MediaController(this));
                vv.start();

            }
            else if(sl.equalsIgnoreCase("jeena mera dil"))
            {
                vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.jeenameradil));
                vv.setMediaController(new MediaController(this));
                vv.start();
            }
            else if(sl.equalsIgnoreCase("Dheere dheere sa tera hua"))
            {
                vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.dheeredheeresaterahua));
                vv.setMediaController(new MediaController(this));
                vv.start();
            }

        }


    }
}
