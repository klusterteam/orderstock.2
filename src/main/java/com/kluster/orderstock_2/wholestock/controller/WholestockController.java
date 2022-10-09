package com.kluster.orderstock_2.wholestock.controller;

import com.kluster.orderstock_2.wholestock.domain.Wholestock;
import com.kluster.orderstock_2.wholestock.service.WholestockService;
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
                                     String storageCode) throws Exception {

        /*test userId of session*/
        String userId = "USER0001";
        if (storageCode != null) {
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

        return "wholestock/wholestock";
    }

    /*도매상 2 : 도매상의 재고 목록 > 폐기*/
    @PostMapping("wholestockitemlist/deleteitem")
    public String wholestockItemDelete(@RequestParam(value = "itemCode", required = true)
                                       String itemCode) throws Exception {

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
        if (itemTypeCode != null) {
            Wholestock wholestock = new Wholestock();
            wholestock.setItemTypeCode(itemTypeCode);
            List<Wholestock> itemTypeResult = wholestockService.getItemType(wholestock);
            Wholestock itemTypeNameList = itemTypeResult.get(0);
            String itemTypeName = itemTypeNameList.getItemTypeName();
            data.put("itemTypeName", itemTypeName);
        }
        if (originCode != null) {
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

    /*도매상 5 : 재고의 창고 이동 1단계(선택한 재고를 히스토리 및 재고 이동 페이지로 넘겨준다)*/
    @PostMapping("/wholestockitemlist/updatestoragelist")
    public String updateItemStorageList(@ModelAttribute Wholestock wholestock, Model model) throws Exception {

        /*test userId of session*/
        String userId = "USER0001";
        List<Wholestock> wholestockItemList = wholestockService.getWholestockItem(wholestock);
        List<Wholestock> storageList = wholestockService.getStorage(userId);

        model.addAttribute("wholestockItemList", wholestockItemList);
        model.addAttribute("storageList", storageList);

        return "wholestock/wholestockstoragemove";
    }

    /*도매상 6 : 재고의 창고 이동 2단계(재고를 최종적으로 현재 창고에서 다른 창고로 이동)*/
    @PostMapping("/wholestockitemlist/updatestorage")
    public String updateItemStorage(@ModelAttribute Wholestock wholestock) throws Exception {
        //test userId of session
        wholestock.setMemberId("USER0001");

        wholestockService.updateItemStorage(wholestock);
        wholestockService.setWholestockStorageLog(wholestock);
        return "redirect:/wholestockitemlist";
    }

    /*도매상 7 : 재고의 창고 이동 로그*/
    @PostMapping("/wholestockitemlist/getStorageMoveLog")
        public String getStorageMoveLog(@ModelAttribute Wholestock wholestock, Model model) throws Exception {

            List<Wholestock> storageMoveLog = wholestockService.getWholestockStorageLog(wholestock);
            model.addAttribute("storageMoveLog", storageMoveLog);
            return "redirect:/wholestockitemlist";
    }

}


