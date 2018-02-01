package com.sf.mvc.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sf on 2017/8/16.
 */
public class BaseActivity extends Activity {

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 添加到Activity 的管理类
         */
        MyActivityManager.add(this);
    }

    /**
     * Toast方法
     */
    public void showToast(CharSequence text) {
        if (isFinishing()) {
            return;
        }
        if (mToast == null) {
            mToast = Toast.makeText(this, "", Toast.LENGTH_LONG);
//            mToast.setGravity(Gravity.BOTTOM, 0, 0);
        }
        mToast.setText(text);
        mToast.show();
    }

    /**
     * 控制log关闭启动
     */
    public void showLog(String l, String r) {
        if (true) {
            Log.e(l, r);
        }
    }

    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//        this.overridePendingTransition(R.anim.push_right_in,
//                R.anim.push_right_out);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
//        this.overridePendingTransition(R.anim.push_right_in,
//                R.anim.push_right_out);
    }

    @Override
    public void finish() {
        super.finish();
//        this.overridePendingTransition(R.anim.push_left_in,
//                R.anim.push_left_out);
    }

}
