package com.zhori.today_headlines.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhori.today_headlines.R;
import com.zhori.today_headlines.enent.TestEnevt;

import org.greenrobot.eventbus.EventBus;
import org.xutils.x;

import java.util.ArrayList;

/**
 * 作者：李亚雷
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class Fragment_Secend extends Fragment {

    private ViewPager vp;
    private ArrayList<String> strings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.act_fragment2, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        String video_url="http://www.iqiyi.com/w_19rqvesqv1.html";
        String video_ur="https://v.qq.com/x/page/g14142zyugf.html";


        vp = (ViewPager) getView().findViewById(R.id.vp_f2);


        strings = new ArrayList<>();

        strings.add("http://img.taopic.com/uploads/allimg/121218/267859-12121R0520287.jpg");
        strings.add("http://img.taopic.com/uploads/allimg/121218/267859-12121R0520287.jpg");
        strings.add("http://img.taopic.com/uploads/allimg/121218/267859-12121R0520287.jpg");


        Myadapter myadapter = new Myadapter();

       vp.setAdapter(myadapter);



        getView().findViewById(R.id.btn_f2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TestEnevt testEnevt = new TestEnevt();
                testEnevt.setMessage("haha  我是2");
                testEnevt.setIndex(555555);
                EventBus.getDefault().post(testEnevt);

            }
        });



    }


    private class Myadapter extends PagerAdapter{


        @Override
        public int getCount() {
            return strings.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = new ImageView(getActivity());


            x.image().bind(imageView,strings.get(position));
            container.addView(imageView);


            return imageView;
        }
    }

}
