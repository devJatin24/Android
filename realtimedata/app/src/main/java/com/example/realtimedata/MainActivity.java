package com.example.realtimedata;

import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
{
    EditText e1,e2;
    Button b,b1,b2;
    String DeviceId;
    FirebaseDatabase fd;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);

        b=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);

        DeviceId= Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        fd=FirebaseDatabase.getInstance();
        ref=fd.getReference(DeviceId);



        //Toast.makeText(this, ""+DeviceId, Toast.LENGTH_SHORT).show();


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,new Main2Activity().getClass()));
            }
        });
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String title=e1.getText().toString();
                String message=e2.getText().toString();

                News news=new News();
                news.setTitle(title);
                news.setMessage(message);

                // ref.setValue(news);

                String id=ref.push().getKey();
                ref.child(id).setValue(news);

                Toast.makeText(MainActivity.this, "news updated...", Toast.LENGTH_SHORT).show();


            }
        });


        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // this listener use for read

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                       /*News news=dataSnapshot.getValue(News.class);
                        String title=news.getTitle();
                        String message=news.getMessage();

                        Toast.makeText(MainActivity.this, "title "+title+"\n Msg" + message, Toast.LENGTH_SHORT).show();
*/
                        //child value get

                       for(DataSnapshot snapshot:dataSnapshot.getChildren())
                        {
                            News news=snapshot.getValue(News.class);
                            String title=news.getTitle();
                            String message=news.getMessage();

                            Toast.makeText(MainActivity.this, "title "+title+"\n Msg" + message, Toast.LENGTH_SHORT).show();

                        }




                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

    }
 }

