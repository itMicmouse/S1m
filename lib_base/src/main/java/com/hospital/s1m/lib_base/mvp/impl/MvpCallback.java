package com.hospital.s1m.lib_base.mvp.impl;


import com.hospital.s1m.lib_base.mvp.base.BasePresenter;
import com.hospital.s1m.lib_base.mvp.base.BaseView;

public interface MvpCallback<V extends BaseView, P extends BasePresenter<V>> {

    P createPresenter();

    V createView();

}
