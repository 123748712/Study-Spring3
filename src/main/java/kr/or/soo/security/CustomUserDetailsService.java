package kr.or.soo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.soo.domain.MemberVO;
import kr.or.soo.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

// username, password 외 다른 정보들도 받을 수 있는 클래스
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// return 타입이 UserDetails기 때문에 MemberVO를 UserDetails로 변환한다.
		// UserDetails를 구현한 클래스가 있어서 User 클래스를 상속받아 만들어준다.

		log.info("ckk{}"+username);

		MemberVO member = memberMapper.read(username);
//		UserDetails userDetails = new CustomUser(member); // CustomUser생성자를 통해 UserDetails로 변환시킴

		return member == null ? null : new CustomUser(member);
		// username이 없는 아이디라면 null이 뜸.
		// 즉, member도 null이기 때문에 null일시 null로 return
		// null이 아닐시 new CustomUser로 return
	}
}