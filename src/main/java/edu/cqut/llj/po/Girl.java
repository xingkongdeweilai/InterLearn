package edu.cqut.llj.po;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import edu.cqut.llj.utils.JacksonUtil;




@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer id;
	private String cupSize;
	@Min(value=18,message="未成年少女禁止入门")
	private Integer age;
	@NotNull(message="金额必填")
	private Integer money;
	public Girl() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Girl [id=" + id + ", cupSize=" + cupSize + ", age=" + age + "]";
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	public static void main(String[] args) throws IOException {
		Girl girl = new Girl();
		girl.setAge(12);
		girl.setMoney(20);
		Object obj = JacksonUtil.toJSonString(girl);
		System.out.println(obj);
	}
}
