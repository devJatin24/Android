package com.example.dell.customgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity
{

    GridView gv;

    Integer pics[]=
            {
                    R.drawable.d3,
                    R.drawable.d4,
                    R.drawable.d1,
                    R.drawable.d2,
                    R.drawable.d5,
                    R.drawable.download
            };

    String text[]=
            {
                    "Alpha",
                    "Beta",
                    "Cupcake",
                    "Donot",
                    "Donotsfsfsd",
                    "45343544Donot"
            };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView)findViewById(R.id.gv);

        CustomAdaptor adapter = new CustomAdaptor(this,text,pics);

        gv.setAdapter(adapter);



    }
}
