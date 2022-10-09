package com.kluster.orderstock_2.wholestock.domain;

public class Wholestock {

    /*wholestock_item 재고
    itemCode : 재고 코드
    itemName : 재고명
    itemType : 재고 타입(농산, 수산 등)
    itemOrigin : 원산지
    itemUnit : 단위(1kg, 1ea 등)
    itemQuan : 재고 수량(단위 * 수량 = 실제 보유 환산)
    itemDesc : 재고 설명 및 유의사항
    itemProd : 생산자 정보
    itemLife : 유통기한
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
    private String itemLife;
    private String storageCode;
    private String itemDate;
    private String recSts;

   /* origin_country 원산지 정보
    originCode : 원산지 코드
    originName : 원산지 국가명*/

    private String originCode;
    private String originName;

    /*os_item_type_category 재고 유형 정보
    itemTypeCode : 재고 유형 코드
    itemTypeName : 재고 유형명*/

    private String itemTypeCode;
    private String itemTypeName;

    /*private String storageCode;*/
    private String storageName;
    private String storageType;
    private String storageOwn;


    /*os_wholestock_storage_log 재고 창고 이동
    logSeq : 재고 이동 코드
    logNote : 재고 이동 상세 설명
    logDate : 재고 이동 일자
    logType : 재고 이동 타입*/

    private String logSeq;
    private String logNote;
    private String logDate;

    private String logType;

    private String memberId;

    public String getItemCode() {
        return itemCode;
    }

    public String getLogType() {
        return logType;
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
                ", itemLife='" + itemLife + '\'' +
                ", storageCode='" + storageCode + '\'' +
                ", itemDate='" + itemDate + '\'' +
                ", recSts='" + recSts + '\'' +
                ", originCode='" + originCode + '\'' +
                ", originName='" + originName + '\'' +
                ", itemTypeCode='" + itemTypeCode + '\'' +
                ", itemTypeName='" + itemTypeName + '\'' +
                ", storageName='" + storageName + '\'' +
                ", storageType='" + storageType + '\'' +
                ", storageOwn='" + storageOwn + '\'' +
                ", logSeq='" + logSeq + '\'' +
                ", logNote='" + logNote + '\'' +
                ", logDate='" + logDate + '\'' +
                ", logType='" + logType + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public String getItemLife() {
        return itemLife;
    }

    public void setItemLife(String itemLife) {
        this.itemLife = itemLife;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public String getRecSts() {
        return recSts;
    }

    public void setRecSts(String recSts) {
        this.recSts = recSts;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getItemTypeCode() {
        return itemTypeCode;
    }

    public void setItemTypeCode(String itemTypeCode) {
        this.itemTypeCode = itemTypeCode;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageOwn() {
        return storageOwn;
    }

    public void setStorageOwn(String storageOwn) {
        this.storageOwn = storageOwn;
    }

    public String getLogSeq() {
        return logSeq;
    }

    public void setLogSeq(String logSeq) {
        this.logSeq = logSeq;
    }

    public String getLogNote() {
        return logNote;
    }

    public void setLogNote(String logNote) {
        this.logNote = logNote;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

}
