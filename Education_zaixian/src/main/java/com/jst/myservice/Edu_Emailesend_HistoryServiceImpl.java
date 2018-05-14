package com.jst.myservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.Edu_Emailesend_HistoryMapper;
import com.jst.model.Edu_Emailesend_History;

@Service
public class Edu_Emailesend_HistoryServiceImpl implements Edu_Emailesend_HistoryService{

	@Autowired
	private Edu_Emailesend_HistoryMapper eMapper;
	
	@Override
	public List<Edu_Emailesend_History> list(Map map) {
		List<Edu_Emailesend_History> list = eMapper.list(map);
		return list;
	}

	@Override
	public void save(Edu_Emailesend_History e) {
		eMapper.save(e);
	}

	@Override
	public void delete(int id) {
		eMapper.delete(id);
	}

	@Override
	public void update(Edu_Emailesend_History edu_Emailesend_History) {
		eMapper.update(edu_Emailesend_History);
	}

	@Override
	public Edu_Emailesend_History getById(int id) {
		Edu_Emailesend_History list = eMapper.getById(id);
		return list;
	}
}
