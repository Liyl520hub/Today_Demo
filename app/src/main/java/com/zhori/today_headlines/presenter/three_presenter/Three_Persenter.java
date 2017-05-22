package com.zhori.today_headlines.presenter.three_presenter;

import android.widget.ImageView;

import com.zhori.today_headlines.model.threefragmentbena.ThreeBean;
import com.zhori.today_headlines.model.utils.Utils;
import com.zhori.today_headlines.presenter.BasePersenter;
import com.zhori.today_headlines.view.iview.F3_Inteface;
import com.zhori.today_headlines.view.iview.UtilsInteface;

/**
 * 作者：李亚雷
 * 时间：2017/5/17
 * 类用途：
 * 思路：
 */

public class Three_Persenter extends BasePersenter<F3_Inteface> {


    public void getData() {

        String url = "http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=gj";

        Utils.HttpGet(url, null, ThreeBean.class, new UtilsInteface() {
            @Override
            public <T> void CallBackBean(T clazz) {

                getImvpview().CallBack((ThreeBean) clazz);

            }
        });


    }

    public void setImage(ImageView imageView, String url) {


        Utils.HttpImag(imageView, url);


    }


}
