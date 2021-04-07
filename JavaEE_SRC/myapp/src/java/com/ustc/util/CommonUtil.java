package com.ustc.util;

import java.io.UnsupportedEncodingException;

/**
 * DOCUMENT ME!
 *
 * @author <a href="mailto:roy.wang123@gmail.com">Roy Wang</a>
 * @version 1.0
 */
public final class CommonUtil {
    /**
     * Creates a new CommonUtil object.
     */
    private CommonUtil() {
    }
    /**
     * @param value
     * @return
     */
    //统一处理NullPoint保护的
    public static String fixNull(String value) {
        if (value == null) {
            return "";
        } else {
            return value;
        }
    }
    //写这个函数来统一处理本地化的
    public static String getLocalString(String value) {
        if (value == null || "".equals(value)) {
            return "";
        } else {
        	try {
				byte byval[] = value.getBytes("ISO-8859-1");
				return new String(byval,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}            
        }
        return value;
    }
   
}