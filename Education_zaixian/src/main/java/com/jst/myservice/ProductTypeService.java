package com.jst.myservice;

import java.util.List;

public interface ProductTypeService {
	
	public ProductTypeService getById(int id);
	List<ProductTypeService> listAll();
	void delete(int id);
	void save(ProductTypeService pType);
	void update(ProductTypeService pType);

}
