package com.example.javalibimplem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.example.ipay_channels.iPay;

public class CheckoutActivity extends AppCompatActivity {
    private WebView checkoutWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        checkoutWebView = findViewById(R.id.checkout_webview);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra("PHONE_NUMBER");
        String emailAddress = intent.getStringExtra("EMAIL_ADDRESS");
        String amount = intent.getStringExtra("PRICE_AMOUNT");
        String live = "1";
        String oid = "112";
        String inv = "112";
        String vid = "demo";
        String curr = "KES";
        String p1 = "112";
        String p2 = "112";
        String p3 = "112";
        String p4 = "112";
        String cbk = "https://kune.africa/success";
        String cst = "1";
        String crl = "2";
        String hashKey = "demoCHANGED";

        renderWebView(live,oid,inv,amount,emailAddress,phoneNumber,vid,curr,p1,p2,p3,p4,cbk,cst,crl,hashKey);

        // Capture the layout's TextView and set the string as its text

    }

    public void renderWebView(String live,String oid,String inv,String ttl,String eml,String tel,
                              String vid,String curr,String p1,String p2,String p3,String p4,String cbk,
                              String cst,String crl,String hsh){

        String response = iPay.INSTANCE.getUrl(live,oid,inv,ttl,tel,eml,vid,curr,p1,p2,p3,p4,cbk,cst,crl,hsh);

        WebSettings webSettings = checkoutWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setUseWideViewPort(true);

        checkoutWebView.setWebViewClient(new WebViewClient());
        checkoutWebView.loadUrl(response);
    }


}
