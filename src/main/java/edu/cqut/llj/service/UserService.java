package edu.cqut.llj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cqut.llj.dao.UserDao;
import edu.cqut.llj.po.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User addUser(User user){
		return userDao.addUser(user);
	}

	public User queryUserByLogin(String username,String password) {
		return userDao.queryUserByLogin(username,password);
	}
	
}
