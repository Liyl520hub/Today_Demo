package com.zhori.today_headlines.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.zhori.today_headlines.R;
import com.zhori.today_headlines.model.MyDecoration;
import com.zhori.today_headlines.model.threefragmentbena.ThreeBean;
import com.zhori.today_headlines.presenter.three_presenter.Three_Persenter;
import com.zhori.today_headlines.view.Toast_Show;
import com.zhori.today_headlines.view.dadpter.RecyclerView_Adapter;
import com.zhori.today_headlines.view.iview.F3_Inteface;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李亚雷
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class Fragment_Three extends Fragment implements F3_Inteface, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recview;
    private RecyclerView_Adapter recyclerView_adapter;
    private Three_Persenter three_persenter;
    private SwipeRefreshLayout sw;
    private ProgressBar bar;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<ThreeBean.ResultBean.DataBean> data;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.act_fragment3, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //初始化控件
        initview();
        //初始化数据
        initdata();

    }

    private void initdata() {


        //设置可刷新的监听
        sw.setOnRefreshListener(this);
        //设置可刷新
        sw.setEnabled(true);
        //设置下拉刷新的bar颜色的切换
        sw.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE);
        //设置下拉刷新的bar的距离
        sw.setProgressViewOffset(true,10,1000);



        //线性布局
        // 第三个参数 true 倒叙，直接定位在最下面；
        //false 顺序
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        //九宫格布局
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);

        //瀑布流
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        //布局管理器
        recview.setLayoutManager(linearLayoutManager);
        //设置条目动画
        recview.setItemAnimator(new DefaultItemAnimator());

        //绘制间隔线  第二个参数：方向设置
        // recview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
       recview.addItemDecoration(new MyDecoration(getActivity()));

        //设置适配器
        recyclerView_adapter = new RecyclerView_Adapter(getActivity());
        recview.setAdapter(recyclerView_adapter);

        //获得数据
        three_persenter = new Three_Persenter();
        three_persenter.setImvpview(this);
        three_persenter.getData();
        recyclerView_adapter.setThree_persenter(three_persenter);


        //上拉加载更多
        recview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //dy>0是上拉
                if (dy > 0) {

                    int last = linearLayoutManager.findLastVisibleItemPosition();
                    int last_grid = gridLayoutManager.findLastVisibleItemPosition();
                    int itemCount = recyclerView_adapter.getItemCount();
                    if (last + 1 == itemCount) {

                        bar.setVisibility(View.VISIBLE);
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    sleep(2000);

                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            bar.setVisibility(View.GONE);
                                        }
                                    });
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();

                    }


                }

            }
        });


        //设置点击事件

        recyclerView_adapter.setMyonclickListener(new RecyclerView_Adapter.MyonCliickListener() {
            @Override
            public void itemListener(View view, int position) {

                Toast_Show.Show(getActivity(), "您点击的是第" + position + "个");


            }

            @Override
            public void itemLongListener(View view, int position) {


                Toast_Show.Show(getActivity(), "您长按的是第" + position + "个");

                recyclerView_adapter.notifyItemRemoved(position);


            }
        });


    }

    private void initview() {

        recview = (RecyclerView) getView().findViewById(R.id.rect_view);
        sw = (SwipeRefreshLayout) getView().findViewById(R.id.swip_refersh);
        bar = (ProgressBar) getView().findViewById(R.id.progress_my);


    }


    @Override
    public void CallBack(ThreeBean threeBean) {
        data = threeBean.getResult().getData();

        recyclerView_adapter.setData((ArrayList<ThreeBean.ResultBean.DataBean>) data);
        recyclerView_adapter.notifyDataSetChanged();


    }


    @Override
    public void onRefresh() {


        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(5000);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            sw.setRefreshing(false);
                            Toast_Show.Show(getActivity(), "dddddddd");
                        }
                    });


                } catch (InterruptedException e) {

                }

            }
        }.start();


    }


}
