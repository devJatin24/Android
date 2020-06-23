package com.example.user.torch;

import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    CameraManager cm;
    String cameraId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tb=(ToggleButton)findViewById(R.id.toggleButton2);
    cm=(CameraManager) getSystemService(CAMERA_SERVICE);

    tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
         if(isChecked==true)
         {
             torchon();
         }
         else
         {
             torchoff();
         }

        }
    });



    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void torchon()
    {
        try
        {

            cameraId=cm.getCameraIdList()[0];
            cm.setTorchMode(cameraId,true);

        }
        catch (Exception e)
        {


        }

    }
    public void torchoff()
    {
        try
        {

            cameraId=cm.getCameraIdList()[0];
            cm.setTorchMode(cameraId,false);

        }
        catch (Exception e)
        {


        }

    }
}
