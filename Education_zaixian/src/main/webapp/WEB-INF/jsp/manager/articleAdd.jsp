<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/static/common/ueditor/themes/default/css/ueditor.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
<script src="/js/jquery-3.2.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"
	src="/static/common/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/static/common/ueditor/ueditor.all.js"></script>
<link rel="stylesheet" href="/css/bootstrap-table.min.css" />
<script src="/js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="/static/common/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style type="text/css">
#s1 {
	width: 100px;
	position: absolute;
}

#s2 {
	width: 100px;
	position: absolute;
}

#s3 {
	width: 100px;
	position: absolute;
}

#s4 {
	width: 100px;
	position: absolute;
}

#s5 {
	width: 100 px;
	position: absolute;
}

#s8 {
	width: 100px;
	position: absolute;
}

#summary {
	width: 530px;
	height: 100px;
}
</style>
<script type="text/javascript">
	function Fun() {
		var s1 = document.getElementById("s1").innerHTML;
		var s2 = document.getElementById("s2").innerHTML;
		var s3 = document.getElementById("s3").innerHTML;
		var s4 = document.getElementById("s4").innerHTML;
		var imgInp = $("#imgInp").val();
		var title = $("#title").val();
		var summary = $("#summary").val();
		var author = $("#author").val();
		var source = $("#source").val();
		var sorts = $("#sort").val();
		var content = UE.getEditor('content').getContentTxt();
		if (s1 == "" && s2 == "" && s3 == "" && s4 == "" && title != ""
				&& summary != "" && author != "" && source != "" && sorts != ""
				&& content != "" && imgInp != "") {
			document.forms[0].action = "/admin/save";
			document.forms[0].submit();
		} else {
			alert("输入框内不能为空");
		}
	}
	function getCount(obj){
		var str=$(obj).text();
		alert(str);
	}
</script>

<body>

	<form class="form-horizontal" enctype="multipart/form-data"
		method="post">
		<div class="form-group">
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />
		</div>
		<div class="form-group">
			<label for="title" class="col-sm-1 control-label">标题</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="title" name="title"
					placeholder="允许输入3-100字符" onblur="titleFun()">
			</div>
			<div class="col-sm-2">
				<span id="s1" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="summary" class="col-sm-1 control-label">摘要</label>
			<div class="col-sm-4">
				<textarea class="form-control" id="summary" name="summary"
					placeholder="允许输入3-200字符" onblur="summaryFun()"></textarea>
			</div>
			<div class="col-sm-2">
				<span id="s2" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="author" class="col-sm-1 control-label">作者</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="author" name="author"
					placeholder="允许输入3-200字符" onblur="authorFun()">
			</div>
			<div class="col-sm-2">
				<span id="s3" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="source" class="col-sm-1 control-label">来源</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="source" name="source"
					placeholder="允许输入3-50字符" onblur="sourceFun()">
			</div>
			<div class="col-sm-2">
				<span id="s4" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="imgInp" class="col-sm-1 control-label">封面图片</label>
			<div class="col-sm-4">
				<image id="blah" style="width:530px; height:250px;" />
				<input type="file" name="file" id="imgInp"> 
			</div>
		</div>
		<div class="form-group">
			<label for="source" class="col-sm-1 control-label">内容</label>
			<div class="col-sm-5">
				<script type="text/plain" id="content" name="contents"
					style="width:800px;height:400px;">
                      <p>允许输入3-2000个字符</p>
                </script>
			</div>
			<div class="col-sm-2">
				<span id="s5" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="sort" class="col-sm-1 control-label">排序值</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="sort" name="sort"
					placeholder="默认为0" onblur="sortFun()">
			</div>
			<div class="col-sm-2">
				<span id="s6" style="font-size: 13px; color: red"></span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-default" onclick="Fun()">添加</button>
				<button type="button" class="btn btn-default" onclick="resetFun()">重置</button>
				<button type="button" class="btn btn-default" onclick="returnFun()">返回列表</button>
			</div>
		</div>
	</form>
</body>
<!-- 实例化编辑器 -->
<script type="text/javascript">
	//实例化编辑器
	var um = UE.getEditor('content',{  
        //这里可以选择自己需要的工具按钮名称,此处仅选择如下五个  
        toolbars:[['FullScreen', 'Source', 'Undo', 'Redo','bold','test']],  
        //focus时自动清空初始化时的内容  
        autoClearinitialContent:true,  
        //关闭字数统计  
        wordCount:true,  
        //关闭elementPath  
        elementPathEnabled:false,  
        //默认的编辑区域高度  
        initialFrameHeight:300,
        maximumWords:1000
    });
</script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imgInp").change(function() {
		readURL(this);
	});

	function returnFun() {
		window.location.href = "/admin/article/showlist";
	}

	function titleFun() {
		var title = document.getElementById("title").value;
		if (title.trim().length == 0) {
			$("#s1").html("(标题不能为空)");
		} else {
			if (title.trim().length >= 3 && title.trim().length < 100) {
				$("#s1").html("");
			} else {
				$("#s1").html("(字符不符)");
				var s1 = document.getElementById("s1").innerText;
				/* document.getElementById("s1").innerhtml("_$tag______________"+s1+"_$tag__"); */
				$("#title").val("");
			}
		}
	}
	function summaryFun() {
		var summary = document.getElementById("summary").value;
		if (summary.trim().length == 0) {
			$("#s2").html("(摘要不能为空)");
		} else {
			if (summary.trim().length >= 3 && summary.trim().length < 100) {
				$("#s2").html("");
			} else {
				$("#s2").html("(字符不符)");
				$("#summary").val("");
			}
		}
	}

	function authorFun() {
		var author = document.getElementById("author").value;
		if (author.trim().length == 0) {
			$("#s3").html("(作者不能为空)");
		} else {
			if (author.trim().length >= 2 && author.trim().length < 10) {
				$("#s3").html("");
			} else {
				$("#s3").html("(字符不符)");
				$("#author").val("");
			}
		}
	}
	function sourceFun() {
		var source = document.getElementById("source").value;
		if (source.trim().length == 0) {
			$("#s4").html("(来源不能为空)");
		} else {
			if (source.trim().length >= 3 && source.trim().length < 50) {
				$("#s4").html("");
			} else {
				$("#s4").html("(字符不符)");
				$("#source").val("");
			}
		}
	}

	function sortFun() {
		var sort = document.getElementById("sort").value;
		var sorts = /^[1-9]\d*$|^0$/;
		if (sorts.test(sort) == true) {
			$("#s6").html("");
			return true;
		} else {
			$("#s6").html("(文本框内必须输入数字)");
			return false;
		}
	}

	function resetFun() {
		$("#title").val("");
		$("#summary").val("");
		$("#author").val("");
		$("#source").val("");
		$("#content").val("");
		$("#sort").val("");
	}
</script>

</html>