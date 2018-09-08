package com.hospital.s1m.lib_base.mvp.base;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleProvider;

public abstract class BasePresenter<V extends BaseView> {

    protected Context mContext;

    public BasePresenter(Context mContext) {
        this.mContext = mContext;
    }

    private V loginView;

    public V getLoginView() {
        return loginView;
    }

    public void attachView(V loginView){
        this.loginView = loginView;
    }

    public void detachView(){
        this.loginView = null;
    }

    public void onDestory(){
        this.mContext = null;
    }
    /**
     * 对 ACTIVITY 生命周期进行管理
     * @return
     */
    protected LifecycleProvider getActivityLifecycleProvider() {
        LifecycleProvider provider = null;
        if (null != mContext && mContext instanceof LifecycleProvider) {
            provider =  (LifecycleProvider)mContext;
        }
        return provider;
    }
}
