package com.jewels.auricjeweladmin.login;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jewels.auricjeweladmin.adapter.Adminuser;
import com.jewels.auricjeweladmin.R;

public class AdminRegisterActivity extends AppCompatActivity {
    private EditText name, email, password, mobile_number;
    private Button verify;

    private ProgressDialog loader;

    FirebaseDatabase fd;
    DatabaseReference ref;
    FirebaseAuth auth;

    private String firstname, mobile, mail, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);
        name = (EditText) findViewById(R.id.aname);
        mobile_number = (EditText) findViewById(R.id.amobile);
        email = (EditText) findViewById(R.id.aemail);
        password = (EditText) findViewById(R.id.apassword);
        verify = (Button) findViewById(R.id.asingup);
        loader = new ProgressDialog(this);

        auth = FirebaseAuth.getInstance();
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

    }
    private void createAccount() {
        firstname = name.getText().toString();
        mobile = mobile_number.getText().toString();
        mail = email.getText().toString();
        pass = password.getText().toString();


        if (TextUtils.isEmpty(firstname)) {
            Toast.makeText(AdminRegisterActivity.this, "Please write your name", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(AdminRegisterActivity.this, "Please write your password", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(AdminRegisterActivity.this, "Please write your Mobile Number", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(mail)) {
            Toast.makeText(AdminRegisterActivity.this, "Please write you email", Toast.LENGTH_SHORT).show();
            return;
        } else {
            loader.setTitle("Create Account");
            loader.setMessage("Please wait, while we checking the credentials");
            loader.setCanceledOnTouchOutside(false);
            loader.show();

            checkMail(mail,pass);

        }


    }

    private void checkMail(String mail, String pass)
    {

        auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                EmaiverficationCodeSend();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AdminRegisterActivity.this, " "+e.getMessage(), Toast.LENGTH_SHORT).show();
                loader.dismiss();
            }
        });


    }

    private void EmaiverficationCodeSend()
    {
        FirebaseUser user=auth.getCurrentUser();
        if(user!=null)
        {
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task)
                {
                    if(task.isSuccessful())
                    {
                        sendData();

                    }
                }
            }).addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    Toast.makeText(AdminRegisterActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }


    private void sendData()
    {
        fd=FirebaseDatabase.getInstance();
        //ref=fd.getReference(auth.getUid());
        ref=fd.getReference("Admin");
        final Adminuser user=new Adminuser(firstname,mail,pass,mobile);
       // ref.setValue(user);
        String id=ref.push().getKey();
        ref.child(id).setValue(user);
        loader.dismiss();
        Toast.makeText(AdminRegisterActivity.this, "Registration successfully ", Toast.LENGTH_SHORT).show();
        finish();

    }


}



