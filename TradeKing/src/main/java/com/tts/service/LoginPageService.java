package com.tts.service;

import org.springframework.stereotype.Service;

import com.tts.dto.LoginDTO;

@Service
public class LoginPageService implements ILoginPageService {

	@Override
	public String LoginProcess(LoginDTO dto) {
		System.out.println(dto.getLoginId() + " ====== "+ dto.getPassword());
		return null;
	}
	
	

}
