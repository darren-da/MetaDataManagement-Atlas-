package com.limp.framework.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RSAUtil {

    private static String algorithm = "RSA";
	/**
	 * 数据加密
	 * @param reqData
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String reqData, String publicKey) throws Exception{
		
		byte[] buffer = (new BASE64Decoder()).decodeBuffer(publicKey); //Base64.decode(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
		RSAPublicKey pck = (RSAPublicKey) keyFactory.generatePublic(keySpec);
		
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, pck);
		byte[] output = cipher.doFinal(reqData.getBytes());
		return (new BASE64Encoder()).encode(output);

	}
	
	/**
	 * 数据解密
	 * @param signStr
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String signStr, String privateKey) throws Exception {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		RSAPrivateKey prk = null;
		byte[] buffer = base64Decoder.decodeBuffer(privateKey);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		prk = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, prk);
		byte[] content = cipher.doFinal(base64Decoder.decodeBuffer(signStr));
		
		return new String(content, "UTF-8");
	}


    public static void main(String[] args) {
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
