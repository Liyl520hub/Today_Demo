package com.zhori.today_headlines.presenter.home_presenter;

import android.widget.ImageView;

import com.zhori.today_headlines.model.homeFragmentBean.HomeBean_F1Content;
import com.zhori.today_headlines.model.utils.Utils;
import com.zhori.today_headlines.presenter.BasePersenter;
import com.zhori.today_headlines.view.iview.F1_Model_Interface;
import com.zhori.today_headlines.view.iview.UtilsInteface;

/**
 * 作者：李亚雷
 * 时间：2017/5/12
 * 类用途：
 * 思路：
 */

public class Fragment_Model_Persenter extends BasePersenter<F1_Model_Interface> {


    //内容url
   // String content_url = "http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=";




    public void getList(String murl) {

        String content_url = "http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri="+murl;


        Utils.HttpGet(content_url, null, HomeBean_F1Content.class, new UtilsInteface() {
            @Override
            public <T> void CallBackBean(T clazz) {

                getImvpview().CallBackXlist((HomeBean_F1Content) clazz);

            }

            @Override
            public void CallBackJson(String json) {

            }
        });


    }

    public void setImag(ImageView imag_, String imag_url) {

        Utils.HttpImag(imag_, imag_url);

       // Utils.OkhttpImag(imag_,imag_url);


    }






}
