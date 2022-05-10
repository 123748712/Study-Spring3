package kr.or.soo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.slf4j.Slf4j;

// 403error(권한없음)에 대한 핸들러 구현
// AccessDeniedHandler를 상속받아 직접 핸들러를 구현하는걸 많이 씀
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException aDE)
			throws IOException, ServletException {
		log.info("AccessDeniedHandler"); // 디버깅시 중요한 표시
		log.info("error : " + aDE.getMessage());
		
		// 403에러 발생시 에러페이지로 리다이렉트
		res.sendRedirect(req.getContextPath() + "/accessError");
	}
}