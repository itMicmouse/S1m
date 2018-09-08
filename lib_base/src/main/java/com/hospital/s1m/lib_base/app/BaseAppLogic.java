package com.hospital.s1m.lib_base.app;

import android.content.res.Configuration;
import android.support.annotation.NonNull;

public class BaseAppLogic {
    protected BaseApplication mApplication;

    public BaseAppLogic() {
    }

    public void setApplication(@NonNull BaseApplication application) {
        mApplication = application;
    }

    public void onCreate() {
    }

    public void onTerinate() {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int level) {
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }


}
