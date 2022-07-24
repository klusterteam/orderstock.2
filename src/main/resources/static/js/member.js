    	function memberSearchBtn(){
			var str='';
			$.ajax({
				type: 'get',
				url: '/admin/getMemberSearch',
				data: $("form[name=searchForm]").serialize(),
				success : function(data){
					console.log(data);
					$('#memberListTbody').empty();
						for(var i= 0; i<data.length; i++){
							console.log(data[i].idx);
							str='<tr>'
							str+='<td>'+data[i].idx+'</td>'
							str+='<td>'+data[i].memberName+'</td>'
							str+='<td>'+data[i].memberCategory.memberCategoryName+'</td>'
							str+='<td>'+data[i].memberEmail+'</td>'
							str+='<td>'+data[i].memberPhone+'</td>'
							str+='<td>구현중</td>'
							str+='<td><a href="/admin/memberdetail?idx='+data[i].idx+'" class="btn btn-primary" >상세보기</a>     '
							str+='<a href="/admin/memberdelete?idx='+data[i].idx+'" class="btn btn-danger">삭제</a></td>'
							str+='</tr>'
							$('#memberListTbody').append(str);
						}
						
							
						
					
				}
			});
		}