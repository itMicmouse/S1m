package com.hospital.s1m;

import android.os.Bundle;
import android.view.View;

import com.hospital.s1m.lib_base.mvp.BaseActivity;
import com.hospital.s1m.lib_base.mvp.base.BasePresenter;
import com.hospital.s1m.lib_base.mvp.base.BaseView;

public class MainActivity extends BaseActivity implements LoginView {

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onLoginResult(String result) {

    }

    @Override
    public BasePresenter createPresenter() {
        return new LoginPresenter(MainActivity.this);
    }

    @Override
    public BaseView createView() {
        return this;
    }
}
