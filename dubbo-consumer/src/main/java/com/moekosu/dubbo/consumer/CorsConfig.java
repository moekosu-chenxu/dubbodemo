package com.moekosu.dubbo.consumer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器
 * Created by moekosu on 2018/3/11.
 */
//@EnableWebMvc
//@Configuration
//@ComponentScan
public class CorsConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry)
	{
		registry.addMapping("**")
				.allowedOrigins("**")
				.allowedMethods("GET", "POST")
				.allowCredentials(false).maxAge(3600);
	}

}
