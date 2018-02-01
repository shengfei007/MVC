package com.sf.mvc.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sf.mvc.R;
import com.sf.mvc.base.BaseActivity;
import com.sf.mvc.base.Common;
import com.sf.mvc.bean.MvcBean;
import com.sf.mvc.controller.MvcListener;
import com.sf.mvc.controller.MvcModel;
import com.sf.mvc.controller.MvcModelImp;
import com.sf.mvc.util.GsonUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MvcListener {

    @Bind(R.id.tv_str)
    TextView tvStr;
    @Bind(R.id.btn_summit)
    Button btnSummit;

    private MvcModel weatherModel;
    private Map<String, String> loginMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        weatherModel = new MvcModelImp();
        loginMap = new HashMap<String, String>();
    }

    private String url = Common.URL + "/login?";

    @OnClick(R.id.btn_summit)
    public void onViewClicked() {
        loginMap.put("uName", "盛飞");
        loginMap.put("password", "123456");
        weatherModel.getHttpInfo(loginMap, url, MainActivity.this);
    }

    @Override
    public void onSuccess(String str) {
        //这里可以解析网络请求的str成对象,以防报错加入try-catch
//        MvcBean mvcBean=null;
//        try {
//            mvcBean=GsonUtils.jsonTobean(str,MvcBean.class);;
//        }catch (Exception e){
//
//        }

        tvStr.setText(str);
    }

    @Override
    public void onFailed() {
        showToast("登录失败");
    }
}
