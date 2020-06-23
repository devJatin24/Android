package com.example.dell.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom);
                dialog.setCanceledOnTouchOutside(false);
                final EditText e1=dialog.findViewById(R.id.edittext);
                Button b1=dialog.findViewById(R.id.button2);

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        dialog.dismiss();// if we click a button dialog closed.
                        String s1;
                        s1 = e1 .getText().toString();
                        Toast.makeText(MainActivity.this, " "+s1, Toast.LENGTH_SHORT).show();

                    }
                });

                dialog.show();

            }
        });
    }
}
