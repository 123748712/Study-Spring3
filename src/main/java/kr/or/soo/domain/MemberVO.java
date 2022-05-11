package kr.or.soo.domain;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private String userid;
	private String userpw;
	private String userName;
	private boolean enabled;
	private Date regDate;
	
	private List<AuthVO> authList;
	// user1 ROLE_ADMIN
	// user1 ROLE_MEMBER
	// 형식처럼 한개의 userid에 여러개의 권한을 가질 수 있기 때문에 List로 받아준다.	
}