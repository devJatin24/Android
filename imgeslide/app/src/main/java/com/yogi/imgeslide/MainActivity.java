package com.yogi.imgeslide;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity
{
    ViewPager mpager;
    CircleIndicator indicator;
    int currentpage=0;
    Integer pic[]={
    R.drawable.off,
    R.drawable.on


    };
    ArrayList<Integer> picArray=new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jadu();
    }

    private void jadu()
    {
        for(int i=0;i<pic.length;i++)
            picArray.add(pic[i]);
        mpager=(ViewPager)findViewById(R.id.pager);
        indicator=(CircleIndicator)findViewById(R.id.indicator);
        mpager.setAdapter(new MyAdapter(this,picArray));
        indicator.setViewPager(mpager);

        final Handler handler=new Handler();

        final Runnable update=new Runnable() {
            @Override
            public void run() {
                if(currentpage==pic.length)
                {
                    currentpage=0;
                }
                mpager.setCurrentItem(currentpage++,true);
            }
        };

        Timer swipeTimer=new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },3000,3000);

    }
}
