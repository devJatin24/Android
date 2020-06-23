package com.example.dell.context_menu_deleteoption;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView lv;
   ArrayList <String> al;
    ArrayAdapter<String> adapter;
    String name[]={"arti","akhil","anuj","shirsti"};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);

        al=new ArrayList<String>(Arrays.asList(name));
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Delete");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        String tittle = item.getTitle().toString();
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(tittle.equalsIgnoreCase("delete"))
        {

            al.remove(info.position);
            adapter.notifyDataSetChanged();

        }




        return super.onContextItemSelected(item);
    }




}
