package com.kluster.orderstock_2.login.service;

import com.kluster.orderstock_2.login.domain.LoginVO;

import javax.servlet.http.HttpSession;

public interface LoginDAO{
    // 회원 로그인 체크
    public boolean loginCheck(LoginVO vo);

    // 회원 로그인 정보
    public LoginVO viewMember(LoginVO vo);

    // 회원 로그아웃
    public void logout(HttpSession httpSession);
}
