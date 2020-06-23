package com.example.sharadsrivastava.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1;

    Button btn;

    EditText age1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        age1 = findViewById(R.id.age);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
              //String name = e1.getText().toString();
                //Toast.makeText(MainActivity.this, "Welcome Mr "+name, Toast.LENGTH_LONG).show();

                String age = age1.getText().toString();
                int age1= Integer.parseInt(age);
                if(age1<18)
                {
                    Toast.makeText(MainActivity.this, "Inavlid Age " + age1, Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(MainActivity.this, "Valid Age " +age1, Toast.LENGTH_LONG).show();
                }




            }
        });
    }
}
