package com.yogi.imgeslide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter
{
    ArrayList<Integer>images;
    LayoutInflater inflater;

    public MyAdapter(Context context,ArrayList<Integer>images)
    {
        this.images=images;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        container.removeView((View)object);
        //super.destroyItem(container, position, object);
    }

    @Override
    public int getCount()
    {
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v=inflater.inflate(R.layout.slide,container,false);
        ImageView myimage=v.findViewById(R.id.image);
        myimage.setImageResource(images.get(position));
        container.addView(v,0);
        return v;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
    {
        return view.equals(o);
    }
}
