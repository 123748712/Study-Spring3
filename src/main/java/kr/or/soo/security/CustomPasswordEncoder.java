package kr.or.soo.security;

import org.springframework.security.crypto.password.PasswordEncoder;

// 암호화 한것처럼 보이는 Encoder제작
public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString(); // 암호화하지 않고 그대로 return
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword); // 문자열로 비교
	}
}
