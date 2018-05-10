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
	
}
