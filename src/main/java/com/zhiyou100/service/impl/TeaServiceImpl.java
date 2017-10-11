package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.TeaDao;
import com.zhiyou100.model.Tea;
import com.zhiyou100.service.TeaService;
import com.zhiyou100.util.PageInfo;
import com.zhiyou100.util.RankUitl;
import com.zhiyou100.vo.TeaQueryVo;

@Service
public class TeaServiceImpl implements TeaService {
	
	@Autowired
	private TeaDao dao;
	

	public float[] addTea(Tea tea) {
		
		float[] similarity = new float[]{};
		
		dao.addTea(tea);
		
		float[] a = {tea.getShape(),tea.getColor(),tea.getPurity(),tea.getLiquorColor(),tea.getAroma(),tea.getTaste(),tea.getLeaf()};
		
		similarity = RankUitl.Ranks(a);
		
		return similarity;
	}

	public PageInfo<Tea> listTea(TeaQueryVo teaQueryVo) {
		
		// 对应的页码
		int pageIndex = teaQueryVo.getPageIndex();


		int m = dao.getPageCount();
		int n = teaQueryVo.getPageSize();

		// 总页数
		int pageCount = (m + n - 1) / n;

		// 如果查询的页数大于总页数，那么查询最后一页内容
		if (pageIndex > pageCount) {

			pageIndex = pageCount;

			teaQueryVo.setPageIndex(pageIndex);
		}

		// 当前页的内容
		List<Tea> data = dao.listTea(teaQueryVo);

		// 把上面三个数据封装在 pageInfo 对象中
		PageInfo<Tea> pageInfo = new PageInfo<Tea>(pageIndex, pageCount, data);

		return pageInfo;
		
	}

	public PageInfo<Tea> listTeaByRank(boolean desc, TeaQueryVo teaQueryVo) {

		List<Tea> data = null;

		if (desc) {
			data = dao.listTeaByRankDesc(teaQueryVo);
		}else {
			data = dao.listTeaByRank(teaQueryVo);
		}
		
		PageInfo<Tea> pageInfo = listTea(teaQueryVo);
		
		pageInfo.setData(data);

		return pageInfo;
	}

	public PageInfo<Tea> listTeaByCreateTime(boolean desc, TeaQueryVo teaQueryVo) {


		List<Tea> data = null;

		if (desc) {
			data = dao.listTeaByCreateTimeDesc(teaQueryVo);
		}else {
			data = dao.listTeaByCreateTime(teaQueryVo);
		}

		PageInfo<Tea> pageInfo = listTea(teaQueryVo);

		pageInfo.setData(data);

		return pageInfo;
	}

	public int countByRank(String rank) {
		
		return dao.countByRank(rank);
	}

	public String getRank(Tea tea) {
		
		return tea.getRank();
	}

	public int[] count() {
		
		int a1 = dao.countByRank("特一级");
		int a2 = dao.countByRank("特二级");
		int a3 = dao.countByRank("特三级");
		int a4 = dao.countByRank("一级");
		int a5 = dao.countByRank("二级");
		int a6 = dao.countByRank("三级");
		int a7 = dao.countByRank("四级");
		
		int[] al = new int[]{a1,a2,a3,a4,a5,a6,a7};
		
		return al;
	}

}
