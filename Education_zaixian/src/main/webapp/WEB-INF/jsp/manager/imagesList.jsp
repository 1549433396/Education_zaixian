<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../../../css/bootstrap.min.css" />
<script src="../../../js/jquery-3.2.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../../../js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" href="../../../css/bootstrap-table.min.css" />
<script src="../../../js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../../../js/bootstrap-table-zh-CN.min.js"
	type="text/javascript" charset="utf-8"></script>
</head>

<style type="text/css">
#t1 {
	background-color: #000000;
	color: white;
}

#t2 {
	font-size: 20px;
}
</style>
<style type="text/css">
#ytr1 {
	text-align: center;
	width: 100%;
}
</style>
</head>
<script type="text/javascript">
	function getByImgeType() {
		window.location.href = "/admin/getByImgeType";
	}
</script>
<body>
	<form action="/admin/website/imagesPage" method="post">
		<input type="text" name="title" id="title" value="${title }"
			placeholder="输入标题查询" /> <select id="type_ids" name="type_ids">
			<option value="-1">请选类型</option>
			<c:forEach items="${listType }" var="listType">
				<option value="${listType.type_id }">${listType.type_name }</option>
			</c:forEach>
		</select> <input type="submit" name="" id="" value="查找文章" onclick="searchFun()" />&nbsp;
		<input type="button" id="" value="清空" onclick="resetFun()" />&nbsp; <input
			type="button" id="" value="批量删除" onclick="deleteAll()" />&nbsp; <input
			type="button" value="新建图片" onclick="getByImgeType()" /> <input
			type="hidden" name="image_id" value="${edu_Website_Images.image_id }" />
		<table class="table table-striped" width="100%" align="center">
			<tr id="t1">
				<td><input type="checkbox" name="all" onclick="userCheck(this)">全选</td>
				<td>编号</td>
				<td>图片地址</td>
				<td>图链接地址</td>
				<td>图标题</td>
				<td>图片类型</td>
				<td>序列号</td>
				<td>背景色</td>
				<td>图片描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${listAll }" var="listAll">
				<tr id="t2">
					<td><input type="checkbox" name="all"
						value="${listAll.image_id }" /></td>
					<td>${listAll.image_id }</td>
					<td><img alt="图片" style="width: 100px; height: 100px"
						src="${listAll.image_url }"></td>
					<td>${listAll.link_address }</td>
					<td>${listAll.title }</td>
					<td>${listAll.type_id.type_name}</td>
					<td>${listAll.series_number }</td>
					<td>${listAll.color }</td>
					<td>${listAll.describes }</td>
					<td><c:if test="${listAll.shows==0 }">
							<a href="/admin/showsEdit/${listAll.image_id }/${listAll.shows }">已展示</a>
						</c:if> <c:if test="${listAll.shows==1 }">
							<a href="/admin/showsEdit/${listAll.image_id }/${listAll.shows }">未展示</a>
						</c:if><a href="/admin/getByIdImage/${listAll.image_id }">修改</a>&nbsp;&nbsp;<a
						href="/admin/deleteImage/${listAll.image_id }">删除</a></td>
				</tr>
			</c:forEach>
			<tr id="ytr1">
				<td colspan="9"><c:if test="${page.isFirstPage==true }">
						<a>首页</a>
					</c:if> <c:if test="${page.isFirstPage==false }">
						<a href="/admin/website/imagesPage?page=${page.firstPage }">首页</a>
					</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.hasPreviousPage==true }">
						<a href="/admin/website/imagesPage?page=${page.prePage }">上一页</a>
					</c:if> <c:if test="${page.hasPreviousPage==false }">
						<a>上一页</a>
					</c:if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					每页${page.pageSize }条
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${page.pageNum }/${page.pages }
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.hasNextPage==true }">
						<a href="/admin/website/imagesPage?page=${page.nextPage }">下一页</a>
					</c:if> <c:if test="${page.hasNextPage==false }">
						<a>下一页</a>
					</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.isLastPage==false }">
						<a href="/admin/website/imagesPage?page=${page.lastPage }">末页</a>
					</c:if> <c:if test="${page.isLastPage==true }">
						<a>末页</a>
					</c:if></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		//全选,设置chheckbox name='all' tbody id=tb
		$("input[name=all]").click(function() {
			if (this.checked) {
				$("#tb :checkbox").prop("checked", true);
			} else {
				$("#tb :checkbox").prop("checked", false);
			}
		});
	});
	//单选 设置name=id
	function userCheck(ths) {
		if (ths.checked == false) {
			$("input[name=all]:checkbox").prop('checked', false);
		} else {
			var count = $("input[name='id']:checkbox:checked").length;
			if (count == $("input[name='id']:checkbox").length) {
				$("input[name=all]:checkbox").prop("checked", true);
			}
		}
	}

	function resetFun() {
		$("#title").val("");
		$("#type_id").val("");
	}

	function deleteAll() {
		var chk_value = [];//定义一个数组
		//利用将name等于ids的多选按钮得到
		$("input[name='all']:checked").each(function() {
			//将选中额数据存到数组里
			chk_value.push($(this).val());
		});
		if (chk_value.length == 0) {
			alert("你还没有选择任何内容！");
		}
		if (chk_value.length > 0) {
			window.location.href = "/admin/deleteImageAll/" + chk_value;
		}
	}
</script>
</html>