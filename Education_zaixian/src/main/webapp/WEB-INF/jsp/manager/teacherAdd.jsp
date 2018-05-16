<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加教师</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<script src="../../../js/jquery-3.2.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="../../../css/bootstrap-table.min.css" />
		<script src="../../../js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/ztree/jquery.ztree.all.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="/js/ztree/zTreeStyle.css" />
		<script type="text/javascript" src="/js/ztree/jquery.ztree.all.js"></script>
		<!-- 富文本编辑器 -->
		<script type="text/javascript" charset="utf-8" src="../../../ueditor-utf8-jsp/ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="../../../ueditor-utf8-jsp/ueditor.all.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="../../../ueditor-utf8-jsp/lang/zh-cn/zh-cn.js"></script>
	</head>
	
	<style>
		#tishi{
			position: absolute;
			color: red;
			font-size: 16px;
		}
	</style>

	<style type="text/css">
		.form-group {
			margin: 10px 0px;
		}
		
		p{
			position: absolute;
			font-size: 20px;
		}
	</style>
	
	<script type="text/javascript">
	var f;
	$(function() {
		//页面加载完成后，执行这段代码----动态创建ztree
		var setting = {
				data : {
					simpleData : {
						enable : true,
						idKey : "subject_id",
						pIdKey : "parent_id",
						rootPId : "0"
					},
					key : {
						name : "subject_name"
					}
		},
		callback : {
			onClick : onClick
		}
	};
		var url = "/subjects";
		$.post(url, function(data) {
			$.fn.zTree.init($("#ztree"), setting, data);
		}, 'json');
	});
	</script>

	<body>

		<div class="container">

			<div class="form-horizontal">
				<form id="form" action="/admin/teacher/insertTM" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">讲师名称</label>
						<div class="col-sm-5">
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" class="form-control" onblur="NotNull1(this.value)" name="name" id="name" placeholder="讲师名" value="">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi1"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="th_name" class="col-sm-2 control-label">讲师账号</label>
						<div class="col-sm-5">
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" class="form-control" onblur="NotNull2(this.value)" name="th_name" id="th_name" placeholder="账号" value="">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi2"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="th_pw" class="col-sm-2 control-label">讲师密码</label>
						<div class="col-sm-5">
							<input type="password" style="font-size: 12px;height:27px;margin-top:5px" class="form-control" onblur="NotNull3(this.value)" name="th_pw" id="th_pw" placeholder="密码" value="">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi3"></p></span>
						</div>
					</div>

					<div class="form-group">
						<input type="hidden" value="" id="perid" name="perid" />
						<label for="is_star" class="col-sm-2 control-label">讲师专业</label>
						<div class="col-sm-5">
							<input type="hidden" name="sid" id="sid" class="form-control" value="" />
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" onclick="showMenu(); return false;" onblur="NotNull4(this.value)" name="subject_ids" id="subject_id" class="form-control" value="" />
							<div id="teaSub" style="width: 373px; padding-top: 2px; border: 1px #AAAAAA solid;">
									<ul id="ztree" class="ztree"></ul>
							</div>
						</div>
						<div class="col-sm-1">
							<span><p id="tishi4"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="is_star" class="col-sm-2 control-label">讲师头衔</label>
						<div class="col-sm-5">
							<select style="font-size: 12px;height:29px;margin-top:5px" class="form-control" onchange="NotNull5(this.value)" name="is_star" id="is_star" class="star">
								<option value="0">--请选择--</option>
								<option value="1">高级讲师</option>
								<option value="2">首席讲师</option>
							</select>
						</div>
						<div class="col-sm-1">
							<span><p id="tishi5"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">讲师排序</label>
						<div class="col-sm-5">
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" id="sort" onblur="NotNull6(this.value)" name="sorts" class="form-control" placeholder="请输入0-100的整数" value="" />
						</div>
						<div class="col-sm-1">
							<span><p id="tishi6"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="education" class="col-sm-2 control-label">讲师资历</label>
						<div class="col-sm-5">
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" onblur="NotNull7(this.value)" class="form-control" name="education" id="education" placeholder="资历" value="">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi7"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">讲师简介</label>
						<div class="col-sm-7">
							<!-- <script id="editor" type="text/plain" style="width:400px;height:100px;"></script> -->
							<textarea name="career" onblur="NotNull8(this.value)" class="form-control" rows="8" id="career" value=""></textarea>
						</div>
						<div class="col-sm-1">
							<span><p id="tishi8"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="pic_path" class="col-sm-2 control-label">讲师头像</label>
						<div class="col-sm-5">
							<span><img name="img" id="img" src="" style="width: 260px;height: 300px; display: none;"></span>
							<input type="file" id="file"  name="file" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label"></label>
						<div class="col-sm-5">
							<input type="button" onclick="nameFun()" id="addBtn" class="btn btn-info" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" onclick="nullTeacher()" class="btn btn-default" value="重置" />
						</div>
					</div>
				</form>
			</div>
		</div>

	</body>

	<script type="text/javascript">
		/* 实例化编辑器 var ue = UE.getEditor('editor'); */
		
		function NotNull1 (p) {
			if (p.length == 0) {
				$("#tishi1").html("×");
				$("#tishi1").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				$("#tishi1").html("√");
				$("#tishi1").css({"color":"blue"});
				$("#addBtn").removeAttr("disabled");
			}
		}
		
		function NotNull2 (p) {
			if (p.length == 0) {
				$("#tishi2").html("×");
				$("#tishi2").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				$("#tishi2").html("√");
				$("#tishi2").css({"color":"blue"});
				$("#addBtn").removeAttr("disabled");
			}
		}
		
		function NotNull3 (p) {
			if (p.length == 0) {
				$("#tishi3").html("×");
				$("#tishi3").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				$("#tishi3").html("√");
				$("#tishi3").css({"color":"blue"});
				$("#addBtn").removeAttr("disabled");
			}
		}
		
		function NotNull4 (p) {
			if (p.length == 0 || p == null) {
				$("#tishi4").html("×");
				$("#tishi4").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				$("#tishi4").html("√");
				$("#tishi4").css({"color":"blue"});
				$("#addBtn").removeAttr("disabled");
			}
		}
		
		function NotNull5 (p) {
			if (p <= 0) {
				$("#tishi5").html("×");
				$("#tishi5").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				$("#tishi5").html("√");
				$("#tishi5").css({"color":"blue"});
				$("#addBtn").removeAttr("disabled");
			}
		}
		
		function NotNull6 (p) {
			if (p.length == 0) {
				$("#tishi6").html("×");
				$("#tishi6").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				if(parseInt(p)==p){
					$("#tishi6").html("√");
					$("#tishi6").css({"color":"blue"});
					$("#addBtn").removeAttr("disabled");
				}else{
					$("#tishi6").html("×");
					$("#tishi6").css({"color":"red"});
					$("#addBtn").attr("disabled","disabled");
				}
			}
		}
		
		function NotNull7 (p) {
			if (p.length == 0) {
				$("#tishi7").html("×");
				$("#tishi7").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				$("#tishi7").html("√");
				$("#tishi7").css({"color":"blue"});
				$("#addBtn").removeAttr("disabled");
			}
		}
		
		function NotNull8 (p) {
			if (p.length == 0) {
				$("#tishi8").html("×");
				$("#tishi8").css({"color":"red"});
				$("#addBtn").attr("disabled","disabled");
			}else{
				$("#tishi8").html("√");
				$("#tishi8").css({"color":"blue"});
				$("#addBtn").removeAttr("disabled");
			}
		}
		
		function nameFun(){
			if($("#tishi1").text()=='√' && $("#tishi2").text()=='√' && $("#tishi3").text()=='√' && $("#tishi4").text()=='√' && $("#tishi5").text()=='√' && $("#tishi6").text()=='√' && $("#tishi1").text()=='√' && $("#tishi7").text()=='√' && $("#tishi8").text()=='√'){
				$("#form").submit();
			}else{
				$("p").html("*");
				$("p").css({"color":"red"});
			}
		}
	
		 function showMenu() {
				var cityObj = $("#subject_id");
				var cityOffset = $("#subject_id").offset();
				$("#teaSub").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
				$("body").bind("mousedown", onBodyDown);
			}
		 
			function hideMenu() {
				$("#teaSub").fadeOut("fast");
				$("body").unbind("mousedown", onBodyDown);
			}
			
			function onBodyDown(event) {
				if (!(event.target.id == "subject_id" || event.target.id == "teaSub" || $(event.target).parents("#teaSub").length>0)) {
					hideMenu();
				}
			}

			function onClick(e, treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("ztree");
				nodes = zTree.getSelectedNodes();
				v = "";
				nodes.sort(function compare(a, b) {
					return a.subject_id - b.subject_id;
				});
				for (var i = 0, l = nodes.length; i < l; i++) {
					v += nodes[i].subject_name + ",";
					f=nodes[i].subject_id ;
				}
				if (v.length > 0){
					v = v.substring(0, v.length - 1);
				}
				$("#subject_id").val(v);
				$("#sid").val(f);
			}
	
		document.getElementById('file').onchange = function() {
			var imgFile = this.files[0];
			var fr = new FileReader();
			fr.onload = function() {
				document.getElementById("img").style.display = "block";
				document.getElementsByTagName('img')[0].src = fr.result;
			};
			fr.readAsDataURL(imgFile);
		}

		function nullTeacher() {
			$("#name").val("");
			$("#th_name").val("");
			$("#th_pw").val("");
			$("#education").val("");
			$("#is_star").val("1");
			$("#career").val("");
			$("#sort").val("")
			$("#file").val("");
			$("#img").attr("src", "");
			document.getElementById("img").style.display = "none";
		}
	</script>

</html>