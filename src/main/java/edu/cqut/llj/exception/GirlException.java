package edu.cqut.llj.exception;

import edu.cqut.llj.enums.ResultEnum;

public class GirlException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	public GirlException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}
