package edu.cqut.llj.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import edu.cqut.llj.dao.WordDao;
import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.exception.GirlException;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.vo.ThreeWordExample;
import edu.cqut.llj.vo.WordAndWordExample;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tk.mybatis.mapper.entity.Example;

@Service
public class WordService {
	
	@Autowired
	private WordDao wordDao;
	private static final Logger logger = LoggerFactory.getLogger(WordService.class);

	/**
	 * 查询所有单词及例句
	 * @return
	 */
	public JSONArray queryWordList() {
		List<Word> list = wordDao.queryWordList();
		JSONArray wordJson = JSONArray.fromObject(list);
		logger.info(wordJson.toString());
		return wordJson;
	}

	public Word updateWord(Word word) {
		return wordDao.updateWord(word);
	}
	
//	public JSONArray queryExampleById(Integer word_id) {
//		List<WordExample> list = wordDao.queryExampleById(word_id);
//		JSONArray wordJson = JSONArray.fromObject(list);
//		return wordJson;
//	}

	public JSONObject queryWordById(Integer word_id){
		Word word = wordDao.queryWordById(word_id);
		return JSONObject.fromObject(word);
	}

	public int addNewWord(Word word) {
		//去掉wordname两端空白
		word.setWordname(word.getWordname().trim());
		if("".equals(word.getWordname())){
			throw new GirlException(ResultEnum.ADD_WORDNAME_NULL);
		}
		return wordDao.addNewWord(word);
	}

	/**
	 * 分页查询单词
	 * @param word 
	 * @param page
	 * @param limit
	 * @return
	 */
	public JSONArray queryWordListPaged(Word word, Integer page, Integer limit) {
		PageHelper.startPage(page,limit);
		Example example = new Example(Word.class);
		example.orderBy("wordname").asc();
		List<Word> list = wordDao.queryWordListPaged(example);
		return JSONArray.fromObject(list);
	}

	/**
	 * 查询wordList的总长度
	 * @return
	 */
	public Integer getWordListSize() {
		return wordDao.getWordListSize();
	}

//	public ThreeWordExample updateWordExample(String cn,String en, Integer word_id) {
//		return wordDao.updateWordExample(cn,en, word_id);
//	}
	
	/*public WordAndWordExample queryDetailById(Integer word_id) {
		return wordDao.queryDetailById(word_id);
	}*/

	
	
	
//	public List<Word> queryWordListPaged(Word word, Integer page, Integer pageSize) {
//		//开始分页
//		PageHelper.startPage(page,pageSize);
//		
//		Example example = new Example(Word.class);
////		Example.Criteria criteria = example.createCriteria();
//		
////		if (!StringUtils.isEmptyOrWhitespace(word.getWordname())) {
////			criteria.andLike("nickname", "%" + word.getWordname() + "%");
////		}
////		example.orderBy("registTime").desc();
//		
//		return wordDao.queryWordListPaged(example);
//	}

//	public List<WordAndWordExample> test() {
//		return wordDao.test();
//	}

}
