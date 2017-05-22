package com.zhori.today_headlines.view.fragment.home_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.limxing.xlistview.view.XListView;
import com.zhori.today_headlines.R;
import com.zhori.today_headlines.model.homeFragmentBean.HomeBean_F1Content;
import com.zhori.today_headlines.presenter.home_presenter.Fragment_Model_Persenter;
import com.zhori.today_headlines.view.activity.NewsActivity;
import com.zhori.today_headlines.view.dadpter.XlistViewAdapter_model;
import com.zhori.today_headlines.view.iview.F1_Model_Interface;

/**
 * 作者：李亚雷
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class HomeFragment_model extends Fragment implements F1_Model_Interface,XListView.IXListViewListener{


    private  String murl;
    private XlistViewAdapter_model xlist_adapter;
    private XListView xlist_view;
    private Fragment_Model_Persenter fragment_model_persenter;


    public HomeFragment_model(String murl) {
        this.murl = murl;
    }


    public HomeFragment_model() {

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.act_fragment1_mode1,container,false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView();
        getData();
    }

    private void initView() {

        xlist_view = (XListView) getView().findViewById(R.id.xlist_view_f1_content);
        xlist_view.setRefreshTime("2017年5月12号");
        xlist_view.setXListViewListener(this);

    }



    public void getData() {


        fragment_model_persenter = new Fragment_Model_Persenter();
        fragment_model_persenter.setImvpview(this);
        fragment_model_persenter.getList(this.murl);

        xlist_adapter = new XlistViewAdapter_model(getActivity());
        xlist_view.setAdapter(xlist_adapter);
        xlist_adapter.setPersenter(fragment_model_persenter);

    }




    @Override
    public void CallBackXlist(final HomeBean_F1Content homeBean_f1Content) {

        xlist_adapter.setListData(homeBean_f1Content);
        xlist_adapter.notifyDataSetChanged();


        //xlistview点击事件，跳转到NewsActivity展示网页  webview
        xlist_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = homeBean_f1Content.getResult().getData().get(position-1).getUrl();

                Intent intent = new Intent(getActivity(), NewsActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);

            }
        });

    }




    @Override
    public void onRefresh() {

        fragment_model_persenter.getList(this.murl);
        xlist_adapter.notifyDataSetChanged();
        xlist_view.stopRefresh(true);
    }

    @Override
    public void onLoadMore() {


        xlist_view.stopLoadMore();
    }
}
