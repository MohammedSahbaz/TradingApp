package com.tts.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.command.LoginCommand;
import com.tts.dto.LoginDTO;
import com.tts.service.ILoginPageService;

@Controller
public class MainController {

	@Autowired
	private ILoginPageService loginPageService;
	
	@RequestMapping("/home.htm")
	public String showHomePage() {
		return "HomePage";
	}

	@RequestMapping("/signup.htm")
	public String showSignUpPage() {
		return "SignupPage";
	}

	@RequestMapping("/login.htm")
	public String showLoginPage() {
		return "LoginPage";
	}

	@RequestMapping("/LoginSubmitAction.htm")
	public String process(Map<String, Object> map, LoginCommand command) throws Exception {
	
		System.out.println("=================================="+command.getLoginId() + " ======> "+ command.getPassword());
		LoginDTO dto = new LoginDTO();
		BeanUtils.copyProperties(command, dto);				
		loginPageService.LoginProcess(dto);	
		
		return "";
	}
}
