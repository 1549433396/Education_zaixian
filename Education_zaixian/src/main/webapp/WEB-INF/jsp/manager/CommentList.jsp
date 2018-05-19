<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>回复列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script src="/common/layui/lay/modules/layer.js"></script>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<link rel="stylesheet" href="/common/layui/css/layui.css" />
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script src="/common/layui/lay/modules/layer.js"></script>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/modules/layer/default/layer.css" />
<script language="javascript" type="text/javascript"
	src="/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
#ca {
	width: 150px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	-o-text-overflow: ellipsis;
	-icab-text-overflow: ellipsis;
	-khtml-text-overflow: ellipsis;
	-moz-text-overflow: ellipsis;
	-webkit-text-overflow: ellipsis;
}
</style>
<script type="text/javascript"> 
function updateIsbest(qcid,is_best,qid){
	if(is_best==0){
		location.href = "/admin/questionscomment/updateIsBest/"+qcid+"/"+qid;
	}else{
		alert("已经采纳为最佳!");
	}
    
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
					<a class="layui-btn layui-btn-normal newsAdd_btn"
						href="/admin/questions/list">返回列表</a>
					<div class="layui-inline">
							<!-- 	<button onclick="batchDeletes()" class="btn btn-danger">批量删除</button> -->
								<a class="layui-btn layui-btn-danger" onclick="batchDeletes()"><i
									class="layui-icon">&#xe640;</i>批量删除</a>
							</div>
				</blockquote>

				<!-- 操作日志 -->
				<div class="layui-form news_list">
					<table class="layui-table">
						<thead>
							<tr>
							    <th><input type="checkbox" id="checkbox" name="checkbox"
									onclick="fun1()"></th>
								<th>编号</th>
								<th>问答标题</th>
								<th>发表人</th>
								<th>是否采纳</th>
								<th>回复内容</th>
								<th>回复数量</th>
								<th>点赞数</th>
								<th>回复时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${list }" var="qc" varStatus="stat">
								<tr align="center">
                                    <th><input type="checkbox" id="subcheck" name="subcheck"
										value="${q.id }"></th>
									<%-- <td>${stat.index+1 }</td> --%>
									<td>${qc.id }</td>
									<td><div id="ca" title="${qc.questions.title }">${qc.questions.title }</div></td>
									<td>${qc.eduUser.email }</td>
									<c:if test="${qc.is_best==0}">
										<td>否</td>
									</c:if>
									<c:if test="${qc.is_best==1}">
										<td>是</td>
									</c:if>
									<td><div id="ca" title="${qc.content }">${qc.content }</div></td>
									<td>${qc.reply_count }</td>
									<td>${qc.praise_count }</td>
									<td><fmt:formatDate value="${qc.add_time }" type="date"
											pattern="yyyy-MM-dd hh:mm:ss" /></td>
									<td><a class="layui-btn layui-btn-danger layui-btn-small"
										data-id="1"
										href="/admin/questionscomment/del/${qc.id }/${qc.questions.id }"><i
											class="layui-icon">&#xe640;</i> 删 除</a> <c:if
											test="${qc.reply_count==0 }">
											<a class="layui-btn layui-btn-normal layui-btn-small" href="#"
												style="display: none;"
												onclick="updateIsbest(${qc.id },${qc.is_best },${qc.questions.id })"><i
												class="layui-icon">&#xe63a;</i> 采纳为最佳</a>
										</c:if> <c:if test="${qc.reply_count>0 }">
											<a class="layui-btn layui-btn-normal layui-btn-small" href="#"
												onclick="updateIsbest(${qc.id },${qc.is_best },${qc.questions.id })"><i
												class="layui-icon">&#xe63a;</i> 采纳为最佳</a>
										</c:if>
								</tr>
							</c:forEach>
							<%-- <tr>
								<td align="center" colspan="10">一共<input type="text"
									value="${page.pages}" style="width: 25px; text-align: center;" />
									页 一共${page.pages}页 <a
									href="/admin/questionscomment/getbyqid?page=${page.firstPage}"
									class="layui-btn layui-btn-normal layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>第一页</a>&nbsp;&nbsp;<a
									href="/admin/questionscomment/getbyqid?page=${page.prePage}"
									class="layui-btn layui-btn-danger layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>上一页</a>&nbsp;&nbsp;<a
									href="/admin/questionscomment/getbyqid?page=${page.nextPage}"
									class="layui-btn layui-btn-danger layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>下一页</a>&nbsp;&nbsp;<a
									href="/admin/questionscomment/getbyqid?page=${page.lastPage}"
									class="layui-btn layui-btn-normal layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>最后页</a> 每页共<input type="text"
									value="${page.pageSize }"
									style="width: 25px; text-align: center;" /> 条 每页${page.pageSize }条
								</td>
							</tr> --%>
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