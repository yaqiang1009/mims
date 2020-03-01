package com.wnxy.hospital.mims.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置类
@Configuration
public class MyConfig {
	@Bean
	public WebMvcConfigurer WebMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// 映射路径
				registry.addViewController("/").setViewName("/index.html");
				registry.addViewController("/index.html").setViewName("/index.html");
				registry.addViewController("/index_top.html").setViewName("/index_top.html");
				registry.addViewController("/index_left.html").setViewName("/index_left.html");
				registry.addViewController("/index_right.html").setViewName("/index_right.html");
				registry.addViewController("/login.html").setViewName("/login.html");
			}
			//拦截器，暂无使用
			/*
			 * @Override public void addInterceptors(InterceptorRegistry registry) { // 拦截器
			 * registry.addInterceptor(new Interceptor())
			 * .addPathPatterns("/**").excludePathPatterns("/login.html",
			 * "/login","/css/**","/js/**"); }
			 */
		};
	}
	
	
}
