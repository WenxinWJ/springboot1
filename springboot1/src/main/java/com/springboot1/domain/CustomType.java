package com.springboot1.domain;

import java.io.Serializable;

/**
 * 自定义输出数据
 */
public class CustomType implements Serializable {
    private static final long serialVersionUID = 2641823596882462840L;
    private Integer code;       // 404
    private Object message;

    public CustomType() {
    }

    public CustomType(Integer code, Object message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
