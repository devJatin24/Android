package com.example.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hide toolbar

        getSupportActionBar().hide();

        //hide title bar

        View v=getWindow().getDecorView();
        int uiOptions=View.SYSTEM_UI_FLAG_FULLSCREEN;
        v.setSystemUiVisibility(uiOptions);

        // task scheduler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() 
            {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);

            }
        },5000);//use android us package

    }
}
