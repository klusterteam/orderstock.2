package com.kluster.orderstock_2.inventory.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kluster.orderstock_2.inventory.domain.Inventory;

@Mapper
public interface InventoryMapper {
    List<Inventory> getDetailList(String itemCategory);
    List<Inventory> getInventoryList();
    Map<String, String> getItemTotalQuan(Inventory itemCategory);

}