<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
	
<script type="text/javascript">
function del () {
    var c="是否要删除？";
    if (confirm(c)==true) {
    	return true;
    } else{
    	return false;
    }
}
//全选反选
function fun1() {
	var checklist = document.getElementsByName("subcheck");
	if (document.getElementById("checkbox").checked) {
		for (var i=0;i<checklist.length;i++) {
			checklist[i].checked = 1;
		}
	} else{
		for (var j=0;j<checklist.length;j++) {
			checklist[j].checked = 0;
		}
	}
}

//批量删除
function batchDeletes() {
	//判断至少写了一项
	var num = $("input[name='subcheck']:checked").length;
	if (num==0) {
		alert("请至少选择一项");
		return false;
	}
	if (confirm("确认删除所选项?")) {
		var checkdList = new Array();
		$("input[name='subcheck']:checked").each(function() {
			checkdList.push($(this).val());
		});
		$.ajax({
			type:"post",
			url:"/admin/comment/del",
			data:{"delitems":checkdList.toString()},
			datetype:"html",
			success:function(date){
			$("[name='checkbox2']:checked").attr("checked",false);
			location.reload();//刷新页面
			},
			error:function(date) {
				art.dialog.tips("删除失败!");
			}
		});
	}
}
</script>

<style type="text/css">
#myButton{
	width: 80px;
}
</style>

<style type="text/css">  
#ca {  
    width:150px;  
    overflow:hidden;  
    white-space:nowrap;  
    text-overflow:ellipsis;  
    -o-text-overflow:ellipsis;  
    -icab-text-overflow: ellipsis;  
    -khtml-text-overflow: ellipsis;  
    -moz-text-overflow: ellipsis;  
    -webkit-text-overflow: ellipsis;  
}  
</style>  

</head>
<body>
	<form action="/admin/comment/query" method="post">
	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">
						<div class="layui-inline">
					内容查询:
						<div class="layui-input-inline">
							<input value="" placeholder="请输入关键字"
								class="layui-input search_input" type="text" name="qname" onkeyup="value=value.replace(/[^\w\u4E00-\u9FA5]/g, '')">
						</div>
						邮箱查询:
						<div class="layui-input-inline">
							<input value="" placeholder="请输入关键字"
								class="layui-input search_input" type="text" name="email">
						</div>
						类型查找:
						<div class="layui-input-inline">
								<label class="sr-only" for="exampleInputEmail3">类型查找</label> 
								<select  id="type" name="type" class="form-control" >
									<option value="" >--请选择--</option>
									<option value="1">文章</option>
									<option value="2">课程</option>
								</select>
							</div>
							开始时间:
							<div class="layui-input-inline">
							<input class="layui-input search_input" type="text" name="start" onclick="WdatePicker()">
						</div>
							结束时间:
							<div class="layui-input-inline">
							<input class="layui-input search_input" type="text" name="end" onclick="WdatePicker()">
						</div>
							<br/>
						<button type="submit" id="myButton" data-loading-text="Loading..." 
							class="btn btn-primary" autocomplete="off">查询</button>
							<button onclick="batchDeletes()" class="btn btn-danger">批量删除</button>
					</div>
					
				</blockquote>
				<div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
					<!-- 操作日志 -->
					<div class="layui-tab-item layui-field-box layui-show">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob" id="tb">
							<thead>
								<tr>
									<th><input type="checkbox" id="checkbox" name="checkbox" onclick="fun1()"></th>
									<th>id</th>
									<th>邮箱</th>
									<th>类型</th>
									<th>点赞</th>
									<th>回复</th>
									<th>创建时间</th>
									<th>评论内容</th>
									<th>操作</th>
								</tr>
							</thead>							
							<tbody>
								<c:forEach items="${list}" var="p" varStatus="count">
									<tr align="center">
										<th><input type="checkbox" id="subcheck" name="subcheck" value="${p.comment_id}"></th>
										<td>${count.index+1 }</td>
										<td>${p.userId.email }</td>
										<c:if test="${p.type==1}"><td>文章</td></c:if>
										<c:if test="${p.type==2 }"><td>课程</td></c:if>
										<td>${p.praise_count }</td>
										<td>${p.reply_count }</td>
										<td><fmt:formatDate value="${p.addtime}" pattern="yyyy-MM-dd" type="both"/></td>
										<td><div id="ca" title="${p.content}">${p.content}</div></td>
										<td><%-- <a href="/admin/comment/init/${p. comment_id}"> <button type="button" class="btn btn-success">修改</button></a> --%>
											<a onclick="javascript:return del()" href="/admin/comment/delete/${p.comment_id}" ><button type="button" class="btn btn-danger" >删除</button></a>
										<a href="/admin/comment/all/${p.comment_id}"> <button type="button" class="btn btn-success">回复列表</button></a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							

						</table>
						<table>
						<tr>
						<td>一共<input type="text"
										value="${page.pages}" style="width: 25px; text-align: center;" />页
										<a href="/admin/comment/query/${p.comment_id}?page=${page.firstPage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>第一页</a> <a
										href="/admin/comment/query/${p.comment_id}?page=${page.prePage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>上一页</a> <a
										href="/admin/comment/query/${p.comment_id}?page=${page.nextPage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>下一页</a> <a
										href="/admin/comment/query/${p.comment_id}?page=${page.lastPage}"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>最后页</a></td>
						</tr>
						</table>
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