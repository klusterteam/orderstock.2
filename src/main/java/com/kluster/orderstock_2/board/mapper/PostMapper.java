package com.kluster.orderstock_2.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.board.domain.Post;

@Mapper
public interface PostMapper {

	List<Post> getPostList(int boardCode);

}
