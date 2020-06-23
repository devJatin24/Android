package com.yogi.googlemap;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MaActivity extends AppCompatActivity {
TextView as;
FirebaseDatabase fd;
DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma);
        as=findViewById(R.id.sa);
        fd= FirebaseDatabase.getInstance();
        ref=fd.getReference("map");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                 for(DataSnapshot snapshot:dataSnapshot.getChildren())
                        {
                            map news=snapshot.getValue(map.class);
                            double title=news.getLat();
                            double message=news.getLon();
                            String aa=Double.toString(message);
                            as.setText("https://www.google.com/maps/@"+title+","+aa+",15z");
                            //Toast.makeText(MainActivity.this, "title "+title+"\n Msg" + message, Toast.LENGTH_SHORT).show();

                        }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
