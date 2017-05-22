package com.zhori.today_headlines.view.myapp;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class MyAppliction extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        PlatformConfig.setQQZone("1106086069","BbUDh6t7rYjJWowh");

        UMShareAPI.get(this);

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

    }
}
