package edu.cqut.llj.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.exception.GirlException;
import edu.cqut.llj.po.User;
import edu.cqut.llj.repository.UserRepository;
import edu.cqut.llj.service.UserService;
import edu.cqut.llj.utils.ResultUtil;
import edu.cqut.llj.vo.Result;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@SuppressWarnings("unchecked")
	@PostMapping("/addUser.do")
	public String addUser(@Valid User user,BindingResult bindingResult,ModelMap map){
		LOGGER.info("user");
		//从注册页面注册的是普通用户
		if(user!=null){
			user.setRole(ResultEnum.USER.getCode());
		}else{
			throw new GirlException(ResultEnum.USER_NULL);
		}
		
		if(bindingResult.hasErrors()){
//			return ResultUtil.error(ResultEnum.USER_REGISTER.getCode(), ResultEnum.USER_REGISTER.getMsg());
			return "html/error";
		}
		map.addAttribute("user", userService.addUser(user));
		return "html/login";
	}
	
	/**
	 * 进入登录页面
	 * @return
	 */
	@GetMapping("/login.do")
	public String test(){
		LOGGER.info("ttttttttttt");
		return "html/login";
	}
	
	/**
	 * 进入注册页面
	 * @return
	 */
	@GetMapping("/regester.do")
	public String test1(){
		LOGGER.info("ttttttttttt");
		return "html/regester";
	}
}
