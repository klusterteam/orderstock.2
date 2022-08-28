package com.kluster.orderstock_2.login.controller;

import com.kluster.orderstock_2.login.serviceImpl.LoginServiceImpl;
import com.kluster.orderstock_2.login.domain.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login/*")
public class LoginController {

    private final LoginServiceImpl loginServiceimpl;
    // 목

    @Autowired
    public LoginController(LoginServiceImpl loginServiceimpl){
        this.loginServiceimpl = loginServiceimpl;
    }
	// 로그인 화면
	@RequestMapping("login.do")
	public String login(){
		return "memberList_";
	}
	// admin/member/login.jsp로 포워드

    // 로그인 처리
	@RequestMapping("loginCheck.do")
    public ModelAndView loginCheck(@ModelAttribute LoginVO vo, HttpSession httpSession){
        boolean result = loginServiceimpl.loginCheck(vo, httpSession);
        ModelAndView mav = new ModelAndView();

        if(result == true){ // 로그인 성공
            // main.jsp로 이동
            mav.setViewName("members/login");
            mav.addObject("msg", "failure");
        }
        return mav;
    }

	// 로그아웃 처리
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession httpSession){
        loginServiceimpl.logout(httpSession);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/login");
        mav.addObject("msg", "logout");
        return mav;
    }
}
