package edu.cqut.llj.pojo;

import javax.persistence.*;

public class Word {
    @Id
    private Integer word_id;

    private String word_describe;

    private String word_translate;

    private String wordname;

	public Integer getWord_id() {
		return word_id;
	}

	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}

	public String getWord_describe() {
		return word_describe;
	}

	public void setWord_describe(String word_describe) {
		this.word_describe = word_describe;
	}

	public String getWord_translate() {
		return word_translate;
	}

	public void setWord_translate(String word_translate) {
		this.word_translate = word_translate;
	}

	public String getWordname() {
		return wordname;
	}

	public void setWordname(String wordname) {
		this.wordname = wordname;
	}

	@Override
	public String toString() {
		return "Word [word_id=" + word_id + ", word_describe=" + word_describe + ", word_translate=" + word_translate
				+ ", wordname=" + wordname + "]";
	}

    
}