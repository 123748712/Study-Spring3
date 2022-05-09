package kr.or.soo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginOutController {

	@GetMapping("/mylogin")
	public String getLogin() {
		log.info("This is my Login-Page");
		return "mylogin";
	}
}
