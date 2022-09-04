package com.kluster.orderstock_2.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kluster.orderstock_2.board.domain.Board;
import com.kluster.orderstock_2.board.domain.Post;
import com.kluster.orderstock_2.board.domain.PostContent;
import com.kluster.orderstock_2.board.service.BoardService;
import com.kluster.orderstock_2.board.service.PostService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	private final PostService postService;
	
	public BoardController(BoardService boardService, PostService postService) {
		this.boardService = boardService;
		this.postService = postService;
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList (Model model) {
		List<Board> boardList = boardService.getBoardList();
		model.addAttribute("boardList",boardList);
		return "board/boardmanagement";
	}
	
	@PostMapping("/update")
	@ResponseBody
	public void updateBoardList (String boardCode, String boardTitle, String categoryCode, String boardActiveStatus, String boardSortOrder) {
		boardService.updateBoardList(boardCode, boardTitle ,categoryCode,boardActiveStatus,boardSortOrder);
	}
	@PostMapping("/create")
	@ResponseBody
	public void createBoardList (String boardTitle, String categoryCode, String boardActiveStatus, String boardSortOrder, String boardConstructor, String boardConstructionDate) {
		boardService.createBoardList(boardTitle ,categoryCode,boardActiveStatus,boardSortOrder,boardConstructor, boardConstructionDate);
	}
	@PostMapping("/delete")
	@ResponseBody
	public void deleteBoardList (String boardCode) {
		boardService.deleteBoardList(boardCode);
	}

	
	@GetMapping("/postcontent")
	public String getPostPage (Model model) {
		return "board/postcontent-type1";
	}
	
	// 자유 게시판 (1)
	@GetMapping("/community")
	public String communityPage (Model model) {
		int boardCode = 1;
		List<Post> postList = postService.getPostList(boardCode);
		
		model.addAttribute("boardCode",boardCode);
		model.addAttribute("totalCnt",postList.size());
		model.addAttribute("boardTitle","자유게시판");
		model.addAttribute("boardIntroduction","자유롭게 게시글을 작성해주세요");
		model.addAttribute("postList",postList);
		return "board/postlist";
	}
	// 공지사항 (2)
	@GetMapping("/notice")
	public String noticePage (Model model) {
		int boardCode = 2;
		List<Post> postList = postService.getPostList(boardCode);
		model.addAttribute("boardCode",boardCode);
		model.addAttribute("totalCnt",postList.size());
		model.addAttribute("boardTitle","공지사항");
		model.addAttribute("boardIntroduction","공지사항입니다.");
		model.addAttribute("postList",postList);
		return "board/postlist";
	}
	// FAQ (3)
	@GetMapping("/FAQ")
	public String FaqPage (Model model) {
		int boardCode = 3;
		List<Post> postList = postService.getPostList(boardCode);
		model.addAttribute("boardCode",boardCode);
		model.addAttribute("totalCnt",postList.size());
		model.addAttribute("boardTitle","FAQ");
		model.addAttribute("boardIntroduction","자주 묻는 질문");
		model.addAttribute("postList",postList);
		return "board/postlist";
	}
	// QNA (4)
	@GetMapping("/QNA")
	public String QnaPage (Model model) {
		int boardCode = 4;
		List<Post> postList = postService.getPostList(boardCode);
		model.addAttribute("boardCode",boardCode);
		model.addAttribute("totalCnt",postList.size());
		model.addAttribute("boardTitle","Q&A");
		model.addAttribute("boardIntroduction","문의사항 및 건의사항을 작성해주세요");
		model.addAttribute("postList",postList);
		return "board/postlist";
	}
	// 매장 소개 (5)
	@GetMapping("/storeIntro")
	public String storeIntroPage (Model model) {
		int boardCode = 5;
		List<Post> postList = postService.getPostList(boardCode);
		model.addAttribute("boardCode",boardCode);
		model.addAttribute("totalCnt",postList.size());
		model.addAttribute("boardTitle","매장 소개");
		model.addAttribute("boardIntroduction","매장에 대해 홍보하는 게시판입니다.");
		model.addAttribute("postList",postList);
		return "board/postlist";
	}
	//게시글 작성
	@GetMapping("/postcontent-type1")
	public String postContentPage (Model model, String boardCode) {
		System.out.println("boardCode : "+ boardCode );
		model.addAttribute("boardCode", boardCode);
		return "board/postcontent-type1";
	}
	
	//게시글 조회
	@GetMapping("/postcontent-type3")
	public String postContentPage3 (Model model, String postCode, String postTitle) {
		PostContent postContents = postService.getPostContent(postCode);
		String postContent = postContents.getPostContent();
		model.addAttribute("postTitle", postTitle);
		model.addAttribute("postContent", postContent);
		return "board/postcontent-type3";
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
