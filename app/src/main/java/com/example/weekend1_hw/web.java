package com.example.weekend1_hw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class web extends AppCompatActivity implements View.OnClickListener {

    Button btnWebBack;
    private WebView wvSite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        btnWebBack = findViewById(R.id.btnWebBack);
        wvSite = findViewById(R.id.wvSite);

        WebSettings webSettings = wvSite.getSettings();  // gets the javaScript of webview
        webSettings.setJavaScriptEnabled(true);

        wvSite.setWebViewClient(new WebViewClient());
        wvSite.loadUrl("https://www.google.com/");


        wvSite.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //   setTitle("Loading......");
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                //  setTitle(view.getTitle());
                super.onPageFinished(view, url);

            }
        });


        btnWebBack.setOnClickListener(this);


    }

    public void goBackHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() { // if webssite can go back, go back
        if (wvSite.canGoBack()) {
            wvSite.goBack();
        } else {
            super.onBackPressed();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnWebBack:  // if camera back is clicked do this
                goBackHome();
                break;

        }

    }
}
