package com.kluster.orderstock_2.member.domain;

public class Criteria {

	//현재 페이지 번호
	private int pageNum;
	
	//페이지 표시 개수
	private int amount;
	
	//페이지 skip
	private int skip;
	
	//검색타입
	private String type;
	
	//검색키워드
	private String keyword;
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum - 1)*amount;
	}
	public Criteria() {
		this(1, 10);
	}
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.skip = (pageNum - 1) *this.amount;
	}
	public void setAmount(int amount) {
	    this.amount = amount;
        this.skip = (this.pageNum - 1) * amount;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getAmount() {
		return amount;
	}
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + ", type=" + type
				+ ", keyword=" + keyword + "]";
	}
	
}
