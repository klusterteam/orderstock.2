package com.kluster.orderstock_2.board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.board.domain.Board;

@Mapper
public interface BoardMapper {
	List<Board> getBoardList();
	void updateBoardList(HashMap<String, String> paramMap);
	void createBoardList(HashMap<String, String> paramMap);
	void deleteBoardList(String boardCode);
}