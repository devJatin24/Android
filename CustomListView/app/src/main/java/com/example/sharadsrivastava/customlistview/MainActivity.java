package com.example.sharadsrivastava.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{

    ListView listView;
    Integer pics[]=
            {
                    R.drawable.img,
                    R.drawable.img1,
                    R.drawable.img2,
                    R.drawable.img3


            };

    String text[]=
            {
                "Alpha",
                "Beta",
                "Cupcake",
                "Donot"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        CustomAdapter adapter = new CustomAdapter(this,text,pics);

        listView.setAdapter(adapter);
    }
}
