package edu.cqut.llj.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import edu.cqut.llj.dao.WordDao;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.pojo.WordExample;
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
	 * 对于一个单词有多个例句的情况，进行去重检测
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
	
	public JSONArray queryExampleById(Integer word_id) {
		List<WordExample> list = wordDao.queryExampleById(word_id);
		JSONArray wordJson = JSONArray.fromObject(list);
		return wordJson;
	}

	public JSONObject queryWordById(Integer word_id){
		Word word = wordDao.queryWordById(word_id);
		return JSONObject.fromObject(word);
	}

	public ThreeWordExample updateWordExample(ThreeWordExample wordExamples, Integer word_id) {
		return wordDao.updateWordExample(wordExamples, word_id);
	}
	
	/*public WordAndWordExample queryDetailById(Integer word_id) {
		return wordDao.queryDetailById(word_id);
	}*/

	
	
	
	public List<Word> queryWordListPaged(Word word, Integer page, Integer pageSize) {
		//开始分页
		PageHelper.startPage(page,pageSize);
		
		Example example = new Example(Word.class);
//		Example.Criteria criteria = example.createCriteria();
		
//		if (!StringUtils.isEmptyOrWhitespace(word.getWordname())) {
//			criteria.andLike("nickname", "%" + word.getWordname() + "%");
//		}
//		example.orderBy("registTime").desc();
		
		return wordDao.queryWordListPaged(example);
	}

	public List<WordAndWordExample> test() {
		return wordDao.test();
	}

}
