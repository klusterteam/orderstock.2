package com.kluster.orderstock_2.board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kluster.orderstock_2.board.domain.Post;
import com.kluster.orderstock_2.board.domain.PostContent;

@Mapper
public interface PostMapper {

	List<Post> getPostList(int boardCode);

	void savePost(Post post);
	String getPostCode();
	void savePostContent(PostContent postCode,  PostContent postContent);

	PostContent getPostContent(String postCode);

	void savePostContent(PostContent postContentObj);

}
