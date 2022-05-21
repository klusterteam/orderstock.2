package com.kluster.orderstock_2.admin.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kluster.orderstock_2.admin.domain.Member;
import com.kluster.orderstock_2.admin.service.MemberService;

@RequestMapping("/")
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	  @GetMapping("/admin/memberlist")
	    public String memberlist(Model model) {
		  
		  List<Member> memberList = memberService.getMember();
		  model.addAttribute("memberList",memberList);
	        return "memberlist";
	    }
}
