package com.jewels.auricjeweladmin.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.jewels.auricjeweladmin.R;

public class AdminForgotActivity extends AppCompatActivity
{

    EditText r;
    Button reset;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_forgot);

        r=(EditText)findViewById(R.id.editText);
        reset=(Button) findViewById(R.id.Resetpassword);


        auth = FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String re = r.getText().toString();

                if (re.equals("")) {
                    Toast.makeText(AdminForgotActivity.this, "Please enter youe e-mail id", Toast.LENGTH_SHORT).show();
                } else {
                    auth.sendPasswordResetEmail(re).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(AdminForgotActivity.this, "Mail sent", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdminForgotActivity.this, AdminLoginActivity.class));
                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AdminForgotActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }
        });

    }
}

