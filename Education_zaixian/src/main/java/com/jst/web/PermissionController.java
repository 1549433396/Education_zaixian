package com.jst.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jst.myservice.PermissionServiceImpl;

@Controller
public class PermissionController {

	@Autowired
	private PermissionServiceImpl p;
	
//	@RequestMapping("/permission")
//	public ModelAndView getAllPermission() {
//		ModelAndView md = new ModelAndView("Permission_Add", "permissionList",p.selectAll());
//		return md;
// 	}
	
	@RequestMapping("/admin/sysfunctioin/showfunctionztree")
	public String toPermissionList() {
		return "/manager/permission";
 	}
	
//	@RequestMapping("/permission_Add")
//	public String insertPermission(HttpServletRequest request) {
//		Permission pp = new Permission();
//		pp.setPname(request.getParameter("pname"));
//		pp.setPaddr(request.getParameter("paddr"));
//		int state = Integer.parseInt(request.getParameter("state"));
//		pp.setState(state);
//		pp.setPid(state == 1 ? 0 : Integer.parseInt(request.getParameter("pid")));
//		p.insertPermission(pp);
//		return "redirect:permission.jsp";
// 	}
//	@RequestMapping("/permissionjsp")
//	public ModelAndView getAllPermissions() {
//		ModelAndView md = new ModelAndView("permission", "permissions",p.selectAll());
//		return md;
// 	}
}
