package com.wnxy.hospital.mims.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.pagehelper.PageHelper;
import com.wnxy.hospital.mims.realm.MyRealm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

//配置类(本地路径映射，新增继承)
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
	@Bean
	public WebMvcConfigurer WebMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// 映射路径
				// 主页相关
				registry.addViewController("/").setViewName("/index/index.html");
				registry.addViewController("/index.html").setViewName("/index/index.html");
				registry.addViewController("/top.html").setViewName("/index/top.html");
				registry.addViewController("/menu.html").setViewName("/index/menu.html");
				registry.addViewController("/content.html").setViewName("/index/content.html");
				registry.addViewController("/password.html").setViewName("/index/password.html");

				//后台相关
				registry.addViewController("/login").setViewName("/backstage/login.html");
				
				//药库
				registry.addViewController("/st_selout").setViewName("/st_selout.html");
				registry.addViewController("/st_selin").setViewName("/st_selin.html");
				registry.addViewController("/st_baobiao").setViewName("/st_baobiao.html");

				// 门诊入口
				registry.addViewController("/op_registry.html").setViewName("/op_registry.html");// 挂号
				registry.addViewController("/op_newCard.html").setViewName("/op_newCard.html");// 办卡
				registry.addViewController("/op_rebondCard.html").setViewName("/op_rebondCard.html");// 就诊卡挂失
				registry.addViewController("/op_selectOpRegistryByCondition.html").setViewName("/op_selectOpRegistryByCondition.html");// 多条件模糊查挂号单
				registry.addViewController("/op_newOffice.html").setViewName("/op_newOffice.html");//添加部门
				registry.addViewController("/op_newDep.html").setViewName("/op_newDep.html");//添加科室
				registry.addViewController("/op_officeAlter.html").setViewName("/op_officeAlter.html");
				
				



			}
			// 拦截器，暂无使用
			/*
			 * @Override public void addInterceptors(InterceptorRegistry registry) { // 拦截器
			 * registry.addInterceptor(new Interceptor())
			 * .addPathPatterns("/**").excludePathPatterns("/login.html",
			 * "/login","/css/**","/js/**"); }
			 */
		};
	}
	
	//照片路径映射D:/img/empphoto/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/empphoto/**").addResourceLocations("file:D:/img/empphoto/");
    }
	
	/*
	 * 注册MyBatis分页插件PageHelper
	 */
	//PageHelper配置bean
	@Bean
	public PageHelper getPageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);

		return pageHelper;
	}
	//shiro配置
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(
			DefaultWebSecurityManager defaultWebSecurityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		//设置拦截信息
		Map<String, String> filterMap=new HashMap<String, String>();
		filterMap.put("/css/**", "anon");//静态资源
		filterMap.put("/js/**", "anon");//静态资源
		filterMap.put("/fonts/**", "anon");//静态资源
		filterMap.put("/img/**", "anon");//静态资源
		filterMap.put("/login", "anon");//登录页面
		filterMap.put("/loginsubmit", "anon");//登录提交
		filterMap.put("/logout", "logout");//退出
		filterMap.put("/**", "authc");

		shiroFilterFactoryBean.setLoginUrl("/login");//拦截跳转登录页面
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	@Bean//安全管理器
	public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(myRealm);
		return defaultWebSecurityManager;
	}
	@Bean//自己的realm
	public MyRealm myRealm(CacheManager cacheManager,HashedCredentialsMatcher credentialsMatcher) {
		MyRealm myRealm=new MyRealm();
		myRealm.setCacheManager(cacheManager);
		myRealm.setCredentialsMatcher(credentialsMatcher);
		return myRealm;
	}
	@Bean//缓存
	public MemoryConstrainedCacheManager cacheManager() {
		return new MemoryConstrainedCacheManager();
	}
	@Bean//凭证匹配器
	public HashedCredentialsMatcher credentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
		credentialsMatcher.setHashIterations(2);
		credentialsMatcher.setHashAlgorithmName("MD5");
		return credentialsMatcher;
	}
	@Bean//权限标签
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
}
