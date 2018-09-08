package com.hospital.s1m.lib_user.login;


import com.hospital.s1m.lib_base.mvp.base.BaseView;

//用于V层和M层交互的接口
public interface LoginView extends BaseView {
    void onLoginResult(String result);
}
