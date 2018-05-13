package edu.cqut.llj.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 单词例句实体类
 * @author LLJ
 *
 */
@Entity
public class WordExample {
	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * 单词例句英文
	 */
	@NotNull
	private String wordExampleEn;
	
	/**
	 * 单词例句中文
	 */
	@NotNull
	private String wordExampleCn;
	
	/**
	 * 外键wordId
	 */
	private Integer wordId;

	public WordExample() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.MERGE},optional=false)
	@JoinColumn(name="word_example_ibfk_1")
	public Integer getWordId() {
		return wordId;
	}

	public void setWordId(Integer wordId) {
		this.wordId = wordId;
	}

	public String getWordExampleEn() {
		return wordExampleEn;
	}

	public void setWordExampleEn(String wordExampleEn) {
		this.wordExampleEn = wordExampleEn;
	}

	public String getWordExampleCn() {
		return wordExampleCn;
	}

	public void setWordExampleCn(String wordExampleCn) {
		this.wordExampleCn = wordExampleCn;
	}

	@Override
	public String toString() {
		return "WordExample [id=" + id + ", wordExampleEn=" + wordExampleEn + ", wordExampleCn=" + wordExampleCn
				+ ", wordId=" + wordId + "]";
	}
	
}
