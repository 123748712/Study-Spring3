package kr.or.soo.security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

// 인증 성공시 어디로 보낼지를 결정
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
			Authentication auth) throws IOException, ServletException {

		Iterator<? extends GrantedAuthority> myIter = auth.getAuthorities().iterator();

		log.info("name : " + auth.getName());
		log.info("cre : " + auth.getCredentials());
		log.info("def : " + auth.getDetails());
		log.info("pri : " + auth.getPrincipal());
		
		
		while(myIter.hasNext()) {
			String authName = myIter.next().toString();
			log.info("auth : " + authName); // 어떤 권한이 넘어오는지 확인
			
			// 여러개의 권한을 갖고 있다면 if문을 먼저 
			if(authName.equals("ROLE_ADMIN")) {
				res.sendRedirect("/soo/fbi/admin");
				break;
			} else if(authName.equals("ROLE_MEMBER")) {
				res.sendRedirect("/soo/fbi/member");
				break;
			} else if(authName.equals("ROLE_SOO")) {
				res.sendRedirect("/soo/fbi/soo");
				break;
			}
		}
	}

}
