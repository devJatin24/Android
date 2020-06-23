package com.example.dell.contextmenuass;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String>adapter;
    String version[] = {"Alpha","Beta","Cupcake","Eclair","Donot"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);
        al=new ArrayList<String>(Arrays.asList(version));
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add("Add");
        menu.add("Delete");
        menu.add("Rename");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        String tittle = item.getTitle().toString();
        final AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if(tittle.equalsIgnoreCase("add"))
        {
            Toast.makeText(this, "Item add", Toast.LENGTH_SHORT).show();

            final Dialog dialog=new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.cutsomdialof_for_add);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setTitle("Add");
            final EditText e1=dialog.findViewById(R.id.edittext);
            Button b1=dialog.findViewById(R.id.button);

            b1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    dialog.dismiss();// if we click a button dialog closed.
                   String s1 = e1 .getText().toString();
                    al.add(s1);
                    adapter.notifyDataSetChanged();

                }
            });
            dialog.show();



        }

        //delete

        else if(tittle.equalsIgnoreCase("delete"))
        {
            final Dialog dialog=new Dialog(MainActivity.this);
            dialog.setTitle("Delete");
            dialog.setContentView(R.layout.customdialog_for_delete);
            final TextView t1=dialog.findViewById(R.id.textview);
           t1.setText("Are you Sure For Deleted This Item?.....");
            Button b1=dialog.findViewById(R.id.button3);
            Button b2=dialog.findViewById(R.id.button4);

            b1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    al.remove(info.position);
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }

            });

            b2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    dialog.dismiss();

                }
            });

            dialog.show();

        }
        //rename

        else if(tittle.equalsIgnoreCase("rename"))
        {
            int a=info.position;
            String a1=String.valueOf(a);
            final Dialog dialog=new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.cutomdialogforrename);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setTitle("Rename");
            final EditText e2=dialog.findViewById(R.id.edittext3);
            

            Button b1=dialog.findViewById(R.id.button2);
            b1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos =info.position ;//pos stand listview position which we want to update
                    al.set(pos,e2.getText().toString());
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();

                }
            });
        dialog.show();
        }




        return super.onContextItemSelected(item);
    }

}
