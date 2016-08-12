package com.test.me;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.web.servlet.view.InternalResourceViewResolver;


import javax.sql.DataSource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jingbo.lin on 2016/7/25.
 */
@Configuration
@EnableWebMvc
@ComponentScan(useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class})
})
//@EnableAspectJAutoProxy
public class WebConfig extends WebMvcConfigurerAdapter{


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/favicon.ico").addResourceLocations("/resources/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
		configurer.mediaType("json", MediaType.valueOf("application/json"));
		configurer.mediaType("xml",MediaType.valueOf("application/xml"));
		configurer.mediaType("html",MediaType.valueOf("text/html"));
		configurer.mediaType("*",MediaType.valueOf("*/*"));
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		List<MediaType> list = new ArrayList<MediaType>();
		list.add(new MediaType("text","plain",Charset.forName("UTF-8")));
		list.add(new MediaType("*","*",Charset.forName("UTF-8")));
		stringConverter.setSupportedMediaTypes(list);

		FastJsonHttpMessageConverter jsonConverter = new FastJsonHttpMessageConverter();
		List<MediaType> jsonList = new ArrayList<MediaType>();
		jsonList.add(MediaType.valueOf("application/json;charset=UTF-8"));
		jsonList.add(MediaType.valueOf("text/plain;charset=utf-8"));
		jsonList.add(MediaType.valueOf("text/html;charset=utf-8"));
		jsonConverter.setSupportedMediaTypes(jsonList);
		jsonConverter.setFeatures(new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat});

		converters.add(stringConverter);
		converters.add(jsonConverter);
	}

	@Bean
	public ViewResolver viewResolver(){

		//ResourceResolver resourceResolver = new PathResourceResolver();
		//resourceResolver.resolveUrlPath("/WEB-INF/js/",null,null);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}



}
