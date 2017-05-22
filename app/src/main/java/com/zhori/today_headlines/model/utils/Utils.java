package com.zhori.today_headlines.model.utils;

import android.content.Context;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zhori.today_headlines.R;
import com.zhori.today_headlines.view.iview.UtilsInteface;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 作者：李亚雷
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class Utils {


    public static <T> void HttpGet(String url, HashMap<String, String> hashMap, final Class<T> tClassa, final UtilsInteface utilsInteface) {


        RequestParams requestParams = new RequestParams();
        requestParams.setUri(url);

        //判断是否为null
        if (hashMap != null) {
            Iterator<String> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = hashMap.get(key);
                requestParams.addParameter(key, value);
            }
        }


        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                T t = gson.fromJson(result, tClassa);

                utilsInteface.CallBackBean(t);


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }


    public static void HttpImag(ImageView imag_right, String thumbnail_pic_s) {


        ImageOptions build = new ImageOptions.Builder()
                .setFailureDrawableId(R.drawable.fail)
                .setLoadingDrawableId(R.drawable.timg)
                .setIgnoreGif(true)
                .setUseMemCache(true)
                .build();


        x.image().bind(imag_right, thumbnail_pic_s, build);


    }


    public static int getScrennWinth(Context mcontext) {


        WindowManager systemService = (WindowManager) mcontext.getSystemService(mcontext.WINDOW_SERVICE);

        return systemService.getDefaultDisplay().getWidth();
    }


}
