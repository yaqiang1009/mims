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
				//主页相关
				registry.addViewController("/").setViewName("/index/index.html");
				registry.addViewController("/index.html").setViewName("/index/index.html");
				registry.addViewController("/top.html").setViewName("/index/top.html");
				registry.addViewController("/menu.html").setViewName("/index/menu.html");
				registry.addViewController("/content.html").setViewName("/index/content.html");
				registry.addViewController("/password.html").setViewName("/index/password.html");
				//
				
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
