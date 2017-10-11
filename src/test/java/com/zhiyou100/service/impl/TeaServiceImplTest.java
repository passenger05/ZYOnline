package com.zhiyou100.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.model.Tea;
import com.zhiyou100.service.TeaService;
import com.zhiyou100.util.PageInfo;
import com.zhiyou100.vo.TeaQueryVo;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TeaServiceImplTest {
	
	@Autowired
	private TeaService service;

	@Test
	public void testAddTea() {
		
		Tea tea = new Tea(1f,0.5f,0.4f,0.4f,0.6f,0.7f,0.8f);
		float[] f = service.addTea(tea);
		
		for (float g : f) {
			System.out.println(g);
		}
	}

	@Test
	public void testListTea() {
		
		TeaQueryVo teaQueryVo = new TeaQueryVo();
		
		teaQueryVo.setPageIndex(1);
		
		teaQueryVo.setPageSize(7);
		
		PageInfo<Tea> info = service.listTea(teaQueryVo);
		
		System.out.println(info);
	}

	@Test
	public void testListTeaByRank() {
		
		TeaQueryVo teaQueryVo = new TeaQueryVo();
		
		teaQueryVo.setPageIndex(1);
		
		teaQueryVo.setPageSize(7);
		
		PageInfo<Tea> info = service.listTeaByRank(true, teaQueryVo);
		
		System.out.println(info);
	}

	@Test
	public void testListTeaByCreateTime() {
		
		TeaQueryVo teaQueryVo = new TeaQueryVo();
		
		teaQueryVo.setPageIndex(1);
		
		teaQueryVo.setPageSize(7);
		
		PageInfo<Tea> info = service.listTeaByCreateTime(false, teaQueryVo);
		
		System.out.println(info);
	}

	@Test
	public void testCountByRank() {
		
		int i = service.countByRank("三级");
		
		System.out.println(i);
		
	}

}
