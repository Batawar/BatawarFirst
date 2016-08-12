package com.test.me;
import javax.servlet.*;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by jingbo.lin on 2016/7/25.
 */

public class webXML implements WebApplicationInitializer {
	public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("AppConfig","classpath:java/com.test.me/AppConfig.java");

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		rootContext.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(rootContext));



		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebConfig.class);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
		registration.setInitParameter("WebConfig","classpath:java/com.test.me/WebConfig.java");
		registration.setLoadOnStartup(1);
		registration.addMapping("/");


		/*
		WebConfig webConfig = new WebConfig();
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("webconfig", (Servlet) webConfig);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/test.jsp");
		*/
	}
}
