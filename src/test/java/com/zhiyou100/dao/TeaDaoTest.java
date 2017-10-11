package com.zhiyou100.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.model.Tea;
import com.zhiyou100.vo.TeaQueryVo;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class TeaDaoTest {
	
	@Autowired
	private TeaDao dao;

	@Test
	public void testAddTea() {
		
		Tea tea = new Tea(1f,1f,1f,1f,1f,1f,1f);
		
		dao.addTea(tea);
		
	}

	@Test
	public void testListTea() {
		
		TeaQueryVo teaQueryVo = new TeaQueryVo();
		
		teaQueryVo.setPageIndex(3);
		teaQueryVo.setPageSize(7);
	
		List<Tea> list = dao.listTea(teaQueryVo);
		
		for (Tea tea : list) {
			
			System.out.println(tea);
		}
	
	}

	@Test
	public void testListTeaByRank() {
		
		TeaQueryVo teaQueryVo = new TeaQueryVo();

		teaQueryVo.setPageIndex(1);
		teaQueryVo.setPageSize(7);

		List<Tea> list = dao.listTeaByRank(teaQueryVo);

		for (Tea tea : list) {

			System.out.println(tea);
		}
		
	}
	
	@Test
	public void testListTeaByRankDesc() {
		
		TeaQueryVo teaQueryVo = new TeaQueryVo();

		teaQueryVo.setPageIndex(1);
		teaQueryVo.setPageSize(7);

		List<Tea> list = dao.listTeaByRankDesc(teaQueryVo);

		for (Tea tea : list) {

			System.out.println(tea);
		}
		
	}

	@Test
	public void testListTeaByCreateTimeDesc() {
		
		TeaQueryVo teaQueryVo = new TeaQueryVo();

		teaQueryVo.setPageIndex(3);
		teaQueryVo.setPageSize(7);

		List<Tea> list = dao.listTeaByCreateTimeDesc(teaQueryVo);

		for (Tea tea : list) {

			System.out.println(tea);
		}
	}
	
	@Test
	public void testListTeaByCreateTime() {

		TeaQueryVo teaQueryVo = new TeaQueryVo();

		teaQueryVo.setPageIndex(3);
		teaQueryVo.setPageSize(7);

		List<Tea> list = dao.listTeaByCreateTime(teaQueryVo);

		for (Tea tea : list) {

			System.out.println(tea);
		}
	
	}
	
	

	@Test
	public void testCountByRank() {
		
		int i = dao.countByRank("特一级");
		
		System.out.println(i);
	}

}
