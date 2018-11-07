package com.pfinfo.util;

import java.util.UUID;

/**
 * 
 * @author pys1714
 *
 */
public class StringUtil {
	
	/**
	 * 系统生成uuid
	 */
	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	
	/**
	 * 把字符串的首字母小写
	 * 
	 * @param name
	 * @return
	 */
	public static String toLowerFirstWord(String name) {
		char[] charArray = name.toCharArray();
		charArray[0] += 32;
		return String.valueOf(charArray);
	}

}
