package com.example.tuan.obesityweightwatcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by tuan on 17/5/2017.
 */

public class HealthInfo extends AppCompatActivity {

    Button btnWeb;
    EditText editTxt;
    String url = "https://www.nih.gov/health-information";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_information);

        WebView browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(url);


        /*btnWeb = (Button) findViewById(R.id.btnWebview);
        editTxt = (EditText) findViewById(R.id.idTxt);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editTxt.getText().toString();
                WebView browser = (WebView) findViewById(R.id.webview);
                browser.setWebViewClient(new WebViewClient());
                browser.loadUrl(s);
            }
        });*/
    }

}
