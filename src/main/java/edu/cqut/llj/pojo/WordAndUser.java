package edu.cqut.llj.pojo;

import javax.persistence.*;

@Table(name = "word_and_user")
public class WordAndUser {
    @Id
    private Integer id;

    private Integer relationship;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "word_id")
    private Integer word_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRelationship() {
		return relationship;
	}

	public void setRelationship(Integer relationship) {
		this.relationship = relationship;
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

	@Override
	public String toString() {
		return "WordAndUser [id=" + id + ", relationship=" + relationship + ", user_id=" + user_id + ", word_id="
				+ word_id + "]";
	}

   
}