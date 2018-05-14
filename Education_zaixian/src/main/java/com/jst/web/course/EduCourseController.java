package com.jst.web.course;

import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jst.model.EduCourse;
import com.jst.model.Edu_course_kpoint;
import com.jst.myservice.course.EduCourseService;
import com.jst.myservice.course.SysSubjectService;
import com.jst.utils.FastDFSClient;
import com.jst.utils.JsonUtils;
import com.jst.utils.Result;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

@Controller
public class EduCourseController {
	@Autowired
	private EduCourseService eduCourseService;

	@Autowired
	private SysSubjectService sysSubjectService;

	@Value("${IMAGE_SERVER}")
	private String IMAGE_SERVER;

	/**
	 * @return
	 * 所有课程列表
	 */
	@RequestMapping("/admin/cou/list")
	public ModelAndView toEduCourse(HttpServletRequest request) {
		ModelAndView md = new ModelAndView();
		Map map = new HashMap();
		map = initMap(request, map);
		md.setViewName("/manager/courseList");
		md.addObject("educourse",eduCourseService.getAllList(map));
		return md;
	}

	private Map initMap(HttpServletRequest request,Map map) {
		String qname = request.getParameter("qname");
		String type = request.getParameter("type");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		System.out.println("开始时间"+start);
		System.out.println("终止时间"+end);
		if (type!=null&&type.trim().length()!=0) {
			int type2 = Integer.parseInt(type);
			request.setAttribute("type",type2);
			map.put("type",type2);
		}
		if (qname!=null&&qname.trim().length()>0) {
			request.setAttribute("qname",qname);
			map.put("qname",qname);
		}

		if (start!=null&&start.trim().length()>0) {
			request.setAttribute("start",start);
			map.put("start",start);
		}
		if (end!=null&&end.trim().length()>0) {
			request.setAttribute("end",end);
			map.put("end",end);
		}
		return map;

	} 

	/**
	 * @return
	 * 去课程添加界面
	 */
	@RequestMapping("/admin/toAddCourse")
	public ModelAndView toAddCourse(){
		ModelAndView md = new ModelAndView();
		md.setViewName("/manager/CourseAdd");
		md.addObject("subjects", sysSubjectService.getAllSubject());
		return md;
	}

	/**
	 * @return
	 * 查询出所有的老师
	 */
	@RequestMapping("/admin/toTeacherList")
	public ModelAndView getAllTeachers() {
		ModelAndView md = new ModelAndView();
		md.setViewName("/manager/teacherList");
		md.addObject("teachers", sysSubjectService.gEduTeachers());
		return md;
	}

	public Map<String, Integer> getMap(HttpServletRequest request) {

		Map<String, Integer> map = new HashMap<>();

		map.put("tid", Integer.parseInt(request.getParameter("teacherId")));
		return map;

	}


	/**
	 * @param request
	 * @param educourse
	 * @param file
	 * @return
	 * @throws Exception
	 * 正式添加课程
	 */
	@RequestMapping(value="/admin/addcourse",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,EduCourse educourse,
			@RequestParam("file") MultipartFile file) throws Exception {
		//上传文件名
		String filename = file.getOriginalFilename();
		educourse.setLogo("/images/upload/course/20150915/"+filename);
		educourse.setAddTime(new Date());
		eduCourseService.insertCourse(educourse);
		Map<String, Integer> map = getMap(request);
		map.put("cid", educourse.getCourseId());
		eduCourseService.addEduCourseTeacher(map);

		//如果文件不为空，写入上传路径
		if(!file.isEmpty()) {
			//上传文件路径
			String path = request.getServletContext().getRealPath("/images/upload/course/20150915/");

			File newfile = new File(path,filename);
			//判断路径是否存在，如果不存在就创建一个
			if (!newfile.exists()) { 
				newfile.createNewFile();
			}
			//将上传文件保存到一个目标文件当中
			file.transferTo(newfile);
			return "redirect:/admin/cou/list";
		} else {
			return "error";
		}

	}

	/**
	 * @param request
	 * @param educourse
	 * @param file
	 * @return 修改课程
	 * @throws Exception
	 */
	@RequestMapping(value="/admin/editcourse",method=RequestMethod.POST)
	public String editCourse(HttpServletRequest request,EduCourse educourse,
			@RequestParam("file") MultipartFile file) throws Exception {
		//上传文件名
		String filename = file.getOriginalFilename();
		educourse.setLogo("/images/upload/course/20150915/"+filename);
		educourse.setUpdateTime(new Date());
		eduCourseService.editCourse(educourse);
		Map<String, Integer> map = getMap(request);
		map.put("cid", educourse.getCourseId());
		eduCourseService.editEduCourseTeacher(map);

		//如果文件不为空，写入上传路径
		if(!file.isEmpty()) {
			//上传文件路径
			String path = request.getServletContext().getRealPath("/images/upload/course/20150915/");

			File newfile = new File(path,filename);
			//判断路径是否存在，如果不存在就创建一个
			if (!newfile.exists()) { 
				newfile.createNewFile();
			}
			//将上传文件保存到一个目标文件当中
			file.transferTo(newfile);
			return "redirect:/admin/cou/list";
		} else {
			return "error";
		}

	}

	/**
	 * @return
	 * 删除课程
	 */
	@RequestMapping("/admin/deleteCourse/{cid}")
	public String deleteCourse(@PathVariable int cid) {
		eduCourseService.deleteCourse(cid);

		return "redirect:/admin/cou/list";
	}


