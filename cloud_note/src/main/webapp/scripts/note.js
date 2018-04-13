//加载笔记本笔记
function loadBookNotes(){
            		  //设置选中效果
            		  $("#book_ul a").removeClass("checked");
            		  $(this).find("a").addClass("checked");
            		  
            		 //获取参数
            		 var bookId=$(this).data("bookId");
            		 //alert(bookId+"这是"); 
            		 $.ajax({
            			 url:path+"/note/loadnotes.do",
            			 type:"post",
            			 data:{"bookId":bookId},
            			 dataType:"json",
            			 success:function(result){
            				 //获取笔记信息
            				 var notes=result.data;
            				 //清除原列表信息
            				 $("#note_ul").empty();
            				 //循环添加li
            				 for(var i=0;i<notes.length;i++){
            					 //获取笔记id
            					 var noteId=notes[i].cn_note_id;
            					 //获取笔记标题
            					 var noteTitle=notes[i].cn_note_title;
            					 //生成笔记li
            					 createNoteLi(noteId,noteTitle);
            					 
            				 }
            			 },
            			 error:	 function(){
            				 alert("笔记加载错误");
            			 }
            		 });
            	  };
//显示笔记信息
function loadNote(){
	//设置选中效果
	$("#note_ul a").removeClass("checked");
	  $(this).find("a").addClass("checked");
	//获取请求参数
	var noteId=$(this).data("noteId");
	//alert(noteId);
	//发送ajax请求
	$.ajax({
		url:path+"/note/load.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
		if(result.status==0){
			var note=result.data;
			//alert(note.cn_note_title+","+note.cn_note_id);
			var title=note.cn_note_title;
			var body=note.cn_note_body;
			$("#input_note_title").val(title);
			um.setContent(body);
		}
		},
		error:function(){
			alert("笔记信息加载失败");
		}
	});
}            	  


function createNoteLi(noteId,noteTitle){
	var sli="";
	sli+='<li class="online">';
	sli+='<a >';
	//动态替换列表标题
	sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	sli+=noteTitle;
	sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
    sli+='</a>';
    sli+='<div class="note_menu" tabindex="-1">';
	sli+='<dl>';
		sli+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至...><i class="fa fa-random"></i></button></dt>';
		sli+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';
		sli+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';
	sli+='</dl>';
sli+='</div>';
sli+='</li>' ;
//转换成jQuery对象
    var $li=$(sli);
    //保存noteId
    $li.data("noteId",noteId);
    //将li追加到ul中
    $("#note_ul").append($li);

};

//保存后更新笔记信息
function saveNote(){
	//获取参数
	var $li=$("#note_ul a.checked").parent();
	//获取笔记本ID
	var noteId=$li.data("noteId");
	//获取笔记的标题和内容
	var noteTitle=$("#input_note_title").val().trim();
	var noteBody=um.getContent();
	//alert(noteId+","+noteTitle+","+noteBody);
	//发送ajax请求
	$.ajax({
		url:path+"/note/update.do",
		data:{"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status==0){
				var str="";
				str+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
				str+=noteTitle;
				str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
				//将str替换到li的a元素里
				$li.find("a").html(str);
                //提示成功				
				alert(result.msg);
			}
			
		},
		error:	function(){
			alert("笔记保存失败");
		}
	});
	
	
};

