package edu.cqut.llj.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * jackson工具类
 * @author LLJ
 *
 */
public final class JacksonUtil {  
	
	public static JsonGenerator jsonGenerator = null;
    public static ObjectMapper objectMapper;  
  
    /** 
     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。 
     * (1)转换为普通JavaBean：readValue(json,Student.class) 
     * (2)转换为List,如List<Student>,将第二个参数传递为Student 
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List 
     *  
     * @param jsonStr 
     * @param valueType 
     * @return 
     */  
    public static <T> T readValue(String jsonStr, Class<T> valueType) {  
        if (objectMapper == null) {  
            objectMapper = new ObjectMapper();  
        }  
  
        try {  
            return objectMapper.readValue(jsonStr, valueType);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }  
      
    /** 
     * json数组转List 
     * @param jsonStr 
     * @param valueTypeRef 
     * @return 
     */  
    public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef){  
        if (objectMapper == null) {  
            objectMapper = new ObjectMapper();  
        }  
  
        try {  
            return objectMapper.readValue(jsonStr, valueTypeRef);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }  
  
    /** 
     * 把JavaBean转换为json字符串 
     *  
     * @param object 
     * @return 
     */  
    public static String toJSonString(Object object) {  
        if (objectMapper == null) {  
            objectMapper = new ObjectMapper();  
        }  
  
        try {  
            return objectMapper.writeValueAsString(object);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return null;  
    }
    
    /**
     * java对象转json
     * @param object
     * @return
     * @throws IOException 
     */
    public static Object toJSon(Object object) throws IOException {  
    	objectMapper.writeValue(System.out, object);
    	System.out.println();
    	return object;
    }
}