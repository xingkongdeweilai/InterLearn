package edu.cqut.llj.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 单词实体类
 * @author LLJ
 *
 */
@Entity
public class Word {
	@Id
	@GeneratedValue
	private Integer wordId;
	
	/**
	 * 单词
	 */
	@NotNull
	@Column(unique=true)
	private String wordname;
	
	/**
	 * 英文描述
	 */
	private String wordDescribe;
	
	/**
	 * 中文翻译
	 */
	private String wordTranslate;
	
	/**
	 * 英文与中文例句
	 */
	private String word_example_en1;
	private String word_example_cn1;
	private String word_example_en2;
	private String word_example_cn2;
	private String word_example_en3;
	private String word_example_cn3;

	/**
	 * 单词状态，0：可用，1：已删除
	 */
	private Integer status;
	
	public Word() {
	}

	public Integer getWordId() {
		return wordId;
	}

	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}

	public String getWordname() {
		return wordname;
	}

	public void setWordname(String wordname) {
		this.wordname = wordname;
	}

	public String getWordDescribe() {
		return wordDescribe;
	}

	public void setWordDescribe(String wordDescribe) {
		this.wordDescribe = wordDescribe;
	}

	public String getWordTranslate() {
		return wordTranslate;
	}

	public void setWordTranslate(String wordTranslate) {
		this.wordTranslate = wordTranslate;
	}

	public String getWord_example_en1() {
		return word_example_en1;
	}

	public void setWord_example_en1(String word_example_en1) {
		this.word_example_en1 = word_example_en1;
	}

	public String getWord_example_cn1() {
		return word_example_cn1;
	}

	public void setWord_example_cn1(String word_example_cn1) {
		this.word_example_cn1 = word_example_cn1;
	}

	public String getWord_example_en2() {
		return word_example_en2;
	}

	public void setWord_example_en2(String word_example_en2) {
		this.word_example_en2 = word_example_en2;
	}

	public String getWord_example_cn2() {
		return word_example_cn2;
	}

	public void setWord_example_cn2(String word_example_cn2) {
		this.word_example_cn2 = word_example_cn2;
	}

	public String getWord_example_en3() {
		return word_example_en3;
	}

	public void setWord_example_en3(String word_example_en3) {
		this.word_example_en3 = word_example_en3;
	}

	public String getWord_example_cn3() {
		return word_example_cn3;
	}

	public void setWord_example_cn3(String word_example_cn3) {
		this.word_example_cn3 = word_example_cn3;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Word [wordId=" + wordId + ", wordname=" + wordname + ", wordDescribe=" + wordDescribe
				+ ", wordTranslate=" + wordTranslate + ", word_example_en1=" + word_example_en1 + ", word_example_cn1="
				+ word_example_cn1 + ", word_example_en2=" + word_example_en2 + ", word_example_cn2=" + word_example_cn2
				+ ", word_example_en3=" + word_example_en3 + ", word_example_cn3=" + word_example_cn3 + ", status="
				+ status + "]";
	}
}
