package com.yogi.volleyimplementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    EditText e,e1;
    Button b,b1;

    RequestQueue requestQueue;
    String setUrl="https://freeantartica.000webhostapp.com/setdata.php";
    String getUrl="https://freeantartica.000webhostapp.com/getdata.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e=findViewById(R.id.editText);
        e1=findViewById(R.id.editText2);
        b=findViewById(R.id.button);
        b1=findViewById(R.id.button2);

        requestQueue= Volley.newRequestQueue(this);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                StringRequest request=new StringRequest(Request.Method.POST, setUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(MainActivity.this, "data saved", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })

                {  //this is init block
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {
                        Map<String,String> data=new HashMap<String,String>();
                        data.put("name",e.getText().toString());
                        data.put("address",e1.getText().toString());
                        return data;
                    }
                };// 4 parameter pass for send a request in url parameter are method,jaya ga url,response, error

                requestQueue.add(request);

            }
        });

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                StringRequest request=new StringRequest(Request.Method.GET, getUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        //json parsing
                        try
                        {
                            JSONObject obj= new JSONObject(response);
                            JSONArray array=obj.getJSONArray("result");
                            for(int i=0;i<array.length();i++)
                            {
                               JSONObject obj2=array.getJSONObject(i);
                               int id=obj2.getInt("id");
                               String name=obj2.getString("name");
                               String addr=obj2.getString("address");

                                Toast.makeText(MainActivity.this, ""+id+"\n"+name+"\n"+addr, Toast.LENGTH_SHORT).show();
                            }

                        }
                        catch (Exception e)
                        {
                            Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }



                        //Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(MainActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(request);
            }
        });

    }
}
