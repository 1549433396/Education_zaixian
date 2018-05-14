package com.jst.myservice.course;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.course.SysSubjectMapper;
import com.jst.model.EduTeacher;
import com.jst.model.SysSubject;
@Service
public class SysSubjectServiceImpl implements SysSubjectService {

	@Autowired
	private SysSubjectMapper sysSubjectMapper;
	
	/* (non-Javadoc)
	 * @see com.jst.myservice.course.SysSubjectService#getAllSubject()
	 *��ȡ���е�רҵ
	 *
	 */
	@Override
	public List<SysSubject> getAllSubject() {
		return sysSubjectMapper.getAllSubect();
	}

	/* (non-Javadoc)
	 * @see com.jst.myservice.course.SysSubjectService#gEduTeachers()
	 *��ȡ���н�ʦ����ϸ��Ϣ
	 */
	@Override
	public List<EduTeacher> gEduTeachers() {
		return sysSubjectMapper.getAllList();
	}

	@Override
	public List<SysSubject> getAllSubjects(Map map) {
		
		return sysSubjectMapper.getALLSubject(map);
	}

}
