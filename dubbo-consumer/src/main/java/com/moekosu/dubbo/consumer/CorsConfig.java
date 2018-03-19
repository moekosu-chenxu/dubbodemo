package com.moekosu.dubbo.consumer;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Cors配置，即控制跨域请求配置
 * @author chenxu
 * @date 2018/03
 */
//@EnableWebMvc
//@Configuration
//@ComponentScan
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许的origin
                .allowedMethods("GET", "POST") // 允许的请求方式
                .allowCredentials(true) // 允许发送cookie
                .maxAge(3600); // 请求预检的有效期(预检：复杂请求的时候会先检查一遍
    }
}
