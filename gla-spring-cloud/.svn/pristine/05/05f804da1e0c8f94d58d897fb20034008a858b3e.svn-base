package com.limp.framework.boss.exception;

import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 0:14 2018/7/9
 * @modified By:
 */
@ControllerAdvice
public class ControllerExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String errorHandler(Exception ex){

        //定义异常返回结果
        Map<String,Object > map=new HashMap<String,Object>();
        //权限 未授权异常
        if(ex instanceof UnauthorizedException){
            ex.printStackTrace();
            return Result.getException(ExceptionEnum.SysError403).getJson();
        }else{
            ex.printStackTrace();

        }
        return  Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,ex.getMessage(),"").getJson();
    }
    /**
     * 自定义异常： @ExceptionHandler(value = Exception.class) 和Exception ex 换成相应的异常类
     */
}
