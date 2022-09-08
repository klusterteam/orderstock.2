/*재고 이동 관리*/

$(function (){
    let storageMoveName = $('#storageMoveName').val();
    let storageMoveCode = $('#storageMoveCode').val();
    let storageMoveNameSelected = $('#storageMoveNameSelected');
    let storageMoveList = $('#storageMoveList').val();
    let storageMoveCheck = $('#storageMoveCheck');

    storageMoveNameSelected.text(storageMoveName);

    /*review required*/
    /*if(storageMoveList == storageMoveCode){
        storageMoveCheck.hide();
    }*/

});

/*재고의 위치를 이동*/
function storageMoveCheckConfirm(){
        let storageMoveCheckName = $('.storageMoveCheck').text();
        let confirmedItem = document.getElementById("confirmedItem");
        //TESTING //alert(confirmedItem.value);
        document.getElementById("confirmedItem_obj").value = confirmedItem.value;

        if (confirm("해당 재고의 위치를 다음 위치로 이동하시겠습니까?\n" + storageMoveCheckName)) {
            document.getElementById('storageMoveConfirm').submit();
            alert("재고 이동이 완료되었습니다.");
            return false;
        } else {
            alert("재고 이동이 취소되었습니다.");
            return false;
        }
}