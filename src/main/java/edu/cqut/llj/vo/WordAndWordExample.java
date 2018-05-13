package edu.cqut.llj.vo;

/**
 * Word+WordExample
 * @author Administrator
 *
 */
public class WordAndWordExample {
	
	private Integer word_id;

    private String word_describe;

    private String word_translate;

    private String wordname;
    
    private String word_example_cn;

    private String word_example_en;

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

	@Override
	public String toString() {
		return "WordAndWordExample [word_id=" + word_id + ", word_describe=" + word_describe + ", word_translate="
				+ word_translate + ", wordname=" + wordname + ", word_example_cn=" + word_example_cn
				+ ", word_example_en=" + word_example_en + "]";
	}
	
}
