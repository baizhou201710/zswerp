package com.zsw.base;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 17:33
 */
public class DaoException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public DaoException() {

    }

    /**
     * @param arg0
     */
    public DaoException(String arg0) {
        super(arg0);

    }

    /**
     * @param arg0
     */
    public DaoException(Throwable arg0) {
        super(arg0);

    }

    /**
     * @param arg0
     * @param arg1
     */
    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);

    }
}
