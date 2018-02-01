package com.sf.mvc.controller;

import java.util.Map;

/**
 * Created by ASUS on 2018/1/31.
 */
public interface MvcModel {

    void getHttpInfo(Map<String,String>  params,String url,MvcListener mvcListener);
}
