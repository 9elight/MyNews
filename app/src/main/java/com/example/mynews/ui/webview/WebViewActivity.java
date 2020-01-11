package com.example.mynews.ui.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.mynews.R;

public class WebViewActivity extends AppCompatActivity {
    private static WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.web_view);
        setContent();
    }

    public void setContent(){
        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);
    }
}
