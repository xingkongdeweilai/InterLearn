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
    public Result<Word> wordList(Model model
    		,@RequestParam(value="page", required=false,defaultValue="1") Integer page
    		,@RequestParam(value="limit", required=false,defaultValue="10") Integer limit){
		Word word = new Word();
		JSONArray wordJson = wordService.queryWordListPaged(word,page,limit);
		
    	logger.info(ResultUtil.success(wordJson).toString());
		return ResultUtil.success(wordJson,wordService.getWordListSize());
    }
	
	/**
	 * 在单词列表中更新数据或者添加新单词
	 * @param word
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/updateWord")
	@ResponseBody
	public Result<Word> updateWord(@Valid Word word){
		if(word.getWord_id()==0){
			int resultKey = wordService.addNewWord(word);
			if(resultKey>0){
				return ResultUtil.success(resultKey);
			}
			return ResultUtil.error(ResultEnum.ADD_WORD_ERROR.getCode(), ResultEnum.ADD_WORD_ERROR.getMsg());
		}else{
			if(wordService.updateWord(word)!=null){
				return ResultUtil.success(word);
			}
			return ResultUtil.error(ResultEnum.UPDATE_WORD_ERROR.getCode(), ResultEnum.UPDATE_WORD_ERROR.getMsg());
		}
	}
	
	/**
	 * 根据word_id查询例句
	 * @param word_id
	 */
//	@GetMapping("/queryExample")
//	@ResponseBody
//	public JSONArray queryExampleById(@Valid Word word){
//		/*return wordService.queryExampleById(word.getWord_id());*/
//		return null;
//	}
	
	/**
	 * 跳转到wordDetail页面或者添加新单词
	 * @param model
	 * @return
	 */
	@GetMapping("/queryDetailById")
    public String queryDetailById(Model model,@RequestParam("word_id") Integer word_id) {
		model.addAttribute("user", userController.getUserInfo());
		if(word_id==0){
			Word word = new Word();
			JSONObject wordJson = JSONObject.fromObject(word);
			model.addAttribute("word", wordJson);
			model.addAttribute("handle", "添加新单词");
			model.addAttribute("type", "text");
			model.addAttribute("wordname", "单词名");
	        return "html/admin/wordDetail";
		}else if(word_id>0){
	    	JSONObject wordJson = wordService.queryWordById(word_id);
	    	model.addAttribute("word", wordJson);
	    	model.addAttribute("handle", "编辑");
			model.addAttribute("type", "hidden");
	    	logger.info(wordJson.toString());
			return "html/admin/wordDetail";
		}
		return "html/error";
    }
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/deleteWord")
	@ResponseBody
	public Result deleteWord(@Valid Word word){
		if(wordService.deleteWord(word)){
			return ResultUtil.success(word);
		}
		return ResultUtil.error(ResultEnum.DELETE_WORD_ERROR.getCode(), ResultEnum.DELETE_WORD_ERROR.getMsg());
	}
	
//	@GetMapping("/updateWordAndExample")
//	public String updateWordAndExample(@Valid Word word,Model model){
//		model.addAttribute("user", userController.getUserInfo());
//		if(wordService.updateWord)
//		return "html/error";
//	}
	
	
	
	
	
//	@SuppressWarnings("unchecked")
//	@PostMapping("/queryWordListPaged")
//	@ResponseBody
//	public Result<Word> queryWordListPaged(Integer page){
//		if(page == null){
//			page=1;
//		}
//		Integer pageSize = 10;
//		Word word = new Word();
//		List<Word> wordList = wordService.queryWordListPaged(word,page,pageSize);
//		return ResultUtil.success(wordList);
//	}
	
//	@SuppressWarnings("unchecked")
//	@GetMapping("/test")
//	@ResponseBody
//	public Result<WordAndWordExample> test(){
//		List<WordAndWordExample> word = wordService.test();
//		return ResultUtil.success(word);
//	}
}
