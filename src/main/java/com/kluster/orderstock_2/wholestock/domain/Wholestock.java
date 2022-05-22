package com.kluster.orderstock_2.wholestock.domain;

public class Wholestock {

    /*Wholestock 재고
    itemCode : 재고 코드
    itemName : 재고명
    itemType : 재고 타입(농산, 수산 등)
    itemOrigin : 원산지
    itemUnit : 단위(1kg, 1ea 등)
    itemQuan : 재고 수량(단위 * 수량 = 실제 보유 환산)
    itemDesc : 재고 설명 및 유의사항
    itemProd : 생산자 정보
    itemLife : 유통기한
    itemMark : 관리군 또는 일반군 표시
    storageCode : 보관 창고 코드
    itemDate : 재고 등록일
    recSts : 재고 정보 유효 또는 삭제*/

    private String itemCode;
    private String itemName;
    private String itemType;
    private String itemOrigin;
    private String itemUnit;
    private int itemQuan;
    private String itemDesc;
    private String itemProd;
    private int itemLife;
    private String itemMark;
    private String storageCode;
    private int itemDate;
    private String recSts;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemOrigin() {
        return itemOrigin;
    }

    public void setItemOrigin(String itemOrigin) {
        this.itemOrigin = itemOrigin;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public int getItemQuan() {
        return itemQuan;
    }

    public void setItemQuan(int itemQuan) {
        this.itemQuan = itemQuan;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemProd() {
        return itemProd;
    }

    public void setItemProd(String itemProd) {
        this.itemProd = itemProd;
    }

    public int getItemLife() {
        return itemLife;
    }

    public void setItemLife(int itemLife) {
        this.itemLife = itemLife;
    }

    public String getItemMark() {
        return itemMark;
    }

    public void setItemMark(String itemMark) {
        this.itemMark = itemMark;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public int getItemDate() {
        return itemDate;
    }

    public void setItemDate(int itemDate) {
        this.itemDate = itemDate;
    }

    public String getRecSts() {
        return recSts;
    }

    public void setRecSts(String recSts) {
        this.recSts = recSts;
    }

    @Override
    public String toString() {
        return "Wholestock{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemOrigin='" + itemOrigin + '\'' +
                ", itemUnit='" + itemUnit + '\'' +
                ", itemQuan=" + itemQuan +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemProd='" + itemProd + '\'' +
                ", itemLife=" + itemLife +
                ", itemMark='" + itemMark + '\'' +
                ", storageCode='" + storageCode + '\'' +
                ", itemDate=" + itemDate +
                ", recSts='" + recSts + '\'' +
                '}';
    }
}
