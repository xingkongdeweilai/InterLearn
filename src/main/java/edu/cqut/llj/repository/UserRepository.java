package edu.cqut.llj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cqut.llj.po.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
