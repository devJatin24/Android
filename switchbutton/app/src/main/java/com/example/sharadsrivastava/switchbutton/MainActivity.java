package com.example.sharadsrivastava.switchbutton;

import android.preference.SwitchPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    Switch aSwitch;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.aswitch);
        btn = findViewById(R.id.boom);
        btn.setEnabled(false);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b==true)
                {
                  btn.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Switch On", Toast.LENGTH_SHORT).show();

                }
                else{

                    btn.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Switch Off", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
