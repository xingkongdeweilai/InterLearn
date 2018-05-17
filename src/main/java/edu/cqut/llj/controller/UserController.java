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
import edu.cqut.llj.utils.ResultUtil;
import edu.cqut.llj.vo.Result;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	private JSONObject userInfo;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping("/addUser")
	public Result<User> addUser(@Valid User user,BindingResult bindingResult){
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
	public String verifyLogin(User user,HttpServletRequest req,Model model){
		String username = user.getUsername();
		String password = user.getPassword();
		//用户名或密码为空，直接返回null
		if(username==null||password==null){
			return "html/login";
		}
		User resultUser = userService.queryUserByLogin(username,password);
		if(resultUser!=null){
			logger.info(resultUser.toString());
		}
		//如果查询到用户信息，向页面传值，以及注入session
		if(resultUser!=null){
			req.getSession().setAttribute("user", resultUser);
			JSONObject resultJson = JSONObject.fromObject(resultUser);
			logger.info(resultJson.toString());
			model.addAttribute("loginInfo", resultJson);
			//根据角色判断跳转的页面
			if(resultUser.getRole()==0||resultUser.getRole()==1){
				setUserInfo(resultJson);
				return "html/admin/index";
			}else{
				return "html/user/index";
			}
		}
		model.addAttribute("error", ResultEnum.LOGIN_ERROR.getMsg());
		return "html/login";
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
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req,Model model){
		req.getSession().setAttribute("user", null);
		return "html/login";
	}
	

	public JSONObject getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(JSONObject userInfo) {
		this.userInfo = userInfo;
	}
}
