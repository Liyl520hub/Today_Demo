package com.zhori.today_headlines.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhori.today_headlines.R;

/**
 * 作者：李亚雷
 * 时间：2017/5/13
 * 类用途：
 * 思路：
 */

public class NewsActivity extends BaseActivity {

    private WebView web_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.act_news);

        getSupportActionBar().hide();

        web_view = (WebView) findViewById(R.id.web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        web_view.loadUrl(url);

        web_view.setWebViewClient(new WebViewClient());
        web_view.setWebChromeClient(new WebChromeClient());

    }
}
