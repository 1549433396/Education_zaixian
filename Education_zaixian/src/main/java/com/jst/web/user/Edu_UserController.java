package com.jst.web.user;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.model.Edu_User;
import com.jst.model.Questions;
import com.jst.myservice.user.Edu_UserService;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

@Controller
@RequestMapping("/admin/user")
public class Edu_UserController {
	
	@Autowired
	private Edu_UserService eduUserService;   
	/*
	 * 查询
	 */
	@RequestMapping("/getuserList")
	public ModelAndView ListEduUser(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		PageHelper.startPage(page,5);
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<Edu_User> listEduUser=eduUserService.listAll(map);
		PageInfo<Edu_User> p = new PageInfo<Edu_User>(listEduUser);
		mv.addObject("listEduUser", listEduUser);
		mv.setViewName("EduUserList");
		return mv;
	}

	/*
	 * 模糊查询封装map 
	 */
	public Map initMap(HttpServletRequest request,Map map) {
		String  eduname=request.getParameter("eduname");
		String  isavalible=request.getParameter("isavalible");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		if (isavalible==null) {
			isavalible="-1";
		}
		if (start!=null&&start.length()>0) {
			map.put("start", start);
		}
		if (end!=null&&end.length()>0) {
			map.put("end", end);
		}
		map.put("isavalible", Integer.valueOf(isavalible));
		if (eduname!=null && eduname.length()>0) {
			map.put("eduname", eduname);
		}

		return map;
	}
	/*
	 * 修改密码
	 */
	@RequestMapping("/updatepwd")
	@ResponseBody
	public int updatepwd(@RequestParam int user_id,@RequestParam String pwd) {
		//		System.out.println(user_id);
		//		System.out.println(pwd);
		Map map=new HashMap<>();
		map.put("user_id", user_id);
		map.put("pwd", pwd);
		eduUserService.update(map);
		return 1;
	}

	/*
	 * 冻结
	 */
	@RequestMapping("/Frozen")
	@ResponseBody
	public int Frozen(@RequestParam int user_id,@RequestParam int is_avalible) {
		/*  System.out.println(user_id);
        System.out.println(is_avalible);*/
		Map map=new HashMap<>();
		map.put("user_id", user_id);
		if (is_avalible==2) {
			map.put("is_avalible", 1);
		}else {
			map.put("is_avalible", 2);
		}
		eduUserService.updateFozen(map); 
		return 1;
	}



	
	@RequestMapping("/toBatchOpen")
	public String toExcel(){
		return "EduOpenUp";
	}

	@RequestMapping("/parseExcel")
	public String parseExcel(@RequestParam("file")MultipartFile file,HttpServletRequest request,Edu_User eduUser)throws Exception{

		//创建输入流  
		InputStream stream =file.getInputStream();  
		//获取Excel文件对象  
		Workbook  rwb = Workbook.getWorkbook(stream);  
		//获取文件的指定工作表 默认的第一个  
		Sheet sheet = rwb.getSheet(0);    
		//行数(表头的目录不需要，从1开始)  
//				List<EduUser> list=new ArrayList<>();
//		System.out.println(sheet.getRows());
//		System.out.println(sheet.getColumns());
		for(int i=2; i<sheet.getRows(); i++){  
			//创建一个数组 用来存储每一列的值  
			String[] str = new String[sheet.getColumns()];  
			Cell cell = null;  
			//列数  
			for(int j=0; j<sheet.getColumns(); j++){  
				//获取第i行，第j列的值  
				cell = sheet.getCell(j,i);      
				str[j] = cell.getContents();  
//								System.out.print(str[j]+" ");
//				if(str[j]==null||str[j].equals("")){
//					break;
//				}
				if(j==0){
					eduUser.setMobile(str[j]);
				}
				if (j==1) {
					eduUser.setEmail(str[j]);
				}
				if (j==2) {
					eduUser.setPassword(str[j]);
				}
				if (j==3) {
					eduUser.setUser_name(str[j]);
				}
				if (j==4) {
					eduUser.setShow_name(str[j]);
				}
				if (j==5) {
					if (str[j].equals("男")) {
						eduUser.setSex(0);
					}else{
						eduUser.setSex(1);
					}
				}
				if (j==6) {
					eduUser.setAge(Integer.valueOf(str[j]));
				}
				if (j==7) {
					/*//获取当前单元格对象
					CellType ct=cell.getType();
					String creatTime=null;
					if (ct.equals(CellType.DATE)) {  
						//日期 类型的处理 ，如果不处理的话，读取的时候表格中的2014-03-25 会读取成14-03-25
						DateCell dc = (DateCell) cell; 					
						Date jxlDate = dc.getDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());  
						sdf.setTimeZone(TimeZone.getTimeZone("GMT")); 
						creatTime=sdf.format(jxlDate);
						TimeZone loca=TimeZone.getDefault();
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date=sdf.parse(creatTime);
						eduUser.setCreate_time(date);
					}*/
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					eduUser.setCreate_time(sdf1.parse(str[j]));
				}
				   
				if (j==8) {
					if (str[j].equals("正常")) {
						eduUser.setIs_avalible(1);
					}else{
						eduUser.setIs_avalible(2);
					}
				}
				if (j==9) {
					eduUser.setPic_img(str[j]);
				}
				if (j==10) {
					eduUser.setBanner_url(str[j]);
				}
			}
			/*Date date=new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String lasttime=sdf1.format(date);*/
			eduUser.setLast_system_time(new Date());
//			System.out.println("===eduUser"+eduUser);
			eduUserService.save(eduUser);
			System.out.println("");
		}  
		
		return "redirect:/admin/user/getuserList";
	}


}
