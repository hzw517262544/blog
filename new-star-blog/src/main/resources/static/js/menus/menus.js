/*!
  * Bolg main JS.
 * 
 * @since: 1.0.0 2017/3/9
 */
"use strict";
//# sourceURL=main.js
 
// DOM 加载完再执行
$(function() {

	var _pageSize; // 存储用于搜索

	// 根据用户名、页面索引、页面大小获取用户列表
	function getMenu(pageIndex, pageSize) {
		 $.ajax({
			 url: "/sysMenu",
			 contentType : 'application/json',
			 data:{
				 "async":true,
				 "pageIndex":pageIndex,
				 "pageSize":pageSize,
				 "name":$("#menuName").val()
			 },
			 success: function(data){
				 $("#mainContainer").html(data);
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	}

	// 分页
	$.tbpage("#mainContainer", function (pageIndex, pageSize) {
        getMenu(pageIndex, pageSize);
		_pageSize = pageSize;
	});

	// 搜索
	$("#searchMenuBtn").click(function() {
        getMenu(0, _pageSize);
	});

	// 获取添加用户的界面
	$("#addMenu").click(function() {
		$.ajax({
			 url: "/sysMenu/add",
			 success: function(data){
				 $("#menuFormContainer").html(data);
		     },
		     error : function(data) {
		    	 toastr.error("error!");
		     }
		 });

	});

	// 获取编辑用户的界面
	$("#rightContainer").on("click",".blog-edit-menu", function () {
		$.ajax({
			 url: "/sysMenu/edit/" + $(this).attr("menuId"),
			 success: function(data){
				 $("#menuFormContainer").html(data);
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	});
    //详情界面
	$("#rightContainer").on("click",".blog-detail-menu",function (){
        $.ajax({
            url: "/sysMenu/detail/" + $(this).attr("menuId"),
            success: function(data){
                $("#menuFormContainer").html(data);
            },
            error : function() {
                toastr.error("error!");
            }
        });
    });

	// 提交变更后，清空表单
	$("#submitEdit").click(function() {
		$.ajax({
			 url: "/sysMenu",
			 type: 'POST',
			 data:$('#menuForm').serialize(),
			 success: function(data){
				 $('#menuForm')[0].reset();

				 if (data.success) {
					 // 从新刷新主界面
                     getMenu(0, _pageSize);
				 }
                 toastr.info(data.message);

		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	});

	// 删除菜单
	$("#rightContainer").on("click",".blog-delete-menu", function () {
		// 获取 CSRF Token
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");
		$.ajax({
			 url: "/sysMenu/" + $(this).attr("menuId") ,
			 type: 'DELETE',
			 beforeSend: function(request) {
                 request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
             },
			 success: function(data){
				 if (data.success) {
					 // 从新刷新主界面
                     getMenu(0, _pageSize);
				 }
				 toastr.info(data.message);
		     },
		     error : function() {
		    	 toastr.error("error!");
		     }
		 });
	});
});