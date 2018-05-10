package edu.cqut.llj.utils;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.vo.Result;

public class ResultUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Result success(Object object){
		Result result = new Result();
		result.setCode(ResultEnum.SUCCESS.getCode());
		result.setMsg(ResultEnum.SUCCESS.getMsg());
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
