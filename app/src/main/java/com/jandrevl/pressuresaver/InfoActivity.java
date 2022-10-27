package com.jandrevl.pressuresaver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class InfoActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.heart.org/en/health-topics/high-blood-pressure/understanding-blood-pressure-readings");
    }
}