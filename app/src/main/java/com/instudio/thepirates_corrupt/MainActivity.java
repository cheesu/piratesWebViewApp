package com.instudio.thepirates_corrupt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class MainActivity extends AppCompatActivity {


    private String TAG = MainActivity.class.getSimpleName();

    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());


        // WebView 화면크기에 맞추도록 설정 - setUseWideViewPort 와 같이 써야함
        webView.getSettings().setLoadWithOverviewMode(true);

        // wide viewport 설정 - setLoadWithOverviewMode 와 같이 써야함
        webView.getSettings().setUseWideViewPort(true);

        // 줌 설정 여부
        webView.getSettings().setSupportZoom(false);

        // 자바스크립트 사용여부
        webView.getSettings().setJavaScriptEnabled(true);

//        webview.addJavascriptInterface(new AndroidBridge(), "android");

        // javascript가 window.open()을 사용할 수 있도록 설정
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        // 멀티 윈도우 사용 여부
        webView.getSettings().setSupportMultipleWindows(false);

        // 로컬 스토리지 (localStorage) 사용여부
        webView.getSettings().setDomStorageEnabled(true);


        //웹페이지 호출
        //webView.loadUrl("https://pirates-cheesu.koyeb.app/");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("https://pirates-cheesu.koyeb.app/game");
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



}