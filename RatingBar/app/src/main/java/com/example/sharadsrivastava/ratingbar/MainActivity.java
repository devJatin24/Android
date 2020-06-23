package com.example.sharadsrivastava.ratingbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    RatingBar ratingBar;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b)
            {
                if(v==1.0 || v==1.5)
                {
                    textView.setText("Very Bad");
                }
                else if(v==2.0 || v==2.5)
                {
                    textView.setText("Good");
                }
                else if(v==3.0 || v==3.5)
                {
                    textView.setText("Very Good");
                }
                else if(v==4.0 || v==4.5)
                {
                    textView.setText("Excellent");
                }
                else
                {
                    textView.setText("Super Star");
                }

            }
        });
    }
}
