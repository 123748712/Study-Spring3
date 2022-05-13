package kr.or.soo.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SimpleServiceImpl implements SimpleService {

	@Override
	public Integer add(String str1, String str2) {
		log.info("add");
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}
	
	@Override
	public Integer minus(String str1, String str2) {
		log.info("minus");
		return Integer.parseInt(str1) - Integer.parseInt(str2);
	}
	
}