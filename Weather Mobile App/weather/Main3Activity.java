package com.example.weather;

import android.content.Intent;
import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
    private WebView webview1;
    private WebView webview2;
    private WebView webview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        webview1=(WebView)findViewById(R.id.webview1);
//        webview1.setWebViewClient(new WebViewClient());
//        webview1.getSettings().setJavaScriptEnabled(true);
//        webview1.getSettings().setDomStorageEnabled(true);
//
//        webview1.setOverScrollMode(webview1.OVER_SCROLL_NEVER);
//        webview1.loadUrl("https://thingspeak.com/channels/1005322/charts/1?api_key=2QWJJ8VNPOQ6V57K&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");

        Intent i=getIntent();
        String url = i.getExtras().getString("url");

        webview1=(WebView)findViewById(R.id.webview1);
        webview1.setWebViewClient(new WebViewClient());
        webview1.getSettings().setJavaScriptEnabled(true);
        webview1.getSettings().setDomStorageEnabled(true);

        webview1.setOverScrollMode(webview1.OVER_SCROLL_NEVER);
        webview1.setHorizontalScrollBarEnabled(true);
        webview1.setVerticalScrollBarEnabled(true);
        webview1.loadUrl(url);



//        webview1 =(WebView)findViewById(R.id.webview1);
//        webview1.setWebViewClient(new WebViewClient());
//        webview1.getSettings().setJavaScriptEnabled(true);
//        webview1.getSettings().setDomStorageEnabled(true);
//        webview1.setHorizontalScrollBarEnabled(true);


//        webview2=(WebView)findViewById(R.id.webview2);
//        webview2.setWebViewClient(new WebViewClient());
//        webview2.getSettings().setJavaScriptEnabled(true);
//        webview2.getSettings().setDomStorageEnabled(true);
//
//        webview2.setOverScrollMode(webview2.OVER_SCROLL_NEVER);
//        webview2.setHorizontalScrollBarEnabled(true);
//        webview2.loadUrl("https://thingspeak.com/channels/1635769/charts/2?api_key=KUWKGSXKWQ5KDXP1&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");

//        webview3 =(WebView)findViewById(R.id.webview3);
//        webview3.setWebViewClient(new WebViewClient());
//        webview3.getSettings().setJavaScriptEnabled(true);
//        webview3.getSettings().setDomStorageEnabled(true);
//        webview3.setHorizontalScrollBarEnabled(true);
//
//        webview1.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
//        webview1.loadUrl("https://thingspeak.com/channels/1005322/charts/1?api_key=2QWJJ8VNPOQ6V57K&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");
//        //webview1.loadUrl("https://thingspeak.com/channels/1635769/charts/1?api_key=KUWKGSXKWQ5KDXP1&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");





    }
}