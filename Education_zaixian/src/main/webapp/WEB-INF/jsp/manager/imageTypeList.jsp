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
#t1 {
	font-size: 20px
}

#ytr1 {
	text-align: center;
	width: 100%;
}
</style>
<script type="text/javascript">
	function save() {
		location.href = "/admin/imagetype/turn";
	}
</script>
<body>
	<form action="" method="post">
		<input type="button" value="新建类型" onclick="save()">
		<table class="table table-striped" width="100%" align="center">
			<tr id="t1">
				<td>类型ID</td>
				<td>类型名称</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${listType }" var="imageTypeList">
				<tr id="t1">
					<td>${imageTypeList.type_id }</td>
					<td>${imageTypeList.type_name }</td>
					<td><a href="/admin/getByIdType/${imageTypeList.type_id }">修改</a>&nbsp;&nbsp;<a
						href="/admin/deleteType/${imageTypeList.type_id }">删除</a></td>
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
</html>