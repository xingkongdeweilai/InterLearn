package edu.cqut.llj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.cqut.llj.enums.ResultEnum;
import edu.cqut.llj.exception.GirlException;
import edu.cqut.llj.po.Girl;
import edu.cqut.llj.repository.GirlRepository;

@Service
public class GirlService {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo(){
		Girl girlA = new Girl();
		girlA.setAge(11);
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setAge(11);
		girlRepository.save(girlB);
	}
	
	public void getAge(Integer id){
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if(age<10){
			//返回"你还在上小学吧" code=100
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age>=10&&age<16){
			//返回"你可能在上初中" code=101
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
	
	/**
	 * 通过id查询一个女生的信息
	 * @param id
	 * @return
	 */
	public Girl findOne(Integer id){
		return girlRepository.findOne(id);
	}
}
