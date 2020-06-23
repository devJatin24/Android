package com.security.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView t;
    int c=0;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);


        t= (TextView) findViewById(R.id.textView);
        b= findViewById(R.id.button);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      //  startService(new Intent(getApplicationContext(), MyService.class));
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("hh","7838836159",null)));

    }
});

    }

    /*@Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_POWER) {
            // Do something here...
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }
      public boolean onKeyDown(int keyCode, KeyEvent event) {
        int action=event.getAction();
        if ((keyCode == android.view.KeyEvent.KEYCODE_VOLUME_DOWN )) {
            // ... your code
            if(android.view.KeyEvent.ACTION_DOWN==action)
            {
                c++;
                String num=String.valueOf(c);
                //  t.setText(num);
                if(c==3)
                {
                    Toast.makeText(this, "kj", Toast.LENGTH_SHORT).show();
                    c=0;
                }

            }
            return true;
        } else if ((keyCode == android.view.KeyEvent.KEYCODE_VOLUME_UP && event.getEventTime()>5000)) {
            // ... your code
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();

            return true;
        }
        else
            Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();

        return super.onKeyDown(keyCode, event);
    }*/
  @Override
  public boolean onKeyLongPress(int keyCode, KeyEvent event) {
      if (keyCode == KeyEvent.KEYCODE_POWER) {
          // Do something here...
          Toast.makeText(this, ",mnbvcxcvbnm,.", Toast.LENGTH_SHORT).show();
          return true;
      }
      return super.onKeyLongPress(keyCode, event);
  }


}
