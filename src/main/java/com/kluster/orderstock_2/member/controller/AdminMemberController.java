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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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

		return "redirect:/admin/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "member_Id", required = false) String memberId
			            ,@RequestParam(name = "member_Password", required = false) String memberPassword
						, HttpSession httpSession
						, RedirectAttributes redirectAttributes
						// 0. 차후 비즈코드로 권한 이관시
						/*, MemberBiz memberBiz*/
						, MemberLogin memberLogin){
		// 1. 회원이 존재할 경우
		if(memberId != null && !"".equals(memberId) &&
				memberPassword != null && !"".equals(memberPassword)){
			Amember member = adminMemberService.getMemberInfoById(memberId);

			if(memberPassword.equals(member.getMemberPassword())){
				httpSession.setAttribute("SID", memberId);
				httpSession.setAttribute("SNAME", member.getMemberName());

				System.out.println("SID"+memberId+" <----- member_Id");
				System.out.println("SNAME"+member.getMemberName()+" <----- member_Name");

				return "redirect:/main?member_id=" + member.getMemberId();
			}else {
				if(memberPassword.equals(member.getMemberPassword())){
					httpSession.setAttribute("SID", memberId);
					httpSession.setAttribute("SNAME", member.getMemberName());

					System.out.println("SID"+memberId+" <----- member_Id");
					System.out.println("SNAME"+member.getMemberName()+" <----- member_Name");
				}
			}
		}
		return "redirect:/";
	}

	// 로그인 화면
	@RequestMapping("login")
	public String login(Model model, @RequestParam(name = "member_Id", required = false) String memberId
			,@RequestParam(name = "member_Password", required = false) String memberPassword){

			System.out.println(memberId + " <:::::: member_Id");
			System.out.println(memberPassword + " <:::::: member_Password");

		if(memberId != null)
			model.addAttribute("member_Id", memberId);
			model.addAttribute("member_Password", memberPassword);

			model.addAttribute("title", "로그인");
			model.addAttribute("location", "로그인");

		return "/login";
	}
}

