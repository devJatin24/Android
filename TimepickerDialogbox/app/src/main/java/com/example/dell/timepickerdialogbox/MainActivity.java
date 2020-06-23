package com.example.dell.timepickerdialogbox;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

EditText e1;
int hh,mm;
Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        calendar=Calendar.getInstance();

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                hh=calendar.get(Calendar.HOUR_OF_DAY);
                mm=calendar.get(Calendar.MINUTE);

                new TimePickerDialog(MainActivity.this,Listener,hh,mm,false).show();
            }
        });
    }

    TimePickerDialog.OnTimeSetListener Listener =new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            e1.setText(hourOfDay+" : "+minute);
        }
    };
}

