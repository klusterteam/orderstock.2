package com.kluster.orderstock_2.wholestock.controller;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import com.kluster.orderstock_2.wholestock.service.WholestockService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WholestockController {

    private final WholestockService wholestockService;

    public WholestockController(WholestockService wholestockService) {
        this.wholestockService = wholestockService;
    }

    /*도매상 1 : 도매상의 재고 목록*/
    @GetMapping("wholestockitemlist")
    public String wholestockItemList(@ModelAttribute Wholestock wholestock, Model model,
                                     @RequestParam(value = "storageCode", required = false)
                                        String storageCode) throws Exception{

        /*test userId of session*/
        String userId = "USER0001";
        if(storageCode != null){
            wholestock.setStorageCode(storageCode);
        }

        List<Wholestock> wholestockItemList = wholestockService.getWholestockItem(wholestock);
        List<Wholestock> itemType = wholestockService.getItemType(wholestock);
        List<Wholestock> originCountry = wholestockService.getOriginCountry(wholestock);
        List<Wholestock> storageList = wholestockService.getStorage(userId);
        String todayDate = wholestockService.getTodayDate();

        model.addAttribute("wholestockItemList", wholestockItemList);
        model.addAttribute("itemType", itemType);
        model.addAttribute("originCountry", originCountry);
        model.addAttribute("storageList", storageList);
        model.addAttribute("storageCode", storageCode);
        model.addAttribute("todayDate", todayDate);

        return "wholestock";
    }
    /*도매상 2 : 도매상의 재고 목록 > 폐기*/
    @GetMapping("wholestockitemlist/deleteitem")
    public String wholestockItemDelete(@RequestParam(value = "itemCode", required = true)
                                       String itemCode) throws Exception{

        wholestockService.deleteWholestockItem(itemCode);

        return "redirect:/wholestockitemlist";
    }

    /*도매상 3 : 도매상의 수동 재고 입력 시 front/view는 한국어, back은 지정된 영문자로 insert*/
    @ResponseBody
    @GetMapping(value = "wholestockitemlist/setitem/getcategories", produces = "application/json")
    public Map<String, String> wholestockItemListGetCategories(@RequestParam String itemTypeCode, @RequestParam String originCode)
                                                                throws Exception {
        //JSONObject data = new JSONObject() >>>>> empty response
        Map<String, String> data = new HashMap<String, String>();
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
        return data;
    }

    /*도매상 4 : 도매상의 재고 수동 입력*/
    @PostMapping("/wholestockitemlist/setitem")
    public String setWholestockItem(Wholestock wholestock) throws Exception {
        wholestockService.setWholestockItem(wholestock);
        return "redirect:/wholestockitemlist";
    }

    @PostMapping("/wholestockitemlist/updatestorage")
    public String updateItemStorage(Wholestock wholestock) throws Exception{
        wholestockService.updateItemStorage(wholestock);
        return "redirect:/wholestockitemlist";
    }
}


