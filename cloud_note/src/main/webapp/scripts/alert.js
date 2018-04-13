//弹出新建笔记本alert
function alertAddBookWindow() {
	// 弹出新建笔记本对话框
	$("#can").load("alert/alert_notebook.html");
	// 显示背景
	$(".opacity_bg").show();
};

// 创建笔记
function createNoteBook() {
	var bookName = $("#input_notebook").val().trim();
	var userId = getCookie("userId");
	// closeAlertWindow();
	alert(bookName + "," + userId);
	if (bookName != "") {
		$.ajax({
			url : path + "/book/add.do",
			data : {
				"userId" : userId,
				"bookName" : bookName
			},
			type : "post",
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					closeAlertWindow();
					var book = result.data;
					createBookLi(userId, book.cn_notebook_name);
					alert("笔记本创建成功");
				}
			},
			error : function() {
				alert("创建笔记本失败");
			}
		});
	} else {
		alert("请输入笔记本名字");
	}

};
// 弹出新建笔记框
function alertAddNoteWindow() {
	// 判断是否有笔记本元素
	var $li = $("#book_ul a.checked").parent();
	if ($li.length == 0) {
		alert("请选择笔记本");
	} else {
		// 弹出创建笔记框
		$("#can").load("alert/alert_note.html");
		$(".opacity_bg").show();
	}

};
// 创建新笔记
function createNote() {
	// alert("绑定成功");
	var title = $("#input_note").val().trim();
	// 获取用户id
	var userId = getCookie("userId");
	// 获取笔记本id
	var $li = $("#book_ul a.checked").parent();
	var bookId = $li.data("bookId");
	// 数据格式检测
	var ok = true;
	if (title == "") {// 判断是否为空
		ok = false;
		$("#title_span").html("标题不能为空");
	}
	if (userId == null) {// 检测是否失效
		window.location.href = "/cloud_note/log_in.html";

	}
	// 发送ajax请求
	if (ok == true) {
		$.ajax({
			url : path + "/note/add.do",
			data : {
				"userId" : userId,
				"title" : title,
				"bookId" : bookId
			},
			type : "post",
			dataType : "json",
			success : function(result) {
				var note = result.data;
				var noteId = note.cn_note_id;
				var noteTitle = note.cn_note_title;
				if (result.status == 0) {
					closeAlertWindow();
					createNoteLi(noteId, noteTitle)
					alert(result.msg);
				} else {
					alert(result.msg);
				}
			},
			error : function() {
				alert("创建笔记失败");
			}
		});
	}
};

// 显示下拉菜单
function showMenu() {
	// alert("绑定成功");
	// 隐藏笔记菜单
	$("#note_ul div").hide();
	// 显示点击菜单
	var note_menu = $(this).parents("li").find("div");
	note_menu.slideDown(1000);
	return false;// 阻止冒泡事件
};
function showBookMenu() {
	// alert("绑定成功");
	// 隐藏笔记菜单
	$("#book_ul div").hide();
	// 显示点击菜单
	var note_menu = $(this).parents("li").find("div");
	note_menu.slideDown(1000);
	return false;// 阻止冒泡事件
};
// 分享笔记
function shareNote() {
	// alert("绑定成功");
	// 获取笔记ID
	var $li = $("#note_ul a.checked").parent();
	var noteId = $li.data("noteId");
	// var noteTitle=$li.data("noteTitle");
	// var noteBody=$li.data("noteBody");
	// alert(noteId+","+noteTitle+","+noteBody);
	$
			.ajax({
				url : path + "/share/add.do",
				data : {
					"noteId" : noteId
				},
				type : "post",
				dataType : "json",
				success : function(result) {
					var note = result.data;
					var noteTitle = note.cn_note_title;
					if (result.status == 0) {
						var str = "";
						str += '<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
						str += noteTitle;
						str += '<i class="fa fa-sitemap">';
						str += '<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';
						// 将str替换到li的a元素里
						$li.find("a").html(str);
						alert(result.msg);
					} else {
						alert(result.msg);
					}
				},
				error : function() {
					alert("分享笔记失败");
				}
			});
};

// 弹出删除笔记页面
function showDeleteAlert() {
	// alert("绑定成功");
	// 弹出创建笔记框
	$("#can").load("alert/alert_delete_note.html");
	$(".opacity_bg").show();
}
function showDeleteBookAlert() {
	// alert("绑定成功");
	// 弹出创建笔记框
	$("#can").load("alert/alert_delete_notebook.html");
	$(".opacity_bg").show();
}
// 删除笔记
function deleteNote() {
	// alert("绑定删除成功");
	// 获取笔记ID
	var $li = $("#note_ul a.checked").parent();
	var noteId = $li.data("noteId");
	// alert(noteId);
	$.ajax({
		url : path + "/note/delete.do",
		data : {
			"noteId" : noteId
		},
		type : "post",
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				// loadBookNotes();
				alert(result.msg);
			} else {
				alert(result.msg);
			}
		},
		error : function() {
			alert("删除失败");
		}
	});
};

function deleteNoteBook() {
	alert("绑定删除成功");
	// 获取笔记ID
	var $li = $("#book_ul a.checked").parent();
	var bookId = $li.data("bookId");
	alert(bookId);
	
};

//关闭对话框
function closeAlertWindow() {
	//清空div
	$("#can").html("");
	//隐藏背景色
	$(".opacity_bg").hide();
};