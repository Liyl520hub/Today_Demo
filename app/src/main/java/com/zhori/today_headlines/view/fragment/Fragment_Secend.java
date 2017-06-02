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
import java.util.Timer;
import java.util.TimerTask;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 作者：李亚雷
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class Fragment_Secend extends Fragment {

    private ViewPager vp;
    private ArrayList<String> strings;
    private int index=0;
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
        strings.add("http://pic.58pic.com/58pic/12/01/41/64s58PICxnC.jpg");
        strings.add("http://pic.58pic.com/58pic/11/20/14/96K58PICAyj.jpg");


        Myadapter myadapter = new Myadapter();

       vp.setAdapter(myadapter);

        //视频接口
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=221"+i+"1&editionType=default&source=ucloud");
        }
        //播放视频
        JCVideoPlayer jCVideoPlayer = (JCVideoPlayer) getView().findViewById(R.id.videocontroller1);
        jCVideoPlayer.setUp(list.get(2), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"测试小视频");


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        vp.setCurrentItem(index,false);
                        index++;
                    }
                });
            }
        },0,2000);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private class Myadapter extends PagerAdapter{


        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
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


            x.image().bind(imageView,strings.get((position % strings.size())));
            container.addView(imageView);


            return imageView;
        }
    }

}
