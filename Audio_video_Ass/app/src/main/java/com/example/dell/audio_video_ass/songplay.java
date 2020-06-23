package com.example.dell.audio_video_ass;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class songplay extends AppCompatActivity
{

    TextView t1;
    Button b,b1,b2;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songplay);
        
        t1=(TextView)findViewById(R.id.textView2);
        b=(Button)findViewById(R.id.button3);//pause
        b1=(Button)findViewById(R.id.button4);//stop
        b2=(Button)findViewById(R.id.button5);//start

                Bundle list = getIntent().getExtras();
                if (list != null)
                {
                    String sl = list.getString("sl0");
                    t1.setText(sl + " Song is playing now");
                    if (sl.equalsIgnoreCase("Tere bina jeena saza"))
                    {
                        mp = MediaPlayer.create(this, R.raw.terebinajeenasazahogaya);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mp.stop();
                                mp = MediaPlayer.create(songplay.this, R.raw.terebinajeenasazahogaya);

                            }
                        });
                    } else if (sl.equalsIgnoreCase("Humnava mere")) {
                        mp = MediaPlayer.create(this, R.raw.humnavamere);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mp.stop();
                                mp = MediaPlayer.create(songplay.this, R.raw.humnavamere);

                            }
                        });
                    } else if (sl.equalsIgnoreCase("pal")) {
                        mp = MediaPlayer.create(this, R.raw.pal);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mp.stop();
                                mp = MediaPlayer.create(songplay.this, R.raw.pal);

                            }
                        });
                    } else if (sl.equalsIgnoreCase("Mera pyar tera pyar")) {
                        mp = MediaPlayer.create(this, R.raw.merapyarterapyar);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mp.stop();
                                mp = MediaPlayer.create(songplay.this, R.raw.merapyarterapyar);
                            }
                        });
                    }

                }

                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {//pause
                        mp.pause();

                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //play
                        mp.start();
                    }
                });

    }

    @Override
    public void onBackPressed()
    {
        mp.stop();
        super.onBackPressed();
    }



}

