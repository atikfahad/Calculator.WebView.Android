package com.webview.webview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    public class WebAppInterface
    {
        Context mContext;
        String data;
        //WebView webView;

        WebAppInterface(Context ctx){
            //this.webView = ctx;
            this.mContext = ctx;
        }

        @android.webkit.JavascriptInterface
        public String addNum(String num)
        {
            return "5";
        }

        public String addOperator(String str, String opr)
        {
            //window.alert("test opr");
            return "";
        }

        public String getResult(String str)
        {
            // window.alert("test res");
            return "";
        }
    }

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webView.loadUrl("file:///android_asset/local.html");
    }

}
