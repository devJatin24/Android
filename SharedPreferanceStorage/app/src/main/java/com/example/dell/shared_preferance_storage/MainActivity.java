package com.example.dell.shared_preferance_storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    Button b1,b2,b3;
    EditText e1,e2;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        b1=(Button) findViewById(R.id.button);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);


        pref=getSharedPreferences("myfile", Context.MODE_PRIVATE);
        editor=pref.edit();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String team=e1.getText().toString();
                String score=e2.getText().toString();

                editor.putString("team",team);
                editor.putString("score",score);

                editor.commit();
                Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
            }
        });
        // read
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               String t= pref.getString("team",null);
               String s= pref.getString("score",null);

                Toast.makeText(MainActivity.this, "Team"+t+"\n score: "+s, Toast.LENGTH_SHORT).show();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             //   editor.clear();
               editor.remove("team");// remove a particular key
                editor.commit();

                Toast.makeText(MainActivity.this, "Data del.", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
