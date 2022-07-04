package com.kluster.orderstock_2.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /*@GetMapping("/")
    public String main(Model model) {
        return "main";
    }*/

    @GetMapping("/")
    public String getIndex()   {
        return "index";
    }

    @GetMapping("/main")
    public String getMain(){
        return "main";
    }

    @GetMapping("/login")
    public String main(){
        System.out.println(" ::::: 로그인을 진행해주세요. ::::: ");
        return "members/login";
    }
}
