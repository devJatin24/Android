package com.jewels.auricjeweladmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoriesActivity extends AppCompatActivity
{
    ImageView ear,pendant,line,ring;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ear=(ImageView)findViewById(R.id.Earring);
        pendant=(ImageView)findViewById(R.id.pendantset);
        line=(ImageView)findViewById(R.id.Line);
        ring=(ImageView)findViewById(R.id.Ring);

        ear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(CategoriesActivity.this,AddProductActivity.class);
                i.putExtra("Category","Earring");
                startActivity(i);


            }
        });

        pendant.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(CategoriesActivity.this,AddProductActivity.class);
                i.putExtra("Category","Pendant Set");
                startActivity(i);

            }
        });

        line.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(CategoriesActivity.this,AddProductActivity.class);
                i.putExtra("Category","Line set");
                startActivity(i);

            }
        });

        ring.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(CategoriesActivity.this,AddProductActivity.class);
                i.putExtra("Category","Ring");
                startActivity(i);

            }
        });
    }
}
