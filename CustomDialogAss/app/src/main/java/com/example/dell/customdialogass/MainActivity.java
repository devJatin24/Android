package com.example.dell.customdialogass;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String s,s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Dialog dialog=new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom);
        dialog.setCanceledOnTouchOutside(false);
        //dialog.show();
        final EditText e1=dialog.findViewById(R.id.edittext);
        final EditText e2= dialog.findViewById(R.id.edittext2);
        Button btn=dialog.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                s=e1.getText().toString();
                s1=e2.getText().toString();
                if(s.equals("ducat")&& s1.equals("123456"))
                {
                    Toast.makeText(MainActivity.this, "matched", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "not matched", Toast.LENGTH_SHORT).show();
                }

            }
        });
                dialog.show();

    }
}
