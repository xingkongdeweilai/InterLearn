package edu.cqut.llj.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 公共工具类
 * @author LLJ
 *
 */
public class CommonUtil {
	
	/**
	 * 获得中国当前年月日字符串，格式"yyyy-MM-dd"
	 * @return
	 */
	public static String getNow(){
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		String timeNow = new SimpleDateFormat("yyyy-MM-dd", Locale.SIMPLIFIED_CHINESE).format(calendar.getTime());
		return timeNow;
	}
}
