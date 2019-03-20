package com.example.studentportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class Webview extends AppCompatActivity {
    public String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        link = getIntent().getStringExtra("LINK");

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl(link);
    }
}
