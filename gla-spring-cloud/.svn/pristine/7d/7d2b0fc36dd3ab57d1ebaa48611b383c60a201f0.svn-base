package com.limp.framework.boss.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 0:17 2018/7/9
 * @modified By:
 */
public class BusException extends  RuntimeException {
    private  String code;
    private  String msg;

    public BusException(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
