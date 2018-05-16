package edu.cqut.llj.utils;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.vo.Result;
import net.sf.json.JSONArray;

public class ResultUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(Object object){
		Result result = new Result();
		result.setCode(ResultEnum.SUCCESS.getCode());
		result.setMsg(ResultEnum.SUCCESS.getMsg());
		result.setData(object);
		result.setCount(0);
		return result;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(JSONArray jsonArray, Integer size){
		Result result = new Result();
		result.setCode(ResultEnum.SUCCESS.getCode());
		result.setMsg(ResultEnum.SUCCESS.getMsg());
		result.setData(jsonArray);
		result.setCount(size);
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	public static Result success(){
		return success(null);
	}
	
	@SuppressWarnings("rawtypes")
	public static Result error(Integer code,String msg){
		Result result = new Result();
		result.setCode(code);
		result.setMsg(msg);
		result.setCount(-1);
		return result;
	}
}
