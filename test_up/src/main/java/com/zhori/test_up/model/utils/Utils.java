package com.zhori.test_up.model.utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class Utils {



    public static void GetData(RequestParams requestParams, Callback.CommonCallback<Object> commonCallback){

        x.http().get(requestParams,commonCallback);

    }


}
