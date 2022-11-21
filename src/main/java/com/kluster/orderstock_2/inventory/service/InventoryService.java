package com.kluster.orderstock_2.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kluster.orderstock_2.inventory.domain.Inventory;
import com.kluster.orderstock_2.inventory.mapper.InventoryMapper;



@Service
public class InventoryService {

    private final InventoryMapper inventoryMapper;
	@Autowired
	public InventoryService(InventoryMapper inventoryMapper) {
		this.inventoryMapper = inventoryMapper;
	}
	public HashMap<String, Object> getInventoryList( ){
		HashMap<String, Object> returnMap = new HashMap<>();
		List<Inventory> inventoryList = inventoryMapper.getInventoryList();
		
		ArrayList<Map<String, String>> tqArrayList = new ArrayList<>();
		for (int i = 0; i < inventoryList.size(); i++) {
			Inventory itemCategory = inventoryList.get(i);
			Map<String, String> totalQuan = inventoryMapper.getItemTotalQuan(itemCategory);
			tqArrayList.add(totalQuan);
		};
		returnMap.put("inventoryList", inventoryList);
		returnMap.put("totalQuan", tqArrayList);
		
		return  returnMap;
	}
    public List<Inventory> getDetailList(String itemCategory){
		List<Inventory> detailList = inventoryMapper.getDetailList(itemCategory);
		return detailList ;
    }
}
