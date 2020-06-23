package com.yogi.locationbased_service;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView t;
    LocationManager lm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t= (TextView) findViewById(R.id.textView);
        lm= (LocationManager) getSystemService(LOCATION_SERVICE);

        //runtime permission

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                 ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},0);
            return;
        }

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location)
            {
                double lat=location.getLatitude();
                double lon=location.getLongitude();

                t.setText("lat: "+lat+"\nlon: "+lon);

                Geocoder geocoder=new Geocoder(MainActivity.this);
                try{

                    List<Address> list=geocoder.getFromLocation(lat,lon,1);
                 //   String country=list.get(0).getCountryName();
                    //String locality=list.get(0).getLocality();
                   // String pincode=list.get(0).getPostalCode();
                    String adr=list.get(0).getAddressLine(0);

                    //t.append(country+","+locality+","+pincode+","+adr);
                }
                catch (Exception e)
                {
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras)
             {

            }

            @Override
            public void onProviderEnabled(String provider)
            {

            }

            @Override
            public void onProviderDisabled(String provider)
            {

            }
        });

    }
}
