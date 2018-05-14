package com.jst.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.jst.model.Sys_function;
import com.jst.model.Sys_user;
import com.jst.myservice.LoginServiceImpl;
import com.jst.myservice.ServiceImpl;

public class MyRealm extends AuthorizingRealm{
	@Autowired
	private ServiceImpl sImpl;
	@Autowired
	private LoginServiceImpl login;
	//认证方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken mytoken = (UsernamePasswordToken)token;
		String username = mytoken.getUsername();
		//根据用户名查询数据库中的密码
		Sys_user user = login.getUpwd(username);
		System.out.println(user);
		if(user == null){
			//用户名不存在
			return null;
		}
		System.out.println("llala");
		//如果能查询到，再由框架比对数据库中查询到的密码和页面提交的密码是否一致
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLogin_pwd(), this.getName());
		return info;
	}

	//授权方法
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前登录对象
		Sys_user users = (Sys_user)principals.getPrimaryPrincipal();
		//定义了一个存储该用户所有权限的集合
		List<Sys_function> list = null;
		//如果当前登录的是jst用户就直接查询所有权限
//		if (users.getUname().trim().equals("jst")) {
//			list =  sImpl.getList();
//		}else {
			//通过用户的id查询所有的权限
			list =  sImpl.getList(users.getUser_id()).getsRole().getList();
//		}
		for (Sys_function sys_function : list) {
			info.addStringPermission(sys_function.getFunction_name()==null?"1":sys_function.getFunction_name());
		}
		return info;
	}


}
