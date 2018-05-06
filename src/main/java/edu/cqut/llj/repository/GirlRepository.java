package edu.cqut.llj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cqut.llj.po.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer>{
	
	//通过年龄查询(方法名一定要按照格式写)
	public List<Girl> findByAge(Integer age);
}
