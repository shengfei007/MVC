package com.sf.mvc.controller;

import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.Map;

import okhttp3.FormBody;

/**
 * Created by ASUS on 2018/1/31.
 */
public class MvcModelImp implements MvcModel{
    @Override
    public void getHttpInfo(Map<String, String> params, String url, final MvcListener mvcListener) {
        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合,,,map集合遍历方式
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
        OkHttpUtils
                .get()
                .url(url)
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {
                        mvcListener.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("response===",response);
                        mvcListener.onSuccess(response);
                    }
                });
    }
}
