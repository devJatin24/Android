package com.example.dell.camera_read_write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    Button b1,b2;
    ImageView iv;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        iv=(ImageView)findViewById(R.id.imageView);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//android.provider.MediaStore we have to write this first
                startActivityForResult(intent,0);

            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {

                    getApplicationContext().setWallpaper(bmp);

                }
                catch (Exception e)
                {

                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        if(requestCode==0&&resultCode==RESULT_OK&& data!=null)
        {
            Bundle b=data.getExtras();
            bmp= (Bitmap) b.get("data");

            iv.setImageBitmap(bmp);
        }
        else
        {
            Toast.makeText(this, "try again", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "received", Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);

    }

}
