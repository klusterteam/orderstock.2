package com.kluster.orderstock_2.member.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.service.MemberService;

@RequestMapping("/")
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	  @GetMapping("/admin/memberlist")
	    public String memberlist(Model model) {
		  
		  List<Member> memberList = memberService.getMemberList();
		  model.addAttribute("memberList",memberList);
	        return "memberlist";
	    }
}
