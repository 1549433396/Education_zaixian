<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>添加课程</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
function Wopen(){
	var iWidth = 600;                          //弹出窗口的宽度;
	  var iHeight = 400;                        //弹出窗口的高度;
	  var iTop = ((window.screen.availHeight-30-iHeight)/2)+'px';       //获得窗口的垂直位置;
	  var iLeft = ((window.screen.availWidth-10-iWidth)/2)+'px';           //获得窗口的水平位置;
    window.open('/admin/toTeacherList','','height='+iHeight+',innerHeight='+iHeight
    		+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
    } 
    
/*  function showPic(mypic){
	 if (mypic.value){
		 alert(mypic.value);
		 $("#showimg").attr({ src: mypic.value, alt: "图片预览",display:"inline-block" });
		 }
 } */
 
 $(function(){
	 $("#btns").click(function() {
			var content = UM.getEditor('editor').getContentTxt();
			$("#in").val(content);
			$("#form1").submit();
		});
	UM.getEditor('editor').setContent('${e.context }');
	document.getElementById("img").style.display = "block";
	document.getElementsByTagName('img')[0].src = '${e.logo}';
 	 $("#subjectId").val('${e.subjectId}');
 	$("#isAvaliable").val('${e.isAvaliable}');
 	$("#losetype").val('${e.losetype}');
 });

</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span>修改课程</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-5" action="/admin/editcourse"
				id="form1" enctype="multipart/form-data" method="post">
					<div class="layui-form-item">
						<label class="layui-form-label">课程名称</label>
						<div class="layui-input-block">
						<input type="hidden" name="courseId" autocomplete="off"
								class="layui-input " value="${e.courseId }">
							<input type="text" name="courseName" autocomplete="off"
								class="layui-input " value="${e.courseName }">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">专业选择</label>
						<div class="layui-input-block">
							<select name="subjectId" id="subjectId" lay-filter="aihao">
								<c:forEach items="${subjects }" var="s">
									<option value="${s.subjectId }">${s.subjectName }</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">状态</label>
						<div class="layui-input-block">
							<select name="isAvaliable" id="isAvaliable" lay-filter="aihao">
								<option value="1">上架</option>
								<option value="2">下架</option>
							</select>
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">总课时</label>
						<div class="layui-input-block">
							<input type="text" name="lessionNum" autocomplete="off"
								class="layui-input " value="${e.lessionNum }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程原价格</label>
						<div class="layui-input-block">
							<input type="text" name="sourcePrice" autocomplete="off"
								class="layui-input" value="${e.sourcePrice }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程销售价格</label>
						<div class="layui-input-block">
							<input type="text" name="currentPrice" autocomplete="off"
								class="layui-input" value="${e.currentPrice }" placeholder="课程销售价">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">有效期类型</label>
						<div class="layui-input-block">
							<select name="losetype" id="losetype" lay-filter="aihao">
								<option value="0" selected="selected">到期时间</option>
								<option value="1">天数</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">有效期结束时间</label>
						<div class="layui-input-block">
							<input type="text" name="loseTime" autocomplete="off"
								class="layui-input " value="${e.loseTime }">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">添加教师</label>
						<div class="layui-inline">
						<input type="hidden" id="courseKpoint.teacherId" name="courseKpoint.teacherId" value="0" />
							<input type="hidden" name="teacherId" id="teacherId" value="${e.id }" />
							<a href="javascript:void(0);" onClick="Wopen()" class="layui-btn">选择讲师</a>
							<span id="teacherName">${e.name }</span>

						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">销售数量</label>
						<div class="layui-input-block">
							<input type="text" name="pageBuycount" autocomplete="off"
								class="layui-input " value="${e.pageBuycount }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">浏览量</label>
						<div class="layui-input-block">
							<input type="text" name="pageViewcount" autocomplete="off"
								class="layui-input" value="${e.pageViewcount }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程简介</label>
						<div class="layui-input-block">
							<input type="text" name="title" autocomplete="off"
								class="layui-input " value="${e.title }">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程图片</label>
						<div class="layui-input-block">
							<input type="file" id="file" name="file" value="" onchange="showPic(this)"/>
							<img alt="图片" id="img" src="" style="display: none;" >
						</div>
					</div>
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">座右铭</label>
						<div class="layui-input-block">
						<script type="text/plain" name="editor" id="editor" style="width: 1000px;height: 220px"></script>
						<input type="hidden" id="in" name="context" value="" />
							<%-- <textarea name="context" placeholder="既然选择了远方，便只顾风雨兼程；路漫漫其修远兮，吾将上下而求索" 
								 class="layui-textarea">${e.context }</textarea> --%>
						</div>
					</div>

					<div class="layui-form-item">
						<div class="layui-input-block">
							<input class="layui-btn" lay-submit="" lay-filter="demo1" id="btns" value="修改" >
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
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
		document.getElementById('file').onchange = function() {
			var imgFile = this.files[0];
			var fr = new FileReader();
			fr.onload = function() {
				document.getElementById("img").style.display = "block";
				document.getElementsByTagName('img')[0].src = fr.result;
			};
			fr.readAsDataURL(imgFile);
		}
</script>
<script type="text/javascript">
   var ue = UM.getEditor('editor');
   </script>
</body>
</html>