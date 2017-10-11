package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Brand;

public interface BrandService {

	void addNumber(Long id);
	
	List<Brand> listBrand();
	
	List<Brand> listBrandByNumber();
	
}
