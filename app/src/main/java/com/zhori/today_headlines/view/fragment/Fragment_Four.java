package com.zhori.today_headlines.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhori.today_headlines.R;
import com.zhori.today_headlines.view.Toast_Show;
import com.zhori.today_headlines.view.activity.Login_QQ;

import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者：李亚雷
 * 时间：2017/5/9
 * 类用途：
 * 思路：
 */

public class Fragment_Four extends Fragment implements View.OnClickListener,Login_QQ.Login_back {

    private Button btn_night;
    private RadioButton btn_history;
    private RadioButton btn_shou;
    private boolean is_one = true;
    private ImageButton weibo;
    private ImageButton qq;
    private ImageButton phone;
    private LinearLayout login_ll;
    private LinearLayout qq_icon_ll;
    private ImageButton qq_icon;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.act_fragment4, container, false);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        initView();


        getIslogin();




        btn_night_text();



    }

    private void getIslogin() {
        SharedPreferences login = getActivity().getSharedPreferences("Login", MODE_PRIVATE);

        boolean islogin = login.getBoolean("islogin", false);

        if (islogin){

            login_ll.setVisibility(View.GONE);
            qq_icon_ll.setVisibility(View.VISIBLE);

        }else{

            login_ll.setVisibility(View.VISIBLE);
            qq_icon_ll.setVisibility(View.GONE);

        }


    }




    private void btn_night_text() {


        SharedPreferences day_night = getActivity().getSharedPreferences("Day_Night", getActivity().MODE_PRIVATE);

        if (day_night.getBoolean("isniaght", false)) {

            btn_night.setText("日间");
            is_one = day_night.getBoolean("isniaght", false);

        } else {

            btn_night.setText("夜间");
            is_one = day_night.getBoolean("isniaght", false);
        }


    }

    private void initView() {

        btn_shou = (RadioButton) getView().findViewById(R.id.btn_shoucang);
        btn_history = (RadioButton) getView().findViewById(R.id.btn_lishi);
        btn_night = (Button) getView().findViewById(R.id.btn_niaght);

        phone = (ImageButton) getView().findViewById(R.id.phone_login);
        qq = (ImageButton) getView().findViewById(R.id.qq_login);
        weibo = (ImageButton) getView().findViewById(R.id.weibo_login);

        //登录和非登录的布局
        login_ll = (LinearLayout) getView().findViewById(R.id.login_ll);
        qq_icon_ll = (LinearLayout) getView().findViewById(R.id.qqicon_ll);

        qq_icon = (ImageButton) getView().findViewById(R.id.qq_icon);


        btn_shou.setOnClickListener(this);
        btn_history.setOnClickListener(this);
        btn_night.setOnClickListener(this);

        phone.setOnClickListener(this);
        qq.setOnClickListener(this);
        weibo.setOnClickListener(this);

        qq_icon.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_shoucang: {
                Toast_Show.Show(getActivity(), "收藏");
            }
            break;

            case R.id.btn_lishi: {
                Toast_Show.Show(getActivity(), "历史");

            }
            break;

            case R.id.btn_niaght: {


                if (is_one) {
                    btn_night.setText("夜间");
                    getActivity().setTheme(R.style.nightTheme);
                    is_one = false;


                } else {

                    btn_night.setText("日间");
                    getActivity().setTheme(R.style.dayTheme);
                    is_one = true;


                }

                SharedPreferences day_night = getActivity().
                        getSharedPreferences("Day_Night", getActivity().MODE_PRIVATE);
                SharedPreferences.Editor edit = day_night.edit();
                edit.putBoolean("isniaght", is_one);
                edit.putInt("position", 3);
                edit.commit();

                getActivity().recreate();


            }
            break;


            case R.id.phone_login: {
                Toast_Show.Show(getActivity(), "手机登录");
            }
            break;

            case R.id.qq_login: {

                qqLogin();
                Toast_Show.Show(getActivity(), "正在使用QQ登录");






            }
            break;

            case R.id.weibo_login: {
                Toast_Show.Show(getActivity(), "微博登录");


            }
            break;

            case R.id.qq_icon: {

                Intent intent = new Intent(getActivity(), Login_QQ.class);

                Login_QQ login_qq = new Login_QQ();
                login_qq.setLogin(this);


                getActivity().startActivity(intent);

            }
            break;


        }


    }

    private void qqLogin() {

        UMAuthListener umAuthListener = new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

                Toast_Show.Show(getActivity(),"onStart");

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

                String name = map.get("name");
                String uid = map.get("uid");
                String iconurl = map.get("iconurl");

                if (name!=null && uid !=null && iconurl!=null){

                    login_ll.setVisibility(View.GONE);
                    qq_icon_ll.setVisibility(View.VISIBLE);

                    SharedPreferences login = getActivity().getSharedPreferences("Login", MODE_PRIVATE);
                    SharedPreferences.Editor edit = login.edit();
                    edit.putBoolean("islogin",true);
                    edit.commit();

                }



            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                Toast_Show.Show(getActivity(),"onError");
            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {
                Toast_Show.Show(getActivity(),"onCancel");
            }
        };


        UMShareAPI umShareAPI = UMShareAPI.get(getActivity());
        umShareAPI.getPlatformInfo(getActivity(),SHARE_MEDIA.QQ,umAuthListener);



    }


    @Override
    public void Back_Login() {

        getIslogin();

    }
}
