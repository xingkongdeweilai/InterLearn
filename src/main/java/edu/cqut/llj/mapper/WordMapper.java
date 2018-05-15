package edu.cqut.llj.mapper;

import java.util.List;

import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.pojo.WordExample;
import edu.cqut.llj.utils.MyMapper;
import edu.cqut.llj.vo.ThreeWordExample;
import edu.cqut.llj.vo.WordAndWordExample;

public interface WordMapper extends MyMapper<Word> {
	
	List<WordAndWordExample> wordAndExample();

	List<WordExample> queryExampleById(Integer word_id);

	/*WordAndWordExample queryDetailById(Integer word_id);*/
	
	Word queryWordById(Integer word_id);

	void updateWordExample(ThreeWordExample wordExamples, Integer word_id);
}