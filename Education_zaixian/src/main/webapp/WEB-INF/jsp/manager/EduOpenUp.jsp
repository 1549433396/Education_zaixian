<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>批量开通学员</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript" src="/common/layui/lay/modules/mobile.js"></script>
<!-- <script type="text/javascript" src="/js/jquery.js"></script> -->
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<link rel="stylesheet" href="/common/layui/css/layui.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/modules/layer/default/layer.css" />
<script src="/common/layui/lay/modules/layer.js"></script>
<style type="text/css">
img {
	width: 35px;
	height: 35px;
	border-radius: 50%;
}

h2 {
	text-align: center;
}

#ptid {
	width: 200px;
}

#qname {
	width: 440px;
}

#search_btn {
	width: 100px;
}

#container {
	text-align: center;
}

#tab1 {
	width: 1000px;
	margin: 10px auto;
	border: 1px solid gainsboro;
	padding-left: 100px;
	margin-left: auto 100px;
}
</style>

</head>
<body>
	<form action="" method="post">
		<table class="table" width="90%" id="tab1">
			<tr>
				<td rowspan="5">*信息描述</td>
				<td>excel模板说明:</td>
			</tr>
			<tr>
				<td>第一列:用户的电子邮件必须是未注册过得</td>
			</tr>
			<tr>
				<td>第二列:用户的手机号</td>
			</tr>
			<tr>
				<td>第三列:密码，如不填写默认111111，不得填入非法字符例如.*#$等</td>
			</tr>
			<tr>
				<td>第四列:赠送课程模板（<a href="#">点击下载模板</a>）
				</td>
			</tr>
			<tr>
			 	<td>导入中出错选择项</td>
				<td><select class="layui-input" name="" id="">
						<option value="-1">--请选择--</option>
						<option value="1">跳过</option>
				</select></td>
			</tr>
			<tr>
				<td>上传</td>
				<td><input type="file" name="file"/><input type="submit" value="提交" /><input
					type="button" value="返回" /></td>
			</tr>
		</table>
	</form>
</body>
</html>