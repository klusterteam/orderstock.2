/*재고 관리*/

$(function (){
    let storageTab = $('#storageCode').val();
    let storageTabDefault = $('#storage-tab-default');
    let storageTabSelected = $('#storage-tab-' + storageTab);

    if(!storageTab){
        storageTabDefault.removeClass('btn-outline-primary');
        storageTabDefault.addClass('btn-primary');
    }else{
        storageTabSelected.removeClass('btn-outline-primary');
        storageTabSelected.addClass('btn-primary');
    }
    return false;
})

function deleteItem(itemCode){
    if(confirm("선택한 재고 항목을 폐기 처분하시겠습니까?")){
        location.href = "wholestockitemlist/deleteitem?itemCode=" + itemCode;
        alert("재고가 폐기 상태로 변경되었습니다.");
        return false;
    }else{
        return false;
    }
}

/*재고의 수동 등록*/
function saveItem(){
    let itemName = document.getElementById("itemNameForm");
    let itemType = document.getElementById("itemTypeNameForm");
    let itemOrigin = document.getElementById("originNameForm");
    let itemUnit = document.getElementById("itemUnitForm");
    let itemQuan = document.getElementById("itemQuanForm");
    let itemDesc = document.getElementById("itemDescForm");
    let itemProd = document.getElementById("itemProdForm");
    let itemLife = document.getElementById("itemLifeForm");
    let unitIndex = (itemUnit.value).substring(1);

    let itemTypeCode = itemType.options[itemType.selectedIndex].value;
    let originCode = itemOrigin.options[itemOrigin.selectedIndex].value;
    let itemOriginObj = { "itemTypeCode": itemTypeCode, "originCode": originCode };

        if(!itemName.value){
        alert("품명이 입력되지 않았습니다.");
        itemName.focus();
        return false;
    }

        if(!itemType.value){
        alert("품목의 유형이 선택되지 않았습니다.");
        itemType.focus();
        return false;
    }

        if(!itemOrigin.value){
        alert("원산지가 선택되지 않았습니다.");
        itemOrigin.focus();
        return false;
    }

        if(!itemUnit.value){
        alert("수량 단위가 입력되지 않았습니다.");
        itemUnit.focus();
        return false;
    }

        if(!itemQuan.value){
        alert("수량이 입력되지 않았습니다.");
        itemQuan.focus();
        return false;
    }

        if(!itemLife.value){
        alert("유통기한이 선택되지 않았습니다.");
        itemLife.focus();
        return false;
    }
        $.ajax({
            url: 'wholestockitemlist/setitem/getcategories',
            data: itemOriginObj,
            dataType: 'json',
            type : 'get',
            success: function(data){
                if(!data.itemTypeName){
                alert("품목 분류명을 불러오는데 실패했습니다. 관리자에게 문의하세요");
                return false;
            }
                if(!data.itemOriginCountry){
                alert("원산지명을 불러오는데 실패했습니다. 관리자에게 문의하세요");
                return false;
            }

                if(!confirm(data.itemOriginCountry + "산 " + data.itemTypeName + "품 " + (itemName.value) + "을(를) " +
                (itemQuan.value) + unitIndex + " 등록하시겠습니까?")){
                return false;
            }else{
                document.setItem.submit();
                alert("등록이 완료되었습니다.");
                return false;
            }
        },
            error: function(jqXHR, textStatus, errorThrown) {
            alert("재고 수동 등록에 실패하였습니다. 관리자에게 문의하세요.");
            console.log("Following error occured \n" + textStatus + " : " + errorThrown);
            //self.close();
        }
    });
}

function getItemListByStorage(storageCode){
    if(!storageCode){
        location.href = "wholestockitemlist";
    }else{
        location.href = "wholestockitemlist?storageCode=" + storageCode;
    }
    return false;
}

/*재고의 창고 이동 시 재고를 선택하여 재고 이동 히스토리 페이지로 넘어감*/
function storageMove(storageCode){
    let updateStorageItemCode = document.getElementById("updateStorageItemCode");
    updateStorageItemCode.value = storageCode;
    document.itemList.submit();
}