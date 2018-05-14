package com.jst.utils;


/**
 * 甯搁噺
 * @author Chunji Li
 */
public class CommonConstants {

	public static String propertyFile = "project";
	public static PropertyUtil propertyUtil = PropertyUtil.getInstance(propertyFile);
	public static String contextPath = propertyUtil.getProperty("contextPath");
	public static String staticServer = propertyUtil.getProperty("contextPath");
	public static String uploadImageServer = propertyUtil.getProperty("contextPath");
	public static String staticImage = propertyUtil.getProperty("contextPath");
	public static String projectName = propertyUtil.getProperty("projectName");
	public static final String MYDOMAIN = propertyUtil.getProperty("mydomain");

	/** 閭姝ｅ垯琛ㄨ揪寮� */
	public static String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	/** 鐢佃瘽鍙风爜姝ｅ垯琛ㄨ揪寮� */
	public static String telRegex = "^1[0-9]{10}$";
	/** 鍚庡彴鐢ㄦ埛鐧诲綍鍚嶆鍒欒〃杈惧紡 */
	public static String loginRegex = "^(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$";
	/** 鍥剧墖楠岃瘉鐮丼ession鐨凨 */
	public static final String RAND_CODE = "COMMON_RAND_CODE";
}
