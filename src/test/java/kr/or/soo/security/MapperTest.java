package kr.or.soo.security;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import kr.or.soo.domain.AuthVO;
import kr.or.soo.domain.MemberVO;
import kr.or.soo.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

// Junit4 사용시 @Runwith(???.class)
@ExtendWith(SpringExtension.class) // Junit5 사용
@ContextConfiguration("classpath:test-context.xml")
@Slf4j
public class MapperTest {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Test
	public void connTest() {
		MemberVO vo = memberMapper.read("user1");
		log.info("ck : " + vo.getUserid());
		log.info("ck : " + vo.getUserpw());
		log.info("ck : " + vo.getUserName());
		log.info("ck : " + vo.getRegDate());
		List<AuthVO> authList = vo.getAuthList();
		for (AuthVO authVO : authList) {
			log.info("list ck : " + authVO.toString());
		}
	}
}