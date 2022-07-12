package com.kluster.orderstock_2.main.mvc;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
    @GetMapping("/")
    public String main(Model model, HttpSession session) {
    	List<MenuVo> menuListD1 = mainService.getMenuList();
    	List<MenuVo> menuListD2 = mainService.getMenuList();
    	session.setAttribute("menuListD1",menuListD1);
    	session.setAttribute("menuListD2",menuListD2);
        return "main";
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
