<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>问答列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="/common/layui/lay/modules/laydate.js"></script>
<script type="text/javascript" src="/common/layui/layui.js"></script>
<link rel="stylesheet" href="/common/layui/css/modules/laydate/laydate.css"  media="all">
<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
<link rel="stylesheet" href="/common/layui/css/layui.css" />	
<script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
 
       <style type="text/css">
          img {
	         width: 35px;
	         height: 35px;
	         border-radius: 50%;
             }      
      </style>
      
<script type="text/javascript">
	 function funzp() {
		/* location.href = "Questions/listAllQuestions?title=" + $("#zp").val(); */
           document.forms[0].action="/admin/questions/list";
           document.forms[0].submit();
	} 
	
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  /* 日期时间选择器 */
		  laydate.render({ 
			  elem: '#test5',type: 'datetime'
			});
	});  
	
  
</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">
				<form action="" method="post">
					<div class="layui-inline">
						<label class="layui-inline">问答标题:</label>	
						<div class="layui-input-inline">
							<input value="" placeholder="请输入关键字" id="zp" class="layui-input"
								name="title" type="text">
						</div>
						<label class="layui-inline">类型:</label>
						<div class="layui-input-inline">
							<select class="layui-input" name="type" id="type"> 
							<option value="-1">--请选择--</option>
							<%-- <c:forEach items="${listType }" var="t"> --%>
								<option value="1">课程问答</option>
								<option value="2">学校分享</option>
							<%-- </c:forEach> --%>
								
							</select>
						</div>
						<label class="layui-inline">问答标签:</label>
						<div class="layui-input-inline">
							<select class="layui-input" name="" id="">
								<option>--请选择--</option>
								<option>1</option>
							</select>
						</div>
						<label class="layui-inline">添加时间:</label>
						<div class="layui-inline">
							<input type="text" class="layui-input" name="satrt"  placeholder="yyyy-MM-dd HH:mm:ss" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒'})">
						</div>
						-
						<div class="layui-inline">
							<input type="text" class="layui-input" name="end" placeholder="yyyy-MM-dd HH:mm:ss" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒'})">
						</div>
						<a class="layui-btn" href="javascript:void(0)" onclick="funzp()"><i class="layui-icon">&#xe615;</i>查询</a>
					    <div class="layui-inline">
						<a class="layui-btn layui-btn-danger batchDel"><i class="layui-icon">&#xe640;</i>批量删除</a>
					    </div>
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
								<th>ID</th>
								<th>发表人</th>
								<th>问答标题</th>
								<th>类型</th>
								<th>是否采纳</th>
								<th>回复数</th>
								<th>浏览数</th>
								<th>点赞数</th>
								<th>添加时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${listQuestions }" var="q" varStatus="stat">
								<tr>

									<%-- <td>${stat.index+1 }</td> --%>
									<td>${q.id }</td>
									<td>${q.eduUser.email }</td>
									<td>${q.title }</td>
									<%-- <td>${q.CONTENT }</td> --%>
									<c:if test="${q.type==1 }">
										<td>课程问答</td>
									</c:if>
									<c:if test="${q.type==2 }">
										<td>学习分享</td>
									</c:if>
									<c:if test="${q.status==0 }">
										<td>是</td>
									</c:if>
									<c:if test="${q.status==1 }">
										<td>否</td>
									</c:if>
									<td>${q.reply_count }</td>
									<td>${q.browse_count }</td>
									<td>${q.praise_count }</td>
									<td><fmt:formatDate value="${q.add_time }" type="date"
											pattern="yyyy-MM-dd hh:mm:ss" />
									</td>
									<td>
									    <a class="layui-btn layui-btn-mini" href="/admin/questions/toupdate?qid=${q.id }"><i	class="iconfont icon-edit"></i> 编辑</a> 
										<a	class="layui-btn layui-btn-danger layui-btn-mini" data-id="1" href="/admin/questions/delQuestions?qid=${q.id }"><i class="layui-icon">&#xe640;</i> 删 除</a> 
										<a class="layui-btn layui-btn-normal layui-btn-mini" href="/admin/questionscomment/list"><i	class="layui-icon">&#xe63a;</i> 查看回复</a>
									</td>
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