package com.zhori.test_up.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zhori.test_up.R;
import com.zhori.test_up.presenter.HomePresenter;
import com.zhori.test_up.view.iview.Iview;

public class MainActivity extends AppCompatActivity implements Iview{

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();





    }

    private void initView() {


        homePresenter = new HomePresenter();
        homePresenter.AttchView(this);
        homePresenter.getData();

    }


    @Override
    public void CallBack(String string) {

        Toast.makeText(this, ">_<"+string, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void CallBackErr(String string, int code) {


    }

}
