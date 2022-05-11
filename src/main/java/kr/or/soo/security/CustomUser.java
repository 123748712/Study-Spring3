package kr.or.soo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.soo.domain.MemberVO;
import lombok.Getter;

// User implements UserDetails
// CustomUser extends User
// 즉, CustomUser 는 UserDetails를 상속받는 것
// CustomUser를 통해 UserDetails로 변환시켜주는 작업을 함 
@Getter // Getter가 없으면 직접적으로 member를 읽지 못한다.
public class CustomUser extends User { // User는 UserDetails를 implements함
	private static final long serialVersionUID = 1L;
	private MemberVO member;
	
	// 생성자에서 부모 생성자를 불러주어야 함
	public CustomUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	// MemberVO를 UserDetails로 변환시켜주는 생성자
	// UserDetails는 기본적으로 id,pw,권한들을 가지고 있다.
	// UserDetails에 memberVO를 붙여주려 함
	public CustomUser(MemberVO vo) {
		super(vo.getUserid(), vo.getUserpw(), 
			vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		this.member = vo; // 핵심
	}
}