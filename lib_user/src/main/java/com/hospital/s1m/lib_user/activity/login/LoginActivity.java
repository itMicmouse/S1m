package com.hospital.s1m.lib_user.activity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hospital.s1m.lib_base.mvp.BaseActivity;
import com.hospital.s1m.lib_base.mvp.base.BasePresenter;
import com.hospital.s1m.lib_base.mvp.base.BaseView;
import com.hospital.s1m.lib_user.R;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    /**
     * 请输入手机号
     */
    private EditText mLoginTel;
    /**
     * 请输入密码
     */
    private EditText mLoginPwd;
    private AppCompatCheckBox mRememberPwd;
    /**
     * 忘记密码?
     */
    private TextView mForgetPwd;
    /**
     * 登录
     */
    private Button mButLogin;
    /**
     * 基层诊所医生的业务利器
     */
    private TextView mBottomTextOne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int setContentView() {
        return R.layout.user_activity_login;
    }

    @Override
    public BasePresenter createPresenter() {
        return new LoginPresenter(LoginActivity.this);
    }

    @Override
    public BaseView createView() {
        return this;
    }

    @Override
    public void onLoginResult(String result) {

    }

    private void initView() {
        mLoginTel =  findViewById(R.id.login_tel);
        mLoginPwd =  findViewById(R.id.login_pwd);
        mRememberPwd =  findViewById(R.id.remember_pwd);
        mForgetPwd =  findViewById(R.id.forget_pwd);
        mButLogin =  findViewById(R.id.but_login);
        mButLogin.setOnClickListener(this);
        mBottomTextOne =  findViewById(R.id.bottom_text_one);
    }

    @Override
    public void onClick(View v) {

    }
}
