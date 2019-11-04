package com.limp.framework.core.annotation;

import com.limp.framework.core.constant.OPERATION;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 18-10-16
 * Time: 下午11:02
 * 控制登录 和 权限
 * To change this template use File | Settings | File Templates.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface Access {
    /**
     * 访问action是否需要登录  true  or false
     * @return
     */
    boolean login() default false;


    /**
     * 是否需要权限 true or false
     * @return
     */
    boolean privilege() default false;

    /**
     * 是否 记录 操作日志  FALSE,SELECT,INSERT,UPDATE,DELETE
     * @return
     */

    OPERATION operationLog() default OPERATION.FALSE;

    /**
     * 日志详情
     * @return
     */
    String operationIntro() default "";

}
