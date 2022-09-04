package com.kluster.orderstock_2.member.controller;

import java.util.List;

import com.kluster.orderstock_2.member.domain.MemberLogin;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.kluster.orderstock_2.member.domain.Amember;
import com.kluster.orderstock_2.member.domain.MemberCategory;
import com.kluster.orderstock_2.member.service.AdminMemberService;
import com.kluster.orderstock_2.util.Pagination;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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

		String hashedPw = BCrypt.hashpw(amember.getMemberPassword(), BCrypt.gensalt());
		amember.setMemberPassword(hashedPw);

		adminMemberService.register(amember);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");

		return "redirect:/login";
	}

	/* 로그인 처리 */
	@GetMapping("/login2")
	public String login(@RequestParam(name = "member_id", required = false) String member_id
			            ,@RequestParam(name = "member_password", required = false) String member_password
						, HttpSession httpSession
						, RedirectAttributes redirectAttributes
						// 0. 차후 비즈코드로 권한 이관시
						/*, MemberBiz memberBiz*/
						, MemberLogin memberLogin) {
		// 1. 회원이 존재할 경우
		System.out.println("[ 확인 ] GetMapping > member_password : " + member_password);
		System.out.println("[ 확인 ] GetMapping > memberLogin.getMember_password() : " + memberLogin.getMember_password());


		if(member_id != null && !"".equals(member_id) &&
				member_password != null && !"".equals(member_password)){
			Amember amember = adminMemberService.getMemberInfoById(member_id);

			if(member_password.equals(memberLogin.getMember_password())){
				System.out.println("GetMapping > member_password : " + member_password);
				System.out.println("GetMapping > memberLogin.getMember_password() : " + memberLogin.getMember_password());

				httpSession.setAttribute("GetMapping > member_password : > SID : ", member_id);
				httpSession.setAttribute("GetMapping > member_password : > SNAME : ", memberLogin.getMember_password());

				System.out.println("GetMapping > member_password : > SID : " + member_id);
				System.out.println("GetMapping > member_password : > SNAME : " + memberLogin.getMember_password());

				System.out.println("GetMapping > member_password : > SID/SNAME > redirect:/main?" + member_id);
				return "redirect:/main?" + member_id;
			}else {
				if (member_id == null){
					System.out.println("member_id 가 존재하지 않음 > redirect:/admin/login");
					return "redirect:/admin/login";
				}
			}
		}
		return "redirect:/";
	}

	// 로그인 화면 접속페이지로 이동
	@GetMapping("/login")
	public String login( Model model){
		model.addAttribute("title","로그인");
		model.addAttribute("location","로그인");
		return "/login";
	}
}

