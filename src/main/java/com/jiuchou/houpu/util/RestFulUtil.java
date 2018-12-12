package com.jiuchou.houpu.util;

/**
 * Created by zq on 2018/11/14.
 */
public class RestFulUtil<T> {

    private RestFulUtil(){}

    public static RestFulUtil getInstance() {
        return new RestFulUtil();
    }

    public RestFulBean<T> getResuFulBean(T o, int status, String msg) {
        RestFulBean<T> objectRestFulBean = new RestFulBean<T>();
        objectRestFulBean.setStatus(status);
        objectRestFulBean.setMsg(msg);
        objectRestFulBean.setData(o);
        return objectRestFulBean;
    }

}
