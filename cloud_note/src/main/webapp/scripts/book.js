//根据用户id查询笔记本列表

function loadUserBooks(){
	//获取userId
	var userId=getCookie("userId");
	//alert(userId);
	//判断是否获取到了有效的userId
	if(userId==null){
		window.location.href="/cloud_note/log_in.html";
	}else{
		//发送ajax请求
		$.ajax({
			url:path+"/book/loadBooks.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(result){
				//判断查询是否成功
				if(result.status==0){
					//获取笔记本集合
					var books=result.data;
					for(var i=0;i<books.length;i++){
						//获取笔记本id
						var bookId=books[i].cn_notebook_id;
						//获取笔记本名字
						var bookName=books[i].cn_notebook_name;
						//创建一个笔记本列表li元素
						createBookLi(bookId,bookName);
					}
					
				}
			},
			error:function(){
				alert("笔记本加载失败");
			}
			
		});
		
	}
	
};

function createBookLi(bookId,bookName){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';
    sli+='	<i class="fa fa-book" title="online" rel="tooltip-bottom">';
    sli+='</i>';
    sli+=bookName;
    sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
    sli+="</a>";
    sli+='<div class="note_menu" tabindex="-1">';
	sli+='<dl>';
		sli+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至...><i class="fa fa-random"></i></button></dt>';
		sli+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
		sli+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli+='</dl>';
    sli+='</div>';
    sli+="</li>";
	//将sli字符串转化为jQuery对象li元素 
    var $li=$(sli);
    //将bookId与jQuery对象绑定
    $li.data("bookId",bookId);
    //将li元素添加到ul列表区
    $("#book_ul").append($li);
    
}