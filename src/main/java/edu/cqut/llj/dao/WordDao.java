package edu.cqut.llj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.cqut.llj.mapper.WordMapper;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.vo.WordAndWordExample;
import tk.mybatis.mapper.entity.Example;

@Component
public class WordDao {

//	@Autowired
//	private WordRepository wordRepository;
	@Autowired
	private WordMapper wordMapper;

	/**
	 * 查询所有单词
	 * @return
	 */
	public List<Word> queryWordList() {
		/*return wordRepository.findAll();*/
		return wordMapper.selectAll();
	}

	/**
	 * 更新单词
	 * @param word
	 * @return
	 */
	public boolean updateWord(Word word) {
//		wordRepository.save(word);
		wordMapper.updateByPrimaryKeySelective(word);
		return true;
	}

	/**
	 * 单词列表分页
	 * @param example
	 * @return
	 */
	public List<Word> queryWordListPaged(Example example) {
		return wordMapper.selectByExample(example);
	}

	public List<WordAndWordExample> test() {
		return wordMapper.test();
	}
}
