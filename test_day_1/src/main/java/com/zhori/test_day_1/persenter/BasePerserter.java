package com.zhori.test_day_1.persenter;

import com.zhori.test_day_1.view.iview.IMvpView;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class BasePerserter<T extends IMvpView> {

    public T t1;

    public void  AttchView(T mainactivity) {

        this.t1=mainactivity;

    }


    public T getT1(){

        return t1;
    }




}
