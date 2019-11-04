package com.limp.framework.utils;

import com.limp.framework.core.bean.EncryptedType;
import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码安全工具类
 *
 * @author shinian
 */
public final class SecurityUtils {

    private static Logger log= Logger.getLogger(SecurityUtils.class);


    /**
     * 生成加密密码(打散后的)
     *
     * @param input 密码明文
     * @return 密文
     */
    public static String MD5(String input) {
        String securityString = null;
        try {
            MessageDigest digest = MessageDigest.getInstance(EncryptedType.MD5.toString());
            digest.update(input.getBytes());
            byte[] securityByte = digest.digest();
            for (int i = 1; i < securityByte.length; i += 2) {
                if (i % 2 != 0) {
                    securityByte[i] = securityByte[i >>> 1];
                }
            }
            securityString = appendSecurity(securityByte);
        } catch (Exception e) {
            log.error(e);
        }
        return securityString;
    }

    /**
     * 加密
     * @param s
     * @return
     */
    public final static String encry(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成加密密码(原生的)
     *
     * @param input 密码明文
     * @return 密文
     */
    public static String MD5Prototype(String input) {
        String securityString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptedType.MD5.toString());
            messageDigest.update(input.getBytes());
            byte securityByte[] = messageDigest.digest();
            securityString = appendSecurity(securityByte);
        } catch (NoSuchAlgorithmException e) {
            log.error(e);
        }
        return securityString.toString();
    }

    private static String appendSecurity(byte[] securityByte) {
        StringBuffer buf = new StringBuffer();
        for (int j = 0, i; j < securityByte.length; j++) {
            i = securityByte[j];
            if (i < 0){
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));

        }
        return buf.toString();
    }

    /************************************DES加密******************************************/

}
