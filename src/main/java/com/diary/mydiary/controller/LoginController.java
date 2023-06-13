package com.diary.mydiary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diary.mydiary.exceptions.WrongIdPasswordException;
import com.diary.mydiary.model.AuthInfo;
import com.diary.mydiary.model.Diary;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/submit2")
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
	
	@PostMapping
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
	
	@GetMapping("/submit2")
	public String loginRedirect() {	
		return "redirect:/";
	}
}
