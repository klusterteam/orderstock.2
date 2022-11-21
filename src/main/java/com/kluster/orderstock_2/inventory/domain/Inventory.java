package com.kluster.orderstock_2.inventory.domain;

public class Inventory {
    String itemCode;
	String itemName;
	String itemCategory;
	String itemUnit;
	String itemQuan;
	String itemDesc;
	String itemProdDate;
	String itemExprDate;
	String itemRecvDate;
    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return this.itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemUnit() {
        return this.itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemQuan() {
        return this.itemQuan;
    }

    public void setItemQuan(String itemQuan) {
        this.itemQuan = itemQuan;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemProdDate() {
        return this.itemProdDate;
    }

    public void setItemProdDate(String itemProdDate) {
        this.itemProdDate = itemProdDate;
    }

    public String getItemExprDate() {
        return this.itemExprDate;
    }

    public void setItemExprDate(String itemExprDate) {
        this.itemExprDate = itemExprDate;
    }

    public String getItemRecvDate() {
        return this.itemRecvDate;
    }

    public void setItemRecvDate(String itemRecvDate) {
        this.itemRecvDate = itemRecvDate;
    }
}
