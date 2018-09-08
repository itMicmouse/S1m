package com.hospital.s1m.lib_base.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseApplication extends Application {
    private List<BaseAppLogic> logicClassList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        initLogic();
    }

    protected abstract void initLogic();

    protected void registerApplicationLogic(BaseAppLogic logicClass) {
        logicClassList.add(logicClass);
        logicClass.onCreate();
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        for (BaseAppLogic baseAppLogic : logicClassList) {
            baseAppLogic.onTerinate();
        }
    }
}
