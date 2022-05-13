package kr.or.soo.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect // Aspect임을 마킹
@Component // Bean 생성
@Slf4j
public class MyLog { // 현재 클래스를 advice라고 함.

	// ()안의 내용을 pointcut이라고 하고, 기술법을 pointcut 표현식 이라고 함
//	@Before("execution(* kr.or.soo.service.SimpleService*.*(..))") // SimpleService로 시작하는 클래스의 메소드를 전부 칭함
//	public void testLog() {
//		log.info("Advice method (Before)");
//	}
	
	// Before, After, AfterThrowing, AfterReturning, Around
	@Around("execution(* kr.or.soo.service.SimpleService*.*(..))") // Around 빼고 나머지 어노테이션은 잘 사용하지 않음.
	public Integer aroundLog(ProceedingJoinPoint pjp) throws Throwable { // pjp가 SimpleServiceImpl 대신 메소드를 호출함. (proceed)
		log.info("proceed 실행 전");
//		log.info("p1 : " + pjp.getClass());
//		log.info("p2 : " + pjp.getTarget().getClass().getName()); // getTarget : SimpleServiceImple
//		log.info("kgb : " + Arrays.toString(pjp.getArgs()));
		Integer retObj = (Integer) pjp.proceed(pjp.getArgs()); // target 클래스의 메소드 호출 (proceed 위에 먼저 실행하고 싶은 메소드, 코드 작성. 아래엔 실행된 다음 실행할 메소드, 코드 작성)
		log.info("proceed 실행 후");
		
		return retObj;
	}
}
