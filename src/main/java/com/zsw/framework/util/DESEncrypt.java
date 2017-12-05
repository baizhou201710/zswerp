/**
 * DesCodec.java
 * Created at 2014-01-04
 * Created by wangkang
 * Copyright (C) llsfw.
 */
package com.zsw.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * <p>
 * ClassName: DesCodec
 * </p>
 * <p>
 * Description: DES加密解密
 * </p>
 * <p>
 * Author: wangkang
 * </p>
 * <p>
 * Date: 2014年1月4日
 * </p>
 */
public class DESEncrypt {
	
	
	public static void main(String[] args) throws Exception{
//		DESEncrypt des = new DESEncrypt();
		String key = DESEncrypt.initkey();
		String en = DESEncrypt.encrypt("LinkedList 中add 和 offer 的区别?查看了下源代码,发现add和offer其实实现的方法貌似是一样的,那么,为什么还要设置两个不同的名称? 它们之间的区别是", key);
		System.out.println(en);
		System.out.println(DESEncrypt.decrypt(en, key));
	}

    /**
     * <p>
     * Field log: 日志
     * </p>
     */
    private static Logger LOG = LoggerFactory.getLogger(DESEncrypt.class); // NOSONAR

    /**
     * <p>
     * Field keyAlgorithm: 算法名称
     * </p>
     */
    private static String keyAlgorithm = "DES";

    /**
     * <p>
     * Field cipherAlgorithm: 算法名称/加密模式/填充方式 <br />
     * DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
     * </p>
     */
    private static String cipherAlgorithm = "DES/ECB/PKCS5Padding";

    /**
     * <p>
     * Field keySize: 密码长度
     * </p>
     */
    private static String keySize = "56";

    /**
     * <p>
     * Field byteSize: 字节数组长度
     * </p>
     */
    private static String byteSize = "1024";

    /**
     * <p>
     * Field charSet: 字符集编码
     * </p>
     */
    private static String charSet = "UTF-8";

    /**
     * <p>
     * Description: 构造函数
     * </p>
     * 
     * @param charSet
     *            字符集编码
     */
    public DESEncrypt(String charSet) {
        charSet = charSet;
    }
    
    public DESEncrypt() {
    }

    /**
     * <p>
     * Description: 生成密钥
     * </p>
     * 
     * @return 密钥
     * @throws NoSuchAlgorithmException
     *             异常
     */
    public static String initkey() throws NoSuchAlgorithmException {
        // 实例化密钥生成器
        KeyGenerator kg = KeyGenerator.getInstance(keyAlgorithm);

        // 初始化密钥生成器
        kg.init(new Integer(keySize));

        // 生成密钥
        SecretKey secretKey = kg.generateKey();

        // 获取二进制密钥编码形式
        return Base64.encodeBase64String(secretKey.getEncoded());
    }

    /**
     * <p>
     * Description: 加密数据
     * </p>
     * 
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @return 加密后的数据
     * @throws SystemException
     */
    public static String encrypt(String data, String key)  {
        try {
            Key k = toKey(Base64.decodeBase64(key)); // 还原密钥
            Cipher cipher = Cipher.getInstance(cipherAlgorithm); // 实例化Cipher对象，它用于完成实际的加密操作
            cipher.init(Cipher.ENCRYPT_MODE, k); // 初始化Cipher对象，设置为加密模式
            
            String desStr =Base64.encodeBase64String(cipher.doFinal(data.getBytes(charSet)));
            return  Encryptor.base64Encode(desStr);// 执行加密操作。加密后的结果通常都会用Base64编码进行传输
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * <p>
     * Description: 解密数据
     * </p>
     * 
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return 解密后的数据
     * @
     */
    public static String decrypt(String data, String key)  {
    	data = Encryptor.base64Decode2Str(data);
        try {
            Key k = toKey(Base64.decodeBase64(key)); // 还原密钥
            Cipher cipher = Cipher.getInstance(cipherAlgorithm); // 实例化Cipher对象，它用于完成实际的加密操作
            cipher.init(Cipher.DECRYPT_MODE, k); // 初始化Cipher对象，设置为解密模式
            return new String(cipher.doFinal(Base64.decodeBase64(data)), charSet); // 执行解密操作
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * <p>
     * Description: 文件加密
     * </p>
     * 
     * @param file
     *            需加密的文件
     * @param destFile
     *            加密后存放的文件
     * @param key
     *            密码
     * @
     */
    public static void encryptFile(String file, String destFile, String key)  {
        BufferedInputStream is = null;
        BufferedOutputStream out = null;
        BufferedInputStream cis = null;
        try {
            // 还原密钥
            Key k = null;
            k = toKey(Base64.decodeBase64(key));

            // 实例化Cipher对象，它用于完成实际的加密操作
            Cipher cipher = null;
            cipher = Cipher.getInstance(cipherAlgorithm);

            // 初始化Cipher对象，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, k);

            // 创建输入输出流
            is = new BufferedInputStream(new FileInputStream(file), 1024); // NOSONAR
            out = new BufferedOutputStream(new FileOutputStream(destFile),1024); // NOSONAR
            cis = new BufferedInputStream(new CipherInputStream(is, cipher), 1024);

            // 开始写文件
            byte[] buffer = null;
            buffer = new byte[new Integer(byteSize)];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
        } catch (Exception s) {
            s.printStackTrace();
        } finally {
        	IOCloseUtil.closeQuietly(cis,is,out);
        }
    }

    /**
     * <p>
     * Description: 解密文件
     * </p>
     * 
     * @param file
     *            待解密的文件
     * @param destFile
     *            解密后存放的文件
     * @param key
     *            密码
     * @
     */
    public static void decryptFile(String file, String destFile, String key)  {
        BufferedInputStream is = null;
        BufferedInputStream cis = null;
        BufferedOutputStream out = null;
        try {
            // 还原密钥
            Key k = null;
            k = toKey(Base64.decodeBase64(key));

            // 实例化Cipher对象，它用于完成实际的加密操作
            Cipher cipher = null;
            cipher = Cipher.getInstance(cipherAlgorithm);

            // 初始化Cipher对象，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, k);

            // 创建输入输出流
            is = new BufferedInputStream(new FileInputStream(file), 1024); // NOSONAR
            out = new BufferedOutputStream(new FileOutputStream(destFile), 1024); // NOSONAR
            cis = new BufferedInputStream(new CipherInputStream(is, cipher), 1024);

            // 开始写文件
            byte[] buffer = null;
            buffer = new byte[new Integer(byteSize)];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	IOCloseUtil.closeQuietly(cis,is,out);
            try {
                cis.close();
                is.close();
                out.flush();
                out.close();
            } catch (Exception e) {
                LOG.error("decryptFile", e);
            }
        }
    }

    /**
     * 
     */
    /**
     * <p>
     * Description: 转换密钥
     * </p>
     * 
     * @param key
     *            密码
     * @return 秘钥
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws Exception
     *             异常
     */
    private static Key toKey(byte[] key)  {
        try {
            DESKeySpec dks = new DESKeySpec(key); // 实例化Des密钥
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(keyAlgorithm); // 实例化密钥工厂
            return keyFactory.generateSecret(dks); // 生成密钥
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
