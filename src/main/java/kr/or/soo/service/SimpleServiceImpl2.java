package kr.or.soo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kr.or.soo.mapper.Tx1Mapper;
import kr.or.soo.mapper.Tx2Mapper;

@Service
public class SimpleServiceImpl2 implements SimpleService2 {
	
	@Autowired
	private Tx1Mapper tx1mapper;
	
	@Autowired
	private Tx2Mapper tx2mapper;	
	
	// 메소드에서 실패한 부분이 있다면 메소드 전체가 실행되지 않도록 하는 트랜잭션 어노테이션
	@Transactional(isolation = Isolation.DEFAULT, // 데이터베이스에 의존
				   readOnly = true, // 읽기전용
				   propagation = Propagation.REQUIRED) // 트랜잭션이 없다면 새로운 트랜잭션으로, 있다면 기존 트랜잭션으로 시작
	@Override 
	public void ins2tb() {
		tx2mapper.insTx2("서울특별시 용산구 청파동");
		tx1mapper.insTx1("서울특별시 용산구 이태원");
	}
}
