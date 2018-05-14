<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>用户添加</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix changepwd">
				<form class="layui-form col-lg-4" method="post" action="/admin/sysuser/createuser">
					<div class="layui-form-item">
						<label class="layui-form-label">用户名</label>
						<div class="layui-input-block">
							<input type="text" name="login_name" id="user_name"
								autocomplete="off" placeholder="请输入用户名"
								class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">密码</label>
						<div class="layui-input-block">
							<input type="password" name="login_pwd" id="user_pwd" value=""
								autocomplete="off" class="layui-input" placeholder="请输入密码">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">确认密码</label>
						<div class="layui-input-block">
							<input type="password" name="upwds" id="upwd" autocomplete="off"
								class="layui-input" value="" placeholder="请输入确认新密码">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">用户真实姓名</label>
						<div class="layui-input-block">
							<input type="text" name="user_name" id="user_name"
								autocomplete="off" placeholder="请输入用户真实姓名"
								class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">邮箱</label>
						<div class="layui-input-block">
							<input type="text" name="email" id="user_name"
								autocomplete="off" placeholder="请输入邮箱"
								class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label">电话</label>
						<div class="layui-input-block">
							<input type="text" name="tel" id="user_name"
								autocomplete="off" placeholder="请输入电话"
								class="layui-input">
						</div>
					</div>


					<div class="layui-form-item">
						<label class="layui-form-label">角色</label>
						<div class="layui-input-block">
							<select name="role_id">
								<c:forEach items="${roles }" var="r">
									<option value="${r.role_id }">${r.role_name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="layui-form-item change-submit">
						<div class="layui-input-block">
							<button class="layui-btn" type="submit" lay-submit=""
								lay-filter="demo1">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use([ 'form', 'upload' ], function() {
			var form = layui.form();
		});
	</script>
</body>
</html>