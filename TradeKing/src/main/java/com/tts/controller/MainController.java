package com.tts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/home.htm")
	public String showPage() {
		return "LoginPage";
	}
}
