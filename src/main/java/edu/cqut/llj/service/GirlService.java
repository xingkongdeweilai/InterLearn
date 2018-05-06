package edu.cqut.llj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		girlA.setCupSize("C");
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setAge(11);
		girlB.setCupSize("C");
		girlRepository.save(girlB);
	}
	
}
