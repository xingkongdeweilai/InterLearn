package edu.cqut.llj.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.cqut.llj.mapper.WordAndUserMapper;
import edu.cqut.llj.mapper.WordMapper;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.pojo.WordAndUser;
import tk.mybatis.mapper.entity.Example;

@Component
public class WordDao {

//	@Autowired
//	private WordRepository wordRepository;
	@Autowired
	private WordMapper wordMapper;
	@Autowired
	private WordAndUserMapper wordAndUserMapper;
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
	 * 方案1：在word_and_user查询1/2，查询条件：relation<3，即正在学习中的词
	 * @param user_id
	 * @param i
	 * @return
	 */
	public List<Word> queryLearningWord(Integer user_id, Integer limit) {
		List<Word> result = wordMapper.queryLearningWord(user_id,limit);
		logger.info(result.toString());
		return result;
	}

	/**
	 * 方案2：在word中查询，查询量补齐
	 * @param user_id
	 * @param i
	 * @return
	 */
	public List<Word> queryNewWord(Integer limit) {
		List<Word> result = wordMapper.queryNewWord(limit);
		logger.info(result.toString());
		return result;
	}

	/**
	 * 查询用户与单词关系
	 * @param user_id
	 * @param word_id
	 * @return
	 */
	public WordAndUser queryRelation(Integer user_id, Integer word_id) {
		return wordMapper.queryRelation(user_id,word_id);
	}

	/**
	 * 中间表增加联系
	 * @param user_id
	 * @param word_id
	 */
	public boolean addRelation(WordAndUser wu) {
		wordAndUserMapper.insert(wu);
		return true;
	}

	/**
	 * 中间表relationship+1
	 * @param wu
	 */
	public boolean updateWordUserRelation(WordAndUser wu) {
		wordAndUserMapper.updateByPrimaryKey(wu);
		return true;
	}
	
	/**
	 * 用户查询已学会单词
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Word> queryMyWord(Integer page, Integer limit, Integer user_id){
		return wordMapper.queryMyWord((page-1)*limit,limit,user_id);
	}

	/**
	 * 用户查询生词
	 * @param page
	 * @param limit
	 * @param user_id
	 * @return
	 */
	public List<Word> queryNotebook(Integer page, Integer limit, Integer user_id) {
		return wordMapper.queryNotebook((page-1)*limit,limit,user_id);
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
