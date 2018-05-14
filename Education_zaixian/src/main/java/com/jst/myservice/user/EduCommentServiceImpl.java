package com.jst.myservice.user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.user.EduCommentMapper;
import com.jst.model.EduComment;

@Service
public class EduCommentServiceImpl implements EduCommentService{
    @Autowired
	private EduCommentMapper eduCommentMapper;
	@Override
	public List<EduComment> listAll(int edqcid) {
		List<EduComment> list=eduCommentMapper.listAll(edqcid);
		return list;
	}

	@Override
	public void delete(int ecid) {
		eduCommentMapper.delete(ecid);
		
	}
    
   
}
