package com.zsw.util;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 17:45
 */
public class Empty {
    /**
     * 判断字符串是否为空或者为null 是返回"0"
     *
     * @param str
     * @return
     */
    public static String isEmpty_2(String str) {
        if ( str == null || str.equals("") ) {
            return "0.0000";
        }
        return str;

    }


    /**
     * 判断字符串是否为空或者为null 是返回"";
     * @param str
     * @return
     */
    public static String isEmpty_1(String str) {
        if ( str == null || str.equals("") ) {
            return "";
        }
        return str;

    }

    /**
     * 判断字符串是否为空，长度为0被认为是空字符串.
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串是否为空，长度为0被认为是空字符串.
     *
     * @param str
     * @return
     */
    public static boolean isEmpty_3(String str) {
        return str == null || str.length() == 0 || "null".equals(str);
    }

    /**
     * 判断字符串是否为空或者为null 是返回"";
     * @return
     */
    public static boolean isEmpty(Object ob) {
        return ob == null;

    }
    /**
     * 判断字符串是否为空，字符串前后空白被截断，截断后长度为0被认为是空字符串.
     *
     * @param str
     * @param isTrimed
     *            是否截去空白
     * @return
     */
    public static boolean isEmpty(String str, boolean isTrimed) {
        if(isTrimed)
            return str == null || str.trim().length() == 0;
        return isEmpty(str);
    }

    /**
     * 判断列表是否为空，列表没有元素也被认为是空
     *
     * @param
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isEmpty(java.util.Collection collection) {
        return collection == null || collection.size() == 0;
    }

    /**
     * 判断数组是否为空
     * @param array
     * @return
     */
    public static boolean isEmpty(Object [] array){
        return array == null || array.length == 0;
    }

    /**
     * 判断字符串是否为空或者为null 是返回"";
     * @param
     * @return
     */
    public static boolean isNotEmpty(Object ob) {
        if(ob instanceof String){
            return !isEmpty((String)ob);
        }else if(ob instanceof Object[]){
            return !isEmpty((Object[])ob);
        }else if(ob instanceof java.util.Collection<?>){
            return !isEmpty((java.util.Collection<?>)ob);
        }else {
            return !isEmpty(ob);
        }

    }
}
