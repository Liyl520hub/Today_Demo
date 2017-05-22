package com.zhori.test_up.view.iview;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public interface Iview extends IMvpView{

    void CallBack(String string);

    void CallBackErr(String string,int code);


}
