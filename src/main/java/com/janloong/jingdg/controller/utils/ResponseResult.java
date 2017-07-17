package com.janloong.jingdg.controller.utils;

/**
 * <p>Description: [controller返回 json对象模型]</p>
 * Created on 2016年11月27日
 * @author  <a href="mailto: lxmh2012@163.com">cd</a>
 * @version 1.0
 */
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public ResponseResult(){

    }
    public ResponseResult(int code, String message){
        this.code = code;
        this.message = message;
    }
    public ResponseResult(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
