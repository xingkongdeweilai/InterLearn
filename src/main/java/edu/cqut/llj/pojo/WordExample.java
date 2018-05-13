package edu.cqut.llj.pojo;

import javax.persistence.*;

@Table(name = "word_example")
public class WordExample {
    @Id
    private Integer id;

    @Column(name = "word_example_cn")
    private String word_example_cn;

    @Column(name = "word_example_en")
    private String word_example_en;

    @Column(name = "word_id")
    private Integer word_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord_example_cn() {
		return word_example_cn;
	}

	public void setWord_example_cn(String word_example_cn) {
		this.word_example_cn = word_example_cn;
	}

	public String getWord_example_en() {
		return word_example_en;
	}

	public void setWord_example_en(String word_example_en) {
		this.word_example_en = word_example_en;
	}

	public Integer getWord_id() {
		return word_id;
	}

	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}

	@Override
	public String toString() {
		return "WordExample [id=" + id + ", word_example_cn=" + word_example_cn + ", word_example_en=" + word_example_en
				+ ", word_id=" + word_id + "]";
	}
    
    
}