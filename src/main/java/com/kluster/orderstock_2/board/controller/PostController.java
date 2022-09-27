package com.kluster.orderstock_2.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kluster.orderstock_2.board.domain.Post;
import com.kluster.orderstock_2.board.domain.PostContent;
import com.kluster.orderstock_2.board.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	//게시글 작성
	@PostMapping("/savePostContent")
	@ResponseBody
	public void savePostContent (PostContent postContent, Post post) {
		postService.savePostContent(postContent, post);
	}
	//게시글 작성
	@PostMapping("/updatePostContent")
	@ResponseBody
	public String updatePostContent (Model model, String postCode, String postTitle)  {
		PostContent postContents = postService.getPostContent(postCode);
		String postContent = postContents.getPostContent();
		System.out.println(postContent);
		model.addAttribute("postTitle", postTitle);
		model.addAttribute("postCode", postCode);
		model.addAttribute("postContent", postContent);
		return "/board/postcontent-type2?postContent="+postContent+"&postTitle="+postTitle;
	}
	//게시글 작성
	@PostMapping("/deletePostContent")
	@ResponseBody
	public void deletePostContent (Post PostCode) {
		postService.deletePostContent(PostCode);
	}

	
}


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
