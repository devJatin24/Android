package com.manishmaurya.sendsms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText) findViewById(R.id.editText );
        ed2=(EditText) findViewById(R.id.editText2);
        b1= (Button) findViewById(R.id.button );

        //runtime permission
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);
            return;
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = ed1.getText().toString();
                String msg = ed2.getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts(msg, to, null)));
                //SmsManager sms = SmsManager.getDefault();
                //sms.sendTextMessage(to,null,msg,null,null);
                
            }
        });
    }
}