	/**
	 * 查询一个课程
	 * @return
	 */
	@RequestMapping("/admin/selectCourse/{cid}")
	public ModelAndView selectByCid(@PathVariable int cid) {
		ModelAndView md = new ModelAndView();
		md.setViewName("/manager/courseEdit");
		md.addObject("e", eduCourseService.selectById(cid));
		md.addObject("subjects", sysSubjectService.getAllSubject());
		return md;
	}

	@RequestMapping("/admin/toZhangJieManger/{courseId}")
	public ModelAndView getAllEduCourseKpoint(@PathVariable int courseId) {
		ModelAndView md = new ModelAndView("/manager/kpoint_list");
		md.addObject("kpointList",JsonUtils.objectToJson(eduCourseService.queryCourseKpointByCourseId(courseId)));
		return md;
	}
	@RequestMapping("/admin/kpoint/getkpoint/{kpointid}")
	@ResponseBody
	public Result getPoint(@PathVariable int kpointid) {
		return  new Result(true, null, eduCourseService.queryCourseKpointById(kpointid));
	}


	/**
	 * 向fastDfs服务器上传视频
	 * @param multiFile
	 * @return
	 */
	@RequestMapping("/admin/kpoint/uploadVideo")
	@ResponseBody
	public String uploadVideo(@RequestParam("uploadfile")MultipartFile multiFile){
		String url = "";
		Encoder encoder = new Encoder();
//		File file = multiFile.transferTo(dest);
//		//file = File.createTempFile("temp", null);
//		
//		try {
//			MultimediaInfo m = encoder.getInfo();
//			long ls = m.getDuration();
//			System.out.println("此视频时长为:"+ls/60000+"分");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try{
			//fastdfs上传配置 Map map = new HashMap(); 
			FastDFSClient client = new FastDFSClient("classpath:client.conf");
			// 读取配置 
			String filename =multiFile.getOriginalFilename();
			// 获得文件名 
			String extName =filename.substring(filename.indexOf(".") + 1);
			// 从点后面截取 
			url =client.uploadFile(multiFile.getBytes(), extName);
			// 创建文件 
			url=IMAGE_SERVER+url;// 拼接视频地址
			System.out.println(url);
//			File file2=new File(new URI(url))
		}catch(Exception e){
			e.printStackTrace();
		}
		return url;
	}


	/**
	 * 修改视频节点
	 */
	@RequestMapping("/admin/kpoint/updateKpoint")
	@ResponseBody
	public Result updateKpoint(HttpServletRequest request) {
		Edu_course_kpoint edu_course_kpoint = new Edu_course_kpoint();
		edu_course_kpoint.setName(request.getParameter("name"));
		edu_course_kpoint.setSort(Integer.parseInt(request.getParameter("sort")));
		edu_course_kpoint.setFile_type(request.getParameter("fileType"));
		edu_course_kpoint.setContent(request.getParameter("content"));
		edu_course_kpoint.setCourse_id(Integer.parseInt(request.getParameter("courseid")));
		//		视屏地址
		edu_course_kpoint.setVideo_url(request.getParameter("url"));
		edu_course_kpoint.setKpoint_type(Integer.parseInt(request.getParameter("pointtype")));
		edu_course_kpoint.setPlay_count(Integer.parseInt(request.getParameter("playCount")));
		edu_course_kpoint.setKpoint_id(Integer.parseInt(request.getParameter("kpoint_id")));
		//		  'video_type':video_type,
		edu_course_kpoint.setVideo_type(request.getParameter("video_type"));
		edu_course_kpoint.setPlay_time(request.getParameter("time"));
		edu_course_kpoint.setIs_free(Integer.parseInt(request.getParameter("isfree")));
		String teacherid = request.getParameter("teacherId");
		if (teacherid != null&&teacherid.trim().length()>0) {
			edu_course_kpoint.setTeacher_id(Integer.parseInt(teacherid));
		}

		try {
			// 本地tomcat服务器
			//			String filename = mp4.getOriginalFilename();// 获得文件名
			//			String extName = filename.substring(filename.indexOf("."));// 从点后面截取
			//			filename = System.currentTimeMillis() + extName;// 文件名
			//			File file = new File(File_location, filename);
			//			FileUtils.copyInputStreamToFile(mp4.getInputStream(), file);
			//			url = PROJECT + filename;
			//			System.out.println("视频地址为:"+ url);
			// 设置url
			eduCourseService.updateKpoint(edu_course_kpoint);
			Result result = new Result(true, "修改成功！", edu_course_kpoint);
			return result;
		} catch (Exception e) {
			//			this.setAjaxException(json);
			//			logger.error("updateKpoint()---error", e);
			return null;
		}
	}

	/**
	 * @param edu_course_kpoint
	 * @return
	 * 添加一个视频节点
	 */
	@RequestMapping("/admin/kpoint/addkpoint")
	@ResponseBody
	public Result addCoursePoint(Edu_course_kpoint edu_course_kpoint) {
		eduCourseService.insertKpoint(edu_course_kpoint);
		return new Result(true, null, edu_course_kpoint);
	}
	/**
	 * @param ids
	 * @return
	 * 删除一个视屏节点
	 */
	@RequestMapping("/admin/kpoint/deletekpoint/{ids}")
	@ResponseBody
	public Result deleteKpoints(@PathVariable String ids) {

		eduCourseService.deleteKpoint(ids);
		return new Result(true, null, null);
	}

}
