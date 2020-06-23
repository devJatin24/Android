package com.example.dell.fragmentass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

EditText e1,e2,e3;
Button b;
RadioButton r1,r2;
    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_first, container, false);

        e1=v.findViewById(R.id.editText);
        e2=v.findViewById(R.id.editText2);
        e3=v.findViewById(R.id.editText3);
        b=v.findViewById(R.id.button);
        r1=v.findViewById(R.id.m);
        r2=v.findViewById(R.id.f);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name=e1.getText().toString();
                String phone=e2.getText().toString();
                String add=e3.getText().toString();
                String gender;

               if(r1.isChecked())
               {
                   gender=r1.getText().toString();

               }
               else
               {
                   gender=r2.getText().toString();

               }

               Bundle b=new Bundle();
                b.putString("na",name);
                b.putString("ph",phone);
                b.putString("ad",add);
                b.putString("g",gender);
                scndFragment sf=new scndFragment();
                sf.setArguments(b);

                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_page,sf);
                ft.addToBackStack("");//use for back (fragment)
                ft.commit();



            }
        });

        return v;
    }

}
