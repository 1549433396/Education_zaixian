package com.jst.myservice.course;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.course.EduCourseMapper;
import com.jst.model.EduCourse;
import com.jst.model.EduCourseKpoint;
import com.jst.model.EduCourseNote;
import com.jst.model.Edu_course_kpoint;

@Service
public class EduCourseServiceImpl implements EduCourseService {
	@Autowired
	private EduCourseMapper eduCourseMapper;



	@Override
	public List<EduCourse> getAllList(Map map) {
		// TODO Auto-generated method stub
		return eduCourseMapper.getAllList(map);
	}

	@Override
	public int insertCourse(EduCourse eduCourse) {

		return eduCourseMapper.insert(eduCourse);
	}

	@Override
	public void addEduCourseTeacher(Map<String, Integer> map) {
		eduCourseMapper.addE_T(map);

	}

	@Override
	public void deleteCourse(int cid) {
		eduCourseMapper.deleteCourse(cid);
		eduCourseMapper.deleteE_T(cid);

	}

	@Override
	public EduCourse selectById(int cid) {

		return eduCourseMapper.selectByCourseId(cid);
	}

	@Override
	public List<Edu_course_kpoint> queryCourseKpointByCourseId(int courseId) {

		return eduCourseMapper.queryKpoint(courseId);
	}

	@Override
	public Edu_course_kpoint queryCourseKpointById(int kpointId) {

		return eduCourseMapper.queryCourseKpoint(kpointId);
	}

	@Override
	public void updateKpoint(Edu_course_kpoint courseKpoint) {

		eduCourseMapper.updateKpoint(courseKpoint);
	}

	@Override
	public void editCourse(EduCourse educourse) {
		eduCourseMapper.updateCourse(educourse);

	}

	/* (non-Javadoc)
	 * @see com.jst.myservice.course.EduCourseService#editEduCourseTeacher(java.util.Map)
	 *修改课程讲师
	 */
	@Override
	public void editEduCourseTeacher(Map<String, Integer> map) {
		eduCourseMapper.updateTeacher(map);

	}

	@Override
	public void addNote(EduCourseNote eduCourseNote) {
		eduCourseMapper.addNote(eduCourseNote);

	}

	@Override
	public EduCourseNote queryNote(EduCourseNote eduCourseNote) {

		return eduCourseMapper.queryNote(eduCourseNote);
	}

	@Override
	public void updateNote(EduCourseNote eduCourseNote) {
		// TODO Auto-generated method stub
		eduCourseMapper.updateNote(eduCourseNote);
	}

	/* (non-Javadoc)
	 * @see com.jst.myservice.course.EduCourseService#insertKpoint(com.jst.model.Edu_course_kpoint)
	 *插入视频节点
	 */
	@Override
	public void insertKpoint(Edu_course_kpoint edu_course_kpoint) {
		eduCourseMapper.insertKpoint(edu_course_kpoint);

	}

	@Override
	public void deleteKpoint(String ids) {
		// TODO Auto-generated method stub
		if(ids!=null && ids.trim().length()>0){
			if(ids.trim().endsWith(",")){
				ids = ids.trim().substring(0,ids.trim().length()-1);
			}
			eduCourseMapper.deleteKpoint(ids);
		}
	}

	/*@Override
	public EduCourseKpoint selectNodeById(int eid) {

		return eduCourseMapper;
	}*/

}
