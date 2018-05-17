package edu.cqut.llj.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.exception.GirlException;
import edu.cqut.llj.mapper.WordMapper;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.vo.ThreeWordExample;
import edu.cqut.llj.vo.WordAndWordExample;
import net.sf.json.JSONArray;
import tk.mybatis.mapper.entity.Example;

@Component
public class WordDao {

//	@Autowired
//	private WordRepository wordRepository;
	@Autowired
	private WordMapper wordMapper;
	private static final Logger logger = LoggerFactory.getLogger(WordDao.class);

	/**
	 * 查询所有单词及例句
	 * @return
	 */
	public List<Word> queryWordList() {
		return wordMapper.selectAll();
//		return wordMapper.wordAndExample();
	}

	/**
	 * 更新单词
	 * @param word
	 * @return
	 */
	public Word updateWord(Word word) {
//		wordRepository.save(word);
		wordMapper.updateByPrimaryKeySelective(word);
		return word;
	}

	/**
	 * 根据word_id查询例句
	 * @param word_id
	 * @return
	 */
//	public List<WordExample> queryExampleById(Integer word_id) {
//		return wordMapper.queryExampleById(word_id);
//	}
	
	/**
	 * 根据word_id查询word
	 * @param word_id
	 * @return
	 */
	public Word queryWordById(Integer word_id){
		return wordMapper.queryWordById(word_id);
	}

	/**
	 * 添加新单词
	 * @param word
	 * @return
	 */
	public int addNewWord(Word word) {
		return wordMapper.insertSelective(word);
	}

	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Word> queryWordListPaged(Example example) {
		return wordMapper.selectByExample(example);
	}

	/**
	 * 查询wordList的总长度
	 * @return
	 */
	public Integer getWordListSize() {
		return wordMapper.getWordListSize();
	}
	
	/**
	 * 删除一个单词（非物理删除）
	 * @param word
	 * @return
	 */
	public boolean deleteWord(Word word){
		wordMapper.deleteWord(word.getWord_id());
		return true;
	}

	/**
	 * 更新例句
	 * @param wordExamples
	 * @param word_id 
	 * @return
	 */
//	public ThreeWordExample updateWordExample(String cn,String en, Integer word_id) {
//		List<WordExample> exampleList = queryExampleById(word_id);
//		for(WordExample example:exampleList){
//			wordMapper.updateWordExample(example.getId(),cn,en);
//		}
//		return null;
//	}

	/*public WordAndWordExample queryDetailById(Integer word_id) {
		return wordMapper.queryDetailById(word_id);
	}*/
	
	/**
	 * 单词列表分页
	 * @param example
	 * @return
	 */
//	public List<Word> queryWordListPaged(Example example) {
//		return wordMapper.selectByExample(example);
//	}

//	public List<WordAndWordExample> test() {
//		/*return wordMapper.wordAndExample();*/
//		return null;
//	}
}
