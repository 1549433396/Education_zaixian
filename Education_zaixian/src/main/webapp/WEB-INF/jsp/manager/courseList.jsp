<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#type").val('${type}');
});

function tijiao(){
	
	$("#courseQuery").submit();
}

</script>
</head>

<body>



	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">

				<blockquote class="layui-elem-quote news_search">
					
					<div class="layui-inline">
						<form action="/admin/cou/list" id="courseQuery" method="post">
						课程标题：
							<div class="layui-input-inline">
								<input  placeholder="课程标题"
									value="${qname}" name="qname" class="layui-input search_input" type="text">
							</div>
							状态：
							<div class="layui-input-inline">
								<label class="sr-only" for="exampleInputEmail3">状态</label> <select
									id="type" name="type" class="form-control">
									<option value="">--请选择--</option>
									<option value="1">上架</option>
									<option value="2">下架</option>
								</select>
							</div>
							开始时间:
							<div class="layui-input-inline">
								<input class="layui-input search_input" type="text" name="start"
								value="${start }"	onclick="WdatePicker()">
							</div>
							结束时间:
							<div class="layui-input-inline">
								<input class="layui-input search_input" type="text" name="end"
								value="${end }"	onclick="WdatePicker()">
							</div>
							<a href="javascript:void(0);" onclick="tijiao()" class="layui-btn search_btn"  >查询</a>
						</form>
					</div>
					<div class="layui-inline">
						<a href="/admin/toAddCourse"
							class="layui-btn layui-btn-normal newsAdd_btn">创建课程</a>
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
									<th>课程名</th>
									<th>状态</th>
									<th>专业</th>
									<th>原价</th>
									<th>实价</th>
									<th>课时</th>
									<th>销售量</th>
									<th>浏览量</th>
									<th>创建时间</th>
									<th>有效结束时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${educourse}" var="e" varStatus="state">
									<tr>
										<td><input type="checkbox" id="selected-all"></td>
										<td>${e.courseName}</td>
										<td>${e.isAvaliable == 1?"上架":"下架" }</td>
										<td>${e.subject.subjectName}</td>
										<td>${e.sourcePrice }</td>
										<td>${e.currentPrice }</td>
										<td>${e.lessionNum }</td>
										<td>${e.pageBuycount }</td>
										<td>${e.pageViewcount }</td>
										<td><fmt:formatDate value="${e.updateTime }" type="both" /></td>
										<td>${e.loseTime }</td>
										<td><a href="/admin/toZhangJieManger/${e.courseId}">章节管理</a>||<a
											href="/admin/selectCourse/${e.courseId}">修改</a>||<a
											href="/admin/deleteCourse/${e.courseId}">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="larry-table-page clearfix">
							<a href="javascript:;" class="layui-btn layui-btn-small"><i
								class="iconfont icon-shanchu1"></i>删除</a>
							<div id="page" class="page"></div>
						</div>
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
    });
</script>
</body>
</html>