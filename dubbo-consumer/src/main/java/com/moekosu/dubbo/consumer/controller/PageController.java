package com.moekosu.dubbo.consumer.controller;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxu
 * @date 2018/03
 */
public class PageController {

    /**
     * 构建返回成功的json串
     * @return
     */
    protected String returnSuccessMap(Object object)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("isSuccess", true);
        resultMap.put("data", object);
        return JSON.toJSONString(resultMap);
    }

    /**
     * 构建返回失败的json串
     * @param msg 失败信息
     * @return
     */
    protected String returnFailMap(String msg)
    {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("isSuccess", false);
        resultMap.put("errMsg", msg);
        return JSON.toJSONString(resultMap);
    }

}
