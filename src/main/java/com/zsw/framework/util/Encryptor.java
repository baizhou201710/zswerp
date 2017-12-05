package com.zsw.framework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import com.zsw.util.Empty;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/** 
 * 编码工具类 
 * 1.将byte[]转为各种进制的字符串 
 * 2.base 64 encode 
 * 3.base 64 decode 
 * 4.获取byte[]的md5值 
 * 5.获取字符串md5值 
 * 6.结合base64实现md5加密 
 * 7.AES加密 
 * 8.AES加密为base 64 code 
 * 9.AES解密 
 * 10.将base 64 code AES解密 
 * @author uikoo9 
 * @version 0.0.7.20140601 
 */  
public class Encryptor {
	private Encryptor() {
	}

	// Md5加密
	public static String md5(String s) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return bytes2Hex(md5.digest(s.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;

		}
	}

	/**
	 * 字节串转十六进制（Hex）
	 * */
	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
	

	/**
	 * 将字符串加密为MD5后在进行base64加密
	 * */
	public static String md5Base64(String str) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			return base64Encode(new String(md5.digest(str.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** 
     * base 64 编码 
     * @param bytes 待编码的byte[] 
     * @return 编码后的base 64 code 
     */  
    public static String base64Encode(byte[] bytes){  
        return new BASE64Encoder().encode(bytes);  
    }  
    
	/**
	 * base64加密
	 * */
	public static String base64Encode(String str) {
		if (str == null) {
			return null;
		} else {
			BASE64Encoder encode = new BASE64Encoder();
			return encode.encode(str.getBytes());
		}
	}

	/** 
     * base 64 解码 
     * @param base64Code 待解码的base 64 code 
     * @return 解码后的byte[] 
     * @throws Exception 
     */  
    public static byte[] base64Decode2Byets(String base64Code) throws Exception{  
        return Empty.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);  
    }  
    
	/**
	 * base64解码
	 * */
	public static String base64Decode2Str(String str) {
		if (str == null) {
			return null;
		}
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			return new String(decoder.decodeBuffer(str));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/** 
     * AES加密 
     * @param content 待加密的内容 
     * @param encryptKey 加密密钥 
     * @return 加密后的byte[] 
     * @throws Exception 
     */  
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));  
  
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));  
          
        return cipher.doFinal(content.getBytes("utf-8"));  
    }  
      
    
    /** 
     * AES加密为base 64 code 
     * @param content 待加密的内容 
     * @param encryptKey 加密密钥 
     * @return 加密后的base 64 code 
     * @throws Exception 
     */  
    public static String aesEncrypt(String content, String encryptKey) throws Exception { 
        return base64Encode(aesEncryptToBytes(content, encryptKey));  
    }  
      
    /** 
     * AES解密 
     * @param encryptBytes 待解密的byte[] 
     * @param decryptKey 解密密钥 
     * @return 解密后的String 
     * @throws Exception 
     */  
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));  
          
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));  
        byte[] decryptBytes = cipher.doFinal(encryptBytes);  
          
        return new String(decryptBytes);  
    }  
      
    /** 
     * 将base 64 code AES解密 
     * @param encryptStr 待解密的base 64 code 
     * @param decryptKey 解密密钥 
     * @return 解密后的string 
     * @throws Exception 
     */  
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception { 
    	String decrypt = Empty.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode2Byets(encryptStr), decryptKey);
        return decrypt;
    } 
    
    /**
     * 判断字符串是否有被base64加密过
     * @return  true|false
     * */
    public static boolean isBase64Encode(String str){
    	String temp = base64Decode2Str(str);
    	String encode2 = base64Encode(temp);
    	if(encode2.equals(str)){
    		return true;
    	}else{
    		return false;
    	}
    }
    
	public static void main(String[] args) throws Exception {
		System.out.println(isBase64Encode(("ningcy03")));
//		String s1 = md5("wpsadmin");
//		String menuids = "DES-Data Encryption Standard";
//		   String key = "123456";  
//		   
//		   System.out.println("base64Encode : "+base64Encode("ningcy03"));
//		   System.out.println("base64Decode : "+base64Decode2Str(base64Encode(key)));
//		   
//	        System.out.println("加密密钥和解密密钥：" + key);  
//	          
//	        String encrypt = aesEncrypt(menuids, key);  
//	        System.out.println("加密后：" + encrypt);  
//	          
//	        String decrypt = aesDecrypt(encrypt, key);  
//	        System.out.println("解密后：" + decrypt);  
	        
//		String s1 = StringUtils.hexEncode(menuids.getBytes());
//		System.out.println(s1.length() + "\n" + s1);
//		s1= String.valueOf(StringUtils.hexDecode(s1));
//		System.out.println(s1.length() + "\n" + s1);
	}
}
