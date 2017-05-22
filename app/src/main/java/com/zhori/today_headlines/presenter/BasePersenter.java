package com.zhori.today_headlines.presenter;

import com.zhori.today_headlines.view.iview.IMvpView;

/**
 * 作者：李亚雷
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class BasePersenter<T extends IMvpView> {


    private T imvpview;


    public T getImvpview() {
        return imvpview;
    }

    public void setImvpview(T imvpview) {
        this.imvpview = imvpview;
    }
}
