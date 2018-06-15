package edu.cqut.llj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.pojo.WordAndUser;
import edu.cqut.llj.utils.MyMapper;

public interface WordMapper extends MyMapper<Word> {

	Word queryWordById(Integer word_id);

	Integer getWordListSize();

	void deleteWord(Integer word_id);

	List<Word> queryLearningWord(@Param("user_id") Integer user_id,@Param("limit") Integer limit);

	List<Word> queryNewWord(@Param("limit") Integer limit);

	WordAndUser queryRelation(@Param("user_id") Integer user_id, @Param("word_id") Integer word_id);

	List<Word> queryMyWord(@Param("page") Integer page,@Param("limit") Integer limit, @Param("user_id") Integer user_id);

	List<Word> queryNotebook(@Param("page") Integer page,@Param("limit") Integer limit, @Param("user_id") Integer user_id);
}