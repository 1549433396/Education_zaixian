<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
	
	<script type="text/javascript">
		function fun(){
			location.href="/admin/to_RoleAdd";
		}
	
	</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">

					<div class="layui-inline">
						<div class="layui-input-inline">
							<input value="" placeholder="请输入关键字"
								class="layui-input search_input" type="text">
						</div>
						<a class="layui-btn search_btn">查询</a>
					</div>
					<div class="layui-inline">
						<a class="layui-btn layui-btn-normal " onclick="fun()" >添加角色</a>
					</div>
					<%-- <shiro:hasPermission name="role_Add">
					<div class="layui-inline">
						<a class="layui-btn layui-btn-normal " onclick="fun()" >添加角色</a>
					</div>
					</shiro:hasPermission> --%>
					<div class="layui-inline">
						<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
					</div>
				</blockquote>

				<div
					class="layui-tab-content larry-personal-body clearfix mylog-info-box">
					<!-- 操作日志 -->
					<div class="layui-tab-item layui-field-box layui-show">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob">
							<thead>
								<tr>
									<th><input type="checkbox" id="selected-all"></th>
									<th>角色编号</th>
									<th>角色id</th>
									<th>角色名称</th>
									<th>创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${role}" var="r" varStatus="count">
									<tr align="center">
										<th><input type="checkbox" id="selected-all"></th>
										<td>${count.index+1 }</td>
										<td>${r.role_id }</td>
										<td>${r.role_name }</td>
										<td><fmt:formatDate value="${r.create_time }" type="both"/></td>
										<td><a href="/admin/toRoleEdit/${r.role_id }" class="layui-btn layui-btn-normal  layui-btn-small">授权</a><a href="/admin/deleteRole/${r.role_id}" class="layui-btn layui-btn-danger  layui-btn-small batchDel" >删除</a></td>
									</tr>
								</c:forEach>
								<tr>
								
								<td align="center" colspan="6" >一共<input type="text" value="${page.pages}" style="width: 25px;text-align: center;" /> 页
								
								        <a href="/admin/sysrole/showroleList?page=${page.firstPage}"class="layui-btn layui-btn-small"><i
								class="iconfont icon-shanchu1"></i>第一页</a>
								        <a href="/admin/sysrole/showroleList?page=${page.prePage}"class="layui-btn layui-btn-small"><i
								class="iconfont icon-shanchu1"></i>上一页</a>
								        <a href="/admin/sysrole/showroleList?page=${page.nextPage}"class="layui-btn layui-btn-small"><i
								class="iconfont icon-shanchu1"></i>下一页</a>
								        <a href="/admin/sysrole/showroleList?page=${page.lastPage}"class="layui-btn layui-btn-small"><i
								class="iconfont icon-shanchu1"></i>最后页</a>
								        
								        </td>
								
								</tr>
								
							</tbody>
						</table>
						<!-- <div class="larry-table-page clearfix">
							<a href="javascript:;" class="layui-btn layui-btn-small"><i
								class="iconfont icon-shanchu1"></i>删除</a>
							<div id="page" class="page"></div>
						</div> -->
					</div>
					<!-- 登录日志 -->
					<div class="layui-tab-item layui-field-box">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob">
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
		</div>
	</section>
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<script type="text/javascript">
	/* layui.use(['jquery','layer','element','laypage'],function(){
	      window.jQuery = window.$ = layui.jquery;
	      window.layer = layui.layer;
          var element = layui.element(),
              laypage = layui.laypage;

            
          laypage({
					cont: 'page',
					pages: 10 //总页数
						,
					groups: 5 //连续显示分页数
						,
					jump: function(obj, first) {
						//得到了当前页，用于向服务端请求对应数据
						var curr = obj.curr;
						if(!first) {
							//layer.msg('第 '+ obj.curr +' 页');
						}
					}
				});

          laypage({
					cont: 'page2',
					pages: 10 //总页数
						,
					groups: 5 //连续显示分页数
						,
					jump: function(obj, first) {
						//得到了当前页，用于向服务端请求对应数据
						var curr = obj.curr;
						if(!first) {
							//layer.msg('第 '+ obj.curr +' 页');
						}
					}
				});
    }); */
</script>
</body>
</html>