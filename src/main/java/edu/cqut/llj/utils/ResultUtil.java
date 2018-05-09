package edu.cqut.llj.utils;

import edu.cqut.llj.vo.Result;

public class ResultUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(Object object){
		Result result = new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(object);
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
		return result;
	}
}
