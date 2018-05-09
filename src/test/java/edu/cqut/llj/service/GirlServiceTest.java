package edu.cqut.llj.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.cqut.llj.po.Girl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

	@Autowired
	private GirlService girlService;
	
	@Test
	public void testFindOne() {
		Girl girl = girlService.findOne(1);
		Assert.assertEquals(new Integer(12), girl.getAge());
	}

}
