package com.kluster.orderstock_2.board.domain;

public class File {
	
	/* 첨부파일 DTO [os_file]
	 * 
	 * fileCode : 파일코드
	 * postCode : 게시글코드
	 * fileName : 파일명
	 * filePath : 파일경로
	 * fileType : 파일유형
	 * fileSize : 파일크기
	 * attachedIndex : 첨부순서	
	 * */
	
	
	private String fileCode;
	private String postCode;
	private String fileName;
	private String filePath;
	private String fileType;
	private int fileSize;
	private int attachedIndex;
	
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public int getAttachedIndex() {
		return attachedIndex;
	}
	public void setAttachedIndex(int attachedIndex) {
		this.attachedIndex = attachedIndex;
	}
}
