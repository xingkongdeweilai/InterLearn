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
		if(password!=null&&password.equals(resultUser.getPassword())){
			return resultUser;
		}
		return null;
	}
	
}
