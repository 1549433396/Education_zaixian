<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>邮箱信息表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">

<style type="text/css">
#myButton{
	width: 80px;
}
</style>
</head>
<body>
	<form action="/admin/email/sendEmaillist" method="post">
	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">
						<div class="layui-inline">
					邮箱:
						<div class="layui-input-inline">
							 
							<input  placeholder="请输入关键字"
								class="layui-input search_input" type="text" name="email" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')">
						</div>
						类型查找:
						<div class="layui-input-inline">
								<label class="sr-only" for="exampleInputEmail3">类型查找</label> 
								<select  id="type" name="type" class="form-control" >
									<option value="" >--请选择--</option>
									<option value="1">普通</option>
									<option value="2">定时</option>
								</select>
							</div>
							类型查找:
							<div class="layui-input-inline">
								<label class="sr-only" for="exampleInputEmail3">类型查找</label> 
								<select  id="status" name="status" class="form-control" >
									<option value="" >--请选择--</option>
									<option value="1">已发送</option>
									<option value="2">未发送</option>
								</select>
							</div>
						<button type="submit" id="myButton" data-loading-text="Loading..." 
							class="btn btn-primary" autocomplete="off">查询</button>
					</div>
					
				</blockquote>
				<div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
					<!-- 操作日志 -->
					<div class="layui-tab-item layui-field-box layui-show">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob">
							<thead>
								<tr>
									<th>id</th>
									<th>邮件类型</th>
									<th>是否发送</th>
									<th>邮件标题</th>
									<th>邮箱</th>
									<th>创建时间</th>
									<th>发送时间</th>
									<th>操作人</th>
									<th>操作</th>
								</tr>
							</thead>							
							<tbody>
								<c:forEach items="${list}" var="p" varStatus="count">
									<tr align="center">
										<td>${count.index+1 }</td>
										<c:if test="${p.type==1}"><td>普通</td></c:if>
										<c:if test="${p.type==2 }"><td>定时</td></c:if>
										<c:if test="${p.status==1}"><td>已发送</td></c:if>
										<c:if test="${p.status==2 }"><td>未发送</td></c:if>
										<td>${p.title}</td>
										<td>${p.email}</td>
										<td><fmt:formatDate value="${p.create_time}" pattern="yyyy-MM-dd" type="both"/></td>
										<td><fmt:formatDate value="${p.send_time}" pattern="yyyy-MM-dd" type="both"/></td>
										<td>${p.user.login_name}</td>
										<td><a href="/admin/email/sendEmailinit/${p.id}"> <button type="button" class="btn btn-success">查看</button></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tr>
						</tr>
						</table>
						
						<table>
						<tr>
						<td >一共<input type="text"
										value="${page.pages}" style="width: 25px; text-align: center;" />页
										<a href="/admin/email/sendEmaillist?page=${page.firstPage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>第一页</a> <a
										href="/admin/email/sendEmaillist?page=${page.prePage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>上一页</a> <a
										href="/admin/email/sendEmaillist?page=${page.nextPage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>下一页</a> <a
										href="/admin/email/sendEmaillist?page=${page.lastPage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>最后页</a></td>
						</tr>
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
						<div class="larry-table-page clearfix">
							<a href="javascript:;" class="layui-btn layui-btn-small"><i
								class="iconfont icon-shanchu1"></i>删除</a>
							<div id="page2" class="page"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	</form>
	
	<script type="text/javascript" src="/common/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use(['jquery','layer','element','laypage'],function(){
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

laypage.render({
    elem: 'demo7'
    ,count: 100
    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
    ,jump: function(obj){
      console.log(obj)
    }
 });
   });
</script>

</body>
</html>