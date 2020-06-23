package com.example.dell.dynamiclistview_remove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView lv;
    EditText e;
    Button b;
    ArrayAdapter<String> ad;
    ArrayList<String> al;
        @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e=(EditText)findViewById(R.id.editText);
        b=(Button)findViewById(R.id.button);
        lv=(ListView)findViewById(R.id.ll);

        al=new ArrayList<String>();
        ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(ad);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=e.getText().toString();
                al.add(data);
                ad.notifyDataSetChanged();
                e.setText("");
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                al.remove(position);
                ad.notifyDataSetChanged();

            }
        });

    }
}
