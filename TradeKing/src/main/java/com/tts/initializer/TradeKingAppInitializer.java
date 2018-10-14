package com.tts.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.tts.config.RootConfigApp;
import com.tts.config.WebMvcConfig;

public class TradeKingAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		
		AnnotationConfigWebApplicationContext webCtx = null, rootCtx = null;
		DispatcherServlet servlet = null;
		ContextLoaderListener listener = null;
		
		webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(WebMvcConfig.class);
		
		rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootConfigApp.class);
		
		listener = new ContextLoaderListener(rootCtx);
		sc.addListener(listener);
		
		servlet = new DispatcherServlet(webCtx);
				
		ServletRegistration.Dynamic register = sc.addServlet("dispatcher", servlet);
		register.addMapping("*.htm");
		register.setLoadOnStartup(2);
		
	}

}
