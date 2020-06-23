package com.example.dell.customgridview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdaptor extends ArrayAdapter<String>
{
    Activity activity;
    Integer pics[];
    String text[];

    public  CustomAdaptor(Activity activity, String text[], Integer pics[])
    {
        super(activity,R.layout.custom_layout,text);
        this.activity=activity;
        this.pics=pics;
        this.text=text;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = activity.getLayoutInflater();

        View view = inflater.inflate(R.layout.custom_layout,null);

        TextView t = view.findViewById(R.id.textView);
        ImageView i = view.findViewById(R.id.imageView);

        t.setText(text[position]);
        i.setImageResource(pics[position]);

        //return super.getView(position, convertView, parent);

        return view;
    }

}
