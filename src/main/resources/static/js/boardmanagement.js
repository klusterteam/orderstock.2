
/* 트리형 메뉴 */
function tree_menu() {
  $('ul.depth_2 >li > a').click(function(e) {

    var temp_el = $(this).next('ul');
    var depth_3 = $('.depth_3');

    // 처음에 모두 슬라이드 업 시켜준다.
    depth_3.slideUp(300);
    // 클릭한 순간 모두 on(-)을 제거한다.// +가 나오도록
    depth_3.parent().find('em').removeClass('on');

    if (temp_el.is(':hidden')) {
      temp_el.slideDown(300);
      $(this).find('em').addClass('on').html('하위폴더 열림');
    } else {
      temp_el.slideUp(300);
      $(this).find('em').removeClass('on').html('하위폴더 닫힘');
    }

    return false;

  });
}
if ($('#tree_menu').is(':visible')) {
  tree_menu();
}

/*<![CDATA[*/
	/* 타임리프로 가져온 데이터 자바스크립트에서 가져오기  */
    var boardList = /*[[${boardList}]]*/ 'default';
/*]]>*/
	console.log(boardList)
$(document).ready(function(){
    alert("asd")
/* 목록 아이템 선택시 게시판 정보 폼에 입력 */
	$(".boardList").click(function() {		// 모든 <button>요소에 click 이벤트를 설정함.
			for(var i =0; i< boardList.length; i++){
				if(this.text == boardList[i].boardTitle){
					$("#ipb-Title")[0].value = boardList[i].boardTitle;
					$("#ipb-Status")[0].value = "update";
					$("#select-Category")[0].value = boardList[i].categoryCode;
					$("#ipb-SortOrder")[0].value = boardList[i].boardSortOrder;
					$("#ipb-Code")[0].value = boardList[i].boardCode;
					
					if(boardList[i].boardActiveStatus == "true"){
						$("#active")[0].checked = true;
					}else{
						$("#inactive")[0].checked = true;
					}
				}
			}
			/* 삭제버튼 활성화 */
			$('.btn-delete')[0].style.display= "inline-block";
		},
	);
/* 게시판 관리 폼 초기화*/
	$(".btn-refresh").click(function(){
		$("#form-board").reset();
	})
	
/* 게시판 관리 create/update */
	$(".btn-save").click(function(){
		/* 변수 선언부 */
		var boardTitle = $("#ipb-Title").val();
		var boardStat = $("#ipb-Status").val();
		var categoryCode = $("#select-Category").val();
		var boardSortOrder = $("#ipb-SortOrder").val();
		var boardActiveStatus = $("#active")[0].checked;
		var boardCode = $("#ipb-Code").val();
		var boardConstructor = "ksk1908TEMP"
		var boardConstructionDate = getFormattedDate();
		
		var rsValidation = validation(boardTitle,boardStat,boardSortOrder,categoryCode);
			console.log(rsValidation)
		if(rsValidation){
		}else{
			return;
		}
		if(boardStat == "create"){
			var request = $.ajax({
				url : "/board/create", 
				method : "POST", 
				data : {
					boardTitle : boardTitle,
					categoryCode : categoryCode,
					boardSortOrder : boardSortOrder, 
					boardActiveStatus : boardActiveStatus,
					boardConstructor : boardConstructor,
					boardConstructionDate : boardConstructionDate
					
					},
				dataType : "text"
			});
		}else{
			var request = $.ajax({
				url : "/board/update", 
				method : "POST", 
				data : {
					boardCode : boardCode,
					boardTitle : boardTitle,
					categoryCode : categoryCode,
					boardSortOrder : boardSortOrder, 
					boardActiveStatus : boardActiveStatus
					},
				dataType : "text"
			});
			
		}
			request.done(function(data) {
				location.reload();
			});

			request.fail(function(jqXHR, textStatus) {
				alert("요청 실패: " + textStatus);
			});
		
	})
});
/* 게시판 Delete */


