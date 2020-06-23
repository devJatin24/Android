package com.yogi.imagestoreindatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DownloadActivity extends AppCompatActivity
{

    ListView lv;
    DatabaseReference ref;

    ArrayList<upload> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        lv=(ListView)findViewById(R.id.mylist);

        ref = FirebaseDatabase.getInstance().getReference("Uploading");

        arrayList=new ArrayList<upload>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    upload upload=snapshot.getValue(upload.class);
                    arrayList.add(upload);
                }
                MyAdapter adapter=new MyAdapter(DownloadActivity.this,arrayList);

                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

