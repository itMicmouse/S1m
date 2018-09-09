package com.hospital.s1m.lib_user.fargment.jurisdiction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hospital.s1m.lib_base.utils.OnItreamClickListener;
import com.hospital.s1m.lib_user.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zyjk654764 on 2018/8/29.
 */

public class FragmentJurisdiction extends Fragment {
    private View view;
    /**
     * 我的名字
     */
    private TextView mNameiew;
    /**
     * 致医健康未来诊所
     */
    private TextView mClinicNameiew;
    private LinearLayout mUserMarageiew;
    private ImageView mQrCodeiew;
    private ImageView mUserHaedimg;
    /**
     * 我名字
     */
    private TextView mUserName;
    /**
     * 致医健康未来诊所
     */
    private TextView mClinic;
    private ImageView mTwoCode;
    private RecyclerView mDrawerRlv;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_jurisdiction_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        //创建将要下载的图片URL
        mUserHaedimg = view.findViewById(R.id.user_haedimg);
        mUserName = view.findViewById(R.id.user_name);
        mClinic = view.findViewById(R.id.clinic);
        mTwoCode = view.findViewById(R.id.two_code);
        mDrawerRlv = view.findViewById(R.id.drawer_rlv);
        list=new ArrayList<String>();
        list.add("公告设置");
        list.add("营业时间");
        list.add("排班挂号");
        list.add("停诊设置");
        list.add("人员设置");
        list.add("云屏设置");
        list.add("退出账号");
        list.add("快速挂号");
        final DrawAdapter drawAdapter=new DrawAdapter(getActivity(),list);
        drawAdapter.setOnItemClickListener(new OnItreamClickListener() {
            @Override
            public void onItemClick(int position) {
                //拿适配器调用适配器内部自定义好的setThisPosition方法（参数写点击事件的参数的position）
                drawAdapter.setThisPosition(position);
                //嫑忘记刷新适配器
                drawAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        mDrawerRlv.setLayoutManager(gridLayoutManager1);
        mDrawerRlv.setAdapter(drawAdapter);

    }
}
