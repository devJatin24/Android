package com.example.dell.filehandligass;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class SaveFragment extends Fragment
{

    EditText e1,e2,e3,e4;
    Button b,b1,b2;
    Calendar calendar;
    int day,month,year,hh,mm;
    public static final  String FILE="myfile";


    public SaveFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_save, container, false);

        b=v.findViewById(R.id.button2);
        e1=v.findViewById(R.id.editText);
        e2=v.findViewById(R.id.editText2);
        e3=v.findViewById(R.id.editText3);

        calendar=Calendar.getInstance();
        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);

        hh=calendar.get(Calendar.HOUR_OF_DAY);
        mm=calendar.get(Calendar.MINUTE);

        e2.setEnabled(false);
        e1.setEnabled(false);
        new TimePickerDialog(getActivity(),Listener,hh,mm,false).show();

        new DatePickerDialog(getActivity(),listener,year,month,day).show();


        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                final Dialog dialog=new Dialog(getActivity());
                dialog.setContentView(R.layout.custom);
                dialog.setCanceledOnTouchOutside(false);
                final EditText e4=dialog.findViewById(R.id.editText4);
                Button b1=dialog.findViewById(R.id.yes);
                Button b2=dialog.findViewById(R.id.no);

                b1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        dialog.dismiss();// if we click a button dialog closed.
                        String s1;
                        s1 = e4 .getText().toString();

                        String data=e3.getText().toString();

                        try
                        {

                            FileOutputStream fout=openFileOutput(FILE, Context.MODE_APPEND);

                            fout.write(data.getBytes());
                            Toast.makeText(getActivity(), "data saved", Toast.LENGTH_SHORT).show();
                            e3.setText("");

                        }
                        catch (Exception e)
                        {

                        }
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
                Toast.makeText(getActivity(), "data saved", Toast.LENGTH_SHORT).show();



            }
        });


        return v;
    }


    DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int y, int m, int d) {
            e1.setText(d+" / "+(m+1)+" / "+y);

            day=d;
            month=m;
            year=y;
        }
    };

    TimePickerDialog.OnTimeSetListener Listener =new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            e2.setText(hourOfDay+" : "+minute);
        }
    };

}