$(".btn-delete").click(function(){
	var boardCode = $("#ipb-Code").val();
	var request = $.ajax({
		url : "/board/delete", 
		method : "POST", 
		data : {
			boardCode : boardCode,
			},
		dataType : "text"
	});
	
	request.done(function(data) {
		location.reload();
	});

	request.fail(function(jqXHR, textStatus) {
		alert("요청 실패: " + textStatus);
	});
})

$(".btn-new").click(function(){
	var tempMap = {};
	tempMap.boardTitle = "새 게시판";
	tempMap.categoryCode = "board";
	tempMap.boardConstuctor = "1";
	tempMap.boardConstuctionDT = "1";
	tempMap.boardActiveStatus = "true";
	tempMap.boardSortOrder = 1;
	tempMap.status = "create";
	boardList.push(tempMap);

	/* 새 게시판 html element 만들기 */	
	const ul = document.createElement("ul");+
	ul.setAttribute("class","depth_2");
	const li = document.createElement("li");
	const a = document.createElement("a");
	a.setAttribute("href", "#none")
	a.setAttribute("class", "boardList")
	a.text = "새 게시판"
	a.addEventListener('click', function(){
		for(var i =0; i< boardList.length; i++){
			if(this.text == boardList[i].boardTitle){
				$("#ipb-Title")[0].value = boardList[i].boardTitle;
				$("#ipb-Status")[0].value = "create";
				$("#select-Category")[0].value = boardList[i].categoryCode;
				$("#ipb-SortOrder")[0].value = boardList[i].boardSortOrder;
				if(boardList[i].boardActiveStatus == "true"){
					$("#active")[0].checked = true;
				}else{
					$("#inactive")[0].checked = true;
				}
			}
		}
		/* 삭제버튼 비활성화 */
		$('.btn-delete')[0].style.display = "none";
	})
	li.appendChild(a);
	ul.appendChild(li);
	$(".depth_1")[0].appendChild(ul);
	
})
/* 유효성 검사 */
function validation(boardTitle,boardStat,boardSortOrder,categoryCode) {
	/* 	정규식 validate_ooo 형식 */
	var validate_title = /^[가-힣a-zA-Z0-9_-\s]{1,15}$/; // 한글, 영어대소문자, 숫자, 언더바(_), 하이픈(-),1~15자리
	var validate_number = /^[0-9]{1,10}$/; // 한글, 영어대소문자, 숫자, 언더바(_), 하이픈(-),1~15자리
	
	/* 게시판명 체크 */
	if(boardTitle == "" || boardTitle == null ){//공백 체크(게시판명)
		alert("게시판 제목을 입력해주세요.")
		$("#ipb-Title").focus();
		return false;
	} 
	if(!validate_title.test(boardTitle)){		//포맷 유효성 체크(게시판명)
		alert("게시판명 조건 : 한글, 영어대소문자, 숫자, 언더바(_), 하이픈(-) 최대 15자");
		$("#ipb-Title").focus();
		return false;
	}
	/* 사용여부, 정렬순서, 카테고리 유효성 검사 */
	if(boardStat == "" || boardStat == null ){
		alert("사용여부는 필수 입력사항입니다.");
		$("#active")[0].focus();
		return false;
	}
	if(!validate_number.test(boardSortOrder)){
		alert("정렬순서는 숫자만 입력 가능합니다..");
		$("#ipb-SortOrder").focus();
		return false;
	}
	if(categoryCode == "" || categoryCode == null ){
		alert("카테고리는 필수 입력사항입니다.");
		$("#select-Category").focus();
		return false;
	}
	return true;
	
}

function getFormattedDate(){
	var today = new Date();
	var months = ["01", "02", "03","04", "05", "06", "07", "08", "09", "10", "11", "12"];
	var time = today.getHours()+":"+today.getMinutes()+":"+today.getMinutes();
	var formattedDate = today.getFullYear() + '-' + months[today.getMonth()] + '-' + today.getDate() + " " + time;
	return formattedDate;
}