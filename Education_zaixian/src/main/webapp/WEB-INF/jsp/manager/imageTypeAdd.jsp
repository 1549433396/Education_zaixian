<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/js/utf8-jsp/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
<script src="/js/jquery-3.2.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap-table.min.css" />
<script src="/js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<form class="form-horizontal" method="post">
		<div class="form-group">
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />
		</div>
		<div class="form-group">
			<label for="type_names" class="col-sm-1 control-label">类别名称</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="type_names"
					name="type_names" placeholder="允许输入3-50字符" value=""
					onblur="type_namesFun()">
			</div>
			<div class="col-sm-2">
				<span id="s1" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-default" onclick="Fun()">添加</button>
				<button type="button" class="btn btn-default" onclick="resetFun()">重置</button>
				<button type="button" class="btn btn-default" onclick="returnFun()">返回列表</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function Fun() {
		var type_names = $("#type_names").val();
		var s1 = document.getElementById("s1").innerHTML;
		if (type_names != "" && s1 == "") {
			document.forms[0].action = "/admin/imagetype/add";
			document.forms[0].submit();
		} else {
			alert("输入框内不能为空");
		}
	}

	function returnFun() {
		window.location.href = "/admin/imagetype/getlist";
	}
	function type_namesFun() {
		var type_names = $("#type_names").val();
		if (type_names.trim().length == 0) {
			$("#s1").html("(不能为空)");
		} else {
			if (type_names.trim().length >= 3 && type_names.trim().length < 100) {
				$("#s1").html("");
			} else {
				$("#s1").html("(字符不符)");
				var s1 = document.getElementById("s1").innerText;
				$("#type_names").val("");
			}
		}
	}
</script>
</html>