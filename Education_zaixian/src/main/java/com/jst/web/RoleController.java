package com.jst.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Sys_function;
import com.jst.model.Sys_role;
import com.jst.model.Sys_user;
import com.jst.myservice.PermissionService;
import com.jst.myservice.RoleService;
import com.jst.myservice.ServiceDemo;
import com.jst.utils.JsonUtils;

@Controller
public class RoleController {
	@Autowired
	private ServiceDemo sImpl;
	
	@Autowired
	private PermissionService per;
	
	@Autowired
	private RoleService role;

	@Autowired
	private RoleService roleServiceImpl;
	/**
	 * 查询生成菜单的权限json集合
	 * @return
	 */
	@RequestMapping("/admin/role")
	public ModelAndView getPermissonById(@RequestParam(defaultValue="0") int id) {
		Sys_user users = (Sys_user)SecurityUtils.getSubject().getPrincipal();
		List<Sys_function> list = null;
		list = sImpl.getListCaiDan(users.getUser_id()).getsRole().getList();
		ModelAndView md = new ModelAndView("/manager/index", "list", list);
		return md;
	}
	@RequestMapping("/admin/to_RoleAdd")
	public String to_RoleAdd() {
		return "/manager/role_Add";
	}
	
	@RequestMapping("/admin/main")
	public String toMain() {
		return "/manager/main";
	}
	
	@RequestMapping("/admin/roleList")
	public String toRoleList() {
		return "/manager/role_Add";
	}

	@RequestMapping("/admin/roles")
	@ResponseBody
	public List<Sys_function> getPermissonById() {
		List<Sys_function> list =  sImpl.getList();
		return list;
	}

	@RequestMapping("/admin/sysrole/showroleList")
	public String getRole(@RequestParam(required=true,defaultValue="1") Integer page,HttpServletRequest request,Model md) {
		PageHelper.startPage(page, 2);
		List<Sys_role> list = roleServiceImpl.allRole();
		 PageInfo<Sys_role> p = new PageInfo<Sys_role>(list);
		 md.addAttribute("role",list);
		 md.addAttribute("page", p);
		return "/manager/role";
	}

	@RequestMapping("/admin/role_Add")
	public String add_Role(HttpServletRequest request) {
		String perid = request.getParameter("perid");
		String rname = request.getParameter("role_name");
		String[] str = perid.split(",");
		Sys_role sys_role = new Sys_role();
		sys_role.setRole_name(rname);
		sys_role.setCreate_time(new Date());
		roleServiceImpl.Add_Role(sys_role);
		for (String string : str) {
			sys_role.setFunction_id((Integer.parseInt(string)));
			roleServiceImpl.r_p_Add(sys_role);
		}
		return "redirect:/admin/sysrole/showroleList";
	}
	
	@RequestMapping("/admin/sysrole/saveroelfunction/")
	public String edit_Role(HttpServletRequest request) {
		String perid = request.getParameter("perid");
		String rid = request.getParameter("Role_id");
		Map<String,Integer> map = new HashMap<>();
		map.put("old_rid", Integer.parseInt(rid));
		role.deleteById(Integer.parseInt(rid));
		per.deleteById(Integer.parseInt(rid));
		String rname = request.getParameter("Role_name");
		String[] str = perid.split(",");
		Sys_role sys_role = new Sys_role();
		sys_role.setRole_name(rname);
		sys_role.setCreate_time(new Date());
		roleServiceImpl.Add_Role(sys_role);
		map.put("new_rid",sys_role.getRole_id());
		roleServiceImpl.updateUserRid(map);
		for (String string : str) {
			sys_role.setFunction_id((Integer.parseInt(string)));
			roleServiceImpl.r_p_Add(sys_role);
		}
		return "redirect:/admin/sysrole/showroleList";
	}
	
	@RequestMapping("/admin/deleteRole/{rid}")
	public String deleteRole(@PathVariable("rid")int rid) {
		role.deleteById(rid);
		return "redirect:/admin/sysrole/showroleList";
	}
	
	/**
	 * @param rid
	 * @return
	 * 这个只是把要授权的角色id传递到角色修改界面
	 */
	@RequestMapping("/admin/toRoleEdit/{rid}")
	public String toRoleEdit(@PathVariable("rid")int rid,Model md) {
		Sys_role role1 = role.selectRoleById(rid);
		md.addAttribute("rid", role1.getRole_id());
		md.addAttribute("rname",role1.getRole_name());
		md.addAttribute("data",JsonUtils.objectToJson(role1.getList()));
		return "/manager/role_Edit";
	}
	
	/**
	 * @param rid
	 * @return
	 * 这个方法的作用是通过角色id查询出相应的角色权限
	 */
	/*@RequestMapping("/selectRoleById")
	@ResponseBody
	public List<Permission> selectById(HttpServletRequest request) {
		String rid = request.getParameter("rid");
		Role role1 = role.selectRoleById(Integer.parseInt(rid));
		return role1.getList();
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
