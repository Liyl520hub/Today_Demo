package com.zhori.test_day_1.model.utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class Utilse {


   public static void getData(RequestParams requestParams, Callback.CommonCallback<String > commonCallback){

       x.http().get(requestParams,commonCallback);


   }




}
