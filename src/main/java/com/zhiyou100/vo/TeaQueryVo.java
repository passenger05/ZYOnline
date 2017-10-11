package com.zhiyou100.vo;

import com.zhiyou100.model.Tea;

public class TeaQueryVo extends PageVo {

	private Tea tea;
	
	public TeaQueryVo() {
		super();
	}

	public TeaQueryVo(Tea tea) {
		super();
		this.tea = tea;
	}

	@Override
	public String toString() {
		return "TeaQueryVo [tea=" + tea + "]";
	}

	public Tea getTea() {
		return tea;
	}

	public void setTea(Tea tea) {
		this.tea = tea;
	}
	
	
	
}
