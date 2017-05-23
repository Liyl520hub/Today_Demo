package com.zhori.today_headlines.model.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.zhori.today_headlines.R;
import com.zhori.today_headlines.view.iview.UtilsInteface;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：李亚雷
 * 时间：2017/5/11
 * 类用途：
 * 思路：
 */

public class Utils {


    private static UtilsInteface utilsInteface111;
    private static  ImageView imagview;




    private static Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){

                case 0:
                {
                    String  obj = (String) msg.obj;
                    utilsInteface111.CallBackJson(obj);
                }
                break;

                case 1:
                {
                    byte[] obj = (byte[]) msg.obj;

                    Bitmap bitmap = BitmapFactory.decodeByteArray(obj, 0, obj.length);
                    imagview.setImageBitmap(bitmap);

                }
                break;



            }




        }
    };





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




    public static void OkhttpImag(ImageView imag_right, String thumbnail_pic_s) {

        imagview=imag_right;


        OkHttpClient okHttpClient = new OkHttpClient();

        Request build = new Request.Builder().url(thumbnail_pic_s).build();
        okHttpClient.newCall(build).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                byte[] bytes = response.body().bytes();

                Message message = handler.obtainMessage();
                message.obj=bytes;
                message.what=1;

                handler.sendMessage(message);
            }
        });


    }




    public static <T>void OkHttpget(String url,UtilsInteface utilsInteface2){


        utilsInteface111=utilsInteface2;


        OkHttpClient okHttpClient = new OkHttpClient();

        final Request build = new Request.Builder().url(url).build();

        okHttpClient.newCall(build).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                Message message = handler.obtainMessage();
                message.obj=string;
                message.what=0;

                handler.sendMessage(message);



            }
        });




    }










    public static int getScrennWinth(Context mcontext) {


        WindowManager systemService = (WindowManager) mcontext.getSystemService(mcontext.WINDOW_SERVICE);

        return systemService.getDefaultDisplay().getWidth();
    }


}
