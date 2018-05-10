package edu.cqut.llj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping({"/hello","/hi"})
public class HelloController {
	
//	@Value("${cupSize}")
//	private String cupSize;
	
//	@Value("${age}")
//	private Integer age;
	
//	@Autowired
//	private GirlProperties girlProperties;
	
	@GetMapping(value="/say")
	public String say(@RequestParam(value="id",required=false,defaultValue="0") Integer id){
		return "id: "+id;
	}
	
//	@GetMapping(value="/say/{id}")
//	public String say(@PathVariable Integer id){
//		return girlProperties.getCupSize();
//		return "index";
//		return "id: "+id;
//	}

}
