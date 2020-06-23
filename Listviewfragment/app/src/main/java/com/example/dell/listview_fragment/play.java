package com.example.dell.listview_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class play extends Fragment
{

    TextView t;
    public play() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_play, container, false);

        t=v.findViewById(R.id.textView);
        Bundle a=getArguments();
       if(a!=null)
       {
        String aa =a.getString("ss");
          //t.setText(aa);
            switch(aa)
            {
                case "Tere bina jeena saza":
                    t.setText("fsdfsd");
                    break;

                case "Humnava mere":
                    t.setText("51454fsdfsd");
                    break;

                case "Pal":
                    t.setText("fs@@@@@@@@@@@@@@dfsd");
                    break;


            }
       }



        return v;

    }

}
