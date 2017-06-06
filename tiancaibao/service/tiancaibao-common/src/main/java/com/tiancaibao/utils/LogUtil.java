package com.tiancaibao.utils;


import org.apache.log4j.Logger;

/**
 * @author macq
 * 
 */
public class LogUtil {
	
	//pc端日志
	public static Logger pcLogger = Logger.getLogger("pc.Log");
	//wechat端日志
    public static Logger wechatLogger = Logger.getLogger("wechat.Log");
    //android端日志
    public static Logger androidLogger = Logger.getLogger("android.Log");	
    //ios
    public static Logger iosLogger = Logger.getLogger("ios.Log");	
	//exception
	public static Logger serviceExceptionLogger = Logger.getLogger("serviceexception.log");
	
	
	/**
	 * author Mack
	 * @explain：封装exception日志
	 * @param log
	 * @return void
	 */
	public static void serviceException(String log) {
		serviceExceptionLogger.error(log);
	}
	/**
	 * pc操作日志
	 * @param string
	 */
	public static void pcLogger(String string) {
		pcLogger.error(string);
	}
	/**
	 * wechat端操作日志
	 * @param string
	 */
	public static void wechatLogger(String string) {
		wechatLogger.error(string);
	}
	/**
	 * android端日志
	 * @param string
	 */
	public static void androidLogger(String string) {
		androidLogger.error(string);
	}
	/**
	 * ios
	 * @param string
	 */
	public static void iosLogger(String string) {
		iosLogger.error(string);
	}
}
