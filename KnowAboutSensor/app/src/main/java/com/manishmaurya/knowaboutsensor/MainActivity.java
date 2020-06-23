package com.manishmaurya.knowaboutsensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    SensorManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView= (ListView) findViewById(R.id.listview);

        ArrayList arrayList=new ArrayList<String>();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.getSensorList(Sensor.TYPE_ALL);
        List<Sensor> list=sm.getSensorList(Sensor.TYPE_ALL);

        for(Sensor obj:list){
            arrayList.add(""+obj.getName());
        }

    }
}
