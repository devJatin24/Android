package com.example.sharadsrivastava.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    CheckBox c1,c2,c3,c4;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String opt1="", opt2="", opt3 ="", opt4="";

                if(c1.isChecked())
                {
                  opt1 = c1.getText().toString();
                }
                if(c2.isChecked())
                {
                  opt2 = c2.getText().toString();

                }
                if(c3.isChecked())
                {
                    opt3 = c3.getText().toString();

                }
                if(c4.isChecked())
                {
                    opt4 = c4.getText().toString();

                }
                Toast.makeText(MainActivity.this, ""+opt1+opt2+opt3+opt4, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
