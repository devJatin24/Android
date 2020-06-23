package com.security.myapplication;

import android.app.Service;
import android.content.Intent;
import android.drm.DrmStore;
import android.os.IBinder;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

  //  KeyEvent event;
    //int a=event.getAction();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public Boolean key( KeyEvent event)
    {
        Toast.makeText(this, "sss", Toast.LENGTH_SHORT).show();
        int action,keycode;
        action=event.getAction();
        keycode=event.getKeyCode();

        switch (keycode){
            case KeyEvent.KEYCODE_VOLUME_UP:
            {
                if (KeyEvent.ACTION_UP==action)
                {
                    Toast.makeText(this, "u" , Toast.LENGTH_SHORT).show();
                }

            }

            case KeyEvent.KEYCODE_VOLUME_DOWN:
            {
                if (KeyEvent.ACTION_DOWN==action)
                {
                    Toast.makeText(this, "d" , Toast.LENGTH_SHORT).show();
                }

            }
        }
        return key(event);

    }


    @Override
    public void onCreate()
    {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
