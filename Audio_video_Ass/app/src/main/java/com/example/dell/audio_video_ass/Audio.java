package com.example.dell.audio_video_ass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Audio extends AppCompatActivity
{
    ListView lv;
    String songlist[];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        lv=(ListView)findViewById(R.id.lv);

        songlist = getResources().getStringArray(R.array.songs);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songlist);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String dd=songlist[position];
                if(position==0)
                {
                    Intent intent = new Intent(Audio.this, songplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent = new Intent(Audio.this, songplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent = new Intent(Audio.this, songplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent = new Intent(Audio.this, songplay.class);
                    intent.putExtra("sl0",dd);
                    startActivity(intent);
                }



            }
        });





    }
}
