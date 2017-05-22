package com.zhori.today_headlines.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;

import com.zhori.today_headlines.model.utils.Utils;

/**
 * 作者：李亚雷
 * 时间：2017/5/18
 * 类用途：
 * 思路：
 */

public class MyDecoration extends ItemDecoration {



    private Context mcontext;


    public MyDecoration(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override

    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int scrennWinth = Utils.getScrennWinth(mcontext);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        int childCount = parent.getChildCount();
        for (int i = 0; i <childCount; i++) {
            int bottom = parent.getChildAt(i).getBottom();

      //   c.drawRect(0,bottom,200,bottom+10,paint);


        }


    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int scrennWinth = Utils.getScrennWinth(mcontext);

//        Paint paint = new Paint();
//        paint.setColor(Color.RED);
//        int childCount = parent.getChildCount();
//        for (int i = 0; i <childCount; i++) {
//            int bottom = parent.getChildAt(i).getBottom();
//
//            c.drawRect(0,bottom,scrennWinth,bottom+10,paint);
//
//        }


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        int childCount = parent.getChildCount();
        for (int i = 0; i <childCount; i++) {
            int bottom = parent.getChildAt(i).getBottom();

            c.drawRect(0,bottom,scrennWinth,bottom+20,paint);




        }



    }


}
