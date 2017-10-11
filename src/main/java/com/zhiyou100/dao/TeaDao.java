package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Tea;
import com.zhiyou100.vo.TeaQueryVo;

public interface TeaDao {

	
	void addTea(Tea tea);
	
	List<Tea> listTea(TeaQueryVo teaQueryVo);
	
	List<Tea> listTeaByRankDesc(TeaQueryVo teaQueryVo);  // 品级降序
	
	List<Tea> listTeaByRank(TeaQueryVo teaQueryVo);
	
	List<Tea> listTeaByCreateTimeDesc(TeaQueryVo teaQueryVo);  // 时间降序
	
	List<Tea> listTeaByCreateTime(TeaQueryVo teaQueryVo);
	
	int countByRank(String rank);
	
	int getPageCount();
}
