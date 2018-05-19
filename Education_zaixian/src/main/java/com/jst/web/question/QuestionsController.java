package com.jst.web.question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jst.mapper.question.QuestionsTagMapper;
import com.jst.model.Questions;
import com.jst.model.QuestionsTag;
import com.jst.myservice.question.QuestionsService;
import com.jst.myservice.question.QuestionsTagService;

@Controller
@RequestMapping("/admin/questions")
public class QuestionsController {

	@Autowired
	private QuestionsService questionsService;
	@Autowired
    private QuestionsTagMapper questionsTagMapper;
	@Autowired
    private QuestionsTagService questionsTagService;
	/*
	 * 查询
	 */
	@RequestMapping("/list")
	public ModelAndView ListQuestions(@RequestParam(required=true,defaultValue="1")Integer page,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		PageHelper.startPage(page,5);
		Map map=new HashMap<>();
		map=initMap(request, map);
		List<Questions> listQuestions=questionsService.listAll(map);
//		问答标签查询
		List< QuestionsTag> listTag=questionsTagMapper.listAll();
		mv.addObject("listTag", listTag);
		PageInfo<Questions> p = new PageInfo<Questions>(listQuestions);
		mv.addObject("page", p);
//		问答类型查询
		/*List<Questions> listType=questionsService.listType();*/
		mv.addObject("listQuestions", listQuestions);
		/*mv.addObject("listType", listType);*/
		mv.setViewName("/manager/QuestionsList");
		return mv;
	}
    
	/*
	 * 模糊查询 封装map
	 */
	public Map initMap(HttpServletRequest request,Map map) {
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String tag=request.getParameter("tag");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		if (type!=null&&!type.equals("-1")&&type.length()>0) {
			map.put("type", type);
		}
		if (tag!=null&&!tag.equals("-1")&&tag.length()>0) {
			map.put("tag", tag);
		}
		if (start!=null&&start.length()>0) {
			map.put("start", start);
		}
		if (end!=null&&end.length()>0) {
			map.put("end", end);
		}
		map.put("title", title);
		
		return map;
	}

	/*
	 * 删除
	 */
	@RequestMapping("/delQuestions")
	public String deleteQuestions(int qid) {
		questionsService.delete(qid);
		return "redirect:/admin/questions/list";
	}
	/*
	 * 修改文本框赋值
	 */
	@RequestMapping("/toupdate")
	public ModelAndView toupdate(int qid) {
		ModelAndView mv=new ModelAndView();
		Questions questions=questionsService.getById(qid);
		mv.addObject("questions", questions);
		mv.setViewName("/manager/QuestionsEdit");
		return mv;
	}
	/*
	 * 修改
	 */
	@RequestMapping("/updQuestions")
	public String updateQuestions(Questions questions) {
		System.out.println(questions);
		questionsService.update(questions);
		return "redirect:/admin/questions/list";
	}
}
