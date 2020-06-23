package com.example.sharadsrivastava.radiocheckgender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RadioButton r1,r2;
    EditText name;
    Button btn;
    String nameResult;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.male);
        r2 = findViewById(R.id.female);
        name = findViewById(R.id.name);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(r1.isChecked())
                {
                    nameResult = name.getText().toString();
                    //gender = r1.getText().toString();
                    Toast.makeText(MainActivity.this, "Welcom Mr."+nameResult, Toast.LENGTH_SHORT).show();

                }
                else
                {
                    nameResult = name.getText().toString();
                    //gender = r2.getText().toString();
                    Toast.makeText(MainActivity.this, "Welcom Mss."+nameResult, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
