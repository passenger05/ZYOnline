package com.zhiyou100.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.model.Brand;
import com.zhiyou100.service.BrandService;
import com.zhiyou100.vo.RankVo;
import com.zhiyou100.vo.ResponseVo;

@Controller
public class BrandController {

	@Autowired
	private BrandService service;
	
	@RequestMapping(path="/brand/listBrand",method=RequestMethod.POST)
	public @ResponseBody List<Brand> listBrand() {
		
		return service.listBrand();
	}
	
	@RequestMapping(path="/brand/vote",method=RequestMethod.POST)
	public @ResponseBody List<Brand> vote(@RequestBody HashMap<String,Long> param , HttpSession session) {
		
		Long id = param.get("id");
		
		service.addNumber(id);
		
		return service.listBrand();
	}
	
	@RequestMapping(path="/brand/login",method=RequestMethod.POST)
	public @ResponseBody ResponseVo<String> login(@RequestBody HashMap<String,String> param , HttpSession session) {
		
		String telephone = param.get("telephone");
		
		session.setAttribute("telephone", telephone);
		
		return new ResponseVo<String>(0,"ok","ok");
	}
	
	@RequestMapping(path="/brand/listBrandByNumber",method=RequestMethod.POST)
	public @ResponseBody RankVo listBrandByNumber() {
		
		String[] names = new String[8];
		
		Long[] numbers = new Long[8];
		
		long a = System.currentTimeMillis();
		
		Date nowTime = new Date(a);
		
		RankVo rankvo = new RankVo(names, numbers, nowTime);
		
		List<Brand> list = service.listBrandByNumber();
		
		int i = 0;
		
		for (Brand brand : list) {
			
			names[i] = brand.getName();
			
			numbers[i] = brand.getNumber();
			
			i ++;
		}
		
		return rankvo;
	}
	
}
