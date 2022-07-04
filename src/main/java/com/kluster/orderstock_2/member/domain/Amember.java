package com.kluster.orderstock_2.member.domain;

public class Amember {
	  private int idx;
	    private String memberName;
	    private String memberId;
	    private String memberPassword;
	    private String memberEmail;
	    private int memberPhone;
	    private String memberAddress;
	    private MemberCategory memberCategory;

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
		public int getMemberPhone() {
			return memberPhone;
		}
		public void setMemberPhone(int memberPhone) {
			this.memberPhone = memberPhone;
		}
		public String getMemberAddress() {
			return memberAddress;
		}
		public void setMemberAddress(String memberAddress) {
			this.memberAddress = memberAddress;
		}
		public MemberCategory getMemberCategory() {
			return memberCategory;
		}
		public void setMemberCategory(MemberCategory memberCategory) {
			this.memberCategory = memberCategory;
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
			builder.append(", memberCategory=");
			builder.append(memberCategory);
			builder.append("]");
			return builder.toString();
		}
	    
	    
}
