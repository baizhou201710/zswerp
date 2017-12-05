package com.zsw.framework.util;


import java.io.Closeable;
import java.io.IOException;
 

/** 
* @ClassName:IOUtil.java
* @CreateTime 2015-5-24 上午11:47:15
* @author:himo mail:zhangyao0905@gmail.com
* @Description:IO流关闭工具类
* @code IOCloseUtil.closeQuietly(FileInputStream ...);<br/>
*/ 
public class IOCloseUtil {
    /**
     * 关闭一个或多个流对象
     * @param closeables
     *            可关闭的流对象列表
     * @throws IOException
     */
    private static void close(Closeable... objects) throws IOException {
        if (objects != null) {
            for (Closeable closeable : objects) {
                if (closeable != null) {
                	closeable.close();
                }
            }
        }
    }
    
    /**
     * 关闭一个或多个流对象
     * 
     * @param closeables
     *            可关闭的流对象列表
     */
    public static void closeQuietly(Closeable... closeables) {
        try {
            close(closeables);
        } catch (IOException e) {
            // do nothing
        }
    }
    
}