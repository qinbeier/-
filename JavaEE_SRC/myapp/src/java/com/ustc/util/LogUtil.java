package com.ustc.util;

/**
 * 调试工具类
 * @author whb
 *
 */
public class LogUtil{
	private static boolean isDebug = true;
	
	public static void logDebug(String log)
	{
		if (isDebug())
		System.out.println("log:"+log);
	}

	private static boolean isDebug() {
		return isDebug;
	}

	public static void setDebug(boolean isDebug) {
		LogUtil.isDebug = isDebug;
	}
}