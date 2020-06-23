package com.example.readsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView t;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t= (TextView) findViewById(R.id.textView);
        b1= (Button) findViewById(R.id.button);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)!=
                PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS},0);
            return;
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String msgdata = "";
                        String data = "";

                        for (int i = 0; i < 15; i++) {
                            data = cursor.getColumnName(i);
                            if (data.equals("address")) {
                                msgdata += " " + cursor.getColumnName(i) + ":" + cursor.getString(i);
                            }
                            if (data.equals("body")) {
                                msgdata += " " + cursor.getColumnName(i) + ":" + cursor.getString(i);
                            }
                        }
                        t.append(msgdata);
                    } while (cursor.moveToNext());
                }
            }
        });

    }

}


