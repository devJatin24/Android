package com.example.dell.fragmentass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class scndFragment extends Fragment {
TextView t;

    public scndFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_scnd, container, false);

        t=v.findViewById(R.id.textView);

        Bundle a=getArguments();
        String a1=a.getString("na");
        String a2=a.getString("ph");
        String a3=a.getString("ad");
        String a4=a.getString("g");

        t.setText("My name is: "+a1+"\n"+"No: "+a2+"\nAddress: "+a3+"\nGender: "+a4);


        return v;
    }

}
