package kr.or.soo.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginOutController {

	@GetMapping("/mylogin")
	public String getLogin(HttpSession session) {
		session.setAttribute("guest", "guest");
		log.info("This is my Login-Page");
		return "mylogin";
	}
	
	@GetMapping("/mylogout")
	public String getLogout() {
		log.info("This is my Logout-Page");
		return "mylogout";
	}
	
	@GetMapping("/accessError")
	public String accessError(HttpServletRequest req, Model model) {
		
		Enumeration<String> reqAttrNames = req.getAttributeNames();
		
		while(reqAttrNames.hasMoreElements()) {
			System.out.println("ck : " + reqAttrNames.nextElement());
		}
			
		log.info("You are not permitted");
		model.addAttribute("msg", "error");
		return "accessError";
	}
}
