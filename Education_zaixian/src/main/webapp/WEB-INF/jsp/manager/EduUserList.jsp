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
<script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
img {
	width: 35px;
	height: 35px;
	border-radius: 50%;
}
</style>

	<script type="text/javascript">
    function updatepwd(user_id){ 
    	layer.open({  
    	        id:1,  
    	        type: 1,  
    	        title:'修改密码',  
    	        skin:'layui-layer-rim',  
    	        area:['450px', 'auto'],  
    	          
    	        content: ' <div class="row" style="width: 420px;  margin-left:7px; margin-top:10px;">'  
    	            +'<div class="col-sm-12">'  
    	            +'<div class="input-group">'  
    	            +'<span class="input-group-addon"> 新 密 码   :</span>'  
    	            +'<input id="firstpwd" type="password" class="form-control" placeholder="请输入密码">'  
    	            +'</div>'  
    	            +'</div>'  
    	              +'<div class="col-sm-12" style="margin-top: 10px">'  
    	              +'<div class="input-group">'  
    	              +'<span class="input-group-addon">确认密码:</span>'  
    	              +'<input id="secondpwd" type="password" class="form-control" placeholder="请再输入一次密码">'  
    	              +'</div>'  
    	              +'</div>'  
    	              +'</div>'  
    	        ,  
    	        btn:['保存','取消'],  
    	        btn1: function (index,layero) {
    	        	var firstpwd=$("#firstpwd").val();
    	        	var sencondpwd=$("#secondpwd").val();
    	        	if (firstpwd!=sencondpwd) {
    	        		/*layer.tips('两次密码不一致，请重新输入！', '吸附元素选择器', {
                           tips: [1, '#3595CC'],
                           time: 4000
                         });*/
    	        		alert("两次密码不一致，请重新输入！");
    	                $("#firstpwd").val("");
    	                $("#secondpwd").val("");
    	                alert(a.val());
    	        	} else{
    	        	if (firstpwd<6) {
    	        		/*layer.tips('输入密码不能少于6位数！', '吸附元素选择器', {
                           tips: [1, '#3595CC'],
                           time: 4000
                         });*/
    	        		alert("输入密码不能少于6位数！")
    	        		$("#firstpwd").val("");
    	                $("#secondpwd").val("");
    	            
    	        	}else{
    	        		$.post("updatepwd?user_id="+user_id+"&pwd="+firstpwd,
    	        		function(data) {
    	        	if (data==1) {
    	        		  /* layer.tips('修改成功！', '吸附元素选择器', {
                           tips: [1, '#3595CC'],
                           time: 4000
                         });*/
                         alert("修改成功！")
                         layer.close(index);
    	        	}
    	        		})
    	        	}
    	        	}
    	        },  
    	        btn2:function (index,layero) {  
    	             layer.close(index);  
    	        }  
    	  
    	    });  
}

      
     /*    查询 */
	 function funzp() {
		document.forms[0].action="/admin/user/getuserList";
        document.forms[0].submit();
	} 
     
	/* 冻结 */
   function frozen(user_id,is_avalible) {
    	if (is_avalible==2) {
    		$.post("Frozen?user_id="+user_id+"&is_avalible="+is_avalible,function(data){
    			 	if (data==1) {
    			 		alert("解冻成功！");
    			 		location.href="/admin/user/getuserList";
    			 	} 
    		})
    	}else{
    		$.post("Frozen?user_id="+user_id+"&is_avalible="+is_avalible,function(data){
    			 	if (data==1) {
    			 		alert("冻结成功！");
    			 		location.href="/admin/user/getuserList";
    			 	} 
    		})
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
						<label class="layui-inline">邮箱或手机号:</label>	
						<div class="layui-input-inline">
							<input value="" placeholder="请输入关键字" id="zp" class="layui-input"
								name="eduname" type="text">
						</div>
						<label class="layui-inline">类型:</label>
						<div class="layui-input-inline">
							<select class="layui-input" name="isavalible" id="isavalible"> 
							<option value="-1">--请选择状态--</option>
								<option value="1">正常</option>
								<option value="2">冻结</option>
							</select>
						</div>
						
						<label class="layui-inline">注册时间:</label>
						<div class="layui-inline">
							<input type="text" class="layui-input" name="satrt"  placeholder="yyyy-MM-dd HH:mm:ss" onclick="WdatePicker()">
						</div>
						-
						<div class="layui-inline">
							<input type="text" class="layui-input" name="end" placeholder="yyyy-MM-dd HH:mm:ss" onclick="WdatePicker()">
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
								<th>邮箱</th>
								<th>手机号</th>
								<th>用户名</th>
								<th>昵称</th>
								<th>性别</th>
								<th>年龄</th>
								<th>注册时间</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody class="news_content">
							<c:forEach items="${listEduUser }" var="eu" varStatus="stat">
								<tr>
									<td>${eu.user_id }</td>
									<td>${eu.email }</td>
									<td>${eu.mobile }</td>
									<td>${eu.user_name }</td>
									<td>${eu.show_name }</td>
									<c:if test="${eu.sex==0 }">
									<td>男</td>
									</c:if>
									<c:if test="${eu.sex==1 }">
									<td>女</td>
									</c:if>
									<td>${eu.age }</td>
									<td>
									 <fmt:formatDate value="${eu.create_time }" type="date" pattern="yyyy-MM-dd hh:mm:ss"/>
									</td>
									<c:if test="${eu.is_avalible==1 }">
									<td>正常</td>
									</c:if>
									<c:if test="${eu.is_avalible==2 }">
									<td>冻结</td>
									</c:if>
									<td> 
									    <a class="layui-btn layui-btn-mini" onclick="updatepwd(${eu.user_id })"><i class="iconfont icon-edit"></i> 修改密码</a> 
									<!--     <a class="layui-btn layui-btn-mini" href="#"><i class="layui-icon">&#xe621;</i> </a> -->
									    <a class="layui-btn layui-btn-danger layui-btn-mini" onclick="frozen(${eu.user_id },${eu.is_avalible })"><i class="layui-icon"><!-- &#x1007; --></i> 冻结/解冻</a>
									    <a class="layui-btn layui-btn-normal layui-btn-mini" href="/addmin/LoginLog/ListJournal?user_id=${eu.user_id }"><i class="layui-icon">&#xe60a;</i> 查看日志</a> 
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