package com.sf.mvc.base;

import android.app.Activity;
import android.text.TextUtils;

import com.sf.mvc.activity.MainActivity;

import java.util.LinkedList;


/**
 * 页面管理
 * @author sf
 */
public class MyActivityManager {

    public static LinkedList<Activity> activities = new LinkedList<Activity>();

    public static Class<?>[] bottomsClazz = new Class<?>[]{
            MainActivity.class};

    /**
     * 添加新的activity
     */
    public static void add(Activity activity) {
        activities.add(activity);
    }

    /**
     * 删除指定activity
     */
    public static void popActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activities.remove(activity);
        }
    }

    /**
     * 关闭除参数activity外的所有activity
     *
     * @param activity
     */
    public static void finish(Activity activity) {
        for (Activity iterable : activities) {
            if (activity != iterable) {
                if (iterable != null) {
                    iterable.finish();
                }
            }
        }
    }

    /**
     * 结束除了指定Activity名以外的全部Activity
     */
    public static void finishButOne(String activityName) {
        if (TextUtils.isEmpty(activityName)) {
            return;
        }
        for (Activity iterable : activities) {
            if (iterable != null
                    && !activityName
                    .equals(iterable.getClass().getSimpleName())) {
                iterable.finish();
            }
        }
    }

    /**
     * 关闭所有活动
     */
    public static void finishAll() {
        for (Activity iterable : activities) {
            if (iterable != null) {
                iterable.finish();
            }
        }
    }

    /**
     * 删除非保持的activity
     */
    public static void delNotBottomActivity() {
        Boolean flag = false;
        for (int i = 0; i < activities.size(); i++) {
            flag = false;
            for (int j = 0; j < bottomsClazz.length; j++) {
                if (activities.get(i).getClass().getSimpleName()
                        .equals(bottomsClazz[j].getSimpleName())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                popActivity(activities.get(i));
                if (i >= 1) {
                    i--;
                }
            }
        }
    }

}
