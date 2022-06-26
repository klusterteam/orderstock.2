package com.kluster.orderstock_2.wholestock.controller;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import com.kluster.orderstock_2.wholestock.service.WholestockService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Wholestock> originCountry = wholestockService.getOriginCountry(wholestock);
        String todayDate = wholestockService.getTodayDate();

        model.addAttribute("wholestockItemList", wholestockItemList);
        model.addAttribute("itemType", itemType);
        model.addAttribute("originCountry", originCountry);
        model.addAttribute("todayDate", todayDate);

        return "wholestock";
    }

    @ResponseBody
    @GetMapping(value = "wholestockitemlist/setitem/getcategories", produces = "application/json")
    public Object wholestockItemListGetCategories(@RequestParam String itemTypeCode, @RequestParam String originCode){
      JSONObject data = new JSONObject();
        if(itemTypeCode != null){
            Wholestock wholestock = new Wholestock();
            wholestock.setItemTypeCode(itemTypeCode);
            List<Wholestock> itemTypeResult = wholestockService.getItemType(wholestock);
            Wholestock itemTypeNameList = itemTypeResult.get(0);
            String itemTypeName = itemTypeNameList.getItemTypeName();
            data.put("itemTypeName", itemTypeName);
        }
        if(originCode != null){
            Wholestock wholestock = new Wholestock();
            wholestock.setOriginCode(originCode);
            List<Wholestock> originCodeResult = wholestockService.getOriginCountry(wholestock);
            Wholestock originCountryResultList = originCodeResult.get(0);
            String itemOriginCountry = originCountryResultList.getOriginName();
            data.put("itemOriginCountry", itemOriginCountry);
        }
        System.out.println(data);
        return data;
    }

    @PostMapping("/wholestockitemlist/setitem")
    public String setWholestockItem(Wholestock wholestock) {
        wholestockService.setWholestockItem(wholestock);
        return "redirect:/wholestockitemlist";
    }
}


