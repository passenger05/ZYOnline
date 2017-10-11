package com.zhiyou100.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhiyou100.util.RankUitl;

public class Tea {
	
	private Long id;
	private Float shape ;
	private Float color ;
	private Float purity ;
	private Float liquorColor ;
	private Float aroma ;
	private Float taste ;
	private Float leaf ;
	private String rank;
	
	
	private Long key;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" , timezone="Asia/Shanghai")
	private Date createTime;
	
	public Tea() {
		super();
	}

	public Tea(Float shape, Float color, Float purity, Float liquorColor, Float aroma, Float taste, Float leaf)
	{
		super();
		this.shape = shape;
		this.color = color;
		this.purity = purity;
		this.liquorColor = liquorColor;
		this.aroma = aroma;
		this.taste = taste;
		this.leaf = leaf;
		this.rank = setRank(shape, color, purity, liquorColor, aroma, taste, leaf);
		this.key = (long) RankUitl.getRank(shape, color, purity, liquorColor, aroma, taste, leaf);
	}
	

	@Override
	public String toString() {
		return "Tea [id=" + id + ", shape=" + shape + ", color=" + color + ", purity=" + purity + ", liquorColor="
				+ liquorColor + ", aroma=" + aroma + ", taste=" + taste + ", leaf=" + leaf + ", rank=" + rank
				+ ", createTime=" + createTime + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getShape() {
		return shape;
	}

	public void setShape(Float shape) {
		this.shape = shape;
	}

	public Float getColor() {
		return color;
	}

	public void setColor(Float color) {
		this.color = color;
	}

	public Float getPurity() {
		return purity;
	}

	public void setPurity(Float purity) {
		this.purity = purity;
	}

	public Float getLiquorColor() {
		return liquorColor;
	}

	public void setLiquorColor(Float liquorColor) {
		this.liquorColor = liquorColor;
	}

	public Float getAroma() {
		return aroma;
	}

	public void setAroma(Float aroma) {
		this.aroma = aroma;
	}

	public Float getTaste() {
		return taste;
	}

	public void setTaste(Float taste) {
		this.taste = taste;
	}

	public Float getLeaf() {
		return leaf;
	}

	public void setLeaf(Float leaf) {
		this.leaf = leaf;
	}

	public String setRank(Float shape, Float color, Float purity, Float liquorColor, Float aroma, Float taste, Float leaf) {
		
		String rank = null;
		
		int big = RankUitl.getRank(shape, color, purity, liquorColor, aroma, taste, leaf);
		
		switch (big) {
		
		case 1:
			rank = "特一级" ;
			break;
		case 2:
			rank = "特二级" ;
			break;
		case 3:
			rank = "特三级";
			break;
		case 4:
			rank = "一级";
			break;
		case 5:
			rank = "二级";
			break;
		case 6:
			rank = "三级";
			break;
		case 7:
			rank = "四级";
			break;

		default:
			break;
		}
		
		return rank;
	}

	public void getRank(String rank) {
		this.rank = rank;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRank() {
		return rank;
	}

	public void setRank() {
		this.rank = setRank(shape, color, purity, liquorColor, aroma, taste, leaf);
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}
	

}
