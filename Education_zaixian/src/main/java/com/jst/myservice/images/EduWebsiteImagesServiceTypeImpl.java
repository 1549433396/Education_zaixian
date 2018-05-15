package com.jst.myservice.images;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.images.EduWebsiteImagesTypeMapper;
import com.jst.model.Edu_Website_Images_Type;

@Service
public class EduWebsiteImagesServiceTypeImpl implements EduWebsiteImagesTypeService{

	@Autowired
	private EduWebsiteImagesTypeMapper eduWebsiteImagesTypeMapper;

	@Override
	public Edu_Website_Images_Type getById(int type_id) {
		Edu_Website_Images_Type edu_Website_Images_Type=eduWebsiteImagesTypeMapper.getById(type_id);
		return edu_Website_Images_Type;
	}

	@Override
	public List<Edu_Website_Images_Type> listAll() {
		List<Edu_Website_Images_Type> listAll=eduWebsiteImagesTypeMapper.listAll();
		return listAll;
	}

	@Override
	public void save(Edu_Website_Images_Type edu_Website_Images_Type) {
		eduWebsiteImagesTypeMapper.save(edu_Website_Images_Type);
	}

	@Override
	public void update(Edu_Website_Images_Type edu_Website_Images_Type) {
		eduWebsiteImagesTypeMapper.update(edu_Website_Images_Type);
	}

	@Override
	public void delete(int type_id) {
		eduWebsiteImagesTypeMapper.delete(type_id);
	}
}
