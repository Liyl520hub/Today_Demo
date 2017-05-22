package com.zhori.today_headlines.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhori.today_headlines.R;

/**
 * 作者：李亚雷
 * 时间：2017/5/13
 * 类用途：
 * 思路：
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        SharedPreferences day_night = getSharedPreferences("Day_Night",MODE_PRIVATE);

        if (day_night.getBoolean("isniaght",false)){
            setTheme(R.style.nightTheme);

        }else{
            setTheme(R.style.dayTheme);
        }


    }
}
