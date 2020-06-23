package com.example.sharadsrivastava.autocompletextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity
{
    AutoCompleteTextView auto;
    String places[];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auto = findViewById(R.id.autoCompleteTextView);

        places = getResources().getStringArray(R.array.data);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,places);

        auto.setAdapter(adapter);
        auto.setThreshold(1);
    }
}
