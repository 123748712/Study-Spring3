package kr.or.soo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/fbi")
@Slf4j
public class MyController {

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
		model.addAttribute("accessUser", "Admin");
		return "adminaccess";
	}
	
	@GetMapping("/soo")
	public String getSoo(Model model) {
		log.info("Soo Access");
		model.addAttribute("accessUser", "Soo");
		return "sooaccess";
	}
}
