package kr.or.soo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.soo.domain.MemberVO;
import kr.or.soo.security.CustomUser;
import kr.or.soo.security.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/fbi")
@Slf4j
public class MyController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@GetMapping("/all")
	public String getAll(Model model) {
		log.info("All Access");
		model.addAttribute("accessUser", "All");
		return "allaccess";
	}
	
	@GetMapping("/member")
	public String getMember(Model model) {
		log.info("Member Access");
		model.addAttribute("accessUser", "Member");
		return "memberaccess";
	}
	
	@GetMapping("/admin")
	public String getAdmin(Model model) {
		log.info("Admin Access");
		
		// jsp에서 sec:authentication에 담긴 security 정보를 java에서 사용할 수 있다.
		SecurityContext secContext = SecurityContextHolder.getContext();
		log.info("SecurityContext : " + secContext.getAuthentication().getDetails());
		log.info("SecurityContext : " + secContext.getAuthentication().getName());
		log.info("SecurityContext : " + secContext.getAuthentication().getAuthorities());
		log.info("SecurityContext : " + secContext.getAuthentication().getPrincipal());
		
		// CustomUser로 캐스팅 memberVO에 접근하기 위해서
		CustomUser myuser = (CustomUser) customUserDetailsService.loadUserByUsername(secContext.getAuthentication().getName());
		MemberVO memberVO = myuser.getMember();
		log.info("UserId : " + memberVO.getUserid());
		log.info("UserName : " + memberVO.getUserName());
		log.info("UserPw : " + memberVO.getUserpw());
		log.info("UserAuthList : " + memberVO.getAuthList().toString());
		
		model.addAttribute("accessUser", "Admin");
		return "adminaccess";
	}
	
	@GetMapping("/admin2")
	public String getAdmin2(Model model) {
		log.info("Admin Access");
		model.addAttribute("accessUser", "Admin");
		return "userDetailsCK";
	}
	
	@GetMapping("/soo")
	public String getSoo(Model model) {
		log.info("Soo Access");
		model.addAttribute("accessUser", "Soo");
		return "sooaccess";
	}
}
