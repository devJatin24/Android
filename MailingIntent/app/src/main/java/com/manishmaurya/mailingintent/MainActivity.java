package com.manishmaurya.mailingintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText) findViewById(R.id.editText);
        ed2= (EditText) findViewById(R.id.editText2);
        ed3= (EditText) findViewById(R.id.editText3);

        b1= (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to=ed1.getText().toString();
                String subject=ed2.getText().toString();
                String message=ed3.getText().toString();

                sendEmail(new String[]{to},subject,message);
            }
        });
    }

    public void sendEmail(String to[],String sub,String msg ){

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto"));

        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT,sub);
        intent.putExtra(Intent.EXTRA_TEXT,msg);

        intent.setType("text/message");

        startActivity(intent);
    }
}
