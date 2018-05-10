package edu.cqut.llj.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户实体类
 * @author LLJ
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	@Column(unique=true)
	private String username;
	@NotNull
	private String password;
	private Integer sex;
	@Column(unique=true)
	private String mobile;
	@Column(unique=true)
	private String eMail;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDay;
	/**
	 * 用户类型
	 * 0：超级管理员
	 * 1：管理员
	 * 2：用户
	 */
	private Integer role;
	public User() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", mobile="
				+ mobile + ", eMail=" + eMail + ", birthDay=" + birthDay + ", role=" + role + "]";
	}
}
