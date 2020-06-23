package com.manishmaurya.gmailapi;

import android.content.pm.PackageInstaller;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= (EditText) findViewById(R.id.editText);
        ed2= (EditText) findViewById(R.id.editText2);
        ed3= (EditText) findViewById(R.id.editText3);

        b1= (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread t=new Thread()
                {

                    public void run() {
                        String to = ed1.getText().toString();
                        String subject = ed2.getText().toString();
                        String message = ed3.getText().toString();

                        String from="manishku027@gmail.com";
                        String pass="Manish96";
                        String host="smtp.gmail.com";
                        try
                        {
                            Properties p =new Properties();
                            Session ses=Session.getInstance(p);
                            MimeMessage msg=new MimeMessage(ses);

                            InternetAddress toId=new InternetAddress(to);
                            InternetAddress fromId=new InternetAddress(from);

                            msg.setRecipient(javax.mail.Message.RecipientType.TO,toId);
                            msg.setFrom(fromId);
                            msg.setSubject(subject);
                            msg.setText(message);

                            Transport tp =ses.getTransport("smtps");
                            tp.connect(host,from,pass);
                            tp.sendMessage(msg,msg.getAllRecipients());
                        }
                        catch (Exception e)
                        {}
                    }
                };
                t.start();
            }
        });
    }
}
