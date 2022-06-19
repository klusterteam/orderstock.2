package com.kluster.orderstock_2.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.board.domain.Board;
import com.kluster.orderstock_2.board.mapper.BoardMapper;

@Service
public class BoardService {
	
	private final BoardMapper boardMapper;
	@Autowired
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	public List<Board> getBoardList() {
		List<Board> boardList = boardMapper.getBoardList();
		return boardList;
	}

	public void updateBoardList(String boardCode, String boardTitle, String categoryCode, String boardActiveStatus, String boardSortOrder) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("boardCode", boardCode);
		paramMap.put("boardTitle", boardTitle);
		paramMap.put("categoryCode", categoryCode);
		paramMap.put("boardActiveStatus", boardActiveStatus);
		paramMap.put("boardSortOrder", boardSortOrder);
		boardMapper.updateBoardList(paramMap);
	}
}
