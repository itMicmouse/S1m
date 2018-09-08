package com.hospital.s1m.lib_base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hospital.s1m.lib_base.mvp.base.BasePresenter;
import com.hospital.s1m.lib_base.mvp.base.BaseView;
import com.hospital.s1m.lib_base.mvp.impl.MvpCallback;
import com.hospital.s1m.lib_base.mvp.impl.MvpImpl;
import com.trello.rxlifecycle2.components.support.RxFragment;


public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends RxFragment implements MvpCallback<V, P> {

    private MvpImpl<V, P> mvpImpl;

    public P getPresenter() {
        return mvpImpl.getPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mvpImpl = new MvpImpl<V, P>(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mvpImpl.onDestroy();
    }
}
