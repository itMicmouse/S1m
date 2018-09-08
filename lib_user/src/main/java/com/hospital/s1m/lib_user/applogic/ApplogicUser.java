package com.hospital.s1m.lib_user.applogic;

import android.util.Log;

import com.hospital.s1m.lib_base.app.BaseAppLogic;

public class ApplogicUser extends BaseAppLogic {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("application","User模块需要在Application中注册的内容");
    }
}
