package com.kluster.orderstock_2.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.board.domain.Post;
import com.kluster.orderstock_2.board.mapper.PostMapper;

@Service
public class PostService {
	
	private final PostMapper PostMapper;
	@Autowired
	public PostService(PostMapper PostMapper) {
		this.PostMapper = PostMapper;
	}
	
	public List<Post> getPostList(int boardCode) {
		List<Post> PostList = PostMapper.getPostList(boardCode);
		return PostList;
	}

}
