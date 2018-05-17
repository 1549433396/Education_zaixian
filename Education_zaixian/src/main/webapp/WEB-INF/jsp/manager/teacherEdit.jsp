<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改教师</title>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
		<script src="../../../js/jquery-3.2.0.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="../../../css/bootstrap-table.min.css" />
		<script src="../../../js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../../../js/ztree/jquery.ztree.all.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" href="/js/ztree/zTreeStyle.css" />
		<script type="text/javascript" src="/js/ztree/jquery.ztree.all.js"></script>
	</head>

	<style type="text/css">
		.container {
			margin-top: 10px;
		}
		
		.form-group {
			margin: 7px 0px;
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
				<form id="form" action="/admin/teacher/updateTM" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<input type="hidden" name="id" id="id" value="${ts.id }" /> <label for="name" class="col-sm-2 control-label">讲师名称</label>
						<div class="col-sm-5">
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" class="form-control" onblur="NotNull1(this.value)" name="name" id="name" placeholder="讲师名" value="${ts.name }">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi1"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="th_name" class="col-sm-2 control-label">讲师账号</label>
						<div class="col-sm-5">
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" class="form-control" onblur="NotNull2(this.value)" name="th_name" id="th_name" placeholder="账号" value="${ts.th_name }">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi2"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="th_pw" class="col-sm-2 control-label">讲师密码</label>
						<div class="col-sm-5">
							<input type="password" style="font-size: 12px;height:27px;margin-top:5px" class="form-control" onblur="NotNull3(this.value)" name="th_pw" id="th_pw" placeholder="密码" value="${ts.th_pw }">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi3"></p></span>
						</div>
					</div>

					<div class="form-group">
						<label for="is_star" class="col-sm-2 control-label">讲师专业</label>
						<div class="col-sm-5">
							<input type="hidden" name="sid" id="sid" class="form-control" value="${ts.subject_id.subject_id }" />
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" onclick="showMenu(); return false;" name="subject_ids" id="subject_id" class="form-control" value="" />
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
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" id="sort" onblur="NotNull6(this.value)" name="sort" class="form-control" placeholder="排序" value="${ts.sort }" />
						</div>
						<div class="col-sm-1">
							<span><p id="tishi6"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="education" class="col-sm-2 control-label">讲师资历</label>
						<div class="col-sm-5">
							<input type="text" style="font-size: 12px;height:27px;margin-top:5px" onblur="NotNull7(this.value)" class="form-control" name="education" id="education" placeholder="资历" value="${ts.education }">
						</div>
						<div class="col-sm-1">
							<span><p id="tishi7"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">讲师简介</label>
						<div class="col-sm-7">
							<textarea name="career" onblur="NotNull8(this.value)" class="form-control" rows="8" id="career" value="">${ts.career }</textarea>
						</div>
						<div class="col-sm-1">
							<span><p id="tishi8"></p></span>
						</div>
					</div>
					<div class="form-group">
						<label for="pic_path" class="col-sm-2 control-label">讲师头像</label>
						<div class="col-sm-5">
							<span><img id="img" name="img" src="${ts.pic_path }" style="width: 260px;height: 300px; " /></span>
							<input type="file" id="file" name="file" value="${ts.pic_path }">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label"></label>
						<div class="col-sm-4">
							<input type="button" id="addBtn" onclick="nameFun()" class="btn btn-info" value="修改" />&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" onclick="nullTeacher()" class="btn btn-default" value="重置" />
						</div>
					</div>
				</form>
			</div>
		</div>

	</body>

	<script type="text/javascript">
		$("#is_star").val("${ts.is_star}");
		$("#subject_id").val("${ts.subject_id.subject_name}");
		
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
		
		function NotNull4 () {
			var p = $("#subject_id").val();
			if (p.length == 0) {
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
			if($("#tishi2").text()=='√' && $("#tishi3").text()=='√'){
				$("#form").submit();
			}else{
				$("#tishi2").html("*");
				$("#tishi2").css({"color":"red"});
				$("#tishi3").html("*");
				$("#tishi3").css({"color":"red"});
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
				NotNull4();
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
			$("#img").attr("src","");
			document.getElementById("img").style.display = "none";
		}
	</script>

</html>