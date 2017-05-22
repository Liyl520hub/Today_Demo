package com.zhori.today_headlines.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhori.today_headlines.R;

/**
 * 作者：李亚雷
 * 时间：2017/5/18
 * 类用途：
 * 思路：
 */

public class WelcomeActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.act_welcome);

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {

             }
         },2000);


    }
}
