package com.jewels.auricjeweladmin.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jewels.auricjeweladmin.CategoriesActivity;
import com.jewels.auricjeweladmin.R;

public class AdminLoginActivity extends AppCompatActivity
{
    private EditText username, password;
    private CheckBox rememberme;
    private TextView forgot;
    private Button signin;

    private String email, pass;

    private ProgressDialog loading;

   private   FirebaseAuth auth;
   private FirebaseUser user;
   private SharedPreferences pref;
   private SharedPreferences.Editor edit;
   private boolean loginSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        loading = new ProgressDialog(this);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        signin = (Button) findViewById(R.id.login);
        rememberme = (CheckBox) findViewById(R.id.remember);
        forgot = (TextView) findViewById(R.id.forgotpassword);

        auth = FirebaseAuth.getInstance();
        pref = getSharedPreferences("userlogin",MODE_PRIVATE);
        edit = pref.edit();

        loginSave = pref.getBoolean("loginsave", loginSave);

        if (loginSave == true)
        {
            username.setText(pref.getString("user", null));
            password.setText(pref.getString("pass", null));
        }

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminLoginActivity.this, AdminForgotActivity.class));

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });


    }

    private void login() {
        email = username.getText().toString();
        pass = password.getText().toString();

        if (TextUtils.isEmpty(email)) {

            Toast.makeText(AdminLoginActivity.this, "Please write your E-mail", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(AdminLoginActivity.this, "Please write your password", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (email.equals("jewelsauric@gmail.com"))
        {
            Toast.makeText(this, "you can't use this email in this app", Toast.LENGTH_SHORT).show();
            email.isEmpty();
            return;

        }
        else {

            loading.setTitle("Login Account");
            loading.setMessage("Please wait, while we checking the credentials");
            loading.setCanceledOnTouchOutside(false);

            validatelogin(email, pass);
        }
    }

    private void validatelogin(final String email, final String pass) {
        loading.show();

        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                edit.putBoolean("loginsave", rememberme.isChecked());
                edit.putString("user", email);
                edit.putString("pass", pass);
                edit.commit();
                if (task.isSuccessful()) {
                    checkVerificationMail();

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loading.dismiss();
                Toast.makeText(AdminLoginActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void checkVerificationMail()
    {
        user = auth.getInstance().getCurrentUser();
        boolean emailverify = user.isEmailVerified();
        if (user.isEmailVerified()) {
            loading.dismiss();
            Toast.makeText(AdminLoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AdminLoginActivity.this, CategoriesActivity.class));
        } else {
            loading.dismiss();
            Toast.makeText(AdminLoginActivity.this, "Please Verify Your Mail", Toast.LENGTH_SHORT).show();
            auth.signOut();
        }
    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(AdminLoginActivity.this,AdminFrontActivity.class));

        super.onBackPressed();
    }
}
