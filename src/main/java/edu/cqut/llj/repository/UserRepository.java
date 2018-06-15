package edu.cqut.llj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cqut.llj.po.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	/*
	 * 根据用户名查找
	 */
	public User findByUsername(String username);
	
	/*
	 * 根据电话号码查找
	 */
	public User findByMobile(String mobile);
	
	/*
	 * 根据用户名查找
	 */
	public User findByeMail(String eMail);
	
	/*
	 * 根据用户ID查找
	 */
	public User findByUserId(Integer user_id);
	
}
