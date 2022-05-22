package com.kluster.orderstock_2.wholestock.controller;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import com.kluster.orderstock_2.wholestock.service.WholestockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WholestockController {

    private final WholestockService wholestockService;

    public WholestockController(WholestockService wholestockService) {
        this.wholestockService = wholestockService;
    }

    /*도매상 1 : 도매상의 재고 목록*/
    @GetMapping("/wholestockitemlist")
    public String wholestockItemList(Model model){

        List<Wholestock> wholestockItemList = wholestockService.getWholestockItem();
        model.addAttribute("wholestockItemList", wholestockItemList);
        return "/wholestock";
    }
}


