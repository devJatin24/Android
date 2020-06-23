package com.example.sharadsrivastava.contextmenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    ListView lv;

    String version[] = {"Alpha","Beta","Cupcake","Donot"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,version);

        lv.setAdapter(arrayAdapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add("Delete");
        menu.add("Rename");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {

        String tittle = item.getTitle().toString();

        if(tittle.equalsIgnoreCase("delete"))
        {
            Toast.makeText(this, "Item Delete", Toast.LENGTH_SHORT).show();
        }
        else
            {
                Toast.makeText(this, "Item Rename", Toast.LENGTH_SHORT).show();
            }

        return super.onContextItemSelected(item);
    }
}
