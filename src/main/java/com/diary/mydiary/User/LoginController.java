package com.diary.mydiary.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diary.mydiary.exceptions.WrongIdPasswordException;
import com.diary.mydiary.model.AuthInfo;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginCommand loginiCommand) {
		return "loginHome";
	}
	
	@PostMapping("/loginSubmit")
	public String submit(@Validated LoginCommand loginCommand, Errors errors, HttpSession session) {
		if(errors.hasErrors()) {
			return "login";
		}
		try {
			AuthInfo authinfo = authService.authenticate(
					loginCommand.getId(),
					loginCommand.getPw());
			
			// 세션에 authInfo 저장 -> 로그인 유지
			session.setAttribute("authinfo", authinfo);
			
			// diary list 불러와서 loginHome 페이지로
			return "redirect:/loginHome";
		} catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login";
		}
	}
	
	@GetMapping("/loginSubmit")
	public String loginRedirect() {	
		return "redirect:/";
	}
}
