package edu.cqut.llj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.PageHelper;

import edu.cqut.llj.dao.WordDao;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.vo.WordAndWordExample;
import tk.mybatis.mapper.entity.Example;

@Service
public class WordService {
	
	@Autowired
	private WordDao wordDao;

	public List<Word> queryWordList() {
		return wordDao.queryWordList();
	}

	public boolean updateWord(Word word) {
		return wordDao.updateWord(word);
	}

	public List<Word> queryWordListPaged(Word word, Integer page, Integer pageSize) {
		//开始分页
		PageHelper.startPage(page,pageSize);
		
		Example example = new Example(Word.class);
		Example.Criteria criteria = example.createCriteria();
		
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
