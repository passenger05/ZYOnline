package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.BrandDao;
import com.zhiyou100.model.Brand;
import com.zhiyou100.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao dao;
	
	public void addNumber(Long id) {
		
		dao.addNumber(id);
	}

	public List<Brand> listBrand() {
		
		return dao.listBrand();
	}

	public List<Brand> listBrandByNumber() {
		
		return dao.listBrandByNumber();
	}

}
