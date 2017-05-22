package com.zhori.today_headlines.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zhori.today_headlines.R;
import com.zhori.today_headlines.view.fragment.Fragment_Four;

import java.util.Map;

/**
 * 作者：李亚雷
 * 时间：2017/5/12
 * 类用途：
 * 思路：
 */

public class Login_QQ extends AppCompatActivity {

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调

        }
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();

            Log.e("dddddddddddddddddddd",  "退出成功");

            SharedPreferences login = getSharedPreferences("Login", MODE_PRIVATE);
            SharedPreferences.Editor edit = login.edit();
            edit.putBoolean("islogin",false);
            edit.commit();
            fragment_four.Back_Login();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
            Log.e("dddddddddddddddddddd", "退出失败 ");
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
            Log.e("dddddddddddddddddddd", "退出取消 ");
        }
    };
    private Button back_;
    private Fragment_Four fragment_four;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_qq);


       // SlidingMenu


        back_ = (Button) findViewById(R.id.btn_back);



        back_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UMShareAPI umShareAPI = UMShareAPI.get(getApplicationContext());
                umShareAPI.deleteOauth(Login_QQ.this,SHARE_MEDIA.QQ,umAuthListener);



            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    public void setLogin(Fragment_Four fragment_four) {

     this.fragment_four=fragment_four;

    }


    public  interface Login_back{


        void Back_Login();


    }



}
