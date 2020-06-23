package com.example.user.scndintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    EditText e1,e2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText3);
        btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name=e1.getText().toString();
                String postalcode=e1.getText().toString();
                Intent intent=new Intent(MainActivity.this,secondActivity.class);
                intent.putExtra("name_key",name);
                intent.putExtra("pin_code",postalcode);
                startActivity(intent);

            }
        });
    }
}
