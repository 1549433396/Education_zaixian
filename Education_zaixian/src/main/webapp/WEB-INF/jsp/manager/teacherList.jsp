<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师列表</title>
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
<script src="../../../js/jquery-3.2.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../../../js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="../../../css/bootstrap-table.min.css" />
<script src="../../../js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="../../../js/bootstrap-table-zh-CN.min.js"
	type="text/javascript" charset="utf-8"></script>
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
				<form id="searchForm" action="/admin/teacher/list" method="post">
					<div class="col-lg-11" align="center">
						<input type="hidden" name="page" id="page" value="${pageNum }" /> <span>讲师名称:</span>
						<input type="text" class="form-control" name="qname" id="qname"
							placeholder="讲师名" value="${name }" style="width: 150px;" /> <select
							name="is_star" class="form-control" id="is_star"
							value="${is_star }">
							<option value="0">请选择</option>
							<option value="1">高级讲师</option>
							<option value="2">首席讲师</option>
						</select> <span>添加时间:</span> <input type="text" onClick="WdatePicker()"
							id="create_time" name="create_time" class="form-control"
							placeholder="开始添加时间" value="${create_time }"
							style="width: 150px;" /> <span>-</span> <input type="text"
							onClick="WdatePicker()" id="create_times" name="create_times"
							class="form-control" placeholder="结束添加时间"
							value="${create_times }" style="width: 150px;" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="image"
							src="../../../images/search.png" class="submit_btn"
							style="margin-top: 40px; margin-bottom: -9px;" /> <input
							type="image" src="../../../images/null.png" onclick="nullFun()"
							class="btn" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="col-lg-9">
		<table class="table table-condensed">
			<tr bgcolor="#272727" style="color: white; font-size: 16px;"
				align="center">
				<td>ID</td>
				<td>名称</td>
				<td>头衔</td>
				<td>专业</td>
				<td width="350">资历</td>
				<td width="100">简介</td>
				<td>添加时间</td>
				<td>排序</td>
				<td width="100">操作</td>
			</tr>
			<c:forEach items="${teas }" var="t">
				<tr style="color: #888888; font-size: 14px;" align="center">
					<td title="${t.id }">${t.id }</td>
					<td title="${t.name }">${t.name }</td>
					<c:if test="${t.is_star==1 }">
						<td title="${t.is_star}">高级讲师</td>
					</c:if>
					<c:if test="${t.is_star==2 }">
						<td title="${t.is_star}">首席讲师</td>
					</c:if>
					<td title="${t.subject_id.subject_name }">${t.subject_id.subject_name }</td>
					<td width="350" title="${t.education }">${t.education }</td>
					<td width="100" title="${t.career }"><font size="4">......</font></td>
					<td title="${t.create_time }"><fmt:formatDate value="${t.create_time }" type="date"
							pattern="yyyy/MM/dd hh:mm:ss" /></td>
					<td title="${t.sort }">${t.sort }</td>
					<td width="100"><a href="/admin/teacher/getIdByTM/${t.id }"><img
							src="../../../images/update.png" /></a>&nbsp;&nbsp; <a
						href="/admin/teacher/deleteTM/${t.id }"><img
							src="../../../images/delete.png" /></a></td>
				</tr>
			</c:forEach>
		</table>

		<div align="center" style="font-size: 16px;color: #AAAAB4;font-family: 微软雅黑;">
			<a href="javascript:onpage()">上一页</a>&nbsp; &nbsp;&nbsp;&nbsp;
			<a href="javascript:nextpage()">下一页</a>
		</div>
	</div>

</body>

<script type="text/javascript">
	$("#qname").val("${qname}");
	var is = "${is_star}";
	if (is != null && is > 0) {
		$("#is_star").val(is);
	} else {
		$("#is_star").val("0");
	}
	$("#create_time").val("${create_time}");
	$("#create_times").val("${create_times}");

	function nullFun() {
		$("#qname").val("");
		$("#is_star").val("0");
		$("#create_time").val("");
		$("#create_times").val("");
	}
	
	var page = ${pageNum};
	function onpage() {
		$("#page").val(page-1);
		$("#searchForm").submit();
	}

	function nextpage() {
		$("#page").val(page+1);
		if(page+1 > "${page.pages}"){
			$("#page").val("${page.pages}");
		}
		$("#searchForm").submit();
	}
</script>

</html>