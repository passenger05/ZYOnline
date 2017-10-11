package com.zhiyou100.service;

import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.model.Tea;
import com.zhiyou100.util.PageInfo;
import com.zhiyou100.vo.TeaQueryVo;

public interface TeaService {
	
	/**
	 * 
	 * @param tea
	 * @return 返回一个随机数（茶叶品级相似度）
	 */
	float[] addTea(Tea tea);
	
	PageInfo<Tea> listTea(TeaQueryVo teaQueryVo);
	
	/**
	 * 
	 * @param desc  是否降序， true代表降序，false 代表升序
	 * @return
	 */
	PageInfo<Tea> listTeaByRank(boolean desc,TeaQueryVo teaQueryVo);
	
	PageInfo<Tea> listTeaByCreateTime(boolean desc,TeaQueryVo teaQueryVo);
	
	int countByRank(String rank);
	
	String getRank(Tea tea);
	
	int[] count();
	
}
