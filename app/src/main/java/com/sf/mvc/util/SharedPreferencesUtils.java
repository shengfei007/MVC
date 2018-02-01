package com.sf.mvc.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 操作sharedPrefrence的工具类
 * @author sf
 */
public class SharedPreferencesUtils {
    public static final String SP_NAME = "config";
    public static SharedPreferences sp;

    /**
     * 保存字符串到sharedPrefrence
     *
     * @param ct    Context
     * @param key   sp的name
     * @param value sp的值
     */
    public static void saveString(Context ct, String key, String value) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        sp.edit().putString(key, value).commit();
    }

    /**
     * 获取字符串
     *
     * @param ct       Context
     * @param key      名称
     * @param defValue 默认值
     * @return
     */
    public static String getString(Context ct, String key, String defValue) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        return sp.getString(key, defValue);
    }

    /**
     * 保存boolean类型到sharedPrefrence
     *
     * @param ct    Context
     * @param key   名称
     * @param value sp的值
     */
    public static void saveBoolean(Context ct, String key, boolean value) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * 获取boolean类型值
     *
     * @param ct       Context
     * @param key      名称
     * @param defValue 默认值
     * @return
     */
    public static Boolean getBoolean(Context ct, String key, boolean defValue) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        return sp.getBoolean(key, defValue);
    }

    public static void saveFloat(Context ct, String key, float value) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        sp.edit().putFloat(key, value).commit();
    }

    public static Float getFloat(Context ct, String key, float defValue) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        return sp.getFloat(key, defValue);
    }

    public static void saveInteger(Context ct, String key, Integer value) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        sp.edit().putInt(key, value).commit();
    }

    public static Integer getInteger(Context ct, String key, Integer defValue) {
        if (sp == null)
            sp = ct.getSharedPreferences(SP_NAME, 0);
        return sp.getInt(key, defValue);
    }

}
