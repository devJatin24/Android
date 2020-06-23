package com.jewels.auricjeweladmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.jewels.auricjeweladmin.login.AdminFrontActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    ImageView mainlogo;
    Timer time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainlogo=(ImageView)findViewById(R.id.imageView);

        Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.lefttoright);

        mainlogo.startAnimation(animation);


        time=new Timer();
        time.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(MainActivity.this, AdminFrontActivity.class);
                startActivity(i);

            }
        },3000);


    }
}
