package com.kluster.orderstock_2.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kluster.orderstock_2.inventory.domain.Inventory;
import com.kluster.orderstock_2.inventory.service.InventoryService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/inventory")
public class InventoryController2 {

	private final InventoryService inventoryService;
	@Autowired
	public InventoryController2(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}


	@GetMapping(value="/list")
	public String inventoryList(Model model) {
		// List<Inventory> inventoryList = inventoryService.getInventoryList();
		HashMap<String, Object>  resultMap = inventoryService.getInventoryList();

		List<Inventory> inventoryList = (List<Inventory>) resultMap.get("inventoryList");
		ArrayList<HashMap<String, Object>> totalQuan = (ArrayList<HashMap<String, Object>>) resultMap.get("totalQuan");
		System.out.println(totalQuan);
		model.addAttribute("inventoryList", inventoryList);
		model.addAttribute("totalQuantity", totalQuan);
		return "inventory/inventoryList";
	}

	@GetMapping(value = "/getDetailList")
	@ResponseBody
	public List<Inventory> getDetailList(String itemCategory, Model model){
		List<Inventory> detailList = inventoryService.getDetailList(itemCategory);
			System.out.println(detailList.get(0).getItemCode());
		model.addAttribute("detailList", detailList);
		return detailList;
	}
}


