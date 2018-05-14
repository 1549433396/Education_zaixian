<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
	<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
</head>
<style type="text/css">
select{width:250px;}

</style>
<!--<script type="text/javascript">
	$(function(){
		$("#types").val("${comment.type}");
	});
</script>-->
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>评论修改</span>
		</header>
		<div class="larry-personal-body clearfix">
		
			<form class="layui-form col-lg-5" action="/admin/comment/update" method="post">
			<input type="text"  name="comment_id" value="${comment.comment_id}" hidden="hidden"/>
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-block">  
						<input type="text" disabled="true" name="email"  class="layui-input " value="${comment.userId.EMAIL}"  autocomplete="off" disabled="disabled" style="width:250px;">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">类型</label>
					<div class="layui-input-block">
						<c:if test="${comment.type==1 }">
						<input type="text" disabled="true" name="type" id="types"  class="layui-input " value="文章"  autocomplete="off" disabled="disabled" style="width:250px;">
						</c:if>
						<c:if test="${comment.type==2 }">
						<input type="text" disabled="true" name="type" id="types"  class="layui-input " value="课程"  autocomplete="off" disabled="disabled" style="width:250px;">
					</c:if>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">点赞</label>
					<div class="layui-input-block">
						<input type="text" name="praise_count"  class="layui-input" value="${comment.praise_count}" style="width:250px;">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">回复</label>
					<div class="layui-input-block">
						<input type="text" name="reply_count"   class="layui-input" value="${comment.reply_count}" disabled="disabled" style="width:250px;">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">评论内容</label>
					<div class="layui-input-block">
						<input type="" id="data"  name="content" class="layui-input" value="${comment.content}" style="width:250px;">
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button type="submit" class="layui-btn" lay-filter="demo1">确认修改</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });

	});
</script>
<script>     
    laydate({         
        elem: '#data',    //选择input的id     
        event: 'focus',     //鼠标获得input焦点开始下拉日期控件
        format: 'YYYY-MM-DD', //日期格式
                festival: true, //显示节日
                choose: function(datas){ //选择日期完毕的回调
                   /* alert('得到：'+datas);*/
                }
    }); 
//添加第二个input日期下拉的方法
    laydate({         
        elem: '#txt',         
        event: 'focus'     
    }); 
</script>


</body>
</html>