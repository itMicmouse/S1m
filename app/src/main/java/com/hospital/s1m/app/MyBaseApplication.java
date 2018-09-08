package com.hospital.s1m.app;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponentCallback;
import com.hospital.s1m.lib_base.app.BaseAppLogic;
import com.hospital.s1m.lib_base.app.BaseApplication;
import com.hospital.s1m.lib_base.constants.Components;
import com.hospital.s1m.lib_base.utils.ToastUtils;

public class MyBaseApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void initLogic() {
        CC.obtainBuilder(Components.ComponentUser).setActionName("getApplogic") .build().callAsyncCallbackOnMainThread(fragmentCallback);
    }

    IComponentCallback fragmentCallback = new IComponentCallback() {
        @Override
        public void onResult(CC cc, CCResult result) {
            if (result.isSuccess()) {
                //call component a for LifecycleFragment success
                BaseAppLogic getApplogic = result.getDataItem("getApplogic");
                registerApplicationLogic(getApplogic);
            } else {
                ToastUtils.showToast(MyBaseApplication.this,"**组件初始化失败");
            }
        }
    };
}
