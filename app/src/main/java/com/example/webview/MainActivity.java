package com.example.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtURL;
    Button btnURL, btnYT;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtURL = (EditText) findViewById(R.id.edtURL);
        btnURL = (Button) findViewById(R.id.btnURL);
        btnYT = (Button) findViewById(R.id.btnYT);
        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new myBrowser());

        btnYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirYoutube(v);
            }
        });

        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbrirURL(v);
            }
        });


    }


    public void AbrirYoutube(View view) {
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://www.youtube.com");

    }

    public void AbrirURL(View view) {
        String url = edtURL.getText().toString();
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);


    }

    public class myBrowser extends WebViewClient {
        public boolean overrideUrlLoading(WebView view, String url) {
            return true;
        }
    }

}
