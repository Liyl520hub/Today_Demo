package com.zhori.today_headlines.presenter;

import android.support.v4.app.Fragment;

import com.zhori.today_headlines.view.fragment.Fragment_Four;
import com.zhori.today_headlines.view.fragment.Fragment_Home;
import com.zhori.today_headlines.view.fragment.Fragment_Secend;
import com.zhori.today_headlines.view.fragment.Fragment_Three;
import com.zhori.today_headlines.view.iview.Iview;

import java.util.ArrayList;

/**
 * 作者：李亚雷
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class MainPresenter extends BasePersenter<Iview> {





    public void setDataFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        Fragment_Home fragment_home = new Fragment_Home();
        Fragment_Secend fragment_secend = new Fragment_Secend();
        Fragment_Three fragment_three = new Fragment_Three();
        Fragment_Four fragment_four = new Fragment_Four();
        fragments.add(fragment_home);
        fragments.add(fragment_secend);
        fragments.add(fragment_three);
        fragments.add(fragment_four);

        getImvpview().CallBackFragments(fragments);

    }






}

