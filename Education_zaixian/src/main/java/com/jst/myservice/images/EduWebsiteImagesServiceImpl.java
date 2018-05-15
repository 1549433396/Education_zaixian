package com.jst.myservice.images;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.images.EduWebsiteImagesMapper;
import com.jst.model.Edu_Website_Images;

@Service
public class EduWebsiteImagesServiceImpl implements EduWebsiteImagesService{

	@Autowired
	private EduWebsiteImagesMapper eduWebsiteImagesMapper;

	@Override
	public void save(Edu_Website_Images edu_Website_Images) {
		eduWebsiteImagesMapper.save(edu_Website_Images);
	}

	@Override
	public void update(Edu_Website_Images edu_Website_Images) {
		eduWebsiteImagesMapper.update(edu_Website_Images);
	}

	@Override
	public void delete(int image_id) {
		eduWebsiteImagesMapper.delete(image_id);
	}

	@Override
	public Edu_Website_Images getById(int image_id) {
		Edu_Website_Images edu_Website_Images=eduWebsiteImagesMapper.getById(image_id);
		return edu_Website_Images;
	}

	@Override
	public List<Edu_Website_Images> listAll(Map map) {
		List<Edu_Website_Images> listAll=eduWebsiteImagesMapper.listAll(map);
		return listAll;
	}

	@Override
	public void deleteAll(Integer[] chk_value) {
		eduWebsiteImagesMapper.deleteAll(chk_value);
	}

	@Override
	public List<Edu_Website_Images> WebListAll() {
		List<Edu_Website_Images> listAll=eduWebsiteImagesMapper.WebListAll();
		return listAll;
	}

	@Override
	public void showsEdit(Edu_Website_Images edu_Website_Images) {
		eduWebsiteImagesMapper.showsEdit(edu_Website_Images);
	}
}
