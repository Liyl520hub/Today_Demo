package com.zhori.test_up.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.zhori.test_up.model.Bean;
import com.zhori.test_up.view.iview.Iview;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 作者：李亚雷
 * 时间：2017/5/10
 * 类用途：
 * 思路：
 */

public class HomePresenter extends BasePersenter<Iview>{




    public void getData(){



        x.http().get(new RequestParams("http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=gj"), new Callback.CommonCallback<String >() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                Bean bean = gson.fromJson(result, Bean.class);

               //   t.CallBack("dd");

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e( "onError:","ddddddddddddddddd");

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });




    }



}
