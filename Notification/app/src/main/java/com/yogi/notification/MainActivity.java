package com.yogi.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));

                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,i,0);

                NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(MainActivity.this);

                mBuilder.setContentIntent(pendingIntent);

                mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
                mBuilder.setContentTitle("my notification");
                mBuilder.setContentText("hello world");
                mBuilder.setAutoCancel(true);
                mBuilder.setOngoing(true); //use for notification not clear

                NotificationManager notif=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notif.notify(1,mBuilder.build());


            }
        });

    }
}
