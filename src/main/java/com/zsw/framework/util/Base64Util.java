package com.zsw.framework.util;

import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
	private static BASE64Encoder encoder = new sun.misc.BASE64Encoder();

    private static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public Base64Util() {
    }
    //加密函数
    public static String encode(String s) {
        return encoder.encode(s.getBytes());
    }
    
    //解密函数
    public static String decode(String s) {
        try {
            byte[] temp = decoder.decodeBuffer(s);
            return new String(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
       
    }
}
