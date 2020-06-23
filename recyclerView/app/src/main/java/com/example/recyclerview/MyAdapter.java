package com.example.recyclerview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    Activity activity;
    Integer images[];
    String text[];

    public MyAdapter(Activity activity,Integer images[],String text[])
    {
        this.activity=activity;
        this.images=images;
        this.text=text;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.recycle,viewGroup,false);

        //View view=activity.getLayoutInflater(R.layout.recycle,viewGroup,false);

        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv.setText(text[i]);
        myViewHolder.iv.setImageResource(images[i]);
        // i refer to position
    }

    @Override
    public int getItemCount()
    {
        return images.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        // store id
        TextView tv;
        ImageView iv;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            tv=itemView.findViewById(R.id.textview);
            iv=itemView.findViewById(R.id.iv);
        }


    }

}
