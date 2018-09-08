package com.hospital.s1m.lib_user.login;

import android.content.Context;

import com.hospital.s1m.lib_base.entity.BeforeLogin;
import com.hospital.s1m.lib_base.listener.ResponseListener;
import com.hospital.s1m.lib_base.mvp.base.BasePresenter;


//P层搞定了
//和V层进行交互->接口
public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginModel loginModel;

    public LoginPresenter(Context mContext) {
        super(mContext);
        this.loginModel = new LoginModel();
    }

    public void login(String username, String password){
        this.loginModel.login(username, password, new ResponseListener<BeforeLogin>() {
            @Override
            public BeforeLogin convert(String jsonStr) {
                return null;
            }

            @Override
            public void onSuccess(BeforeLogin result) {
                getLoginView().onLoginResult(result.getAes_key());
            }

            @Override
            public void onFailed(String errorCode, String errorInfo) {

            }
        });
    }

}
