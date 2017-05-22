package com.zhori.today_headlines.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 作者：李亚雷
 * 时间：2017/5/13
 * 类用途：自定义吐司
 * 思路：
 */

public class Toast_Show {


    public static void Show(Context mcontext, String string){

        Toast toast = new Toast(mcontext);

        TextView textView= new TextView(mcontext);
        textView.setTextColor(Color.parseColor("#FF6C6C"));
        textView.setTextSize(15);
        textView.setText(string);
        toast.setView(textView);
        toast.show();
    }


}
