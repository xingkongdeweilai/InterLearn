package edu.cqut.llj.mapper;

import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.utils.MyMapper;

public interface WordMapper extends MyMapper<Word> {

	Word queryWordById(Integer word_id);
}