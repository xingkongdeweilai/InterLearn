package edu.cqut.llj.vo;

/**
 * http请求返回的最外层对象
 * @author Administrator
 *
 */
public class Result<T> {
	
	//错误码
	private Integer code;
	//提示信息
	private String msg;
	private Integer count;
	//具体的内容
	private T data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
}
