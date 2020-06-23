package com.yogi.imagestoreindatabase;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String>
{

    Activity activity;
    ArrayList<upload>arrayList;

    public MyAdapter(Activity activity,ArrayList<upload>arrayList)
    {
        super(activity,R.layout.custom);
        this.activity=activity;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount()
    {
        return arrayList.size();
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View v =  inflater.inflate(R.layout.custom,null );

        ImageView imageView=v.findViewById(R.id.asd);
        TextView t=v.findViewById(R.id.t1);

        upload upload=arrayList.get(position);
        t.setText(upload.getName());
        Glide.with(activity).load(upload.getUrl()).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);


        return v;
    }
}
