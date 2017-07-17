package com.janloong.jingdg.controller.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目全局返回码
 * @author leiyupei
 * @date 2015-7-8 
 * @version
 */
public class ReturnCode {

    /**
     * 全局返回码说明
     */
    private final static Map<Integer, String> returnCodeMap = new HashMap<Integer, String>();

    static {
        returnCodeMap.put(-1, "系统繁忙，此时请开发者稍候再试");
        returnCodeMap.put(0, "请求成功");
        returnCodeMap.put(1, "信息错误，请重试或者检查填写信息");
    }

    /**
     * 返回异常信息
     * @param returnCode
     * @return
     */
    public static String getMsg(int returnCode) {
        if (returnCodeMap.containsKey(returnCode)) {
            return returnCodeMap.get(returnCode);
        }
        return "";
    }
}
