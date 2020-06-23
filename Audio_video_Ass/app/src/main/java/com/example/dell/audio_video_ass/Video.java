package com.example.dell.audio_video_ass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Video extends AppCompatActivity
{
    ListView lv;
    String videolist[];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        lv=(ListView)findViewById(R.id.lv);

        videolist = getResources().getStringArray(R.array.videos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,videolist);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String dd=videolist[position];
                if(position==0)
                {
                    Intent intent = new Intent(Video.this, Videoplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent = new Intent(Video.this, Videoplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent = new Intent(Video.this, Videoplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(Video.this, Videoplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }


            }
        });




    }
}
