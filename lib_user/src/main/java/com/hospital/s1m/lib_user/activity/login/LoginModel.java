package com.hospital.s1m.lib_user.activity.login;

import com.hospital.s1m.lib_base.data.CacheDataSource;
import com.hospital.s1m.lib_base.data.NetDataSource;
import com.hospital.s1m.lib_base.entity.BeforeLogin;
import com.hospital.s1m.lib_base.listener.ResponseListener;


//M层
public class LoginModel {

    public void login(String username, String password,ResponseListener<BeforeLogin> listener){

        CacheDataSource.setBaseUrl("http://bt-usercenter.yunzhenshi.com.cn");
        NetDataSource.post(this, "/login/beforeLogin","",listener);
    }

}
