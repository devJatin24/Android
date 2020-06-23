package com.example.sharadsrivastava.webviewassigment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Details extends AppCompatActivity
{
    WebView webView;
    int a=4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        Bundle list = getIntent().getExtras();
        if (list != null)
        {
            String values=list.getString("ListViewClickedValue");
          //  String values = getIntent().getStringExtra("ListViewClickedValue");
            switch (values) {
                case "Kabir Das":
                webView.loadUrl("https://www.fb.com");
                break;

                case "Tulsi Das":
                    webView.loadUrl("https://www.google.com");
                    break;

                case "Rahim":
                    webView.loadUrl("https://www.youtube.com");
                    break;

                case "Mahadevi Verma":
                    webView.loadUrl("https://www.gmail.com");
                    break;



            }
        }

    }
}
