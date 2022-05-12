package kr.or.soo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.soo.domain.AuthVO;
import kr.or.soo.domain.MemberVO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

// User implements UserDetails
// CustomUser extends User
// 즉, CustomUser 는 UserDetails를 상속받는 것
// CustomUser를 통해 UserDetails로 변환시켜주는 작업을 함 
@Getter // Getter가 없으면 직접적으로 member를 읽지 못한다.
@Slf4j
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
		
		// Stream(Buffer)
		// buffer size에 데이터가 전부 들어가면, 그 이상의 데이터는 흐르게 된다.
		// 흐르는 데이터들을 Stream이라고 칭한다.
		// 동영상을 시청할때 버퍼링이 걸리는 이유는 buffer size에 영상의 데이터를 담기 위한 것
		// 그 후로 영상이 안끊기는 것은 buffer size에 데이터가 가득 차 그 이상의 데이터는 흐르게 되는 것
		
		// intermediate operation (중간 operation)
		// terminal operation (종료 operation)
		List<SimpleGrantedAuthority> ckList = vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList());
		List<AuthVO> myList = vo.getAuthList();
		List<SimpleGrantedAuthority> ck2List = new ArrayList<SimpleGrantedAuthority>(); // 옮겨담을 것
		
		for (AuthVO authVO : myList) {
			ck2List.add(new SimpleGrantedAuthority(authVO.getAuth()));
		}
		
		log.info("stream result : " + ckList);
		log.info("just check : " + ck2List);
		
		this.member = vo; // 핵심
	}
}