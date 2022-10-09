/*재고 이동 관리*/

$(function (){
    let storageMoveCode = $('#storageMoveCode').val();
    let currentStorage = $('#currentStorage_' + storageMoveCode);
    currentStorage.css('display', 'inline');

});

/*재고의 위치를 이동*/
function storageMoveCheckConfirm(storageCode){

        let storageMoveCode = document.getElementById('storageMoveCode').val();
        if(storageMoveCode == storageCode){
            alert("현재 위치와 이동할 위치가 같습니다.");
            return false;
        }

        let confirmedStorageName = document.getElementById('confirmedStorageName').text();
        let confirmedItem = document.getElementById("confirmedItem");
        let storageLogType = document.getElementById("storageLogType");
        let storageLogNote = document.getElementById("storageLogNote");
        document.getElementById("confirmedItemCode").value = confirmedItem.value;
        //재고 이동
        storageLogType.value = 'MOVE';

        if (confirm("해당 재고의 위치를 선택한 창고로 이동하시겠습니까?")) {
            let note = prompt("재고 이동 사유를 입력하세요.\n취소를 선택하면 사유 입력 없이 이동 처리됩니다.");
            storageLogNote.value = note;
            document.getElementById('confirmedStorageCode').value = storageCode;
            document.getElementById('storageMoveConfirm').submit();
            alert("재고 이동이 완료되었습니다.");
            return false;
        } else {
            return false;
        }
}