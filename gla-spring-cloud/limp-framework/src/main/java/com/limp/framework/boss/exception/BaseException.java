package com.limp.framework.boss.exception;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 10:16 2018/5/26
 * @modified By:
 */
public class BaseException  extends Exception{
    private ExceptionEnum exceptionEnum;
    Exception exception;


    public Exception getException() {
        return exception;
    }


    public BaseException(ExceptionEnum code) {
        super(code.toString());
        this.exceptionEnum = code;
    }

    public BaseException(ExceptionEnum code, Exception exception) {
        super(code.toString());
        this.exceptionEnum = code;
        this.exception = exception;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return super.toString() +
                (exception != null ? "\r\n------------------exception----------------\r\n" + exception.toString() : "");
    }
}
