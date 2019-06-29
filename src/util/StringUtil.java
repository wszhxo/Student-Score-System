package util;

import java.util.regex.Pattern;

public class StringUtil {
	 
	/**
	 * 判断字符串是否为空
	 */
	public static boolean isNull(String str) {
		return null == str || str.length() == 0 || "".equals(str)
				|| str.matches("\\s*");
	}
	/**
	 * 非空判断
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	
	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
  }
}
