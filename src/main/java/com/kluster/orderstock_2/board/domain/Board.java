package com.kluster.orderstock_2.board.domain;

public class Board {
	/* 게시판 테이블 DTO [os_board]
	 * boardCode : 게시판 코드
	 * boardTitle : 게시판명
	 * categoryCode : 게시판 카테고리
	 * boardConstuctor : 게시판 등록자(생성자)
	 * boardConstuctionDT : 게시판 등록일시(생성일시)
	 * boardActiveStatus : 게시판 활성화 상태
	 * boardSortOrder : 게시판 정렬 순서
	 * 
	 * */
	
	private String boardCode;
	private String boardTitle;
	private String categoryCode;
	private String boardConstuctor;
	private String boardConstuctionDT;
	private String boardActiveStatus;
	private int boardSortOrder;
	
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getBoardConstuctor() {
		return boardConstuctor;
	}
	public void setBoardConstuctor(String boardConstuctor) {
		this.boardConstuctor = boardConstuctor;
	}
	public String getBoardConstuctionDT() {
		return boardConstuctionDT;
	}
	public void setBoardConstuctionDT(String boardConstuctionDT) {
		this.boardConstuctionDT = boardConstuctionDT;
	}
	public String getBoardActiveStatus() {
		return boardActiveStatus;
	}
	public void setBoardActiveStatus(String boardActiveStatus) {
		this.boardActiveStatus = boardActiveStatus;
	}
	public int getBoardSortOrder() {
		return boardSortOrder;
	}
	public void setBoardSortOrder(int boardSortOrder) {
		this.boardSortOrder = boardSortOrder;
	}
}
