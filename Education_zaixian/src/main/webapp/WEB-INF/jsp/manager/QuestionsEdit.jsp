<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<meta charset="UTF-8">
<title>问答列表修改</title>
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
<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
#h5 {
	color: black;
}
select{width:400px;}
</style>
<script type="text/javascript">
	/*修改  */
	 function updateQue() {
		document.forms[0].action = "/admin/questions/updQuestions";
		document.forms[0].submit();
	} 

	  $(function() {
		$("input:radio[name='type'][value='${questions.type}']").attr('checked','true');
		$("input:radio[name='status'][value='${questions.status}']").attr('checked','true');
	});  
</script>
<body>
	<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit"> 
		<span><h4 id="h4">问答列表编辑</h4></span> 
		</header>
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-5" action="" method="post"
				enctype="multipart/form-data">
				<input type="hidden" class="form-control" name="qid" id="qid"
					value="${questions.id }">
				<div class="layui-form-item">
					<label class="layui-form-label">发表人昵称  </label>
					<div class="layui-input-block">
						<input type="text" name="show_name" id="show_name"
							style="width:400px;" class="layui-input"
							value="${questions.eduUser.show_name }" placeholder="请输入发表人昵称" disabled="disabled">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">发表人邮箱 </label>
					<div class="layui-input-block">
						<input type="text" name="email" id="email"
							style="width:400px;" class="layui-input"
							value="${questions.eduUser.email }" placeholder="请输入发表人邮箱" disabled="disabled">
					</div>
				</div>
                
                <div class="layui-form-item">
					<label class="layui-form-label">问答标题  </label>
					<div class="layui-input-block">
						<input type="text" name="title" id="title"
							style="width:400px;" class="layui-input"
							value="${questions.title }" placeholder="请输入问答标题">
					</div>
				</div>
                
				<div class="layui-form-item">
					<label class="layui-form-label">问答分类 </label>
					<!-- <div class="layui-input-block">
						<input type="radio" name="type" id="type"
							value="1" title="课程问答" checked="">
						<div class="layui-unselect layui-form-radio layui-form-radioed">
							<i class="layui-anim layui-icon"></i><span>课程问答</span>
						</div>
						<input type="radio" name="type" id="types"
							value="2" title="学习分享">
						<div class="layui-unselect layui-form-radio">
							<i class="layui-anim layui-icon"></i><span>学习分享</span>
						</div>
					</div> --> 
							<div class="layui-input-inline">
								<select class="layui-input" name="type" id="type" style="width: 400px">
									<option value="-1">--请选择--</option>
									<option value="1">课程问答</option>
									<option value="2">学校分享</option>
								</select>
							</div>
				</div>


				 <div class="layui-form-item">
					<label class="layui-form-label">是否采纳 </label>
					<div class="layui-input-block">
						<input type="radio" name="status" id="status"
							value="0" title="是" checked="">
						<div class="layui-unselect layui-form-radio layui-form-radioed">
							<i class="layui-anim layui-icon"></i><span>是</span>
						</div>
						<input type="radio" name="status" id="status"
							value="1" title="否">
						<div class="layui-unselect layui-form-radio">
							<i class="layui-anim layui-icon"></i><span>否</span>
						</div>
					</div>
				</div> 
                
                <div class="layui-form-item">
					<label class="layui-form-label">回复数 </label>
					<div class="layui-input-block">
						<input type="text" name="reply_count" id="reply_count"
							style="width:400px;" class="layui-input"
							value="${questions.reply_count }" placeholder="请输入回复数" disabled="disabled">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">点赞数 </label>
					<div class="layui-input-block">
						<input type="text" name="praise_count" id="praise_count"
							style="width:400px;" class="layui-input"
							value="${questions.praise_count }" placeholder="请输入点赞数" disabled="disabled">
					</div>
				</div>
                 
                 <div class="layui-form-item">
					<label class="layui-form-label">浏览数 </label>
					<div class="layui-input-block">
						<input type="text" name="browse_count" id="browse_count"
							style="width:400px;" class="layui-input"  disabled="disabled"
							value="${questions.browse_count }" placeholder="请输入浏览数">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">问答内容 </label>
					<div class="">
					<script type="text/plain" id="content" name="content"
					style="width:800px;height:400px;">
                      ${questions.content }
                    </script>
						<%-- <textarea rows="" cols="65" name="content"
							id="content">${questions.content }</textarea> --%>
					</div>
				</div>

				<%-- <div class="layui-form-item">
					<label class="layui-form-label">添加时间:</label>
					<div class="layui-input-block">
						<input type="text" name="add_time" id="add_time"
							style="width:400px;" class="layui-input"
							value="${questions.add_time }" placeholder="请输入添加时间" onclick="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分ss秒'})">
					</div>
				</div> --%> 

				<div class="layui-form-item">
					<div class="layui-input-block">
					     <!-- <a class="layui-btn layui-btn-normal newsAdd_btn" href="#">编辑</a>  -->
						<button type="button" class="layui-btn" onclick="updateQue()">编辑</button>
						<a class="layui-btn layui-btn-normal newsAdd_btn" href="/admin/questions/list">返回列表</a> 
				</div>
				
				</div>
			</form>
		</div>
	</div>
	</section>
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use([ 'form', 'upload' ], function() {
			var form = layui.form();
			layui.upload({
				url : '',//上传接口 
				success : function(res) {
					//上传成功后的回调 
					console.log(res)
				}
			});

		});
	</script>
	<script type="text/javascript" src="/common/layui/layui.js"></script>
	<script type="text/javascript" src="/js/newslist.js"></script>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;

			//监听提交
			form.on('submit(formDemo)', function(data) {
				layer.msg(JSON.stringify(data.field));
				return false;
			});
		});
	</script>

	<script type="text/javascript" src="/common/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use([ 'form', 'upload' ], function() {
			var form = layui.form();
			layui.upload({
				url : '',//上传接口 
				success : function(res) {
					//上传成功后的回调 
					console.log(res)
				}
			});

		});
	</script>
	<script type="text/javascript">
	  $("#type").val("${questions.type}");
	</script>
</body>
</html>