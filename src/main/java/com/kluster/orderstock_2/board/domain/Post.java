package com.kluster.orderstock_2.board.domain;

public class Post {
	/* 게시글 테이블 DTO [os_post]
	 * 
	 * postCode : 게시글 코드
	 * boardCode : 게시판 코드
	 * categoryCode : 게시판 카테고리
	 * postTitle : 게시글 제목
	 * memberId : 작성자 ID
	 * memberIdx : 작성자 Member 인덱스
	 * postWriteDT : 작성일자
	 * postUpdateId : 수정자 ID
	 * postUpdateDT : 수정일자
	 * postRemoveDT : 삭제일자
	 * postNotice : 공지사항 여부
	 * postActiveStatus : 게시글 활성화 여부 (숨김처리)
	 * postViewCount : 조회수 
	 * postLikeCount : 좋아요수 
	 * */
	
	private String postCode;
	private String boardCode;
	private String categoryCode;
	private String postTitle;
	private String memberId;
	private String memberIdx;
	private String postWriteDT;
	private String postUpdateId;
	private String postUpdateDT;
	private String postRemoveDT;
	private String postNotice;
	private String postActiveStatus;
	private int postViewCount;
	private int postLikeCount;
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(String memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getPostWriteDT() {
		return postWriteDT;
	}
	public void setPostWriteDT(String postWriteDT) {
		this.postWriteDT = postWriteDT;
	}
	public String getPostUpdateId() {
		return postUpdateId;
	}
	public void setPostUpdateId(String postUpdateId) {
		this.postUpdateId = postUpdateId;
	}
	public String getPostUpdateDT() {
		return postUpdateDT;
	}
	public void setPostUpdateDT(String postUpdateDT) {
		this.postUpdateDT = postUpdateDT;
	}
	public String getPostRemoveDT() {
		return postRemoveDT;
	}
	public void setPostRemoveDT(String postRemoveDT) {
		this.postRemoveDT = postRemoveDT;
	}
	public String getPostNotice() {
		return postNotice;
	}
	public void setPostNotice(String postNotice) {
		this.postNotice = postNotice;
	}
	public String getPostActiveStatus() {
		return postActiveStatus;
	}
	public void setPostActiveStatus(String postActiveStatus) {
		this.postActiveStatus = postActiveStatus;
	}
	public int getPostViewCount() {
		return postViewCount;
	}
	public void setPostViewCount(int postViewCount) {
		this.postViewCount = postViewCount;
	}
	public int getPostLikeCount() {
		return postLikeCount;
	}
	public void setPostLikeCount(int postLikeCount) {
		this.postLikeCount = postLikeCount;
	}
}
