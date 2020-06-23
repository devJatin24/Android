package com.jewels.firebaseauth;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity
{
    Button b;
    EditText e1,e2;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        b=(Button)findViewById(R.id.button2);
        e1=(EditText) findViewById(R.id.editText3);
        e2=(EditText) findViewById(R.id.editText4);
        auth=FirebaseAuth.getInstance();
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String name= e1.getText().toString();
        String pass= e2.getText().toString();

        auth.createUserWithEmailAndPassword(name,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "sucess", Toast.LENGTH_SHORT).show();
                e1.setText("");
                e2.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
});

    }
}
