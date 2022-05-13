package kr.or.soo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.soo.domain.EmailDTO;
import kr.or.soo.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
    EmailService emailService;
 
    @GetMapping("/write")
    public String write() {
        return "/email/write";
    }
 
    @PostMapping("/send") // 확인 (메일발송) 버튼을 누르면 맵핑되는 메소드
    public String send(@ModelAttribute EmailDTO dto, Model model) { // @ModelAttribute를 사용하면 자동으로 model에 담긴다.
        try {
 
            emailService.sendMail(dto); // dto (메일관련 정보)를 sendMail에 저장함
            model.addAttribute("message", "이메일이 발송되었습니다."); // 이메일이 발송되었다는 메시지를 출력시킨다.
 
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "이메일 발송 실패..."); // 이메일 발송이 실패되었다는 메시지를 출력
        }
        return "/email/write"; // 실패했으므로 다시 write jsp 페이지로 이동함
    }
}
