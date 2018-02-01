package com.sf.mvc.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by sf
 * 继承okhttpclient的StringCallback实现带加载圈的请求监听
 */
public class LoadCallBack extends StringCallback {
    private ProgressDialog m_pDialog = null;
    private Context context;

    public LoadCallBack(Context context){
        this.context=context;
        m_pDialog=new ProgressDialog(context);
        m_pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        m_pDialog.setIndeterminate(false);
        m_pDialog.setCancelable(false);
        m_pDialog.setMessage("上传中");
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(String response, int id) {

    }

    @Override
    public void onBefore(Request request, int id) {
        super.onBefore(request, id);
        m_pDialog.show();
    }

    @Override
    public void onAfter(int id) {
        super.onAfter(id);
        m_pDialog.hide();
    }

}
