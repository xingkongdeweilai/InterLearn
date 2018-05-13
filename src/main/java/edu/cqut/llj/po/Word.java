package edu.cqut.llj.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@NotNull
	private String wordDescribe;
	
	/**
	 * 中文翻译
	 */
	@NotNull
	private String wordTranslate;

	public Word() {
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="wordId")
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

	@Override
	public String toString() {
		return "Word [wordId=" + wordId + ", wordname=" + wordname +  ", wordDescribe="
				+ wordDescribe + ", wordTranslate=" + wordTranslate + "]";
	}


}
