package com.jewels.auricjeweladmin.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jewels.auricjeweladmin.CategoriesActivity;
import com.jewels.auricjeweladmin.R;

public class AdminFrontActivity extends AppCompatActivity
{

   Button login,signup;
    ImageView logo;

    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_front);

        login=(Button)findViewById(R.id.button);
        signup=(Button)findViewById(R.id.button2);
        logo=(ImageView)findViewById(R.id.imageView2);

        Animation animation= AnimationUtils.loadAnimation(AdminFrontActivity.this,R.anim.blink_anim);

        logo.startAnimation(animation);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(AdminFrontActivity.this,AdminLoginActivity.class);
                startActivity(i);

            }
        });

        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(AdminFrontActivity.this,AdminRegisterActivity.class);
                 startActivity(i);
            }
        });


        if (user != null) {
            finish();
            Intent i = new Intent(AdminFrontActivity.this, CategoriesActivity.class);
            startActivity(i);
        }


    }
}
