package edu.cqut.llj.enums;

public enum ResultEnum {
	UNKNOWN_ERROR(98,"未知错误"),
	SUCCESS(99,"成功"),
	PRIMARY_SCHOOL(100,"你可能还在上小学"),
	MIDDLE_SCHOOL(101,"你可能还在上初中"),
	USER_REGISTER(102,"用户注册失败"),
	USER_NULL(103,"获取用户实例为空"),
	
	SUPER_ADMIN(0,"超级管理员"),
	ADMIN(1,"管理员"),
	USER(2,"用户")
	;
	
	private Integer code;
	
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
