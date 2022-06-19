package com.kluster.orderstock_2.member.controller;

import com.kluster.orderstock_2.member.domain.Member;
import com.kluster.orderstock_2.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    /* 생성자 주입 - DI */
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* 조회 */
    @GetMapping("/members/new")
    public String createFrom(){
        return "members/joinus";
    }

    /* 등록 */
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();

        member.setMember_name(form.getName());
        member.setMember_id(form.getMemberId());
        member.setMember_password(form.getMemberPassword());
        member.setMember_email(form.getMemberEmail());
        member.setMember_address(form.getMemberAddress());
        member.setMember_phone(form.getMemberPhone());

        System.out.println("member Name = " + member.getMember_name());
        System.out.println("member Id = " + member.getMember_id());
        System.out.println("member Password = " + member.getMember_password());
        System.out.println("member email = " + member.getMember_email());
        System.out.println("member address = " + member.getMember_address());
        System.out.println("member phone = " + member.getMember_phone());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


    @GetMapping("/login")
    public String login(){
        return "members/login";
    }

}
