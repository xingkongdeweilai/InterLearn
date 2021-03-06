package edu.cqut.llj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.po.User;
import edu.cqut.llj.pojo.Word;
import edu.cqut.llj.service.WordService;
import edu.cqut.llj.utils.ResultUtil;
import edu.cqut.llj.vo.Result;
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
			Integer resultKey = wordService.addNewWord(word);
			if(resultKey>0){
				logger.info("后台没问题");
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
	
	/**
	 * 管理员删除单词
	 * @param word
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/deleteWord")
	@ResponseBody
	public Result deleteWord(@Valid Word word){
		if(wordService.deleteWord(word)){
			return ResultUtil.success(word);
		}
		return ResultUtil.error(ResultEnum.DELETE_WORD_ERROR.getCode(), ResultEnum.DELETE_WORD_ERROR.getMsg());
	}
	
	/**
	 * 返回每日单词
	 * @param req
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/getRememberWord")
	@ResponseBody
	public Result getRememberWord(HttpServletRequest req){
		Integer user_id = ((User)req.getSession().getAttribute("user")).getUserId();
//		JSONObject lastWordList = (JSONObject) req.getSession().getAttribute("today");
		
		JSONObject jsonObject = wordService.getRememberWord(user_id);
		if(jsonObject!=null){
//			//为了下次判断是否查询做准备
//			req.getSession().setAttribute("today", jsonObject);
			return ResultUtil.success(jsonObject);
		}
		return ResultUtil.error(ResultEnum.EVERY_WORD_ERROR.getCode(), ResultEnum.EVERY_WORD_ERROR.getMsg());
	}
	
	/**
	 * 更新用户与单词的relationship
	 * @param word
	 * @param req
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/updateWordUserRelation")
	@ResponseBody
	public Result updateWordUserRelation(@Valid Word word,HttpServletRequest req){
		Integer user_id = ((User)req.getSession().getAttribute("user")).getUserId();
		if(wordService.updateWordUserRelation(user_id,word.getWord_id())){
			
		}
		return null;
	}
	
	 /**
     * 用户查询已学会单词
     * @return
     */
	@SuppressWarnings("unchecked")
	@GetMapping("/getMyWord")
    @ResponseBody
    public Result<Word> getMyWord(HttpServletRequest req
    		,@RequestParam(value="page", required=false,defaultValue="1") Integer page
    		,@RequestParam(value="limit", required=false,defaultValue="10") Integer limit){
		logger.info("page:"+page+" limit:"+limit);
		Integer user_id = ((User)req.getSession().getAttribute("user")).getUserId();
		JSONArray wordJson = wordService.queryMyWord(page,limit,user_id);
    	logger.info(ResultUtil.success(wordJson).toString());
		return ResultUtil.success(wordJson,wordService.getMyWordListSize(page,limit,user_id));
    }
	
	 /**
     * 用户查询生词，relationship>0且小于3
     * @return
     */
	@SuppressWarnings("unchecked")
	@GetMapping("/getNotebook")
    @ResponseBody
    public Result<Word> getNotebook(HttpServletRequest req
    		,@RequestParam(value="page", required=false,defaultValue="1") Integer page
    		,@RequestParam(value="limit", required=false,defaultValue="10") Integer limit){
		Integer user_id = ((User)req.getSession().getAttribute("user")).getUserId();
		JSONArray wordJson = wordService.queryNotebook(page,limit,user_id);
    	logger.info(ResultUtil.success(wordJson).toString());
		return ResultUtil.success(wordJson,wordService.getNotebookSize(page,limit,user_id));
    }
	
//	/**
//	 * 用户查看单词详情
//	 * @param model
//	 * @return
//	 */
//	@PostMapping("/queryDetailByIdUser")
//	@ResponseBody
//    public JSONObject queryDetailByIdUser(Model model, Word word) {
//    	logger.info(word.toString());
//		model.addAttribute("word", userController.getUserInfo());
//		return JSONObject.fromObject(word);
//    }
	
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
