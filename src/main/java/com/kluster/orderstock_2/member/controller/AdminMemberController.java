package com.kluster.orderstock_2.member.controller;

import java.sql.JDBCType;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.MemberCategory;
import com.kluster.orderstock_2.member.service.AdminMemberService;
import com.kluster.orderstock_2.util.Pagination;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	private final AdminMemberService adminMemberService;

	@Autowired
	public AdminMemberController(AdminMemberService adminMemberService) {
		this.adminMemberService = adminMemberService;
	}

	@GetMapping("/memberlist")
	public String memberlist(Model model
			, @RequestParam(required = false, defaultValue = "1") int page
	) {
		//전체 게시글 개수
		int totalListCnt = adminMemberService.getMemberListCnt();
		//Pagination 객체 생성
		Pagination pagination = new Pagination(totalListCnt, page);

		//db select start index
		int startIndex = pagination.getStartIndex();
		//ㅠㅔ이지당 보여지는 게시글의 최대개수
		int pageSize = pagination.getPageSize();


		List<Amember> memberList = adminMemberService.getMemberList(startIndex, pageSize);
		model.addAttribute("pagination", pagination);
		model.addAttribute("totalListCnt", totalListCnt);
		model.addAttribute("memberList", memberList);
		return "memberlist";
	}

	@GetMapping("/memberdetail")
	public String memberdetail(@RequestParam(name = "idx", required = false) int idx
			, Model model) {
		Amember memberdetail = adminMemberService.getMemberDetail(idx);
		List<MemberCategory> memberCategory = adminMemberService.getMemberCategory();
		model.addAttribute("memDetail", memberdetail);
		model.addAttribute("memCategory", memberCategory);
		System.out.println("memberdetail값-------------------" + memberdetail);
		return "memberdetail";
	}

	@PostMapping("/membermodify")
	public String membermodify(Amember amember, Model model) {
		System.out.println("받은값" + amember.getMemberCategory().getMemberCategoryName());


		adminMemberService.memberModify(amember);
		return "redirect:/admin/memberlist";
	}

	@GetMapping("/memberdelete")
	public String deleteMember(@RequestParam(name = "idx", required = false) int idx) {
		adminMemberService.deleteMember(idx);
		return "redirect:/admin/memberlist";
	}

	@GetMapping("/getMemberSearch")
	@ResponseBody
	public List<Amember> getMemberSearch(@RequestParam("type") String type,
										 @RequestParam("keyword") String keyword, Model model) {
		Amember amember = new Amember();
		amember.setKeyword(keyword);
		amember.setType(type);
		return adminMemberService.getMemberSearchList(amember);
	}


	/*
	 * 	재혁
	 * * * * * * * * * */

	// 회원 가입 페이지
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET()throws Exception{
		return "register";
	}

	// 회원 가입 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(Amember amember, RedirectAttributes redirectAttributes) throws Exception{
		/*
		String hashedPw = BCrypt.hashpw(Amember.getMemberPassword(), BCrypt.gensalt());
		amember.setMemberPassword(hashedPw);
		*/
		adminMemberService.register(amember);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		return "redirect:/admin/login";
	}
}

