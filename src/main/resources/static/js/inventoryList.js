var card = $(".card-selectable");
var leftSection = $("#left-section")
var rightSection = $("#right-section")
$(document).ready(function(){
  sectionCollapse(false)
})

card.click(function(e){
  if(rightSection.hasClass("section-collapsed")){
    // expand
    var itemName = e.currentTarget.querySelector(".item-name").getAttribute("value")
    getDetailList(itemName)
    sectionCollapse(true)
  }else{
    // collpase
    sectionCollapse(false)
  }
  
})

function sectionCollapse(pbCollapsed){
  // 섹션이 collapsed 인 상태이면
  if(pbCollapsed){
    rightSection.removeClass("section-collapsed")
    leftSection.width("")
  }else{
    rightSection.addClass("section-collapsed")
    leftSection.width("100%")
  }
}

function getDetailList(psItemCategory){
    $('#list222').dataTable({
      pageLength: 10,
      bPaginate: true,
      bLengthChange: true,
      lengthMenu : [ [ 3, 5, 10, -1 ], [ 3, 5, 10, "All" ] ],
      bAutoWidth: false,
      processing: true,
      ordering: true,
      serverSide: false,
      searching: true,
      destroy: true,
      ajax : {
          url:"/inventory/getDetailList",
          type:"GET",
          data: {itemCategory: psItemCategory},
          dataSrc :''
      },
      columns : [
          {data: "itemName"},
          {data: "itemCategory"},
          {data: "itemQuan"},
          {data: "itemExprDate"}
      ]

  });
  
   
}