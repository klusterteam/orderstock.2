package com.kluster.orderstock_2.member.controller.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException{
        HttpSession session = request.getSession();

        String id = request.getParameter("member_id");
        String pw = request.getParameter("member_password");
        System.out.println("입력된 id = " + id);
        System.out.println("입력된 pw = " + pw);

        session.setAttribute("greeting", authentication.getName() + "님 반갑습니다.");
        System.out.println(authentication.getName()+ "님 반갑습니다.");
        response.sendRedirect("/main");

        Object principal =
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();
        }else {
            String username = principal.toString();
        }
    }
}
