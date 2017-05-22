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


//        Uri uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
//        VideoView videoView = (VideoView)getView().findViewById(R.id.vp_f2);
//
//        videoView.setMediaController(new MediaController(getActivity()));
//
//        videoView.setVideoURI(uri);
//        videoView.start();
       // videoView.requestFocus();


        vp = (ViewPager) getView().findViewById(R.id.vp_f2);


        strings = new ArrayList<>();

        strings.add("http://img.taopic.com/uploads/allimg/121218/267859-12121R0520287.jpg");
        strings.add("http://img.taopic.com/uploads/allimg/121218/267859-12121R0520287.jpg");
        strings.add("http://img.taopic.com/uploads/allimg/121218/267859-12121R0520287.jpg");


        Myadapter myadapter = new Myadapter();

       vp.setAdapter(myadapter);


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
