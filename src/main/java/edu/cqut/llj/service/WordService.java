package edu.cqut.llj.service;

import java.util.ArrayList;
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
import edu.cqut.llj.pojo.WordAndUser;
import edu.cqut.llj.properties.WordProperties;
import edu.cqut.llj.utils.CommonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tk.mybatis.mapper.entity.Example;

@Service
public class WordService {
	
	@Autowired
	private WordDao wordDao;
	@Autowired
	private WordProperties wordProperties;
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
		int result = 0;
		//去掉wordname两端空白
		word.setWordname(word.getWordname().trim());
		if("".equals(word.getWordname())){
			throw new GirlException(ResultEnum.ADD_WORDNAME_NULL);
		}
		try{
			result = wordDao.addNewWord(word);
		}catch(Exception e){
			throw new GirlException(ResultEnum.ADD_WORD_ERROR);
		}
		return result;
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
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("status", 0);
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
	
	/**
	 * 删除一个单词
	 * @param word
	 * @return
	 */
	public boolean deleteWord(Word word){
		return wordDao.deleteWord(word);
	}

	/**
	 * 返回每日单词，两个查询方案
	 * 1、在word_and_user查询1/2，查询条件：relation<3，即正在学习中的词
	 * 2、在word中查询，查询量补齐
	 * @param user_id
	 * @param lastWordList 
	 * @return
	 */
	public JSONObject getRememberWord(Integer user_id) {
		//存入redis中的key，用来作为存取redis的键
		String key = user_id.toString()+"_"+CommonUtil.getNow();
		//每日单词打包对象
		JSONObject resultJson = new JSONObject();
		
		//通过查询redis来判断今天是否已经获取过当日单词，是:直接返回上次的json,否则请求新的json
		byte[] byt = CommonUtil.getJedis().get(key.getBytes());
		if(byt!=null){
			Object obj = CommonUtil.unserizlize(byt);
			JSONArray jsonArray = null;
			if(obj instanceof JSONArray){
				jsonArray = (JSONArray) obj;
				logger.info("redis中每日单词："+ jsonArray);
			}
			if(jsonArray!=null){
				resultJson.put("todayWordList", jsonArray);
				resultJson.put("getNow", key.split("_")[1]);
				resultJson.put("user_id", key.split("_")[0]);
				logger.info("resultJson:"+resultJson.toString());
				return resultJson;
			}
		}
		
//		if(lastWordList!=null
//				&&lastWordList.get("getNow")!=null
//				&&lastWordList.get("user_id")!=null
//				&&lastWordList.get("getNow").toString().equals(CommonUtil.getNow())
//				&&user_id==Integer.valueOf(lastWordList.get("user_id").toString())){
//			return lastWordList;
//		}
		
		//从数据库取每日单词并将每日单词打包成json数组
		Integer size1 = 0;
		List<Word> plan1 = new ArrayList<>();
		List<Word> plan2 = new ArrayList<>();
		Integer wordNumber = Integer.parseInt(wordProperties.getEveryWord());
		plan1 = wordDao.queryLearningWord(user_id,wordNumber/2);
		size1 = plan1.size();
		plan2 = wordDao.queryNewWord(wordNumber-size1);
		plan1.addAll(plan2);
		JSONArray todayWordList = JSONArray.fromObject(plan1);
		
		//以“user_id_getNow”为键，每日单词json为值存入redis中
		CommonUtil.getJedis().set(key.getBytes(), CommonUtil.serialize(todayWordList));
		resultJson.put("todayWordList", todayWordList);
		resultJson.put("getNow", CommonUtil.getNow());
		resultJson.put("user_id", user_id);
		logger.info("key:"+key);
		return resultJson;
	}

	/**
	 * 更新用户与单词的relationship
	 * 先查询中间表word_and_user中是否有用户与单词的联系
	 * 如果没有，中间表添加一条新数据
	 * 如果有，且relationship<3,relationship+1，没有，不操作
	 * @param user_id
	 * @param word_id
	 * @return
	 */
	public boolean updateWordUserRelation(Integer user_id, Integer word_id) {
		WordAndUser wu = wordDao.queryRelation(user_id,word_id);
		//没有联系就新增
		if(wu==null){
			wu = new WordAndUser();
			wu.setUser_id(user_id);
			wu.setWord_id(word_id);
			wu.setRelationship(0);
			wordDao.addRelation(wu);
		//正在学的单词relationship+1
		}else if(wu.getRelationship()<3){
			logger.info(wu.toString());
			wu.setRelationship(wu.getRelationship()+1);
			logger.info(wu.toString());
			wordDao.updateWordUserRelation(wu);
		}
		return true;
	}

	/**
	 * 用户查询已学会单词
	 * @param word
	 * @param page
	 * @param limit
	 * @param user_id 
	 * @return
	 */
	public JSONArray queryMyWord(Integer page, Integer limit, Integer user_id) {
		List<Word> myWordList = wordDao.queryMyWord(page, limit, user_id);
		return JSONArray.fromObject(myWordList);
	}

	/**
	 * 得到用户的已学会单词长度
	 * @return
	 */
	public Integer getMyWordListSize(Integer page,Integer limit,Integer user_id) {
		return this.queryMyWord(page, limit, user_id).size();
	}

	/**
	 * 用户查询生词
	 * @param page
	 * @param limit
	 * @param user_id
	 * @return
	 */
	public JSONArray queryNotebook(Integer page, Integer limit, Integer user_id) {
		List<Word> myWordList = wordDao.queryNotebook(page, limit, user_id);
		return JSONArray.fromObject(myWordList);
	}

	/**
	 * 得到生词长度
	 * @param page
	 * @param limit
	 * @param user_id
	 * @return
	 */
	public Integer getNotebookSize(Integer page, Integer limit, Integer user_id) {
		return this.queryNotebook(page, limit, user_id).size();
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
