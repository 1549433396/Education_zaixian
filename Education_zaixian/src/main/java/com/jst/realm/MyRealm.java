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
	//��֤����
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken mytoken = (UsernamePasswordToken)token;
		String username = mytoken.getUsername();
		//�����û�����ѯ���ݿ��е�����
		Sys_user user = login.getUpwd(username);
		System.out.println(user);
		if(user == null){
			//�û���������
			return null;
		}
		System.out.println("llala");
		//����ܲ�ѯ�������ɿ�ܱȶ����ݿ��в�ѯ���������ҳ���ύ�������Ƿ�һ��
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLogin_pwd(), this.getName());
		return info;
	}

	//��Ȩ����
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//��ȡ��ǰ��¼����
		Sys_user users = (Sys_user)principals.getPrimaryPrincipal();
		//������һ���洢���û�����Ȩ�޵ļ���
		List<Sys_function> list = null;
		//�����ǰ��¼����jst�û���ֱ�Ӳ�ѯ����Ȩ��
//		if (users.getUname().trim().equals("jst")) {
//			list =  sImpl.getList();
//		}else {
			//ͨ���û���id��ѯ���е�Ȩ��
			list =  sImpl.getList(users.getUser_id()).getsRole().getList();
//		}
		for (Sys_function sys_function : list) {
			info.addStringPermission(sys_function.getFunction_name()==null?"1":sys_function.getFunction_name());
		}
		return info;
	}


}
