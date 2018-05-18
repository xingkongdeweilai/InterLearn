package edu.cqut.llj.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="word")
@PropertySource(value="classpath:myConfig.properties")
public class WordProperties {
	/**
	 * 每日学习单词数
	 */
	private String everyWord;

	public WordProperties() {
		super();
	}

	public String getEveryWord() {
		return everyWord;
	}

	public void setEveryWord(String everyWord) {
		this.everyWord = everyWord;
	}
}
