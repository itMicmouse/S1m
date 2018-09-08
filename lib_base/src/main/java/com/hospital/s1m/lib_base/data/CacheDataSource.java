package com.hospital.s1m.lib_base.data;

import android.os.Bundle;

import com.hospital.s1m.lib_base.entity.BeforeLogin;

/**
 * Created by 10295 on 2017/12/5 0005.
 * 缓存数据，静态变量保存
 * 应保证缓存的数据只有在登录成功被存储，注销需主动清除缓存
 */

public class CacheDataSource {
    private static String clinicId;
    private static String doctorMainId;
    private static String imei;
    private static String type;
    private static String v;
    private static String baseUrl;
    private static String token;

    private static BeforeLogin beforeLogin;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        CacheDataSource.token = token;
    }

    public static String getClinicId() {
        return clinicId;
    }

    public static void setClinicId(String clinicId) {
        CacheDataSource.clinicId = clinicId;
    }

    public static String getDoctorMainId() {
        return doctorMainId;
    }

    public static void setDoctorMainId(String doctorMainId) {
        CacheDataSource.doctorMainId = doctorMainId;
    }

    public static String getImei() {
        return imei;
    }

    public static void setImei(String imei) {
        CacheDataSource.imei = imei;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        CacheDataSource.type = type;
    }

    public static String getV() {
        return v;
    }

    public static void setV(String v) {
        CacheDataSource.v = v;
    }

    public static BeforeLogin getBeforeLogin() {
        return beforeLogin;
    }

    public static void setBeforeLogin(BeforeLogin beforeLogin) {
        CacheDataSource.beforeLogin = beforeLogin;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        CacheDataSource.baseUrl = baseUrl;
    }

    /**
     * 清除缓存
     */
    public static void clearCache() {
        clinicId="";
        doctorMainId="";
        imei="";
        type="";
        v="";
        beforeLogin = null;
    }

    public static void saveData(Bundle outState) {
        outState.putString("clinicId", clinicId);
        outState.putString("doctorMainId", doctorMainId);
        outState.putString("imei", imei);
        outState.putString("type", type);
        outState.putString("v", v);
        outState.putSerializable("beforeLogin", beforeLogin);
    }

    public static void restoreData(Bundle savedInstanceState) {
        clinicId = savedInstanceState.getString("clinicId");
        doctorMainId = savedInstanceState.getString("doctorMainId");
        imei = savedInstanceState.getString("imei");
        type = savedInstanceState.getString("type");
        v = savedInstanceState.getString("v");
        beforeLogin = (BeforeLogin) savedInstanceState.getSerializable("beforeLogin");
    }
}
