package com.jst.myservice.images;

import java.util.List;

import com.jst.model.Edu_Website_Images_Type;

public interface EduWebsiteImagesTypeService {

	public Edu_Website_Images_Type getById(int type_id);
	public List<Edu_Website_Images_Type>listAll();
	public void save(Edu_Website_Images_Type edu_Website_Images_Type);
	public void update(Edu_Website_Images_Type edu_Website_Images_Type);
	public void delete(int type_id);

}
