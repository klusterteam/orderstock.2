/*재고 이동 관리*/

$(function (){
    let storageMoveCode = $('#storageMoveCode').val();
    let currentStorage = $('#currentStorage_' + storageMoveCode);
    currentStorage.css('display', 'inline');

    /*if(currentStorage.click()){
        alert("현재 위치와 이동할 위치가 같습니다.");
        return false;
    }*/
});

/*재고의 위치를 이동*/
function storageMoveCheckConfirm(storageCode){
        let confirmedStorageName = $('#confirmedStorageName').text();
        let confirmedItem = document.getElementById("confirmedItem");
        document.getElementById("confirmedItemCode").value = confirmedItem.value;

        if (confirm("해당 재고의 위치를 다음 위치로 이동하시겠습니까?\n" + confirmedStorageName)) {
            document.getElementById('confirmedStorageCode').value = storageCode;
            document.getElementById('storageMoveConfirm').submit();
            alert("재고 이동이 완료되었습니다.");
            return false;
        } else {
            return false;
        }
}