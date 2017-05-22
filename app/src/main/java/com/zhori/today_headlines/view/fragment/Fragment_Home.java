package com.zhori.today_headlines.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhori.today_headlines.R;
import com.zhori.today_headlines.model.homeFragmentBean.HomeBean_F1;
import com.zhori.today_headlines.presenter.home_presenter.Fragment_Home_Presenter;
import com.zhori.today_headlines.view.dadpter.ViewPageAdapter;
import com.zhori.today_headlines.view.fragment.home_fragment.HomeFragment_model;
import com.zhori.today_headlines.view.iview.F1_Interface;

import java.util.ArrayList;

/**
 * 作者：李亚雷
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class Fragment_Home extends Fragment implements F1_Interface {

    private TabLayout tab_f1;
    private Fragment_Home_Presenter f1_home_presenter;
    private ArrayList<HomeBean_F1.ResultBean.DateBean> data = new ArrayList<>();
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPageAdapter viewPageAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.act_fragment1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //初始化控件
        initView();
        //初始化数据
        initData();


    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("myMessage", "+++++");
    }

    private void initView() {
        tab_f1 = (TabLayout) getView().findViewById(R.id.tab_f1);
        //   tab_f1.setTabTextColors(R.attr.Mycolor,R.color.colorAccent);
        viewPager = (ViewPager) getView().findViewById(R.id.vp_home_feagment1);
        viewPager.setOffscreenPageLimit(3);
    }


    private void initData() {

        //专属FragmentHome的数据Persenter类
        f1_home_presenter = new Fragment_Home_Presenter();
        f1_home_presenter.setImvpview(this);
        f1_home_presenter.getTabList();

    }


    @Override
    public void CallBackTabList(HomeBean_F1 homeBean) {

        if (homeBean.getError_code() == 0) {
            data = (ArrayList<HomeBean_F1.ResultBean.DateBean>) homeBean.getResult().getDate();
            fragments.clear();
            //循环建立TabLayout的标签,fragment类
            for (int i = 0; i < data.size(); i++) {

                tab_f1.addTab(tab_f1.newTab().setText(data.get(i).getTitle()));
                this.fragments.add(new HomeFragment_model(data.get(i).getUri()));
                //  this.fragments.add(new HomeFragment_model());

            }

            setAdapter();
        }

    }

    private void setAdapter() {

        viewPageAdapter = new ViewPageAdapter(getActivity().getSupportFragmentManager(), fragments, data);
        viewPager.setAdapter(viewPageAdapter);
        //viewPager.setOffscreenPageLimit(0);
        tab_f1.setupWithViewPager(viewPager, false);
       // viewPageAdapter.notifyDataSetChanged();
        // tab_f1.setTabsFromPagerAdapter(viewPageAdapter);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        for (int i = 0; i < fragments.size(); i++) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.remove(fragments.get(i));
            fragmentTransaction.commit();
        }


    }
}
