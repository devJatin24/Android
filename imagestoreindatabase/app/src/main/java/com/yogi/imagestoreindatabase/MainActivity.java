package com.yogi.imagestoreindatabase;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText editText;
    ImageView imageView;
    Button selectButton,uploadButton,downloadButton;
    Uri filePath;
    ProgressDialog pd;
    DatabaseReference dbReferance;
    StorageReference stReference;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd=new ProgressDialog(this);
        editText = findViewById(R.id.editView);
        imageView = findViewById(R.id.imageView);
        selectButton = findViewById(R.id.selectButton);
        uploadButton = findViewById(R.id.uploadButton);
        downloadButton = findViewById(R.id.downloadButton);

        selectButton.setOnClickListener(this);
        uploadButton.setOnClickListener(this);
        downloadButton.setOnClickListener(this);

        dbReferance = FirebaseDatabase.getInstance().getReference("Uploading");

        stReference = FirebaseStorage.getInstance().getReference();

    }

    public void onClick(View view)
    {
        if(view==selectButton)
        {
            selectPicture();
        }
        else if(view==uploadButton)
        {
            uploadFile();
        }
        else if(view==downloadButton){

            startActivity(new Intent(MainActivity.this,DownloadActivity.class));

        }
    }

    public  void selectPicture()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==0 && resultCode==RESULT_OK && data!=null)
        {
            filePath=data.getData();
            imageView.setImageURI(filePath);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public String getFileExtention(Uri uri)
    {
        ContentResolver cR = getContentResolver();

        MimeTypeMap mime = MimeTypeMap.getSingleton();

        return  mime.getExtensionFromMimeType(cR.getType(uri));
    }

    public  void uploadFile()
    {

        pd.setMessage("uploading...");

        if(filePath!=null)
        {
            pd.show();
            final StorageReference ref = stReference.child("Upload/"+
                    System.currentTimeMillis()+"."+
                    getFileExtention(filePath));

            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                {
                    String name=editText.getText().toString();

                    Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!urlTask.isSuccessful());
                    Uri downloadUrl = urlTask.getResult();


                    String url= downloadUrl.toString();


                    upload upload=new upload();
                    upload.setName(name);
                    upload.setUrl(url);

                    String id=dbReferance.push().getKey();
                    dbReferance.child(id).setValue(upload);
                    pd.dismiss();
                    Toast.makeText(MainActivity.this, "File Uploaded...", Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot)
                {
                    double progress=(100*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                    pd.setMessage("uploaded..."+progress+"%");
                }
            });


        }
    }

}

