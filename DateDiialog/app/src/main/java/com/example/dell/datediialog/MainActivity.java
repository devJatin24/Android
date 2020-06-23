package com.example.dell.datediialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Calendar calendar;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    calendar=Calendar.getInstance();
    day=calendar.get(Calendar.DAY_OF_MONTH);
    month=calendar.get(Calendar.MONTH);
    year=calendar.get(Calendar.YEAR);

    e1=(EditText)findViewById(R.id.editText);
    e1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new DatePickerDialog(MainActivity.this,listener,year,month,day).show();
        }
    });

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

}
