package edu.cqut.llj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.cqut.llj.po.User;
import edu.cqut.llj.repository.UserRepository;

@Component
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public User addUser(User user){
		return userRepository.save(user);
	}

	/**
	 * 登录信息查询
	 * @param username
	 * @param password
	 * @return
	 */
	public User queryUserByLogin(String username,String password) {
		//分别根据姓名、电话号码及邮箱查询
		User resultUser1 = userRepository.findByUsername(username);
		User resultUser2 = userRepository.findByMobile(username);
		User resultUser3 = userRepository.findByeMail(username);
		User resultUser = null;
		if(resultUser1!=null){
			resultUser = resultUser1;
		}else if(resultUser2!=null){
			resultUser = resultUser2;
		}else if(resultUser3!=null){
			resultUser = resultUser3;
		}else{
			return null;
		}
		//验证密码
		if(password!=null&&password.equals(resultUser.getPassword())){
			return resultUser;
		}
		return null;
	}
	
	public String getNameById(Integer id){
		User user = userRepository.findByUserId(id);
		return user.getUsername();
	}
}
