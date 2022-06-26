package com.kluster.orderstock_2.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.Criteria;
import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.service.AdminMemberService;
@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	private final AdminMemberService adminMemberService;
	
	public AdminMemberController(AdminMemberService adminMemberService) {
		this.adminMemberService = adminMemberService;
	}
	
	  @GetMapping("/memberlist")
	    public String memberlist(Model model) {
		  List<Amember> memberList = adminMemberService.getMemberList();
		  model.addAttribute("memberList",memberList);
	        return "memberlist";
	    }
	  @GetMapping("/memberdetail")
	  	public String memberdetail(Model model) {
		  
		  return "memberdetail";
	  }
	  
}
