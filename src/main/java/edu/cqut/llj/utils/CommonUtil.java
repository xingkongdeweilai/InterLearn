package edu.cqut.llj.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import redis.clients.jedis.Jedis;

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
	
	/**
	 * Date转String,格式"yyyy-MM-dd HH:mm:ss"
	 * @param date
	 * @return 
	 */
	public static String DateToString(Date date){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dateString = formatter.format(date);
		 return dateString;
	}
	
	/**
	 * 获得中国地区当前时间
	 * @return
	 */
	public static Date getNowD(){
		Calendar calendar = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		return calendar.getTime();
	}
	
	/**
	 * 获得jedis对象
	 * @return
	 */
	public final static Jedis getJedis(){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		return jedis;
	}
	
	/**
	 * 序列化
	 * @param obj
	 * @return
	 */
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 反序列化
     * @param byt
     * @return
     */
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return null;
    }
}
