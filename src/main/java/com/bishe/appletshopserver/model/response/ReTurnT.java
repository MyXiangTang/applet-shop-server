package com.bishe.appletshopserver.model.response;

import java.io.Serializable;

/**
 * @Author
 * @Description 响应实体
 * @Date 2019/5/5
 * @Modify
 */
public class ReTurnT<T> implements Serializable {
    private int code;
    private String msg;
    private T content;

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    public static final ReTurnT<String> SUCCESS = new ReTurnT<>(SUCCESS_CODE,"SUCCESS");
    public static final ReTurnT FAIL = new ReTurnT<>(FAIL_CODE,"FAIL");

    public ReTurnT() {
    }

    public ReTurnT(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ReTurnT(int code, String msg, T content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public ReTurnT(T content) {
        this.code = SUCCESS_CODE;
        this.content = content;
        this.msg = "SUCCESS！";
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReTurnT{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}