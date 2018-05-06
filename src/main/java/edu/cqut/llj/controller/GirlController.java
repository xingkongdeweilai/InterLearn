package edu.cqut.llj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cqut.llj.po.Girl;
import edu.cqut.llj.repository.GirlRepository;
import edu.cqut.llj.service.GirlService;

@RestController
@RequestMapping("/girls")
public class GirlController {

	@Autowired
	private GirlRepository girlRepository;
	@Autowired
	private GirlService girlsevice;
	
	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping("/queryAll")
	public List<Girl> girlList(){
		return girlRepository.findAll();
	}
	
	/**
	 * 添加一个女生
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping("/add")
	public Girl girlAdd(@Valid Girl girl,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getFieldError().getDefaultMessage());
			return null;
		}
//		girl.setCupSize(girl.getCupSize());
//		girl.setAge(girl.getAge());
		return girlRepository.save(girl);
	}
	
	//查询一个女生
	@GetMapping("/queryOne/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id){
		return girlRepository.findOne(id);
	}
	
	//更新
	@PutMapping("/update/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
							@RequestParam("cupSize") String cupSize,
							@RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		
		return girlRepository.save(girl);
	}
	
	//删除
	@DeleteMapping("/delete/{id}")
	public void girlDelete(@PathVariable("id") Integer id){
		girlRepository.delete(id);
	}
	
	//通过年龄查询女生列表
	@GetMapping("queryByAge/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}
	
	@PostMapping("/addTwo")
	public void addTwo(){
		girlsevice.insertTwo();
	}
}
