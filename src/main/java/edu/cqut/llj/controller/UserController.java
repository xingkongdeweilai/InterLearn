package edu.cqut.llj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.exception.GirlException;
import edu.cqut.llj.po.User;
import edu.cqut.llj.service.UserService;
import edu.cqut.llj.utils.JacksonUtil;
import edu.cqut.llj.utils.ResultUtil;
import edu.cqut.llj.vo.Result;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@ResponseBody
	@PostMapping("/addUser")
	public Result<User> addUser(@Valid User user,BindingResult bindingResult){
		LOGGER.info("user");
		//从注册页面注册的是普通用户
		if(user!=null){
			user.setRole(ResultEnum.USER.getCode());
		}else{
			throw new GirlException(ResultEnum.USER_NULL);
		}
		
		if(bindingResult.hasErrors()){
			return ResultUtil.error(ResultEnum.USER_REGISTER.getCode(), ResultEnum.USER_REGISTER.getMsg());
//			return "html/error";
		}
		/*map.addAttribute("user", userService.addUser(user));*/
//		return "html/login";
		return ResultUtil.success(userService.addUser(user));
	}
	
	/**
	 * 验证登录
	 * @param user
	 * @param req
	 * @param model
	 * @return
	 */
	@PostMapping("/verifyLogin")
	public String verifyLogin(/*User user,HttpServletRequest req*/){
		/*String username = user.getUsername();
		String password = user.getPassword();
		if(username==null||password==null){
			return null;
		}
		User resultUser = userService.queryUserByLogin(username,password);
		LOGGER.info(resultUser.toString());
		if(resultUser!=null){
			req.getSession().setAttribute("user", resultUser);
			
			String json = JacksonUtil.toJSonString(resultUser);
			LOGGER.info(json);
//			model.addAttribute("user", json);
		}*/
		return "html/index";
	}
	
	/**
	 * 进入登录页面
	 * @return
	 */
	@GetMapping("/login")
	public String login(){
		return "html/login";
	}
	
	/**
	 * 进入注册页面
	 * @return
	 */
	@GetMapping("/regester")
	public String regester(){
		return "html/regester";
	}
}
