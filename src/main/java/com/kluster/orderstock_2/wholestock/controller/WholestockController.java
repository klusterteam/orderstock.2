package com.kluster.orderstock_2.wholestock.controller;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import com.kluster.orderstock_2.wholestock.service.WholestockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.MessageHandler;
import java.util.List;

@Controller
public class WholestockController {

    private final WholestockService wholestockService;

    public WholestockController(WholestockService wholestockService) {
        this.wholestockService = wholestockService;
    }

    /*도매상 1 : 도매상의 재고 목록*/
    @GetMapping("wholestockitemlist")
    public String wholestockItemList(@ModelAttribute Wholestock wholestock, Model model){

        List<Wholestock> wholestockItemList = wholestockService.getWholestockItem();
        List<Wholestock> itemType = wholestockService.getItemType(wholestock);
        List<Wholestock> originCountry = wholestockService.getOriginCountry();
        String todayDate = wholestockService.getTodayDate();

        model.addAttribute("wholestockItemList", wholestockItemList);
        model.addAttribute("itemType", itemType);
        model.addAttribute("originCountry", originCountry);
        model.addAttribute("todayDate", todayDate);

        return "wholestock";
    }

    /*IN PROGRESS 20220618*/
   /* @GetMapping("wholestockitemlist/setitem/getcategories")
    public String wholestockItemListGetCategories(@PathVariable String itemTypeCode, @PathVariable String originCode,
            Model model){
        if(itemTypeCode != null){
            Wholestock wholestock = new Wholestock();
            wholestock.setItemTypeCode(itemTypeCode);
            List<Wholestock> itemTypeResult = wholestockService.getItemType(wholestock);
            Wholestock itemTypeNameList = itemTypeResult.get(0);
            String itemTypeName = itemTypeNameList.getItemTypeName();

        }
    }*/

    @PostMapping("/wholestockitemlist/setitem")
    public String setWholestockItem(Wholestock wholestock) {
        wholestockService.setWholestockItem(wholestock);
        return "redirect:/wholestockitemlist";
    }
}


