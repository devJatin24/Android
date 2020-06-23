package com.jewels.auricjeweladmin;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.jewels.auricjeweladmin.adapter.uploadProduct;

public class AddProductActivity extends AppCompatActivity
{

    private String url,ProductName,ProductDescribe,Price,categoryName,Size;
    private Button add;
    private ImageView iv;
    private EditText e,e1,e2,e3;
    private Uri filePath;
    private ProgressDialog pd;
    private TextView logout;

    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseStorage fs;
    private  DatabaseReference dbReferance;
    private  StorageReference stReference;

    private static final int picselect=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        firebaseDatabase=FirebaseDatabase.getInstance();
        fs=FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();

        e=(EditText)findViewById(R.id.productname);
        e1=(EditText)findViewById(R.id.productdescription);
        e2=(EditText)findViewById(R.id.price);
        e3=(EditText)findViewById(R.id.size);
        add=(Button)findViewById(R.id.addproduct);
        iv=(ImageView)findViewById(R.id.picss);
        pd=new ProgressDialog(this);



//        categoryName = getIntent().getExtras().get("Category").toString();
        //      Toast.makeText(this, "" + categoryName, Toast.LENGTH_SHORT).show();
        Bundle as = getIntent().getExtras();
        if (as != null)
        {
            categoryName=as.getString("Category");
            switch (categoryName) {
                case "Earring":
                    dbReferance = firebaseDatabase.getReference("Earring");
                    stReference = fs.getReference("Earring");
                    iv.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            openGallery();
                        }
                    });

                    add.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            validateProduce();
                        }
                    });

                    break;

                case "Pendant Set":
                    dbReferance = firebaseDatabase.getReference("pendentset");
                    stReference = fs.getReference("pendentset");
                    iv.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            openGallery();
                        }
                    });

                    add.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            validateProduce();
                        }
                    });

                    break;

                case "Line set":
                    dbReferance = firebaseDatabase.getReference("lineset");
                    stReference = fs.getReference("lineset");
                    iv.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            openGallery();
                        }
                    });

                    add.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            validateProduce();
                        }
                    });

                    break;

                case "Ring":
                    dbReferance = firebaseDatabase.getReference("ring");
                    stReference = fs.getReference("Ring");
                    e3.setVisibility(View.VISIBLE);
                    iv.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            openGallery();
                        }
                    });

                    add.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            validateProduce();
                        }
                    });

                    break;

            }

        }




    }

    private void openGallery()
    {
        Intent intent = new Intent();//(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,picselect);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data)
    {
        if(requestCode==picselect && resultCode==RESULT_OK && data!=null)
        {
            filePath=data.getData();
            try
            {
                iv.setImageURI(filePath);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public String getFileExtention(Uri uri)
    {
        ContentResolver cR = getContentResolver();

        MimeTypeMap mime = MimeTypeMap.getSingleton();

        return  mime.getExtensionFromMimeType(cR.getType(uri));
    }


    private void validateProduce()
    {
        ProductName=e.getText().toString();
        ProductDescribe=e1.getText().toString();
        Price=e2.getText().toString();

        if(filePath==null)
        {
            Toast.makeText(AddProductActivity.this, "Product image is mandatory...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(ProductName))
        {
            Toast.makeText(AddProductActivity.this, "Write a product name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(ProductDescribe))
        {
            Toast.makeText(AddProductActivity.this, "Write a product description", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(Price))
        {
            Toast.makeText(AddProductActivity.this, "Write a product price", Toast.LENGTH_SHORT).show();
        }
        else
        {
            uploadFile();
        }
    }

    public  void uploadFile()
    {

        pd.setTitle("Product uploading");

        if(filePath!=null)
        {
            pd.show();
            final StorageReference ref = stReference.child(ProductName+
                    System.currentTimeMillis()+"."+
                    getFileExtention(filePath));

            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                {
                    Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                    while (!urlTask.isSuccessful());
                    Uri downloadUrl = urlTask.getResult();


                    url= downloadUrl.toString();


                    uploadProduct upload=new uploadProduct();
                    upload.setUrl(url);
                    upload.setName(ProductName);
                    upload.setDescribe(ProductDescribe);
                    upload.setPrice(Price);
                    upload.setSize(Size);
                    String id=dbReferance.push().getKey();
                    dbReferance.child(ProductName).setValue(upload);
                    pd.dismiss();


                }
            }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(AddProductActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot)
                {
                    double progress=100*taskSnapshot.getTotalByteCount()/taskSnapshot.getTotalByteCount();
                    pd.setMessage("uploaded..."+progress+"%");
                }
            });

            Toast.makeText(this, "Product Uploaded...", Toast.LENGTH_SHORT).show();
        }
    }


}

