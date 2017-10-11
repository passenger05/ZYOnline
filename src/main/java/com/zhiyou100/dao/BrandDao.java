package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Brand;

public interface BrandDao {

	void addNumber(Long id);
	
	List<Brand> listBrand();
	
	List<Brand> listBrandByNumber();
}
