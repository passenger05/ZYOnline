package com.zhiyou100.vo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RankVo {
	
	private String[] names ;
	
	private Long[] numbers;

	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" , timezone="Asia/Shanghai")
	private Date nowTime;
	

	public RankVo() {
		super();
	}

	public RankVo(String[] names, Long[] numbers, Date nowTime) {
		super();
		this.names = names;
		this.numbers = numbers;
		this.nowTime = nowTime;
	}

	@Override
	public String toString() {
		return "RankVo [names=" + Arrays.toString(names) + ", numbers=" + Arrays.toString(numbers) + ", NowTime="
				+ nowTime + "]";
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public Long[] getNumbers() {
		return numbers;
	}

	public void setNumbers(Long[] numbers) {
		this.numbers = numbers;
	}

	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

}
