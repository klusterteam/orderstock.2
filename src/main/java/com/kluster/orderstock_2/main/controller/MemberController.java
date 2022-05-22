package com.kluster.orderstock_2.main.controller;

import com.kluster.orderstock_2.main.domain.Member;
import com.kluster.orderstock_2.main.service.MemberService;
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
        return "members/createMemberForm";
    }

    /* 등록 */
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member =" + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
