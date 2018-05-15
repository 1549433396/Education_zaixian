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
<body>
	<form class="form-horizontal" enctype="multipart/form-data"
		method="post">
		<div class="form-group">
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />
			<input type="hidden" name="image_id"
				value="${edu_Website_Images.image_id }">
		</div>
		<div class="form-group">
			<label for="title" class="col-sm-1 control-label">图片标题</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="title" name="title"
					placeholder="允许输入3-100字符" value="${edu_Website_Images.title }"
					onblur="titleFun()">
			</div>
			<div class="col-sm-2">
				<span id="s1" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="describes" class="col-sm-1 control-label">图片描述</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="describes"
					name="describes" placeholder="允许输入3-200字符"
					value="${edu_Website_Images.describes }" onblur="describesFun()">
			</div>
			<div class="col-sm-2">
				<span id="s2" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="type_id" class="col-sm-1 control-label">图片类型</label>
			<div class="col-sm-4">
				<select id="type_id" name="type_ids"
					style="width: 530px; height: 30px">
					<c:forEach items="${listType }" var="listType">
						<option value="${listType.type_id }">${listType.type_name }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="link_address" class="col-sm-1 control-label">跳转链接</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="link_address"
					name="link_address" value="${edu_Website_Images.link_address }"
					placeholder="允许输入3-50字符" onblur="link_addressFun()">
			</div>
			<div class="col-sm-2">
				<span id="s3" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="series_numbers" class="col-sm-1 control-label">序列号</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="series_number"
					name="series_numbers" value="${edu_Website_Images.series_number }"
					placeholder="允许输入3-200字符" onblur="series_numbersFun()">
			</div>
			<div class="col-sm-2">
				<span id="s4" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="sort" class="col-sm-1 control-label">图片</label>
			<div class="col-sm-4">
				<image id="blah1" src="${edu_Website_Images.image_url }"
					style="width:530px; height:250px;" />
				<input type="file" name="file1" id="file1"><input
					type="hidden" name="hiddens"
					value="${edu_Website_Images.image_url }"> <font color="red">(请上传宽高为：640*357的图片)</font>
			</div>
		</div>
		<div class="form-group">
			<label for="sort" class="col-sm-1 control-label">背景色</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="color" name="color"
					placeholder="允许输入3-100字符(默认为空)"
					value="${edu_Website_Images.color }" onblur="colorFun()">
			</div>
			<div class="col-sm-2">
				<span id="s5" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">修改</button>
				<button type="button" class="btn btn-default" onclick="resultFun()">重置</button>
				<button type="button" class="btn btn-default" onclick="returnFun()">返回列表</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function Fun() {
		var s1 = document.getElementById("s1").innerHTML;
		var s2 = document.getElementById("s2").innerHTML;
		var s3 = document.getElementById("s3").innerHTML;
		var s4 = document.getElementById("s4").innerHTML;
		var s5 = document.getElementById("s5").innerHTML;
		var title = $("#title").val();
		var describes = $("#describes").val();
		var link_address = $("#link_address").val();
		var series_number = $("#series_number").val();
		var color = $("#color").val();
		if (s1 == "" && s2 == "" && s3 == "" && s4 == "" && s5 == ""
				&& title != "" && describes != "" && link_address != ""
				&& series_number != "" && color != "") {
			document.forms[0].action = "/admin/editImages";
			document.forms[0].submit();
		} else {
			alert("输入框内不能为空");
		}
	}
</script>
<script type="text/javascript">
	function readURL1(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah1').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#file1").change(function() {
		readURL1(this);
	});

	function readURL2(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah2').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#file2").change(function() {
		readURL2(this);
	});
	
	function titleFun() {
		var title = $("#title").val();
		if (title.trim().length == 0) {
			$("#s1").html("(不能为空)");
		} else {
			if (title.trim().length >= 3 && title.trim().length < 255) {
				$("#s1").html("");
			} else {
				$("#s1").html("(允许3-100个字符)");
				var s1 = document.getElementById("s1").innerText;
				$("#title").val("");
			}
		}
	}

	function describesFun() {
		var describes = $("#describes").val();
		if (describes.trim().length == 0) {
			$("#s2").html("(不能为空)");
		} else {
			if (describes.trim().length >= 3 && describes.trim().length < 100) {
				$("#s2").html("");
			} else {
				$("#s2").html("(允许3-100个字符)");
				var s2 = document.getElementById("s2").innerText;
				$("#describes").val("");
			}
		}
	}

	function link_addressFun() {
		var link_address = $("#link_address").val();
		if (link_address.trim().length == 0) {
			$("#s3").html("(不能为空)");
		} else {
			if (link_address.trim().length >= 3
					&& link_address.trim().length < 100) {
				$("#s3").html("");
			} else {
				$("#s3").html("(允许3-100个字符)");
				var s3 = document.getElementById("s3").innerText;
				$("#link_address").val("");
			}
		}
	}

	function series_numbersFun() {
		var series_number = $("#series_number").val();
		var series_numbers = /^[1-9]\d*$|^0$/;
		if (series_numbers.test(series_number) == true) {
			$("#s4").html("");
			return true;
		} else {
			$("#s4").html("(文本框内必须输入数字)");
			$("#series_numbers").val("");
			return false;
		}
	}

	function colorFun() {
		var color = $("#color").val();
		if (color.trim().length == 0) {
			$("#s5").html("(不能为空)");
		} else {
			if (color.trim().length >= 3 && color.trim().length < 100) {
				$("#s5").html("");
			} else {
				$("#s5").html("(允许3-100个字符)");
				var s5 = document.getElementById("s5").innerText;
				$("#series_numbers").val("");
			}
		}
	}

	function resultFun() {
		$("#title").val("");
		$("#describes").val("");
		$("#type_id").val("");
		$("#link_address").val("");
		$("#series_number").val("");
		$("#preview_url").val("");
		$("#color").val("");
	}

	function returnFun() {
		window.location.href = "/admin/website/imagesPage";
	}
</script>
</html>