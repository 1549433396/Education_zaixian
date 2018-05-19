<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学员列表</title>
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
<script src="/common/layui/lay/modules/layer.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">
     /*    查询 */
	 function funzp() {
		/* document.forms[0].action="/admin/user/getuserList";
        document.forms[0].submit(); */
	} 
   
 //全选反选
	function fun1() {
		var checklist = document.getElementsByName("subcheck");
		if (document.getElementById("checkbox").checked) {
			for (var i = 0; i < checklist.length; i++) {
				checklist[i].checked = 1;
			}
		} else {
			for (var j = 0; j < checklist.length; j++) {
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

</head>
<body>
	<section class="layui-larry-box">

		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">
					<form action="" method="post">
					<div class="layui-inline">
						<!-- <label class="layui-inline">登录时间:</label>
						<div class="layui-inline">
							<input type="text" class="layui-input" name="satrt"  placeholder="yyyy-MM-dd HH:mm:ss" onclick="WdatePicker()">
						</div> -->
						<!-- <a class="layui-btn" href="javascript:void(0)" onclick="funzp()"><i class="layui-icon">&#xe615;</i>查询</a> -->
					    <a class="layui-btn layui-btn-normal newsAdd_btn" href="/admin/user/getuserList">返回列表</a> 
					    <div class="layui-inline">				    
						<a class="layui-btn layui-btn-danger batchDel" onclick="batchDeletes()"><i class="layui-icon">&#xe640;</i>批量删除</a>
					    </div>
					</div>
					</form>
				</blockquote>

				<!-- 操作日志 -->
				<div class="layui-form news_list">
					<table class="layui-table">
						<thead>
							<tr>
							   <!--  <th><input type="checkbox" id="checkbox" name="checkbox"
									onclick="fun1()"></th> -->
								<th>编号</th>
								<th>登录时间</th>
								<th>登录IP</th>
								<th>操作系统</th>
								<th>浏览器</th>
								<!-- <th>操作</th> -->
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${listLogin }" var="lo" varStatus="stat">
								<tr>
								 <%-- <th><input type="checkbox" id="subcheck" name="subcheck"
										value="${lo.log_id }"></th> --%>
								<td>${lo.log_id }</td>
								<td>
								<fmt:formatDate value="${lo.login_time }" type="date" pattern="yyyy-MM-dd mm:HH:ss"/>
								</td>
								<td>${lo.ip }</td>
								<td>${lo.os_name }</td>
								<td>${lo.user_agent }</td>
								<%-- <td><a
										class="layui-btn layui-btn-danger layui-btn-small" data-id="1"
										href="/admin/LoginLog/delloginLog/${lo.log_id }/${lo.user_id }"><i
											class="layui-icon">&#xe640;</i> 删 除</a></td> --%>
								</tr>
							</c:forEach>
							<%-- <tr>
								<td align="center" colspan="11">一共<input type="text"
									value="${page.pages}" style="width: 25px; text-align: center;" />
									页 一共${page.pages}页 <a
									href="/admin/LoginLog/ListJournal?user_id=${lo.user_id }&page=${page.firstPage}"
									class="layui-btn layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>第一页</a>&nbsp;&nbsp;<a
									href="/admin/LoginLog/ListJournal?user_id=${lo.user_id }&page=${page.prePage}"
									class="layui-btn layui-btn-normal layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>上一页</a>&nbsp;&nbsp;<a
									href="/admin/LoginLog/ListJournal?user_id=${lo.user_id }&page=${page.nextPage}"
									class="layui-btn layui-btn-normal layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>下一页</a>&nbsp;&nbsp;<a
									href="/admin/LoginLog/ListJournal?user_id=${lo.user_id }&page=${page.lastPage}"
									class="layui-btn layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>最后页</a> 每页共<input type="text"
									value="${page.pageSize }"
									style="width: 25px; text-align: center;" /> 条 每页${page.pageSize }条
								</td>
							</tr>	 --%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
</body>
</html>