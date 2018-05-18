package edu.cqut.llj.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 用户实体类
 * @author LLJ
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	@NotNull
	@Column(unique=true)
	private String username;
	@NotNull
	private String password;
	@JsonInclude(Include.NON_NULL)
	private Integer sex;
	@Column(unique=true)
	@NotNull
	private String mobile;
	@Column(unique=true)
	@NotNull
	private String eMail;
	@JsonInclude(Include.NON_NULL)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDay;
//	@ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
//	@JoinTable(name="word",joinColumns=@JoinColumn(name="user_id",referencedColumnName = "id"),inverseJoinColumns=@JoinColumn(name="word_id",referencedColumnName="id"))
//	private List<Word> wordList = new ArrayList<>();
	/**
	 * 用户类型
	 * 0：超级管理员
	 * 1：管理员
	 * 2：用户
	 */
	private Integer role;
	public User() {
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	
//	public List<Word> getWordList() {
//		return wordList;
//	}
//	public void setWordList(List<Word> wordList) {
//		this.wordList = wordList;
//	}
	@Override
	public String toString() {
		return "User [id=" + userId + ", username=" + username + ", password=" + password + ", sex=" + sex + ", mobile="
				+ mobile + ", eMail=" + eMail + ", birthDay=" + birthDay + ", role=" + role + "]";
	}
}
