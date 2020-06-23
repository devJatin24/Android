package com.example.sharadsrivastava.progressdialogbox;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btn;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("Downloading...");
                pd.setCanceledOnTouchOutside(false);
                pd.show();
            }
        });



    }
}
