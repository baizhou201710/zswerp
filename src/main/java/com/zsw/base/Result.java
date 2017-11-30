package com.zsw.base;

import java.io.Serializable;

/**
 * 请求返回结果
 *
 * @author baizhou
 * @create 2017-11-20 16:12
 */
public class Result implements Serializable{

    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private Object content;

    public Result() {
    }

    public Result(String code, String msg, String content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
