package com.zhori.test_up.presenter;

import com.zhori.test_up.view.iview.IMvpView;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class BasePersenter <T extends IMvpView> {

    public T t;

    public void AttchView(T t){

        this.t =t;

    }




}
