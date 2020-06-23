package com.security.volleylstview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{
    public  static TextView data;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.blocking);
        data=findViewById(R.id.tt);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data process = new data();
                process.execute();
                Toast.makeText(MainActivity.this, "dfsdf", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
