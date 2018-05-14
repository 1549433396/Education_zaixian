<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>查看邮件信息</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" href="/common/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
	<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
#table{
width: 80%;
}
</style>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>查看</span>
		</header>
		<div class="larry-personal-body clearfix">
		
		    	<table border="0" >
    		<tr>
    			<td>操作人</td>
    			<td><input type="text" name="user_id"  class="layui-input " value="${list.user.login_name}"  autocomplete="off" disabled="disabled"></td>
    		</tr>
    		<tr>
    			<td>邮箱</td>
    			<td><input type="text" name="email"  class="layui-input " value="${list.email}"  autocomplete="off" disabled="disabled"></td>
    		</tr>
    		<tr>
    			<td>类型</td>
    			<td>
    				<c:if test="${list.type==1}">
							<input type="text" name="type"  class="layui-input " value="普通"  autocomplete="off" disabled="disabled">
						</c:if>
						<c:if test="${list.type==2}">
							<input type="text" name="type"  class="layui-input " value="定时"  autocomplete="off" disabled="disabled">
						</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td>是否发送</td>
    			<td>
    				<c:if test="${list.status==1}">
							<input type="text" name="status"  class="layui-input " value="已发送"  autocomplete="off" disabled="disabled">
						</c:if>
						<c:if test="${list.status==2}">
							<input type="text" name="status"  class="layui-input " value="未发送"  autocomplete="off" disabled="disabled">
						</c:if>
    			</td>
    		</tr>
    		<tr>
    			<td>标题</td>
    			<td><input type="text" name="title"  class="layui-input" value="${list.title}" disabled="disabled"></td>
    		</tr>
    		<tr>
    			<td>邮箱正文</td>
    			<td>
    			<script type="text/plain" draggable="false" name="editor" id="editor" style="width: 800px;height: 200px" >${list.content}</script>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><a href="/admin/email/sendEmaillist">
						<button type="button" class="layui-btn" lay-submit="" lay-filter="demo1">返回</button>
					</a></td>
    		</tr>
    	</table>
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
<script type="text/javascript">
   var ue = UM.getEditor('editor');
   </script>
</html>