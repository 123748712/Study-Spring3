package kr.or.soo.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class) // Junit5(단위테스트용 프레임워크), 3rd party tool
@ContextConfiguration("classpath:test-context.xml") // 설정파일 읽어오기
public class PasswordEncoderTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test // 서버를 키지 않아도 실행될 수 있는 어노테이션
	@Disabled
	public void myTest() throws Exception {
		String mySQL = "insert into users(userid, username, password) values(?, ?, ?)";
		for (int i = 1; i <= 10; i++) {
			Connection conn = dataSource.getConnection();
			PreparedStatement psmt = conn.prepareStatement(mySQL);
			psmt.setString(1, "user" + i);
			psmt.setString(2, "soo" + i);
			psmt.setString(3, passwordEncoder.encode("user"+i));
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}
	}
	
	@Test
//	@Disabled // junit5 테스트실행이 되어도 실행되지 않게하는 어노테이션
	public void myTest2() throws Exception {
		String mySQL = "insert into authorities(userid, authority) values(?, ?)";
		for (int i = 1; i <= 10; i++) {
			Connection conn = dataSource.getConnection();
			PreparedStatement psmt = conn.prepareStatement(mySQL);
			psmt.setString(1, "user" + i);
			if(i <=5) {
				psmt.setString(2, "ROLE_ADMIN"); // ROLE_권한
			} else {
				psmt.setString(2, "ROLE_MEMBER");
			}
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}
	}
}
