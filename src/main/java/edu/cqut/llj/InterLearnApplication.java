package edu.cqut.llj;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * spring boot启动
 * @author Administrator
 *
 */
@SpringBootApplication
//扫描mybatis mapper包路径
@MapperScan(basePackages="edu.cqut.llj.mapper")
public class InterLearnApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterLearnApplication.class, args);
	}
}
