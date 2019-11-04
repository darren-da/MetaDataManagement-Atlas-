package com.gla.datacenter.consumer.filter;

import com.limp.framework.core.bean.Result;
import com.limp.framework.core.constant.ExceptionEnum;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 消费者统一以处理异常类
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/15 20:19
 */

@ControllerAdvice
public class AdminExceptionHandler {
    Logger logger= LoggerFactory.getLogger(AdminExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handConsumerError(Exception ex)
    {
        //处理feigin异常信息
        if(ex  instanceof FeignException){
            ex.printStackTrace();
            //token异常
            if(401==((FeignException) ex).status()){
                return Result.getException(ExceptionEnum.AuthorityTokenError).getJson();
            }
            logger.error(ex.getMessage());
            return Result.getException("FeignException["+ex.getMessage()+"]").getJson();

        }
        System.out.println("异常处理类");
        //logic
        System.out.println("AdminExceptionHandler");
        return Result.getException(ex.getMessage()).getJson();
    }

}
