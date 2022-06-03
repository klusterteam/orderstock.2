package com.kluster.orderstock_2.member.domain;

public class Member {
	private int memberIdx;
	private String memberName;
	private String memberId;
	private String memberEmail;
	private String memberPhone;
	private String memberNickname;
	
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	@Override
	public String toString() {
		return "Member [memberIdx=" + memberIdx + ", memberName=" + memberName + ", memberId=" + memberId
				+ ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone + ", memberNickname=" + memberNickname
				+ "]";
	}
	
	

}
