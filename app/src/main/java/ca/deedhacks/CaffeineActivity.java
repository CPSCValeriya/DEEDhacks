package ca.deedhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class CaffeineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_caffeine);

        WebView wb=(WebView)findViewById(R.id.webView1);
        WebSettings webSettings=wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wb.loadUrl("https://www.cnn.com/");


    }
}