package com.kluster.orderstock_2.main.mvc;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
	
	private final MainMapper mainMapper;
	
	@Autowired
	public MainService(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}

	public List<MenuVo> getMenuList() {
		List<MenuVo> menuList = mainMapper.getMenuList();
		return menuList;
	}
	

}
