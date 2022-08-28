package com.kluster.orderstock_2.login.domain;

import com.kluster.orderstock_2.member.domain.MemberCategory;

public class LoginVO {
	  private int idx;
	    private String memberName;
	    private String memberId;
	    private String memberPassword;
	    private String memberEmail;
	    private String memberPhone;
	    private String memberAddress;
	    private int memberCategoryNumber;
	    private MemberCategory memberCategory;
	    private java.sql.Timestamp memberDeletedAt;
	    private String type;
	    private String keyword;
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
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
		public String getMemberPassword() {
			return memberPassword;
		}
		public void setMemberPassword(String memberPassword) {
			this.memberPassword = memberPassword;
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
		public String getMemberAddress() {
			return memberAddress;
		}
		public void setMemberAddress(String memberAddress) {
			this.memberAddress = memberAddress;
		}
		public int getMemberCategoryNumber() {
			return memberCategoryNumber;
		}
		public void setMemberCategoryNumber(int memberCategoryNumber) {
			this.memberCategoryNumber = memberCategoryNumber;
		}
		public MemberCategory getMemberCategory() {
			return memberCategory;
		}
		public void setMemberCategory(MemberCategory memberCategory) {
			this.memberCategory = memberCategory;
		}
		public java.sql.Timestamp getMemberDeletedAt() {
			return memberDeletedAt;
		}
		public void setMemberDeletedAt(java.sql.Timestamp memberDeletedAt) {
			this.memberDeletedAt = memberDeletedAt;
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
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Amember [idx=");
			builder.append(idx);
			builder.append(", memberName=");
			builder.append(memberName);
			builder.append(", memberId=");
			builder.append(memberId);
			builder.append(", memberPassword=");
			builder.append(memberPassword);
			builder.append(", memberEmail=");
			builder.append(memberEmail);
			builder.append(", memberPhone=");
			builder.append(memberPhone);
			builder.append(", memberAddress=");
			builder.append(memberAddress);
			builder.append(", memberCategoryNumber=");
			builder.append(memberCategoryNumber);
			builder.append(", memberCategory=");
			builder.append(memberCategory);
			builder.append(", memberDeletedAt=");
			builder.append(memberDeletedAt);
			builder.append(", type=");
			builder.append(type);
			builder.append(", keyword=");
			builder.append(keyword);
			builder.append("]");
			return builder.toString();
		}
	
	    
	    
	    
	 
		
}
