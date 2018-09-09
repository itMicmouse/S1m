package com.hospital.s1m.lib_user.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.hospital.s1m.lib_base.mvp.BaseActivity;
import com.hospital.s1m.lib_base.mvp.base.BasePresenter;
import com.hospital.s1m.lib_base.mvp.base.BaseView;
import com.hospital.s1m.lib_base.utils.StatusBarUtils;
import com.hospital.s1m.lib_user.R;
import com.hospital.s1m.lib_user.fargment.jurisdiction.FragmentJurisdiction;

public class TestActivity extends BaseActivity implements BaseView {

    private FrameLayout mLeftLayout;
    private DrawerLayout mDrawerLayout;
    private Toolbar id_toolbar;

    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.with(this)
                .setDrawerLayoutContentId(true,R.id.center_layout)
                .setColor(getResources().getColor(com.hospital.s1m.lib_base.R.color.basic_status_bar_color))
                .init();
        initView();
        onListener();
    }

    private void onListener() {
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                //试验
                FragmentJurisdiction fragment_patient=new FragmentJurisdiction();
                //动态添加fragment进来
                getSupportFragmentManager().beginTransaction().replace(R.id.left_layout,fragment_patient).commit();
                mDrawerLayout.openDrawer(mLeftLayout);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        id_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, id_toolbar, R.string.user_open, R.string.user_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //侧滑栏打开
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //侧滑栏关闭
            }
        };

        //mDrawerToggle.syncState();此处注释掉是为了不使用默认的开关箭头

        //设置侦听
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        setSupportActionBar(id_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initView() {
        mLeftLayout =  findViewById(R.id.left_layout);
        mDrawerLayout =  findViewById(R.id.drawer_layout);
        id_toolbar =  findViewById(R.id.id_toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 绑定toobar跟menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected int setContentView() {
        return R.layout.user_test;
    }

    @Override
    public BasePresenter createPresenter() {
        return new TestPresenter(this);
    }

    @Override
    public BaseView createView() {
        return this;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
