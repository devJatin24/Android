package com.example.user.scndintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t1=(TextView) findViewById(R.id.textView);
       Bundle bundle=getIntent().getExtras();
      String n= bundle.getString("name_key");
      String a= bundle.getString("pin_code");
      t1.setText(n+"\n"+a);


    }
}
