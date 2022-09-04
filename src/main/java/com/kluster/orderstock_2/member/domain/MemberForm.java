package com.kluster.orderstock_2.member.domain;

public class MemberForm {

    private String name;
    private int memberCategoryNumber;
    private String memberId;
    private String memberPassword;
    private String memberEmail;
    private String memberAddress;
    private int memberPhone;

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public int getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(int memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberCategoryNumber() {
        return memberCategoryNumber;
    }

    public void setMemberCategoryNumber(int memberCategoryNumber) {
        this.memberCategoryNumber = memberCategoryNumber;
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
}
