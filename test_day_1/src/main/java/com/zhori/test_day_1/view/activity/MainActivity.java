package com.zhori.test_day_1.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zhori.test_day_1.R;
import com.zhori.test_day_1.persenter.MainPersenter;
import com.zhori.test_day_1.view.iview.IVew;

public class MainActivity extends AppCompatActivity implements IVew{

    private MainPersenter mainPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mainPersenter = new MainPersenter();

        mainPersenter.AttchView(this);

        mainPersenter.getString();

    }

    @Override
    public void CallBack(String string) {

        Toast.makeText(this, "==="+string, Toast.LENGTH_SHORT).show();



    }
}
