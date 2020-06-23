package com.example.materialdesign_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Animation anime;
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.imageView) ;

        //fifth blink,third zoom in,fourth in gap,second rotate ,first bounce

        anime=AnimationUtils.loadAnimation(this,R.anim.first );
        iv.startAnimation(anime);

    }
}
