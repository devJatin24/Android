package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


  RecyclerView rc;

  Integer pics[]=
          {
            R.drawable.e,
            R.drawable.e,
            R.drawable.a
          };

  String data[]=
          {
            "aplha",
            "beta",
            "cupcake"
          };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc=(RecyclerView)findViewById(R.id.recy);

        MyAdapter adapter=new MyAdapter(this,pics,data);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(adapter);

    }
}
