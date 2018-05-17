package edu.cqut.llj.pojo;

import javax.persistence.*;

public class Word {
    @Id
    @Column(name = "word_id")
    private Integer word_id;

    @Column(name = "word_describe")
    private String word_describe;

    @Column(name = "word_translate")
    private String word_translate;

    @Column(name = "word_example_cn1")
    private String word_example_cn1;

    @Column(name = "word_example_cn2")
    private String word_example_cn2;

    @Column(name = "word_example_cn3")
    private String word_example_cn3;

    @Column(name = "word_example_en1")
    private String word_example_en1;

    @Column(name = "word_example_en2")
    private String word_example_en2;

    @Column(name = "word_example_en3")
    private String word_example_en3;

    private String wordname;

	public Word() {
	}
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Integer status;


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

	public String getWord_example_cn1() {
		return word_example_cn1;
	}

	public void setWord_example_cn1(String word_example_cn1) {
		this.word_example_cn1 = word_example_cn1;
	}

	public String getWord_example_cn2() {
		return word_example_cn2;
	}

	public void setWord_example_cn2(String word_example_cn2) {
		this.word_example_cn2 = word_example_cn2;
	}

	public String getWord_example_cn3() {
		return word_example_cn3;
	}

	public void setWord_example_cn3(String word_example_cn3) {
		this.word_example_cn3 = word_example_cn3;
	}

	public String getWord_example_en1() {
		return word_example_en1;
	}

	public void setWord_example_en1(String word_example_en1) {
		this.word_example_en1 = word_example_en1;
	}

	public String getWord_example_en2() {
		return word_example_en2;
	}

	public void setWord_example_en2(String word_example_en2) {
		this.word_example_en2 = word_example_en2;
	}

	public String getWord_example_en3() {
		return word_example_en3;
	}

	public void setWord_example_en3(String word_example_en3) {
		this.word_example_en3 = word_example_en3;
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
				+ ", word_example_cn1=" + word_example_cn1 + ", word_example_cn2=" + word_example_cn2
				+ ", word_example_cn3=" + word_example_cn3 + ", word_example_en1=" + word_example_en1
				+ ", word_example_en2=" + word_example_en2 + ", word_example_en3=" + word_example_en3 + ", wordname="
				+ wordname + ", status=" + status + "]";
	}

}