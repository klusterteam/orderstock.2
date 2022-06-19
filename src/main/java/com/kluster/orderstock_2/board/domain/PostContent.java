package com.kluster.orderstock_2.board.domain;

/** 게시글 콘텐츠는 게시글에 포함될 내용이 구체화 되기 전까지 사용하지 않습니다. KKS : 220529**/

public class PostContent {
	/* 게시클 내용 DTO [os_post_content]
	 *  postCode : 게시글 코드
	 *  postContent : 게시글 내용
	 *  itemCode : 상품 코드(상품 관련 데이터를 가져올 때 사용)
	 * */
	private String postCode;
	private String postContent;
	private String itemCode;
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
}
