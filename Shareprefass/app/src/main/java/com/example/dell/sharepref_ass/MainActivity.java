package com.example.dell.sharepref_ass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b;
    CheckBox c;
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    String name, pass;
    boolean loginsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = (CheckBox) findViewById(R.id.checkBox);
        b = (Button) findViewById(R.id.button);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);

        pref = getSharedPreferences("myfile",MODE_PRIVATE);
        edit = pref.edit();

        loginsave = pref.getBoolean("loginsave", loginsave);

        if (loginsave == true)
        {
            e1.setText(pref.getString("user", null));
            e2.setText(pref.getString("pass", null));
        }


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = e1.getText().toString();
                pass = e2.getText().toString();

                edit.putBoolean("loginsave", c.isChecked());
                edit.putString("user", name);
                edit.putString("pass", pass);
                edit.commit();

                Intent intent = new Intent(MainActivity.this, Loginpage.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "logined", Toast.LENGTH_SHORT).show();


            }
        });




    }
}
