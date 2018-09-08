package com.hospital.s1m.lib_base.utils;

import com.alibaba.fastjson.JSON;
import com.hospital.s1m.lib_base.data.CacheDataSource;
import com.hospital.s1m.lib_base.entity.Body;
import com.hospital.s1m.lib_base.entity.Header;
import com.hospital.s1m.lib_base.entity.HttpResult;
import com.lzy.okgo.model.HttpParams;

public class HttpParamsUtils<T> {


    public HttpParams getSha1Str(T source) {
        HttpParams httpParams = new HttpParams();
        HttpResult<T> httpResult = null;

        httpResult = new HttpResult<T>();
        Header header = new Header();
        header.setImei(CacheDataSource.getImei());
        header.setType(CacheDataSource.getType());
        header.setV(CacheDataSource.getV());
        header.setClinicId(CacheDataSource.getClinicId());
        header.setDoctorMainId(CacheDataSource.getDoctorMainId());
        httpResult.setHeader(header);
        Body<T> body = new Body<T>();
        body.setParam(source);
        httpResult.setBody(body);

        httpResult.getHeader().setCurrentTime(System.currentTimeMillis());
        String param = JSON.toJSONString(httpResult);
        httpParams.put("detail", param);
        return httpParams;
    }
}
