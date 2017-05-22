package com.zhori.today_headlines.view.dadpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhori.today_headlines.model.homeFragmentBean.HomeBean_F1;

import java.util.ArrayList;

/**
 * 作者：李亚雷
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class ViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<HomeBean_F1.ResultBean.DateBean> tab_list = new ArrayList<>();


    public ViewPageAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<HomeBean_F1.ResultBean.DateBean> tab_list) {
        super(fm);
        if (fragments != null) {

            this.fragments.addAll(fragments);
        }

        if (tab_list != null) {

            this.tab_list.addAll(tab_list);
        }


    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tab_list.get(position).getTitle();

    }
}
