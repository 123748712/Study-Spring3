package kr.or.soo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:test-context.xml")
@Slf4j
public class SimpleTest {
	
	@Autowired
	private SimpleService simpleService;
	
	@Test
	public void myTest() {
		log.info("sum : " + simpleService.add("272", "337"));
		log.info("cha : " + simpleService.minus("337", "272"));
	}
}
