package kr.or.soo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class) // Junit5
@ContextConfiguration("classpath:test-context.xml")
@Slf4j
public class SimpleTest {
	
	@Autowired
	SimpleService simpleService;
	
	@Test
	public void simpleTest() {
		log.info("simple");
		simpleService.ins2tb();
	}
}