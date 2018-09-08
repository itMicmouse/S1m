package com.hospital.s1m.lib_base.mvp.impl;

import com.hospital.s1m.lib_base.mvp.base.BasePresenter;
import com.hospital.s1m.lib_base.mvp.base.BaseView;

//如何抽象？
public class MvpImpl<V extends BaseView, P extends BasePresenter<V>> {

    private P presenter;
    private V view;

    private MvpCallback<V, P> callback;

    public P getPresenter() {
        return presenter;
    }

    public MvpImpl(MvpCallback<V, P> callback){
        this.callback = callback;
        init();
    }

    private void init() {
        presenter = this.callback.createPresenter();
        if (presenter == null) {
            throw new NullPointerException("presenter，空指针异常...");
        }
        view = this.callback.createView();
        if (view == null){
            throw new NullPointerException("view，空指针异常...");
        }
        presenter.attachView(view);
    }

    public void onDestroy() {
        if (presenter != null){
            presenter.detachView();
            presenter.onDestory();
        }
    }

}
