package edu.cqut.llj.utils;

import java.util.Iterator;
import java.util.List;

import edu.cqut.llj.vo.WordAndWordExample;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * word专用util
 * @author LLJ
 *
 */
public class WordUtil {

	/**
	 * 处理jsonArray中重复id，将里面的例句合并到一起
	 * @param jsonObjcet
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static JSONArray getUnRe(List<WordAndWordExample> list){
		JSONArray result = new JSONArray();
		JSONObject tempJson = new JSONObject();
		//将list中的每个对象添加到tempJson中，对于例句执行不重复添加
		for(WordAndWordExample temp:list){
			JSONObject json = JSONObject.fromObject(temp);
//			tempJson.put(temp.getWord_id().toString(), temp.getWord_id());
//			tempJson.put(temp.getWord_id().toString(), temp.getWord_describe());
//			tempJson.put(temp.getWord_id().toString(), temp.getWord_translate());
//			tempJson.put(temp.getWord_id().toString(), temp.getWordname());
//			tempJson.accumulate(temp.getWord_id().toString(), temp.getWord_example_cn());
//			tempJson.accumulate(temp.getWord_id().toString(), temp.getWord_example_en());
			tempJson.accumulate(temp.getWord_id().toString(), json);
		}
		//遍历tempJson，取里面的值添加到result
		Iterator<String> it = tempJson.keys();
		while(it.hasNext()){
			String key = it.next();
			Object value = tempJson.get(key);
			result.add(value);
		}
		return result;
	}
}
