package com.yogi.wifiandbluettoh;

import android.bluetooth.BluetoothAdapter;
import android.net.wifi.WifiManager;
import android.net.wifi.aware.WifiAwareManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity
{
    ToggleButton wifi,blue;

    WifiManager wifiManager;
    BluetoothAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifi=findViewById(R.id.toggleButton);
        blue=findViewById(R.id.toggleButton2);

        wifiManager=(WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        adapter=BluetoothAdapter.getDefaultAdapter();

        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {

                if(isChecked==true)
                {
                    wifiManager.setWifiEnabled(true);
                }
                else
                {
                    wifiManager.setWifiEnabled(false);
                }

            }
        });

        blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {

                if(isChecked==true)
                {
                    adapter.enable();

                }
                else
                {
                    adapter.disable();
                }

            }
        });




    }
}
