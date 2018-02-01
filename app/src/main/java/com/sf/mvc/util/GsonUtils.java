package com.sf.mvc.util;


import com.google.gson.Gson;

/**
 * json 解析工具类
 * @author sf
 */
public class GsonUtils {
    public static <T> T jsonTobean(String result, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            T t = gson.fromJson(result, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String objectToJsonStr(Object obj) {
        try {
            Gson gson = new Gson();
            String t = gson.toJson(obj);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
