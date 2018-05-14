<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>问答回复列表查看评论</title>
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

 
       <style type="text/css">
          img {
	         width: 35px;
	         height: 35px;
	         border-radius: 50%;
             }      
      </style>
      
<script type="text/javascript">
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
					<a class="layui-btn layui-btn-normal newsAdd_btn" href="/admin/QuestionsComment/ListAllQc">返回列表</a> 
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
								<th>点赞数</th>
								<th>评论内容</th>
								<th>添加时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${listeduComment }" var="ec" varStatus="stat">
								<tr>
                                    <td>${ec.comment_id }</td>
									<td>${ec.eduUser.email }</td>
									<td>${ec.praise_count }</td>
									<td>${ec.content }</td>
									<td>
									<fmt:formatDate value="${ec.addtime }" pattern="yyyy-MM-dd hh:mm:ss"/>
									</td>
									<td>
										<a	class="layui-btn layui-btn-danger layui-btn-mini" data-id="1" href="/admin/EduComment/EduCommentList?ecid=${ec.comment_id }"><i class="layui-icon">&#xe640;</i> 删 除</a> 
									</td>
								</tr>
							</c:forEach>
							<%-- <tr>
								<td align="center" colspan="10">一共${page.pages}页 <a
									href="/coupons/listcoupons?page=${page.firstPage}"
									class="layui-btn layui-btn-mini">第一页</a> <a
									href="/coupons/listcoupons?page=${page.prePage}"
									class="layui-btn layui-btn-normal layui-btn-mini">上一页</a> <a
									href="/coupons/listcoupons?page=${page.nextPage}"
									class="layui-btn layui-btn-danger layui-btn-mini">下一页</a> <a
									href="/coupons/listcoupons?page=${page.lastPage}"
									class="layui-btn layui-btn-danger layui-btn-mini">最后页</a></td>
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