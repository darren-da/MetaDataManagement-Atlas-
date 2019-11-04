
package com.gla.datacenter.zuul.controller;

import com.limp.framework.core.bean.Result;
import com.limp.framework.core.constant.ExceptionEnum;
//import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 统一处理zull错误请求
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/15 16:46
 */

@RestController
public class ErrorHandlerController implements ErrorController {
/**
     * 出异常后进入该方法，交由下面的方法处理
     */

    @Override
    public String getErrorPath() {
        return "/error";
    }
    @RequestMapping("/error")
    public String error(){
        return Result.getException(ExceptionEnum.SysErrorUnexpected).getJson();
    }
}

