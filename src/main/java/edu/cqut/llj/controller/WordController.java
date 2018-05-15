package edu.cqut.llj.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.pojo.WordExample;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.service.WordService;
import edu.cqut.llj.utils.ResultUtil;
import edu.cqut.llj.vo.Result;
import edu.cqut.llj.vo.ThreeWordExample;
import edu.cqut.llj.vo.WordAndWordExample;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/word")
public class WordController {
	
	@Autowired
	private UserController userController;
	@Autowired
	private WordService wordService;
	private static final Logger logger = LoggerFactory.getLogger(WordController.class);
	/**
     * 跳转到单词列表页面
     * @return
     */
    @GetMapping("/toWordList")
    public String toWordList(Model model) {
    	model.addAttribute("user", userController.getUserInfo());
        return "html/admin/wordList";
    }
    
    /**
     * 加载单词列表及例句
     * @return
     */
	@SuppressWarnings("unchecked")
	@GetMapping("/wordList")
    @ResponseBody
    public Result<WordAndWordExample> wordList(){
    	JSONArray wordJson = wordService.queryWordList();
    	logger.info(ResultUtil.success(wordJson).toString());
//    	JSONObject json = new JSONObject();
//    	json.put("data", wordJson);
		return ResultUtil.success(wordJson);
    }
	
	/**
	 * 在单词列表中更新数据
	 * @param word
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/updateWord")
	@ResponseBody
	public Result<Word> updateWord(@Valid Word word){
		if(wordService.updateWord(word)!=null){
			return ResultUtil.success(word);
		}
		return ResultUtil.error(ResultEnum.UPDATE_WORD_ERROR.getCode(), ResultEnum.UPDATE_WORD_ERROR.getMsg());
	}
	
	/**
	 * 根据word_id查询例句
	 * @param word_id
	 */
	@GetMapping("/queryExample")
	@ResponseBody
	public JSONArray queryExampleById(@Valid Word word){
		return wordService.queryExampleById(word.getWord_id());
	}
	
	/**
	 * 跳转到wordDetail页面
	 * @param model
	 * @return
	 */
	@GetMapping("/queryDetailById")
    public String queryDetailById(Model model,@RequestParam("word_id") Integer word_id) {
    	model.addAttribute("user", userController.getUserInfo());
    	JSONObject wordJson = wordService.queryWordById(word_id);
    	model.addAttribute("word", wordJson);
    	logger.info(wordJson.toString());
    	JSONArray exampleJson = wordService.queryExampleById(word_id);
    	model.addAttribute("example", exampleJson);
    	logger.info(exampleJson.toString());
        return "html/admin/wordDetail";
    }
	
	@GetMapping("/updateWordAndExample")
	public String updateWordAndExample(@Valid Word word,ThreeWordExample wordExamples,Model model){
		logger.info(wordExamples.toString());
		if(wordService.updateWord(word)!=null
				&&wordService.updateWordExample(1,wordExamples.getWord_example_cn1(),wordExamples.getWord_example_en1(),word.getWord_id())!=null){
			model.addAttribute("user", userController.getUserInfo());
			model.addAttribute("word", word);
			return "html/admin/wordDetail";
		}
		return "html/error";
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/queryWordListPaged")
	@ResponseBody
	public Result<Word> queryWordListPaged(Integer page){
		if(page == null){
			page=1;
		}
		Integer pageSize = 10;
		Word word = new Word();
		List<Word> wordList = wordService.queryWordListPaged(word,page,pageSize);
		return ResultUtil.success(wordList);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/test")
	@ResponseBody
	public Result<WordAndWordExample> test(){
		List<WordAndWordExample> word = wordService.test();
		return ResultUtil.success(word);
	}
}
