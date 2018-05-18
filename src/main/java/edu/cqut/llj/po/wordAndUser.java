package edu.cqut.llj.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class wordAndUser {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer user_id;
	private Integer word_id;
	/**
	 * 用户与单词的熟悉程度，取值范围0-3
	 * 0：刚认识，3：完全认识
	 */
	private Integer relationship;
	public wordAndUser() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getWord_id() {
		return word_id;
	}
	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}
	public Integer getRelationship() {
		return relationship;
	}
	public void setRelationship(Integer relationship) {
		this.relationship = relationship;
	}
	@Override
	public String toString() {
		return "wordAndUser [id=" + id + ", user_id=" + user_id + ", word_id=" + word_id + ", relationship="
				+ relationship + "]";
	}
}
