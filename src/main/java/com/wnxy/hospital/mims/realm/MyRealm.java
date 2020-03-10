package com.wnxy.hospital.mims.realm;


import java.util.Collection;

import javax.annotation.Resource;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.ApplicationContext;

import com.wnxy.hospital.mims.service.Sys_LogService;

import lombok.Setter;

public class MyRealm extends AuthorizingRealm{
	@Resource
	@Setter private ApplicationContext ac;
	@Resource
	private Sys_LogService Sys_LogService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//检索权限
		Collection<String> permissions = Sys_LogService.selectAuth(principals.toString());
		System.out.println("查询权限为："+permissions);
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(permissions);
		return authorizationInfo;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 返回认证信息
		//获取用户输入的账号
		Object principal = token.getPrincipal();
		//账号数据库查询看是否存在
		Sys_LogService logService =(Sys_LogService) ac.getBean("sys_LogServiceImpl");
		try {
			//检索数据库，判断账号是否存在，不存在抛异常
			//UserPsd userPsd = logService.selectUser(principal.toString());
			//String credentials =userPsd.getUserPassword();
			//盐
			ByteSource salt=ByteSource.Util.bytes("m");
			//账号存在
			
				//屏蔽数据库密码验证，临时使用
				String credentials =new String(((UsernamePasswordToken)token).getPassword());
				credentials= new SimpleHash("MD5",credentials,"m",2).toString();
				
			SimpleAuthenticationInfo authenticationInfo=
					new SimpleAuthenticationInfo(principal, credentials,salt, this.getName());
			return authenticationInfo;
		} catch (Exception e) {
			//账号不存在
			return null;
		}
	}
}
