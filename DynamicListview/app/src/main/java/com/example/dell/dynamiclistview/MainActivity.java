package com.example.dell.dynamiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    EditText e1;
    Button btn;
    ListView lv;
    ArrayAdapter<String> ad;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        btn=(Button) findViewById(R.id.button);
        lv=(ListView)findViewById(R.id.aalistview);

        al=new ArrayList<String>();
        ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(ad);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String data=e1.getText().toString();
                al.add(data);
                ad.notifyDataSetChanged();
                e1.setText("");

            }
        });


    }
}
