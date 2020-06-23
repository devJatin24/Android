package com.yogi.mapintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ba=(Button)findViewById(R.id.button);

        ba.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                double latitude=23.67667868;
                double longitude=72.676678;

                String label="User Location";
                String uriBegin="geo: "+latitude+","+longitude;
                String query=latitude+","+longitude+"("+label+")";
                String encodequery= Uri.encode(query);
                String uriString=uriBegin + "?q"+encodequery+"&z=16";

                Uri uri=Uri.parse(uriString);//store path of any file

                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }
}
