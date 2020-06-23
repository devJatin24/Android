package com.example.dell.popupmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pm = new PopupMenu(MainActivity.this, tv);
                pm.getMenuInflater().inflate(R.menu.menu, pm.getMenu());

                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        int id = item.getItemId();
                        if (id == R.id.item1) {
                            tv.setTextColor(Color.RED);
                        } else if (id == R.id.item2) {
                            tv.setTextColor(Color.YELLOW);
                        } else if (id == R.id.item3) {
                            tv.setTextColor(Color.GREEN);
                        }


                        return false;
                    }
                });

                pm.show();
            }
        });
    }
}
