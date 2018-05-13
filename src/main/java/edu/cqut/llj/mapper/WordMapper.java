package edu.cqut.llj.mapper;

import java.util.List;

import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.utils.MyMapper;
import edu.cqut.llj.vo.WordAndWordExample;

public interface WordMapper extends MyMapper<Word> {
	
	List<WordAndWordExample> test();
	
}