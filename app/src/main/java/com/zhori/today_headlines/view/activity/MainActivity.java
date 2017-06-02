package com.zhori.today_headlines.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.umeng.socialize.UMShareAPI;
import com.zhori.today_headlines.R;
import com.zhori.today_headlines.presenter.MainPresenter;
import com.zhori.today_headlines.view.iview.Iview;

import java.util.ArrayList;

import static com.zhori.today_headlines.R.drawable.day_night;

public class MainActivity extends BaseActivity implements Iview, View.OnClickListener {

    private MainPresenter homePresenter;
    private ArrayList<Fragment> fragments;
    private LinearLayout fragment_ll;
    private int index = 0;
    private RadioGroup grop;
    private RadioButton radio_home;
    private RadioButton radio_video;
    private RadioButton radio_we;
    private RadioButton radio_me;
    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);


        getSupportActionBar().hide();

        initView();
        initData();






        SharedPreferences day_night = getSharedPreferences("Day_Night", MODE_PRIVATE);

        SharedPreferences.Editor edit = day_night.edit();
        int position = day_night.getInt("position", 0);


       //数据回来默认展示第一个fragment

        FragmentManager sm = getSupportFragmentManager();
        FragmentTransaction ft = sm.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            ft.add(R.id.fragment_ll, fragments.get(i));
        }
        ft.commit();



        changeFragment(fragments.get(position));

        edit.putInt("position", 0);
        edit.commit();


        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);



        menu.setShadowWidth(R.dimen.shadow_width);
        menu.setBehindOffsetRes(R.dimen.shadow_width);
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.sliding_menu);



    }

    private void initView() {


        grop = (RadioGroup) findViewById(R.id.group_layout);

        radio_home = (RadioButton) findViewById(R.id.radio_home);
        radio_video = (RadioButton) findViewById(R.id.radio_video);
        radio_we = (RadioButton) findViewById(R.id.radio_we);
        radio_me = (RadioButton) findViewById(R.id.radio_me);

        fragment_ll = (LinearLayout) findViewById(R.id.fragment_ll);

        radio_home.setOnClickListener(this);
        radio_video.setOnClickListener(this);
        radio_we.setOnClickListener(this);
        radio_me.setOnClickListener(this);


    }


    private void initData() {

        homePresenter = new MainPresenter();
        homePresenter.setImvpview(this);
        homePresenter.setDataFragments();


    }


    @Override
    public void CallBackFragments(ArrayList<Fragment> fragments) {

        this.fragments = fragments;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.radio_home: {

                index = 0;
                radio_home.setChecked(true);

//                   menu.showMenu();
//                  menu.showContent();
            }
            break;

            case R.id.radio_video: {

                index = 1;
                radio_video.setChecked(true);
            }
            break;

            case R.id.radio_we: {

                index = 2;
                radio_we.setChecked(true);
            }
            break;

            case R.id.radio_me: {

                index = 3;
                radio_me.setChecked(true);
            }
            break;

        }

        changeFragment(fragments.get(index));

    }

    private void changeFragment(Fragment fragment) {

        FragmentManager sm = getSupportFragmentManager();
        FragmentTransaction ft = sm.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            ft.hide(fragments.get(i));
        }

        ft.show(fragment);
        ft.commit();
    }

    @Override
    public void recreate() {
        try {//避免重启太快 恢复
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            for (Fragment fragment : fragments) {
                fragmentTransaction.remove(fragment);
            }
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
        }
        super.recreate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }




}
