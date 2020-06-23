package com.example.dell.filehandling_storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity
{

    EditText e1;
    Button b1,b2;
    public static final  String FILE="myfile";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String data=e1.getText().toString();

                try
                {

                    FileOutputStream fout=openFileOutput(FILE, Context.MODE_APPEND);

                    fout.write(data.getBytes());
                    Toast.makeText(MainActivity.this, "data saved", Toast.LENGTH_SHORT).show();
                    e1.setText("");

                }
                catch (Exception e)
                {

                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                {

                    FileInputStream fine=openFileInput(FILE);

                    int i=0;
                    String data="";

                    while((i=fine.read())!=-1)
                    {
                        data=data +Character.toString((char)i);
                    }
                    Toast.makeText(MainActivity.this, ""+data, Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
        });

    }
}
