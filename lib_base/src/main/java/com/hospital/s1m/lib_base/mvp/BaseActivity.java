package com.hospital.s1m.lib_base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hospital.s1m.lib_base.data.NetDataSource;
import com.hospital.s1m.lib_base.mvp.base.BasePresenter;
import com.hospital.s1m.lib_base.mvp.base.BaseView;
import com.hospital.s1m.lib_base.mvp.impl.MvpCallback;
import com.hospital.s1m.lib_base.mvp.impl.MvpImpl;
import com.hospital.s1m.lib_base.utils.SystemUIUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends RxAppCompatActivity implements MvpCallback<V, P> {

    private MvpImpl<V, P> mvpImpl;

    public P getPresenter() {
        return mvpImpl.getPresenter();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (setContentView() != 0) {
            setContentView(setContentView());
        }
        SystemUIUtils.setStickFullScreen(getWindow().getDecorView());
        mvpImpl = new MvpImpl<V, P>(this);
    }

    /**
     * 设置显示布局
     *
     * @return layout资源ID
     */
    protected abstract int setContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mvpImpl.onDestroy();
        NetDataSource.unRegister(this);
    }
}
