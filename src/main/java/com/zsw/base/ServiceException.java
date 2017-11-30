package com.zsw.base;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 17:15
 */
public class ServiceException extends Exception{


    /**
     *
     */
    public ServiceException() {
        super();
    }

    /**
     * @param arg0
     */
    public ServiceException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public ServiceException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public ServiceException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
