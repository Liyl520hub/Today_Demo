package com.zhori.today_headlines.presenter.home_presenter;

import com.zhori.today_headlines.model.homeFragmentBean.HomeBean_F1;
import com.zhori.today_headlines.model.utils.Utils;
import com.zhori.today_headlines.presenter.BasePersenter;
import com.zhori.today_headlines.view.iview.F1_Interface;
import com.zhori.today_headlines.view.iview.UtilsInteface;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class Fragment_Home_Presenter extends BasePersenter<F1_Interface> {


    //标题url
    String tab_url = "http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab?uri=news";





    private List<HomeBean_F1.ResultBean.DateBean> date=new ArrayList<>();



    public void getTabList() {

        Utils.HttpGet(tab_url, null, HomeBean_F1.class, new UtilsInteface() {
            @Override
            public <T> void CallBackBean(T clazz) {

                date.addAll(((HomeBean_F1) clazz).getResult().getDate());

                getImvpview().CallBackTabList((HomeBean_F1) clazz);



            }
        });


    }



}
