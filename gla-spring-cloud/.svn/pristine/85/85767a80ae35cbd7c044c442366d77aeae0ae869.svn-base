package com.gla.datacenter.consumer.filter;

import com.limp.framework.core.exception.PrivilegeException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/15 20:15
 */
public class ConsumerErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response)
    {
        System.out.println(methodKey);
        Exception exception=null;
        try
        {
            String json = Util.toString(response.body().asReader());
//            exception= JsonUtils.json2Object(json,TmallBaseException.class);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return exception!=null?exception:new PrivilegeException("系统运行异常");
    }

}
