package com.limp.framework.utils;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-1-31
 * Time: 上午12:56
 * To change this template use File | Settings | File Templates.
 */


import org.apache.log4j.Logger;

/**
 * 扩展工具类入口
 */
public class ExpUtils {

    private static Logger log= Logger.getLogger(ExpUtils.class);


    /**
     * 二维码：功能
     * @param content 二维码上内容
     * @param path 二维码生成路径
     * @return 二维码生成路径
     */
    public static String getQRCode(String content,String path){
        try {
            //QRCodeEncoder.create_image(content,path);
            log.debug("-----二维码生成成功,路径如下-----");
            log.debug("-----"+path+"----");
        } catch (Exception e) {
            return  null;
        }
        return  path;
    }
}
