<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>登录日志</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript" src="/common/layui/lay/modules/mobile.js" ></script>
<!-- <script type="text/javascript" src="/js/jquery.js"></script> -->
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<link rel="stylesheet" href="/common/layui/css/layui.css" media="all"/>
<link rel="stylesheet" type="text/css" href="/common/layui/css/modules/layer/default/layer.css"/>
<link rel="stylesheet" type="text/css" href="/common/layui/css/modules/layer/default/layer.css"/>
<style type="text/css">
img {
	width: 35px;
	height: 35px;
	border-radius: 50%;
}
</style>

<script type="text/javascript">
   
</script>
</head>
<body>
	<section class="layui-larry-box">

		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">

					<form action="" method="post">
					<div class="layui-inline">
						<label class="layui-inline">登录时间:</label>
						<div class="layui-inline">
							<input type="date" class="layui-input" id="test5" placeholder="yyyy-MM-dd HH:mm:ss">
						</div>
						<a class="layui-btn" href="javascript:void(0)" onclick="funzp()"><i class="layui-icon">&#xe615;</i>查询</a>
					    <div class="layui-inline">
						<a class="layui-btn layui-btn-danger batchDel"><i class="layui-icon">&#xe640;</i>批量删除</a>
					    </div>
					    <a class="layui-btn layui-btn-normal newsAdd_btn" href="/admin/EduUser/ListEduUser">返回列表</a> 
					</div>
					</form>
					<div class="layui-inline">
						<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div>
					</div>
				</blockquote>

				<!-- 操作日志 -->
				<div class="layui-form news_list">
					<table class="layui-table">
						<colgroup>
							<col width="50">
							<col width="20%">
							<col width="9%">
							<col width="15%">
							<col width="9%">
							<col width="15%">
							<col width="15%">
							<col width="5%">
						</colgroup>
						<thead>
							<tr>
								<th>登录时间</th>
								<th>登录IP</th>
								<th>操作系统</th>
								<th>浏览器</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${listLogin }" var="lo" varStatus="stat">
								<tr>
								<td>${lo.login_time }</td>
								<td>${lo.ip }</td>
								<td>${lo.os_name }</td>
								<td>${lo.user_agent }</td>
								</tr>
							</c:forEach>
							<tr>
								<td align="center" colspan="10">一共${page.pages}页 <a
									href="/coupons/listcoupons?page=${page.firstPage}"
									class="layui-btn layui-btn-mini">第一页</a> <a
									href="/coupons/listcoupons?page=${page.prePage}"
									class="layui-btn layui-btn-normal layui-btn-mini">上一页</a> <a
									href="/coupons/listcoupons?page=${page.nextPage}"
									class="layui-btn layui-btn-danger layui-btn-mini">下一页</a> <a
									href="/coupons/listcoupons?page=${page.lastPage}"
									class="layui-btn layui-btn-danger layui-btn-mini">最后页</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 登录日志 -->
				<div class="layui-tab-item layui-field-box">
					<table class="layui-table table-hover">
						<thead>
							<tr>
								<th><input type="checkbox" id="selected-all"></th>
								<th>ID</th>
								<th>管理员账号</th>
								<th>状态</th>
								<th>最后登录时间</th>
								<th>上次登录IP</th>
								<th>登录IP</th>
								<th>IP所在位置</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox"></td>
								<td>110</td>
								<td>admin</td>
								<td>后台登录成功</td>
								<td>2016-12-19 14:26:03</td>
								<td>127.0.0.1</td>
								<td>127.0.0.1</td>
								<td>Unknown</td>
							</tr>
						</tbody>
					</table>
					<!-- <div class="larry-table-page clearfix">
						<a href="javascript:;" class="layui-btn layui-btn-small"><i
							class="iconfont icon-shanchu1"></i>删除</a>
						<div id="page2" class="page"></div>
					</div> -->
				</div>
			</div>
		</div>

	</section>
</body>
</html>