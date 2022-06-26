package com.kluster.orderstock_2.member.domain;

public class MemberCategory {
	
	private int memberCategoryNumberIdx;
	private String memberCategoryName;
	
	public int getMemberCategoryNumberIdx() {
		return memberCategoryNumberIdx;
	}
	public void setMemberCategoryNumberIdx(int memberCategoryNumberIdx) {
		this.memberCategoryNumberIdx = memberCategoryNumberIdx;
	}
	public String getMemberCategoryName() {
		return memberCategoryName;
	}
	public void setMemberCategoryName(String memberCategoryName) {
		this.memberCategoryName = memberCategoryName;
	}
	
	@Override
	public String toString() {
		return "MemberCategory [memberCategoryNumberIdx=" + memberCategoryNumberIdx + ", memberCategoryName="
				+ memberCategoryName + "]";
	}
	
	
}
