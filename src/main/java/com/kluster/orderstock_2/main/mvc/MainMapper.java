package com.kluster.orderstock_2.main.mvc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MainMapper {

	List<MenuVo> getMenuList();
}