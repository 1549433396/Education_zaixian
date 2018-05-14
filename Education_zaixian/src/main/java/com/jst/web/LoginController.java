package com.jst.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Sys_role;
import com.jst.model.Sys_user;
import com.jst.myservice.LoginService;
import com.jst.myservice.RoleService;
import com.jst.utils.MD5Utils;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService user;
	@Autowired
	private RoleService role;

	@RequestMapping("/admin/login")
	public String login(String uname, String upwd,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(uname,MD5Utils.md5(upwd));
		try{
			subject.login(token);
			return "redirect:/admin/role";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("errorMsg", "用户或密码错误！");
			return "redirect:/admin/index";
		}
	}
	//pagehelp鍒嗛〉
	@RequestMapping("/admin/sysuser/userlist")
	public String allList(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model md) {
		PageHelper.startPage(page, 2);
		Map map = newMap(request);
		List<Sys_user> list = user.listAll(map);
		PageInfo<Sys_user> p = new PageInfo<Sys_user>(list);
		md.addAttribute("page", p);
		md.addAttribute("users", list);
		return "/manager/Users";
	}
	@RequestMapping("/admin/index")
	public String toLoginIndex() {
		return "/manager/login";
	}
	
//	@RequestMapping("/allList")
//	public ModelAndView allList(HttpServletRequest request) {
//		Map map = newMap(request);
//		//鏌ュ嚭鎬婚〉鏁�
//		int pageTotle = user.listAllRows();
//		//鍏辨湁澶氬皯椤�
//		int page = pageTotle%2==0?pageTotle/2:pageTotle/2+1;
//		ModelAndView md = new ModelAndView();
//		md.setViewName("Users");
//		md.addObject("page", page);
//		md.addObject("users", user.listAll(map));
//		return md;
//	}
	
	private Map newMap(HttpServletRequest request) {
		Map map = new HashMap<>();
//	 	String currentPage = request.getParameter("currentPage");
//	 	System.out.println(currentPage);
//	 	if (currentPage == null) {
//			currentPage = "1";
//		}
//	 	request.setAttribute("curentPage",currentPage);
//	 	int current = Integer.parseInt(currentPage);
//	 	map.put("currentPage", (current-1)*2);
//	 	map.put("pagerows", 2);
		return map;
	}
 
	@RequestMapping("/admin/toUserAdd")
	public ModelAndView toUserAdd() {
		return new ModelAndView("/manager/userAdd","roles",role.allRole());
	}
	
	@RequestMapping("/admin/sysuser/createuser")
	public String user_Add(Sys_user users){
		users.setLogin_pwd(MD5Utils.md5(users.getLogin_pwd()));
		users.setCreate_time(new Date());
		user.addUser(users);
		return "redirect:/admin/sysuser/userlist";
	}
	@RequestMapping("/admin/user_delete/{uid}")
	public String deleteById(@PathVariable(value = "uid")int uid) {
		
		user.deleteById(uid);
		return "redirect:/admin/sysuser/userlist";
	}
	
	@RequestMapping("/admin/user_edit/{uid}")
	public String selectUserById(@PathVariable(value = "uid")int uid,Model md) {
		Sys_user users = user.selectUserById(uid);
		List<Sys_role> roles = role.allRole();
		md.addAttribute("user",users);
		md.addAttribute("roles",roles);
		return "/manager/user_Edit";
	}
//	
	@RequestMapping("/admin/user_Edit")
	public String user_Edit(Sys_user users) {
		users.setLogin_pwd(MD5Utils.md5(users.getLogin_pwd()));
		user.updateUser(users);
		return "redirect:/admin/sysuser/userlist";
	}
	
	@RequestMapping("/admin/tologin")
	public String toLogin(){
		return "/manager/login";
	}
	
}
