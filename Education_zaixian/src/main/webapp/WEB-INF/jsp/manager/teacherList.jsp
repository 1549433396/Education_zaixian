<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>教师列表</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<script src="../../../js/jquery-3.2.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="../../../css/bootstrap-table.min.css" />
		<script src="../../../js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<style type="text/css">
		.container {
			margin-top: -25px;
		}
		
		a {
			color: black;
		}
		
		#pageDiv {
			text-align: center;
			width: 1100px;
			font-size: 18px;
			font-weight: bold;
		}
	</style>

	<body>

		<div class="container">
			<div class="col-lg-offset-1">
				<div class="form-inline">
					<form action="/admin/teacher/list/getById" method="post">
						<div class="col-lg-11" align="center">
							<span>讲师名称:</span>
							<input type="text" class="form-control" name="qname" id="qname" placeholder="讲师名" value="${name }" style="width: 150px;" />
							<select name="is_star" class="form-control" id="is_star" value="${is_star }">
								<option value="0">请选择</option>
								<option value="1">高级讲师</option>
								<option value="2">首席讲师</option>
							</select>
							<span>添加时间:</span>
							<input type="text" onClick="WdatePicker()" id="create_time" name="create_time" class="form-control" placeholder="开始添加时间" value="${create_time }" style="width: 150px;" />
							<span>-</span>
							<input type="text" onClick="WdatePicker()" id="create_times" name="create_times" class="form-control" placeholder="结束添加时间" value="${create_times }" style="width: 150px;" /> &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="image" src="../../../images/search.png" class="submit_btn" style="margin-top: 40px; margin-bottom: -9px;" />
							<input type="image" src="../../../images/null.png" onclick="nullFun()" class="btn" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-lg-9">
			<table class="table table-condensed">
				<tr bgcolor="#272727" style="color: white;font-size: 16px;" align="center">
					<td>ID</td>
					<td>名称</td>
					<td>头衔</td>
					<td>专业</td>
					<td width="200">资历</td>
					<td width="400">简介</td>
					<td>添加时间</td>
					<td>排序</td>
					<td width="100">操作</td>
				</tr>
				<c:forEach items="${teas }" var="t">
					<tr style="color: #888888;font-size: 14px;" align="center">
						<td>${t.id }</td>
						<td>${t.name }</td>
						<c:if test="${t.is_star==1 }">
							<td>高级讲师</td>
						</c:if>
						<c:if test="${t.is_star==2 }">
							<td>首席讲师</td>
						</c:if>
						<td>${t.subject_id.subject_name }</td>
						<td width="200">${t.education }</td>
						<td width="400" title="${t.career }">${t.career }</td>
						<td>
							<fmt:formatDate value="${t.create_time }" type="date" pattern="yyyy/MM/dd hh:mm:ss" />
						</td>
						<td>${t.sort }</td>
						<td width="100">
							<a href="/admin/teacher/getIdByTM/${t.id }"><img src="../../../images/update.png" /></a>&nbsp;&nbsp;
							<a href="/admin/teacher/deleteTM/${t.id }"><img src="../../../images/delete.png" /></a>
						</td>
					</tr>
				</c:forEach>
			</table>

			<div id="pageDiv">
				<span>
				每页${page.pageSize }条 &nbsp;当前页${page.size }条  &nbsp;${page.pageNum }/${page.pages }页
				 &nbsp;记录数${page.total }
			</span> &nbsp;
				<c:if test="${page.isFirstPage==true }">
					<a>首页</a>
				</c:if>
				<c:if test="${page.isFirstPage==false }">
					<a href="/admin/teacher/list?page=${page.firstPage}&qname=${qname}&is_star=${is_star}">首页</a>
				</c:if>
				&nbsp;
				<c:if test="${page.hasPreviousPage==true }">
					<a href="/admin/teacher/list?page=${page.prePage }&qname=${qname}&is_star=${is_star}">上一页</a>
				</c:if>
				<c:if test="${page.hasPreviousPage==false }">
					<a>上一页</a>
				</c:if>
				&nbsp;
				<c:if test="${page.hasNextPage==true }">
					<a href="/admin/teacher/list?page=${page.nextPage }&qname=${qname}&is_star=${is_star}">下一页</a>
				</c:if>
				<c:if test="${page.hasNextPage==false }">
					<a>下一页</a>
				</c:if>
				&nbsp;
				<c:if test="${page.isLastPage==true }">
					<a>末页</a>
				</c:if>
				<c:if test="${page.isLastPage==false }">
					<a href="/admin/teacher/list?page=${page.lastPage }&qname=${qname}&is_star=${is_star}">末页</a>
				</c:if>
			</div>
		</div>

	</body>

	<script type="text/javascript">
		$("#qname").val("${qname}");
		var is = "${is_star}";
		if(is != null && is > 0) {
			$("#is_star").val(is);
		} else {
			$("#is_star").val("0");
		}
		$("#create_time").val("${create_time}");
		$("#create_times").val("${create_times}");
		
		function nullFun(){
			$("#qname").val("");
			$("#is_star").val("0");
			$("#create_time").val("");
			$("#create_times").val("");
		}
	</script>

</html>