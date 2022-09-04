package com.kluster.orderstock_2.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.board.domain.Post;
import com.kluster.orderstock_2.board.domain.PostContent;
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

	public void savePostContent(PostContent postContent, Post post) {
		//게시글 os_post 저장
		PostMapper.savePost(post);
		//게시글 os_post에서 post_code 조회
		String postCode = PostMapper.getPostCode();
		PostContent postContentObj = new PostContent();
		postContentObj.setPostCode(postCode);
		postContentObj.setPostContent(postContent.getPostContent());
		if(postCode != null) {
			//os_post_content 저장
			PostMapper.savePostContent(postContentObj);
		}
	}

	public PostContent getPostContent(String postCode) {
		PostContent postContent = PostMapper.getPostContent(postCode);
		return postContent;
	}

}
