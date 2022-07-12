package com.kluster.orderstock_2.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kluster.orderstock_2.member.domain.Amember;
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
	  	public String memberdetail(@RequestParam(name="idx",required = false) int idx
	  								,Model model) {
		  Amember memberdetail = adminMemberService.getMemberDetail(idx);
		  model.addAttribute("memDetail",memberdetail);
		 System.out.println("memberdetail값-------------------"+memberdetail);
		  return "memberdetail";
	  }
	  @PostMapping("/membermodipy")
	  	public String membermodipy(Amember amember , Model model) {
		 System.out.println("받은값"+amember);
		  //수정시 수정한 디테일로 넘어가는거 구현해야함ㄴ
		  int membermodipy = adminMemberService.memberModipy(amember);
		    return "redirect:/admin/memberlist";
	  }
}
