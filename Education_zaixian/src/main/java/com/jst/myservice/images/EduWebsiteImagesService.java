package com.jst.myservice.images;

import java.util.List;
import java.util.Map;

import com.jst.model.Edu_Website_Images;

public interface EduWebsiteImagesService {

	public void save(Edu_Website_Images edu_Website_Images);
	public void update(Edu_Website_Images edu_Website_Images);
	public void delete(int image_id);
	public Edu_Website_Images getById(int image_id);
	public List<Edu_Website_Images>listAll(Map map);
	public void deleteAll(Integer[] chk_value);
	public List<Edu_Website_Images>WebListAll();
	public void showsEdit(Edu_Website_Images edu_Website_Images);
}
