package com.example.dell.camera_gallery_readwrite;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
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

    Button b;
    ImageView iv;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(Button)findViewById(R.id.button);
        iv=(ImageView) findViewById(R.id.imageView);

        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setTitle("please choose a option");
                Button b1=dialog.findViewById(R.id.b1);
                Button b2=dialog.findViewById(R.id.b2);

                b1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        dialog.dismiss();

                        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(i,0);

                    }
                });

                b2.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {

                        Intent i=new Intent();
                        i.setType("image/*");
                        i.setAction(Intent.ACTION_GET_CONTENT);
                        dialog.dismiss();
                        startActivityForResult(i,1);


                    }
                });


                dialog.show();
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==0&&resultCode==RESULT_OK&&data!=null)
        {

            Bundle b=data.getExtras();
            bmp= (Bitmap) b.get("data");

            iv.setImageBitmap(bmp);
            //Toast.makeText(this, "camera", Toast.LENGTH_SHORT).show();
        }
       else if(requestCode==1&&resultCode==RESULT_OK&&data!=null)
        {
            try {
                Uri uri = data.getData();
                iv.setImageURI(uri);
            }
            catch (Exception e)
            {
                Toast.makeText(this, "try again", Toast.LENGTH_SHORT).show();
            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
