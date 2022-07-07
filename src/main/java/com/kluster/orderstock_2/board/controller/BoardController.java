package com.kluster.orderstock_2.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kluster.orderstock_2.board.domain.Board;
import com.kluster.orderstock_2.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList (Model model) {
		List<Board> boardList = boardService.getBoardList();
		model.addAttribute("boardList",boardList);
		System.out.println(boardList.get(0).getBoardCode());
		return "boardmanagement";
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
