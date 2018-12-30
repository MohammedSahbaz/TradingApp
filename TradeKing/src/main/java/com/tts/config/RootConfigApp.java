package com.tts.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.tts.config.ServiceConfigApp;

@Configuration
@Import(ServiceConfigApp.class)
public class RootConfigApp {

}
