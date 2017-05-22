package com.zhori.test_day_1.persenter;

import android.util.Log;

import com.zhori.test_day_1.model.utils.Utilse;
import com.zhori.test_day_1.view.iview.IVew;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class MainPersenter extends BasePerserter<IVew> {


    public void getString() {


        Utilse.getData(new RequestParams("http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab?uri=news"),
                new Callback.CommonCallback<String >() {
            @Override
            public void onSuccess(String result) {

                getT1().CallBack(result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("onError: ", "dddd");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });














//        Utilse.getData(new RequestParams("http://result.eolinker.com/gfGTLlHc049c6b450500b16971f52bd8e83f6b2fed305ab?uri=news"),
//                new Callback.CommonCallback<String >() {
//            @Override
//            public void onSuccess(String result) {
//
//                getT1().CallBack(result);
//
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });


    }
}