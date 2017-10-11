package com.zhiyou100.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.model.Tea;
import com.zhiyou100.service.TeaService;
import com.zhiyou100.util.PageInfo;
import com.zhiyou100.vo.ResponseVo;
import com.zhiyou100.vo.TeaQueryVo;

@Controller
public class TeaController {

	@Autowired
	private TeaService service;
	
	
	@RequestMapping(path="/tea/addTea",method=RequestMethod.POST)
	public @ResponseBody ResponseVo<float[]> addTea(@RequestBody Tea tea) {
		
		Tea tea2 = new Tea(tea.getShape(),tea.getColor(),tea.getPurity(),tea.getLiquorColor(),tea.getAroma(),tea.getTaste(),tea.getLeaf());
		
		float[] f = service.addTea(tea2);
		
		String rank = service.getRank(tea2);
		
		return new ResponseVo<float[]>(0, rank, f);
	}
	
	@RequestMapping(path="/tea/listTea",method=RequestMethod.POST)
	public @ResponseBody ResponseVo<PageInfo<Tea>> list(@RequestBody TeaQueryVo vo) {
		
		PageInfo<Tea> pageInfo = service.listTea(vo);
		
		ResponseVo<PageInfo<Tea>> result = new ResponseVo<PageInfo<Tea>>(0, "", pageInfo);
		
		return result;
	}
	
	@RequestMapping(path="/tea/countTea",method=RequestMethod.POST)
	public @ResponseBody int[] count() {
		
		int[] al = service.count();
		
		return al;
	}
	
	@RequestMapping(path="/tea/listTeaByRankup",method=RequestMethod.POST)
	public @ResponseBody ResponseVo<PageInfo<Tea>> listTeaByRankup(@RequestBody TeaQueryVo vo) {
		
		PageInfo<Tea> pageInfo = service.listTeaByRank(true, vo);
		
		ResponseVo<PageInfo<Tea>> result = new ResponseVo<PageInfo<Tea>>(0, "", pageInfo);
		
		return result;
	}

	@RequestMapping(path="/tea/listTeaByRankdown",method=RequestMethod.POST)
	public @ResponseBody ResponseVo<PageInfo<Tea>> listTeaByRankdown(@RequestBody TeaQueryVo vo) {
		
		PageInfo<Tea> pageInfo = service.listTeaByRank(false, vo);
		
		ResponseVo<PageInfo<Tea>> result = new ResponseVo<PageInfo<Tea>>(0, "", pageInfo);
		
		return result;
	}
	
	@RequestMapping(path="/tea/listTeaByTimeup",method=RequestMethod.POST)
	public @ResponseBody ResponseVo<PageInfo<Tea>> listTeaByTimeup(@RequestBody TeaQueryVo vo) {
		
		PageInfo<Tea> pageInfo = service.listTeaByCreateTime(true, vo);
		
		ResponseVo<PageInfo<Tea>> result = new ResponseVo<PageInfo<Tea>>(0, "", pageInfo);
		
		return result;
	}
	
	@RequestMapping(path="/tea/listTeaByTimedown",method=RequestMethod.POST)
	public @ResponseBody ResponseVo<PageInfo<Tea>> listTeaByTimedown(@RequestBody TeaQueryVo vo) {
		
		PageInfo<Tea> pageInfo = service.listTeaByCreateTime(false, vo);
		
		ResponseVo<PageInfo<Tea>> result = new ResponseVo<PageInfo<Tea>>(0, "", pageInfo);
		
		return result;
	}
	
	
}
