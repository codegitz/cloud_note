//更多按钮，搜索加载下一页笔记
function moreSearchShare(){
	//获取参数
	var keyword=$("#search_note").val().trim();
	page=page+1;
	//发送ajax请求，加载列表
	loadPageShare(keyword,page);
};

function loadPageShare(keyword,page){
	// 发送ajax请求
	$.ajax({
				url : path + "/share/search.do",
				data : {"keyword" : keyword,"page":page},
				type : "post",
				dataType : "json",
				success : function(result) {
					var shares = result.data;
					for (var i = 0; i <shares.length; i++) {
						// 获取shareID
						var shareId = shares[i].cn_share_id;
						// 获取shareTitle
						var shareTitle = shares[i].cn_share_title;
						// 获取li对象
						var sli = "";
						sli += '<li class="online">';
						sli += '<a >';
						// 动态替换列表标题
						sli += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
						sli += shareTitle;
						sli += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
						sli += '</a>';
						sli += '</li>';
						var $li=$(sli);
						//绑定shareid
						$li.data("shareId",shareId);
						//添加li到ul中
						$("#search_ul").append($li);
						//切换显示区
						$("#pc_part_2").hide();//隐藏
						$("#pc_part_6").show();//显示
					}
				},
				error : function() {
					alert("搜索失败");
				}
			});
};
//按回车搜索分享笔记，分页显示
function searchShareNote(event) {
	// alert("绑定成功");
	var code = event.keyCode;
	if (code == 13) {
		$("#search_ul li").remove();
		// 获取请求参数
		var keyword = $("#search_note").val().trim();
		page=1;
		loadPageShare(keyword,page);
	}
};