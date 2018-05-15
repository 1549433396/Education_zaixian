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
	href="/css/bootstrap.min.css" />
<script src="/js/jquery-3.2.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" href="/css/bootstrap-table.min.css" />
<script src="/js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js"
	type="text/javascript" charset="utf-8"></script>
</head>

<style type="text/css">
#t2 {
	font-size: 20px;
}

#t1 {
	background-color: #000000;
	color: white;
}

#ytr1 {
	text-align: center;
	width: 100%;
}
</style>

<body>
	<form method="post" action="/admin/article/showlist">
		<input type="text" name="title" id="title" value="${title }"
			placeholder="标题/作者/来源" /> 创建时间：<input type="date"
			name="start" placeholder="开始时间" value="">--<input
			type="date" name="end" placeholder="结束时间"
			value="">&nbsp;&nbsp;<input type="submit"
			name="" id="" value="查找文章" />&nbsp; <input type="button" id=""
			value="清空" onclick="resetFun()" />&nbsp; <input type="button" id=""
			value="批量删除" onclick="deleteAll()" />&nbsp;
		<table class="table table-striped" width="100%" align="center">
			<tr id="t1">
				<td><input type="checkbox" name="all" onclick="userCheck(this)">全选</td>
				<td>标题</td>
				<td>作者</td>
				<td>来源</td>
				<td>创建时间</td>
				<td>点击量</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${listA }" var="listA">
				<tr id="t2">
					<td><input type="checkbox" name="all"
						value="${listA.article_id }" /></td>
					<td>${listA.title }</td>
					<td>${listA.author }</td>
					<td>${listA.source }</td>
					<td><fmt:formatDate value="${listA.create_time }" type="date"
							pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td>${listA.click_num }</td>
					<td><c:if test="${listA.releases==0 }">
							<a
								href="/admin/releaseEdit/${listA.article_id}/${listA.releases}">已发布</a>
						</c:if> <c:if test="${listA.releases==1}">
							<a
								href="/admin/releaseEdit/${listA.article_id}/${listA.releases}">未发布</a>
						</c:if> &nbsp;&nbsp;<a href="/admin/getById/${listA.article_id }">修改</a>&nbsp;&nbsp;<a
						href="/admin/delete/${listA.article_id }">删除</a></td>
				</tr>
			</c:forEach>
			<tr id="ytr1">
				<td colspan="9"><c:if test="${page.isFirstPage==true }">
						<a>首页</a>
					</c:if> <c:if test="${page.isFirstPage==false }">
						<a href="/admin/article/showlist?page=${page.firstPage }">首页</a>
					</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.hasPreviousPage==true }">
						<a href="/admin/article/showlist?page=${page.prePage }">上一页</a>
					</c:if> <c:if test="${page.hasPreviousPage==false }">
						<a>上一页</a>
					</c:if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					每页${page.pageSize }条
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${page.pageNum }/${page.pages }
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.hasNextPage==true }">
						<a href="/admin/article/showlist?page=${page.nextPage }">下一页</a>
					</c:if> <c:if test="${page.hasNextPage==false }">
						<a>下一页</a>
					</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.isLastPage==false }">
						<a href="/admin/article/showlist?page=${page.lastPage }">末页</a>
					</c:if> <c:if test="${page.isLastPage==true }">
						<a>末页</a>
					</c:if></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	if ("${article_type }" > 0) {
		$("#article_type").val("${article_type }");
	} else {
		$("#article_type").val("0");
	}

	if ("${title }" > 0) {
		$("#title").val("${title }");
	} else {
		$("#title").val("");
	}

	function resetFun() {
		var title = $("#title").val("");
		var article_type = $("#article_type").val("");
		var create_time = $("#create_time").val("");
		var publish_time = $("#publish_time").val("");
	}

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
			window.location.href = "/admin/deleteAll/" + chk_value;
		}
	}
</script>

</html>